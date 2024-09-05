package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.domain.usecase.TurmaService;
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

    @PreAuthorize("hasRole(T(com.gestao.feedback_academico.domain.entity.UserRole).ADMIN.name())")
    @GetMapping("/")
    public ResponseEntity<List<DetalhesTurmaDto>> buscarTodos() {
        return  null;
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('PROFESSOR')")
    @PostMapping("/")
    public ResponseEntity<DetalhesTurmaDto> criar(@RequestBody @Valid CriarTurmaDto turma) {
        return  null;
    }
}
