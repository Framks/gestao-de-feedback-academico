package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.dto.CriarAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.usecase.AulaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/aula")
public class AulaController {

    private final AulaService aulaService;

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesAulaDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.aulaService.buscarPorId(id));
    }
    //get all
    @GetMapping("/")
    public ResponseEntity<List<DetalhesAulaDto>> getAll() {
        return  ResponseEntity.ok(this.aulaService.listar());
    }
    //delete
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PROFESSOR') OR hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.aulaService.remover(id);
        return ResponseEntity.noContent().build();
    }
    // create
    @PostMapping("/")
    @PreAuthorize("hasRole('PROFESSOR') OR hasRole('ADMIN')")
    public ResponseEntity<DetalhesAulaDto> criar(@RequestBody @Valid CriarAulaDto dto) {
        return ResponseEntity.ok(this.aulaService.criar(dto));
    }
    // update
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PROFESSOR') OR hasRole('ADMIN')")
    public ResponseEntity<DetalhesAulaDto> atualizar(@PathVariable Long id ,@RequestBody @Valid CriarAulaDto dto) {
        return ResponseEntity.ok(this.aulaService.atualizar(id, dto));
    }
}
