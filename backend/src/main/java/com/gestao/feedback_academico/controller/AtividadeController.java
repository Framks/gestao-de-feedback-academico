package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.usecase.AtividadeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/atividade")
public class AtividadeController {

    private final AtividadeService atividadeService;

    @GetMapping("/")
    public ResponseEntity<List<DetalhesAtividadeDto>> listar() {
        return ResponseEntity.ok(atividadeService.listar());
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @PostMapping("/criar")
    public ResponseEntity<DetalhesAtividadeDto> Criar(@RequestBody CriarAtividadeDto criarAtividadeDto) {
        return ResponseEntity.ok(atividadeService.criar(criarAtividadeDto));
    }

    @PreAuthorize("hasRole('PROFESSOR') OR hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesAtividadeDto> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(atividadeService.buscarPorId(id));
    }
}
