package com.gestao.feedback_academico.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private UserRole role;

    @Column(name = "p_nome", length = 100, nullable = false)
    private String primeiroNome;

    @Column(name = "s_nome", length = 100, nullable = false)
    private String segundoNome;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 256, nullable = false)
    private String senha;

    @Column(unique = true)
    private Integer matricula;

    @Column(name = "link_telegram", length = 200)
    private String linkTelegram;


    public User(String email, String senha, String primeiroNome, String segundoNome, UserRole role) {
        this.email = email;
        this.senha = senha;
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.role = role;
    }


    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
       List<SimpleGrantedAuthority> authorities;
       authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+this.role.name()));
//        if (this.role == UserRole.ADMIN) {
//            authorities.add(new SimpleGrantedAuthority("ADMIN"));
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        } else if (this.role == UserRole.PROFESSOR) {
//            authorities.add(new SimpleGrantedAuthority("PROFESSOR"));
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        } else if (this.role == UserRole.ALUNO) {
//            authorities.add(new SimpleGrantedAuthority("ALUNO"));
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }

        return authorities;
   }

}