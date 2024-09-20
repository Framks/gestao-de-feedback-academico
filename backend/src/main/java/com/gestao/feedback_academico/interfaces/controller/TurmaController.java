package com.gestao.feedback_academico.interfaces.controller;

import com.gestao.feedback_academico.interfaces.dto.CriarTurmaDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.application.usecase.TurmaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/turma")
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTurmaDto> buscarPorId(@PathVariable Long id) {
        return  null;
    }

    @PreAuthorize("hasRole(T(com.gestao.feedback_academico.domain.entity.UserRole).ADMIN.name()) OR hasRole('PROFESSOR')")
    @GetMapping("/")
    public ResponseEntity<List<DetalhesTurmaDto>> buscarTodos() {
        return ResponseEntity.ok(this.turmaService.listar());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<DetalhesTurmaDto> criar(@RequestBody @Valid CriarTurmaDto turma) {
        return ResponseEntity.ok(this.turmaService.criar(turma));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESSOR')")
    public ResponseEntity<Void> atualizar(@PathVariable long id, @RequestBody @Valid CriarTurmaDto turma) {
        this.turmaService.atualizar(id, turma);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        this.turmaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
