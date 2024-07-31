package com.gestao.feedback_academico.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "usuarios")
/**
 * Configura a estratégia de herança para a entidade `User` e suas subclasses.
 *
 * @Inheritance(strategy = InheritanceType.JOINED)
 * Define que cada classe na hierarquia de herança terá sua própria tabela no banco de dados.
 * A tabela da subclasse terá uma chave estrangeira referenciando a chave primária da tabela da superclasse.
 * Isso ajuda a manter a normalização dos dados e permite consultas mais eficientes em algumas situações.
 *
 * @DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
 * Define uma coluna de discriminação na tabela da superclasse para distinguir entre os diferentes tipos de subclasses.
 * A coluna `user_type` armazenará o tipo de entidade (por exemplo, ADMIN, PROFESSOR, ALUNO) como uma string.
 */
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(name = "primeiro_nome", nullable = false)
    private String primeiroNome;

    @Column(name = "segundo_nome", nullable = false)
    private String segundoNome;

    @Enumerated(EnumType.STRING) //Mapeia o campo enum role como uma string no banco de dados
    @Column(nullable = false)
    private UserRole role;

    public User(String login, String senha, String primeiroNome, String segundoNome, UserRole role) {
        this.login = login;
        this.senha = senha;
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.role = role;
    }

    /**
     * Retorna as autoridades concedidas ao usuário com base no seu papel.
     *
     * Este método verifica o papel do usuário (ADMIN, PROFESSOR, ALUNO) e
     * adiciona as autoridades correspondentes a uma lista de autoridades
     * simples. Cada tipo de usuário recebe um conjunto específico de
     * permissões, refletido em seus papéis.
     *
     * @return Uma coleção de autoridades concedidas ao usuário.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (this.role == UserRole.ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (this.role == UserRole.PROFESSOR) {
            authorities.add(new SimpleGrantedAuthority("ROLE_PROFESSOR"));
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (this.role == UserRole.ALUNO) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ALUNO"));
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
