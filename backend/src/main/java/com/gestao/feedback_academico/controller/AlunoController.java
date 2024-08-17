package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.usecase.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
@Slf4j
@AllArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    /**
     * Avalia uma atividade.
     *
     * @param detalhesAtividadeDto DTO contendo os detalhes da avaliação da atividade.
     * @return Detalhes da avaliação realizada.
     */
    @Operation(
            summary = "Avaliar uma atividade",
            description = "Endpoint para realizar a avaliação de uma atividade.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Avaliação da atividade realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para avaliação."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @PostMapping("/atividades/avaliar")
    public ResponseEntity<DetalhesAvaliacaoAtivAlunoDto> avaliarAtividade(
            @Parameter(description = "DTO contendo os detalhes da avaliação da atividade.", required = true)
            @Valid @RequestBody CriarAvaliacaoAtivAlunoDto detalhesAtividadeDto
    ) {
        DetalhesAvaliacaoAtivAlunoDto resultado = alunoService.avaliarAtividade(detalhesAtividadeDto);
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }

    /**
     * Avalia uma aula.
     *
     * @param criarAvaliacaoAulaAlunoDto DTO contendo os detalhes da avaliação da aula.
     * @return Detalhes da avaliação realizada.
     */
    @Operation(
            summary = "Avaliar uma aula",
            description = "Endpoint para realizar a avaliação de uma aula.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Avaliação da aula realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para avaliação."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @PostMapping("/aulas/avaliar")
    public ResponseEntity<DetalhesAvaliacaoAtivAlunoDto> avaliarAula(
            @Parameter(description = "DTO contendo os detalhes da avaliação da aula.", required = true)
            @Valid @RequestBody CriarAvaliacaoAulaAlunoDto criarAvaliacaoAulaAlunoDto
    ) {
        DetalhesAvaliacaoAtivAlunoDto resultado = alunoService.avaliarAula(criarAvaliacaoAulaAlunoDto);
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }

    /**
     * Obtém todas as aulas de uma turma específica.
     *
     * @param idTurma O ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAulaDto} contendo os detalhes de todas as aulas da turma especificada.
     */
    @Operation(
            summary = "Listar todas as aulas de uma turma",
            description = "Endpoint para obter todas as aulas de uma turma específica.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aulas da turma recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/turmas/aulas")
    public ResponseEntity<List<DetalhesAulaDto>> getAulasByTurma(
            @Parameter(description = "ID da turma para a qual as aulas devem ser recuperadas.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma
    ) {
        List<DetalhesAulaDto> aulas = alunoService.getAulasByTurma(idTurma);
        return ResponseEntity.ok(aulas);
    }

    /**
     * Obtém todas as aulas que o aluno avaliou.
     *
     * @param matricula A matrícula do aluno para o qual as aulas avaliadas devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAulaDto} contendo os detalhes de todas as aulas avaliadas pelo aluno.
     */
    @Operation(
            summary = "Listar todas as aulas avaliadas por um aluno",
            description = "Endpoint para obter todas as aulas que o aluno avaliou.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aulas avaliadas pelo aluno recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/alunos/{matricula}/aulas/avaliadas")
    public ResponseEntity<List<DetalhesAulaDto>> getAulasAvaliadasByAluno(
            @Parameter(description = "Matrícula do aluno para o qual as aulas avaliadas devem ser recuperadas.", required = true)
            @PathVariable @NotNull @Positive Long matricula
    ) {
        List<DetalhesAulaDto> aulas = alunoService.getAulasAvaliadasByAluno(matricula);
        return ResponseEntity.ok(aulas);
    }

    /**
     * Obtém todas as atividades de uma turma específica.
     *
     * @param idTurma O ID da turma para a qual as atividades devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAtividadeDto} contendo os detalhes de todas as atividades da turma especificada.
     */
    @Operation(
            summary = "Listar todas as atividades de uma turma",
            description = "Endpoint para obter todas as atividades de uma turma específica.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades da turma recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/turmas/atividades")
    public ResponseEntity<List<DetalhesAtividadeDto>> getAtividadesByTurma(
            @Parameter(description = "ID da turma para a qual as atividades devem ser recuperadas.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma
    ) {
        List<DetalhesAtividadeDto> atividades = alunoService.getAtividadesByTurma(idTurma);
        return ResponseEntity.ok(atividades);
    }

    /**
     * Obtém todas as atividades que o aluno avaliou.
     *
     * @param matricula A matrícula do aluno para o qual as atividades avaliadas devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAtividadeDto} contendo os detalhes de todas as atividades avaliadas pelo aluno.
     */
    @Operation(
            summary = "Listar todas as atividades avaliadas por um aluno",
            description = "Endpoint para obter todas as atividades que o aluno avaliou.",
            method = "GET",
            parameters = @Parameter(
                    name = "matricula",
                    description = "Matrícula do aluno para o qual as atividades avaliadas devem ser recuperadas.",
                    required = true,
                    schema = @Schema(type = "integer", example = "12345")
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades avaliadas pelo aluno recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/alunos/{matricula}/atividades/avaliadas")
    public ResponseEntity<List<DetalhesAtividadeDto>> getAtividadesAvaliadasByAluno(
            @PathVariable @NotNull @Positive Long matricula) {
        List<DetalhesAtividadeDto> atividades = alunoService.getAtividadesAvaliadasByAluno(matricula);
        return ResponseEntity.ok(atividades);
    }

}