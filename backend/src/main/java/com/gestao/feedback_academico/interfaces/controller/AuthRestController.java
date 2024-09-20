package com.gestao.feedback_academico.interfaces.controller;


import com.gestao.feedback_academico.infrastructure.config.security.JwtUtil;
import com.gestao.feedback_academico.interfaces.dto.AuthRequest;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.interfaces.repository.UserRespository;
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
    private final PasswordEncoder passwordEncoder;

    public AuthRestController(UserRespository userRespository, AuthenticationManager authenticationManager, JwtUtil jwtService, PasswordEncoder passwordEncoder) {
        this.userRespository = userRespository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String login(@RequestBody AuthRequest authRequest) {
        System.out.println(authRequest.senha()+ " encode \n "+ this.passwordEncoder.encode(authRequest.senha()));
        Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.senha());
        this.authenticationManager.authenticate(authentication);
        User usuario = this.userRespository.findByEmail(authRequest.email()).orElseThrow(() -> new RuntimeException("Error na busca de um usuario"));
        return this.jwtService.createTooken(usuario, usuario.getRole());
    }
}
