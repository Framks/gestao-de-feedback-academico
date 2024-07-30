package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.controller.log_messages.AlunoLogMessages;
import com.gestao.feedback_academico.domain.dto.request.AvaliacaoAtividadeDto;
import com.gestao.feedback_academico.domain.dto.request.AvaliacaoAulaDto;
import com.gestao.feedback_academico.domain.dto.response.AtividadeDetalhesDto;
import com.gestao.feedback_academico.domain.dto.response.AulaDetalhesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aluno")
@Slf4j
public class AlunoController {

    /**
     * Realiza a avaliação de uma atividade.
     *
     * @param avaliacaoAtividadeDto DTO contendo os detalhes da avaliação da atividade.
     * @return Status 201 Created se a avaliação for realizada com sucesso.
     */
    @Operation(summary = "Avaliar uma atividade", description = "Endpoint para realizar a avaliação de uma atividade.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Avaliação da atividade realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para avaliação."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @PostMapping("/atividades/avaliar")
    public ResponseEntity<Void> avaliarAtividade(@Valid @RequestBody AvaliacaoAtividadeDto avaliacaoAtividadeDto) {
        log.info(AlunoLogMessages.AVALIACAO_ATIVIDADE_REALIZADA.getMessage(), avaliacaoAtividadeDto.atividadeId());
        // Implementar a lógica para avaliar a atividade
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Realiza a avaliação de uma aula.
     *
     * @param avaliacaoAulaDto DTO contendo os detalhes da avaliação da aula.
     * @return Status 201 Created se a avaliação for realizada com sucesso.
     */
    @Operation(summary = "Avaliar uma aula", description = "Endpoint para realizar a avaliação de uma aula.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Avaliação da aula realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para avaliação."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @PostMapping("/aulas/avaliar")
    public ResponseEntity<Void> avaliarAula(@Valid @RequestBody AvaliacaoAulaDto avaliacaoAulaDto) {
        log.info(AlunoLogMessages.AVALIACAO_AULA_REALIZADA.getMessage(), avaliacaoAulaDto.aulaId(), avaliacaoAulaDto.nota());
        // Implementar a lógica para avaliar a aula
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Obtém todas as aulas de uma turma específica.
     *
     * @param turmaId O ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de {@link AulaDetalhesDto} contendo os detalhes de todas as aulas da turma especificada.
     */
    @Operation(summary = "Listar todas as aulas de uma turma", description = "Endpoint para obter todas as aulas de uma turma específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aulas da turma recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/turmas/{turmaId}/aulas")
    public ResponseEntity<List<AulaDetalhesDto>> getAulasByTurma(@PathVariable @NotNull @Positive Long turmaId) {
        log.info(AlunoLogMessages.AULAS_REQUISITADAS_TURMA.getMessage(), turmaId);
        List<AulaDetalhesDto> aulas = new ArrayList<>();
        // Implementar a lógica para recuperar as aulas da turma
        log.info(AlunoLogMessages.AULAS_RECUPERADAS_TURMA.getMessage(), turmaId);
        return ResponseEntity.ok(aulas);
    }

    /**
     * Obtém todas as aulas que o aluno avaliou.
     *
     * @param alunoId O ID do aluno para o qual as aulas avaliadas devem ser recuperadas.
     * @return Uma lista de {@link AulaDetalhesDto} contendo os detalhes de todas as aulas avaliadas pelo aluno.
     */
    @Operation(summary = "Listar todas as aulas avaliadas por um aluno", description = "Endpoint para obter todas as aulas que o aluno avaliou.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aulas avaliadas pelo aluno recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/alunos/{alunoId}/aulas/avaliadas")
    public ResponseEntity<List<AulaDetalhesDto>> getAulasAvaliadasByAluno(@PathVariable @NotNull @Positive Long alunoId) {
        log.info(AlunoLogMessages.AULAS_AVALIADAS_REQUISITADAS.getMessage(), alunoId);
        List<AulaDetalhesDto> aulas = new ArrayList<>();
        // Implementar a lógica para recuperar as aulas avaliadas pelo aluno
        log.info(AlunoLogMessages.AULAS_AVALIADAS_RECUPERADAS.getMessage(), alunoId);
        return ResponseEntity.ok(aulas);
    }

    /**
     * Obtém todas as atividades de uma turma específica.
     *
     * @param turmaId O ID da turma para a qual as atividades devem ser recuperadas.
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades da turma especificada.
     */
    @Operation(summary = "Listar todas as atividades de uma turma", description = "Endpoint para obter todas as atividades de uma turma específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades da turma recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/turmas/{turmaId}/atividades")
    public ResponseEntity<List<AtividadeDetalhesDto>> getAtividadesByTurma(@PathVariable @NotNull @Positive Long turmaId) {
        log.info(AlunoLogMessages.ATIVIDADES_TURMA_REQUISITADAS.getMessage(), turmaId);
        List<AtividadeDetalhesDto> atividades = new ArrayList<>();
        // Implementar a lógica para recuperar as atividades da turma
        log.info(AlunoLogMessages.ATIVIDADES_TURMA_RECUPERADAS.getMessage(), turmaId);
        return ResponseEntity.ok(atividades);
    }

    /**
     * Obtém todas as atividades que o aluno avaliou.
     *
     * @param alunoId O ID do aluno para o qual as atividades avaliadas devem ser recuperadas.
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades avaliadas pelo aluno.
     */
    @Operation(summary = "Listar todas as atividades avaliadas por um aluno", description = "Endpoint para obter todas as atividades que o aluno avaliou.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades avaliadas pelo aluno recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/alunos/{alunoId}/atividades/avaliadas")
    public ResponseEntity<List<AtividadeDetalhesDto>> getAtividadesAvaliadasByAluno(@PathVariable @NotNull @Positive Long alunoId) {
        log.info(AlunoLogMessages.ATIVIDADES_AVALIADAS_REQUISITADAS.getMessage(), alunoId);
        List<AtividadeDetalhesDto> atividades = new ArrayList<>();
        // Implementar a lógica para recuperar as atividades avaliadas pelo aluno
        log.info(AlunoLogMessages.ATIVIDADES_AVALIADAS_RECUPERADAS.getMessage(), alunoId);
        return ResponseEntity.ok(atividades);
    }
}


