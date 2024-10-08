package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.usecase.AlunoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
@Slf4j
@AllArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PreAuthorize("hasRole('PROFESSOR') OR hasRole('ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<DetalhesUsuarioDto>> findAll() {
        return ResponseEntity.ok(alunoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesUsuarioDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.buscarAlunoPorId(id));
    }

    @PreAuthorize("hasRole('PROFESSOR') OR hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<DetalhesUsuarioDto> criar(@Valid @RequestBody CriarUsuarioDto criarUsuarioDto){
        return ResponseEntity.ok(alunoService.criar(criarUsuarioDto));
    }

    @PreAuthorize("hasRole('PROFESSOR') OR hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('PROFESSOR') OR hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<DetalhesUsuarioDto> atualizar(@PathVariable Long id, @RequestBody CriarUsuarioDto criarUsuarioDto){
        return ResponseEntity.ok(alunoService.atualizar(id, criarUsuarioDto));
    }

}