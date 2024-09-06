package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.usecase.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole(T(com.gestao.feedback_academico.domain.entity.UserRole).ADMIN.name())")
    public ResponseEntity<DetalhesUsuarioDto> buscarAdmin(@PathVariable Long id){
        return ResponseEntity.ok(adminService.buscarAdminPorID(id));
    }

    @PreAuthorize("hasRole(T(com.gestao.feedback_academico.domain.entity.UserRole).ADMIN.name())")
    @GetMapping("/")
    public ResponseEntity<List<DetalhesUsuarioDto>> listarAdmin(){
        return ResponseEntity.ok(adminService.listar());
    }

    @PreAuthorize("hasRole(T(com.gestao.feedback_academico.domain.entity.UserRole).ADMIN.name())")
    @PostMapping("/")
    public ResponseEntity<DetalhesUsuarioDto> criar(@Valid @RequestBody CriarUsuarioDto criarUsuarioDto){
        return ResponseEntity.ok(adminService.criar(criarUsuarioDto));
    }

    @PreAuthorize("hasRole(T(com.gestao.feedback_academico.domain.entity.UserRole).ADMIN.name())")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        adminService.remover(id);
        return ResponseEntity.noContent().build();
    }


}
