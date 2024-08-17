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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "usr_role", nullable = false)
    private UserRole role;

    @Column(name = "p_nome", length = 100, nullable = false)
    private String primeiroNome;

    @Column(name = "s_nome", length = 100, nullable = false)
    private String segundoNome;

    @Column(name = "uk_email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 256, nullable = false)
    private String senha;

    @Column(name = "uk_matricula", unique = true)
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
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        if (this.role == UserRole.ADMIN) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        } else if (this.role == UserRole.PROFESSOR) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_PROFESSOR"));
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        } else if (this.role == UserRole.ALUNO) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_ALUNO"));
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//
//        return authorities;
//    }

}