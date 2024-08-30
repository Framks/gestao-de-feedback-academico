package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.usecase.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DetalhesUsuarioDto> buscarAdmin(@PathParam("id") Long id){
        return ResponseEntity.ok(adminService.buscarAdminPorID(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<DetalhesUsuarioDto>> listarAdmin(){
        return ResponseEntity.ok(adminService.listar());
    }

    @PostMapping("/")
    public ResponseEntity<DetalhesUsuarioDto> criar(@Valid @RequestBody CriarUsuarioDto criarUsuarioDto){
        return ResponseEntity.ok(adminService.criar(criarUsuarioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        adminService.remover(id);
        return ResponseEntity.noContent().build();
    }


}
