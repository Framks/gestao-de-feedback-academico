package com.gestao.feedback_academico.interfaces.controller;


import com.gestao.feedback_academico.application.usecase.ProfessorService;
import com.gestao.feedback_academico.interfaces.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.interfaces.dto.UpdateUser;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesUsuarioDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DetalhesUsuarioDto> getProfessorById(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(this.professorService.buscarPorId(id));
    }

    @PreAuthorize("hasRole(T(com.gestao.feedback_academico.domain.entity.UserRole).ADMIN.name())")
    @GetMapping("/")
    public ResponseEntity<List<DetalhesUsuarioDto>> getAllProfessores(){
        List<DetalhesUsuarioDto> professores = professorService.listar();
        return ResponseEntity.ok(professores);
    }

    @PreAuthorize("hasRole(T(com.gestao.feedback_academico.domain.entity.UserRole).ADMIN.name())")
    @PostMapping("/")
    public ResponseEntity<DetalhesUsuarioDto> postProfessor(@RequestBody @Valid CriarUsuarioDto dto){
        return ResponseEntity.ok(professorService.criar(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id){
        professorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<DetalhesUsuarioDto> atualizarProfessor(@PathVariable Long id, @RequestBody @Valid UpdateUser dto){
        this.professorService.atualizar(id, dto);
        return ResponseEntity.ok(this.professorService.buscarPorId(id));
    }
}
