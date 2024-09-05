package com.gestao.feedback_academico.controller;


import com.gestao.feedback_academico.config.security.JwtUtil;
import com.gestao.feedback_academico.domain.dto.AuthRequest;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.repository.UserRespository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthRestController {

    private final UserRespository userRespository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtService;

    /// DEPOIS DE VERIFICAR TEM QUE REMOVER:
    private final PasswordEncoder encoder;

    public AuthRestController(UserRespository userRespository, AuthenticationManager authenticationManager, JwtUtil jwtService, PasswordEncoder encoder) {
        this.userRespository = userRespository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    @PostMapping
    public String login(@RequestBody AuthRequest authRequest) {
        System.out.println(authRequest);
        System.out.println(encoder.encode(authRequest.senha()));
        Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.senha());
        this.authenticationManager.authenticate(authentication);
        User usuario = this.userRespository.findByEmail(authRequest.email()).orElseThrow(() -> new RuntimeException("Error na busca de um usuario"));
        return this.jwtService.createTooken(usuario, usuario.getRole());
    }
}
