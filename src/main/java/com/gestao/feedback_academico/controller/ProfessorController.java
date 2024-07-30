package com.gestao.feedback_academico.controller;


import com.gestao.feedback_academico.controller.log_messages.ProfessorLogMessages;
import com.gestao.feedback_academico.domain.dto.request.NovaAtividadeDto;
import com.gestao.feedback_academico.domain.dto.request.NovaAulaDto;
import com.gestao.feedback_academico.domain.dto.request.NovaTurmaDto;
import com.gestao.feedback_academico.domain.dto.request.NovoAlunoDto;
import com.gestao.feedback_academico.domain.dto.response.AtividadeDetalhesDto;
import com.gestao.feedback_academico.domain.dto.response.AulaDetalhesDto;
import com.gestao.feedback_academico.domain.dto.response.AvaliacaoDetalhesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    /**
     * Obtém todas as atividades disponíveis.
     *
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades disponíveis.
     */
    @Operation(summary = "Listar todas as atividades disponíveis", description = "Obtém todas as atividades disponíveis.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades recuperadas com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/atividades")
    public ResponseEntity<List<AtividadeDetalhesDto>> getAllAtividades() {
        log.info(ProfessorLogMessages.ATIVIDADES_REQUISITADAS.getMessage());
        List<AtividadeDetalhesDto> atividades = new ArrayList<>();
        // Implementar a lógica para recuperar todas as atividades
        log.info(ProfessorLogMessages.ATIVIDADES_RECUPERADAS.getMessage());
        return ResponseEntity.ok(atividades);
    }

    /**
     * Obtém todas as aulas de uma turma específica.
     *
     * @param turmaId O ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de {@link AulaDetalhesDto} contendo os detalhes de todas as aulas da turma especificada.
     */
    @Operation(summary = "Listar todas as aulas de uma turma", description = "Obtém todas as aulas de uma turma específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aulas da turma recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/turmas/{turmaId}/aulas")
    public ResponseEntity<List<AulaDetalhesDto>> getAulasByTurma(@PathVariable @NotNull @Positive Long turmaId) {
        log.info(ProfessorLogMessages.AULAS_REQUISITADAS_TURMA.getMessage(), turmaId);
        List<AulaDetalhesDto> aulas = new ArrayList<>();
        // Implementar a lógica para recuperar as aulas da turma
        log.info(ProfessorLogMessages.AULAS_RECUPERADAS_TURMA.getMessage(), turmaId);
        return ResponseEntity.ok(aulas);
    }

    /**
     * Obtém todas as atividades que foram disponibilizadas pelo professor.
     *
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades disponibilizadas pelo professor.
     */
    @Operation(summary = "Listar todas as atividades disponibilizadas", description = "Obtém todas as atividades que foram disponibilizadas pelo professor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades disponibilizadas recuperadas com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/atividades")
    public ResponseEntity<List<AtividadeDetalhesDto>> getAtividadesDisponibilizadas() {
        log.info(ProfessorLogMessages.ATIVIDADES_DISPONIBILIZADAS_REQUISITADAS.getMessage());
        List<AtividadeDetalhesDto> atividades = new ArrayList<>();
        // Implementar a lógica para recuperar as atividades disponibilizadas
        log.info(ProfessorLogMessages.ATIVIDADES_DISPONIBILIZADAS_RECUPERADAS.getMessage());
        return ResponseEntity.ok(atividades);
    }

    /**
     * Disponibiliza uma nova atividade para avaliação.
     *
     * @param novaAtividadeDto DTO contendo os detalhes da nova atividade a ser disponibilizada.
     * @return Status 201 Created se a atividade for criada com sucesso.
     */
    @Operation(summary = "Disponibilizar nova atividade", description = "Disponibiliza uma nova atividade para avaliação.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividade criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para criação da atividade."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @PostMapping("/atividades")
    public ResponseEntity<Void> disponibilizarAtividade(@Valid @RequestBody NovaAtividadeDto novaAtividadeDto) {
        log.info(ProfessorLogMessages.NOVA_ATIVIDADE_DISPONIBILIZADA.getMessage(), novaAtividadeDto);
        // Implementar a lógica para disponibilizar a atividade
        log.info(ProfessorLogMessages.ATIVIDADE_DISPONIBILIZADA_SUCESSO.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Cria uma nova turma.
     *
     * @param novaTurmaDto DTO contendo os detalhes da nova turma a ser criada.
     * @return Status 201 Created se a turma for criada com sucesso.
     */
    @Operation(summary = "Criar nova turma", description = "Cria uma nova turma.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Turma criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para criação da turma."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @PostMapping("/turmas")
    public ResponseEntity<Void> criarTurma(@Valid @RequestBody NovaTurmaDto novaTurmaDto) {
        log.info(ProfessorLogMessages.NOVA_TURMA_CRIADA.getMessage(), novaTurmaDto);
        // Implementar a lógica para criar uma turma
        log.info(ProfessorLogMessages.TURMA_CRIADA_SUCESSO.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Apaga uma turma específica.
     *
     * @param turmaId O ID da turma a ser apagada.
     * @return Status 204 No Content se a turma for apagada com sucesso.
     */
    @Operation(summary = "Apagar turma", description = "Apaga uma turma específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Turma apagada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @DeleteMapping("/turmas/{turmaId}")
    public ResponseEntity<Void> apagarTurma(@PathVariable @NotNull @Positive Long turmaId) {
        log.info(ProfessorLogMessages.TURMA_APAGADA.getMessage(), turmaId);
        // Implementar a lógica para apagar uma turma
        log.info(ProfessorLogMessages.TURMA_APAGADA_SUCESSO.getMessage());
        return ResponseEntity.noContent().build();
    }

    /**
     * Cria um novo aluno.
     *
     * @param novoAlunoDto DTO contendo os detalhes do novo aluno a ser criado.
     * @return Status 201 Created se o aluno for criado com sucesso.
     */
    @Operation(summary = "Criar novo aluno", description = "Cria um novo aluno.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para criação do aluno."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @PostMapping("/alunos")
    public ResponseEntity<Void> criarAluno(@Valid @RequestBody NovoAlunoDto novoAlunoDto) {
        log.info(ProfessorLogMessages.NOVO_ALUNO_CRIADO.getMessage(), novoAlunoDto);
        // Implementar a lógica para criar um aluno
        log.info(ProfessorLogMessages.ALUNO_CRIADO_SUCESSO.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Apaga um aluno específico.
     *
     * @param matricula O número de matrícula do aluno a ser apagado.
     * @return Status 204 No Content se o aluno for apagado com sucesso.
     */
    @Operation(summary = "Apagar aluno", description = "Apaga um aluno específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Aluno apagado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @DeleteMapping("/alunos/{matricula}")
    public ResponseEntity<Void> apagarAluno(@PathVariable @NotNull @Positive Long matricula) {
        log.info(ProfessorLogMessages.ALUNO_APAGADO.getMessage(), matricula);
        // Implementar a lógica para apagar um aluno
        log.info(ProfessorLogMessages.ALUNO_APAGADO_SUCESSO.getMessage());
        return ResponseEntity.noContent().build();
    }

    /**
     * Cria uma nova aula.
     *
     * @param novaAulaDto DTO contendo os detalhes da nova aula a ser criada.
     * @return Status 201 Created se a aula for criada com sucesso.
     */
    @Operation(summary = "Criar nova aula", description = "Cria uma nova aula.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aula criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para criação da aula."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @PostMapping("/aulas")
    public ResponseEntity<Void> criarAula(@Valid @RequestBody NovaAulaDto novaAulaDto) {
        log.info(ProfessorLogMessages.NOVA_AULA_CRIADA.getMessage(), novaAulaDto);
        // Implementar a lógica para criar uma aula
        log.info(ProfessorLogMessages.AULA_CRIADA_SUCESSO.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Apaga uma aula específica.
     *
     * @param turmaId O ID da turma onde a aula foi realizada.
     * @param dataOcorreu A data e hora em que a aula ocorreu.
     * @return Status 204 No Content se a aula for apagada com sucesso.
     */
    @Operation(summary = "Apagar aula", description = "Apaga uma aula específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Aula apagada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aula não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @DeleteMapping("/aulas/{turmaId}/{dataOcorreu}")
    public ResponseEntity<Void> apagarAula(@PathVariable @NotNull @Positive Long turmaId, @PathVariable @NotNull LocalDateTime dataOcorreu) {
        log.info(ProfessorLogMessages.AULA_APAGADA.getMessage(), turmaId, dataOcorreu);
        // Implementar a lógica para apagar uma aula
        log.info(ProfessorLogMessages.AULA_APAGADA_SUCESSO.getMessage());
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtém todas as avaliações associadas a uma aula específica.
     *
     * @param turmaId O ID da turma onde a aula foi realizada.
     * @param dataOcorreu A data e hora em que a aula ocorreu.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações associadas à aula.
     */
    @Operation(summary = "Listar todas as avaliações de uma aula", description = "Obtém todas as avaliações associadas a uma aula específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliações da aula recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aula não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/aulas/{turmaId}/{dataOcorreu}/avaliacoes")
    public ResponseEntity<List<AvaliacaoDetalhesDto>> getAvaliacoesByAula(@PathVariable @NotNull @Positive Long turmaId, @PathVariable @NotNull LocalDateTime dataOcorreu) {
        log.info(ProfessorLogMessages.AVALIACOES_REQUISITADAS_AULA.getMessage(), turmaId, dataOcorreu);
        List<AvaliacaoDetalhesDto> avaliacoes = new ArrayList<>();
        // Implementar a lógica para recuperar as avaliações da aula
        log.info(ProfessorLogMessages.AVALIACOES_RECUPERADAS_AULA.getMessage(), turmaId, dataOcorreu);
        return ResponseEntity.ok(avaliacoes);
    }

    /**
     * Obtém todas as avaliações associadas a uma atividade específica.
     *
     * @param atividadeId O ID da atividade para a qual as avaliações devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações associadas à atividade.
     */
    @Operation(summary = "Listar todas as avaliações de uma atividade", description = "Obtém todas as avaliações associadas a uma atividade específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliações da atividade recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Atividade não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/atividades/{atividadeId}/avaliacoes")
    public ResponseEntity<List<AvaliacaoDetalhesDto>> getAvaliacoesByAtividade(@PathVariable @NotNull @Positive Long atividadeId) {
        log.info(ProfessorLogMessages.AVALIACOES_REQUISITADAS_ATIVIDADE.getMessage(), atividadeId);
        List<AvaliacaoDetalhesDto> avaliacoes = new ArrayList<>();
        // Implementar a lógica para recuperar as avaliações da atividade
        log.info(ProfessorLogMessages.AVALIACOES_RECUPERADAS_ATIVIDADE.getMessage(), atividadeId);
        return ResponseEntity.ok(avaliacoes);
    }

    /**
     * Obtém todas as avaliações de aulas associadas a um aluno específico.
     *
     * @param alunoId O ID do aluno para o qual as avaliações de aulas devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações de aulas associadas ao aluno.
     */
    @Operation(summary = "Listar todas as avaliações de aulas de um aluno", description = "Obtém todas as avaliações de aulas associadas a um aluno específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliações de aulas do aluno recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/alunos/{alunoId}/avaliacoes/aulas")
    public ResponseEntity<List<AvaliacaoDetalhesDto>> getAvaliacoesAulasByAluno(@PathVariable @NotNull @Positive Long alunoId) {
        log.info(ProfessorLogMessages.AVALIACOES_AULAS_REQUISITADAS_ALUNO.getMessage(), alunoId);
        List<AvaliacaoDetalhesDto> avaliacoes = new ArrayList<>();
        // Implementar a lógica para recuperar as avaliações de aulas do aluno
        log.info(ProfessorLogMessages.AVALIACOES_AULAS_RECUPERADAS_ALUNO.getMessage(), alunoId);
        return ResponseEntity.ok(avaliacoes);
    }

    /**
     * Obtém todas as avaliações de atividades associadas a um aluno específico.
     *
     * @param alunoId O ID do aluno para o qual as avaliações de atividades devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações de atividades associadas ao aluno.
     */
    @Operation(summary = "Listar todas as avaliações de atividades de um aluno", description = "Obtém todas as avaliações de atividades associadas a um aluno específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliações de atividades do aluno recuperadas com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    @GetMapping("/alunos/{alunoId}/avaliacoes/atividades")
    public ResponseEntity<List<AvaliacaoDetalhesDto>> getAvaliacoesAtividadesByAluno(@PathVariable @NotNull @Positive Long alunoId) {
        log.info(ProfessorLogMessages.AVALIACOES_ATIVIDADES_REQUISITADAS_ALUNO.getMessage(), alunoId);
        List<AvaliacaoDetalhesDto> avaliacoes = new ArrayList<>();
        // Implementar a lógica para recuperar as avaliações de atividades do aluno
        log.info(ProfessorLogMessages.AVALIACOES_ATIVIDADES_RECUPERADAS_ALUNO.getMessage(), alunoId);
        return ResponseEntity.ok(avaliacoes);
    }
}