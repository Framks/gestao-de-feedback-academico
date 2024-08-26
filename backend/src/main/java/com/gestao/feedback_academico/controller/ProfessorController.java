package com.gestao.feedback_academico.controller;


import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.CriarAulaDto;
import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.*;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.usecase.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/professores")
public class ProfessorController {

    private ProfessorService professorService;

    @GetMapping("/")
    public ResponseEntity<List<DetalhesUsuarioDto>> getAllProfessores(){
        List<DetalhesUsuarioDto> professores = professorService.getAllProfessores();
        return ResponseEntity.ok(professores);
    }



}
