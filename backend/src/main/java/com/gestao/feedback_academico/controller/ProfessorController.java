package com.gestao.feedback_academico.controller;


import com.gestao.feedback_academico.domain.dto.AtividadeDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AulaDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AvaliacaoDetalhesDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.NovaAtividadeDto;
import com.gestao.feedback_academico.domain.dto.NovaAulaDto;
import com.gestao.feedback_academico.domain.dto.NovaTurmaDto;
import com.gestao.feedback_academico.domain.dto.TurmaDetalhesDto;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private ProfessorService professorService;

    /**
     * Recupera todas as aulas de uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de {@link AulaDetalhesDto} contendo os detalhes de todas as aulas da turma especificada.
     */
    @Operation(
            summary = "Recuperar todas as aulas de uma turma",
            description = "Endpoint para recuperar todas as aulas de uma turma específica.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aulas recuperadas com sucesso",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = AulaDetalhesDto.class)))),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/turmas/aulas")
    public ResponseEntity<List<AulaDetalhesDto>> getAulasByTurma(
            @Parameter(description = "ID da turma para a qual as aulas devem ser recuperadas", required = true)
            @Valid @RequestBody IdTurmaDto idTurma) {
        List<AulaDetalhesDto> aulas = professorService.getAulasByTurma(idTurma);
        return ResponseEntity.ok(aulas);
    }

    /**
     * Recupera todas as atividades disponibilizadas em uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma para a qual as atividades foram disponibilizadas.
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades disponibilizadas na turma.
     */
    @Operation(
            summary = "Recuperar todas as atividades de uma turma",
            description = "Endpoint para recuperar todas as atividades disponibilizadas em uma turma específica.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades recuperadas com sucesso",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = AtividadeDetalhesDto.class)))),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/turmas/atividades")
    public ResponseEntity<List<AtividadeDetalhesDto>> getAtividadesDisponibilizadas(
            @Parameter(description = "ID da turma para a qual as atividades devem ser recuperadas", required = true)
            @Valid @RequestBody IdTurmaDto idTurma) {
        List<AtividadeDetalhesDto> atividades = professorService.getAtividadesDisponibilizadas(idTurma);
        return ResponseEntity.ok(atividades);
    }

    /**
     * Disponibiliza uma nova atividade para avaliação em uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma onde a atividade será disponibilizada.
     * @param novaAtividadeDto DTO contendo os detalhes da nova atividade a ser disponibilizada.
     * @return {@link AtividadeDetalhesDto} contendo os detalhes da atividade criada.
     */
    @Operation(
            summary = "Disponibilizar nova atividade para uma turma",
            description = "Endpoint para disponibilizar uma nova atividade para avaliação em uma turma específica.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividade criada com sucesso",
                    content = @Content(schema = @Schema(implementation = AtividadeDetalhesDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/turmas/atividades")
    public ResponseEntity<AtividadeDetalhesDto> disponibilizarAtividade(
            @Parameter(description = "ID da turma onde a atividade será disponibilizada", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Detalhes da nova atividade a ser disponibilizada", required = true)
            @Valid @RequestBody NovaAtividadeDto novaAtividadeDto) {
        AtividadeDetalhesDto atividade = professorService.disponibilizarAtividade(idTurma, novaAtividadeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(atividade);
    }

    /**
     * Cria uma nova turma.
     *
     * @param novaTurmaDto DTO contendo os detalhes da nova turma a ser criada.
     * @return {@link TurmaDetalhesDto} contendo os detalhes da turma criada.
     */
    @Operation(
            summary = "Criar nova turma",
            description = "Endpoint para criar uma nova turma.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Turma criada com sucesso",
                    content = @Content(schema = @Schema(implementation = TurmaDetalhesDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/turmas")
    public ResponseEntity<TurmaDetalhesDto> criarTurma(
            @Parameter(description = "Detalhes da nova turma a ser criada", required = true)
            @Valid @RequestBody NovaTurmaDto novaTurmaDto) {
        TurmaDetalhesDto turma = professorService.criarTurma(novaTurmaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(turma);
    }

    /**
     * Apaga uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma a ser apagada.
     * @return Resposta indicando se a operação foi bem-sucedida.
     */
    @Operation(
            summary = "Apagar uma turma",
            description = "Endpoint para apagar uma turma específica.",
            method = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Turma apagada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/turmas")
    public ResponseEntity<Void> apagarTurma(
            @Parameter(description = "ID da turma a ser apagada", required = true)
            @Valid @RequestBody IdTurmaDto idTurma) {
        professorService.apagarTurma(idTurma);
        return ResponseEntity.noContent().build();
    }

    /**
     * Cria uma nova aula em uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma onde a aula será criada.
     * @param novaAulaDto DTO contendo os detalhes da nova aula a ser criada.
     * @return {@link AulaDetalhesDto} contendo os detalhes da aula criada.
     */
    @Operation(
            summary = "Criar nova aula em uma turma",
            description = "Endpoint para criar uma nova aula em uma turma específica.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aula criada com sucesso",
                    content = @Content(schema = @Schema(implementation = AulaDetalhesDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/turmas/aulas")
    public ResponseEntity<AulaDetalhesDto> criarAula(
            @Parameter(description = "ID da turma onde a aula será criada", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Detalhes da nova aula a ser criada", required = true)
            @Valid @RequestBody NovaAulaDto novaAulaDto) {
        AulaDetalhesDto aula = professorService.criarAula(idTurma, novaAulaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(aula);
    }

    /**
     * Apaga uma aula específica em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde a aula foi realizada.
     * @param dataOcorreu Data e hora em que a aula ocorreu.
     * @return Resposta indicando se a operação foi bem-sucedida.
     */
    @Operation(
            summary = "Apagar uma aula",
            description = "Endpoint para apagar uma aula específica em uma turma.",
            method = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Aula apagada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aula ou turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/turmas/aulas/{dataOcorreu}")
    public ResponseEntity<Void> apagarAula(
            @Parameter(description = "DTO contendo o ID da turma onde a aula foi realizada.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Data e hora em que a aula ocorreu", required = true)
            @PathVariable LocalDateTime dataOcorreu) {
        professorService.apagarAula(idTurma, dataOcorreu);
        return ResponseEntity.noContent().build();
    }

    /**
     * Recupera todas as avaliações associadas a uma aula específica em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde a aula foi realizada.
     * @param dataOcorreu Data e hora em que a aula ocorreu.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações associadas à aula.
     */
    @Operation(
            summary = "Recuperar avaliações de uma aula",
            description = "Endpoint para recuperar todas as avaliações associadas a uma aula específica em uma turma.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliações recuperadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aula ou turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/turmas/aulas/{dataOcorreu}/avaliacoes")
    public ResponseEntity<List<AvaliacaoDetalhesDto>> getAvaliacoesByAula(
            @Parameter(description = "DTO contendo o ID da turma onde a aula foi realizada.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Data e hora em que a aula ocorreu", required = true)
            @PathVariable LocalDateTime dataOcorreu) {
        List<AvaliacaoDetalhesDto> avaliacoes = professorService.getAvaliacoesByAula(idTurma, dataOcorreu);
        return ResponseEntity.ok(avaliacoes);
    }


    /**
     * Recupera todas as avaliações associadas a uma atividade específica em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde a atividade foi disponibilizada.
     * @param atividadeId O ID da atividade para a qual as avaliações devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações associadas à atividade.
     */
    @Operation(
            summary = "Recuperar avaliações de uma atividade",
            description = "Endpoint para recuperar todas as avaliações associadas a uma atividade específica em uma turma.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliações recuperadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Atividade ou turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/turmas/atividades/{atividadeId}/avaliacoes")
    public ResponseEntity<List<AvaliacaoDetalhesDto>> getAvaliacoesByAtividade(
            @Parameter(description = "DTO contendo o ID da turma onde a atividade foi disponibilizada.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "ID da atividade para a qual as avaliações devem ser recuperadas", required = true)
            @PathVariable @NotNull @Positive Long atividadeId) {
        List<AvaliacaoDetalhesDto> avaliacoes = professorService.getAvaliacoesByAtividade(idTurma, atividadeId);
        return ResponseEntity.ok(avaliacoes);
    }

    /**
     * Recupera todas as avaliações de aulas associadas a um aluno específico em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde o aluno está matriculado.
     * @param matricula A matrícula do aluno para o qual as avaliações de aulas devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações de aulas associadas ao aluno.
     */
    @Operation(
            summary = "Recuperar avaliações de aulas de um aluno",
            description = "Endpoint para recuperar todas as avaliações de aulas associadas a um aluno específico em uma turma.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliações recuperadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno ou turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/turmas/alunos/{matricula}/avaliacoes-aulas")
    public ResponseEntity<List<AvaliacaoDetalhesDto>> getAvaliacoesAulasByAluno(
            @Parameter(description = "DTO contendo o ID da turma onde o aluno está matriculado.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Matrícula do aluno para o qual as avaliações de aulas devem ser recuperadas", required = true)
            @PathVariable @NotNull @Positive Long matricula) {
        List<AvaliacaoDetalhesDto> avaliacoes = professorService.getAvaliacoesAulasByAluno(idTurma, matricula);
        return ResponseEntity.ok(avaliacoes);
    }

    /**
     * Recupera todas as avaliações de atividades associadas a um aluno específico em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde o aluno está matriculado.
     * @param matricula A matrícula do aluno para o qual as avaliações de atividades devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações de atividades associadas ao aluno.
     */
    @Operation(
            summary = "Recuperar avaliações de atividades de um aluno",
            description = "Endpoint para recuperar todas as avaliações de atividades associadas a um aluno específico em uma turma.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliações recuperadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno ou turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/turmas/alunos/{matricula}/avaliacoes-atividades")
    public ResponseEntity<List<AvaliacaoDetalhesDto>> getAvaliacoesAtividadesByAluno(
            @Parameter(description = "DTO contendo o ID da turma onde o aluno está matriculado.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Matrícula do aluno para o qual as avaliações de atividades devem ser recuperadas", required = true)
            @PathVariable @NotNull @Positive Long matricula) {
        List<AvaliacaoDetalhesDto> avaliacoes = professorService.getAvaliacoesAtividadesByAluno(idTurma, matricula);
        return ResponseEntity.ok(avaliacoes);
    }
}
