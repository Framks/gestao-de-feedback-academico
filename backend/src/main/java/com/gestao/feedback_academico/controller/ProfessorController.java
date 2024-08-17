package com.gestao.feedback_academico.controller;


import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.CriarAulaDto;
import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.*;
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

    /**
     * Recupera todas as aulas de uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de DetalhesAulaDto contendo os detalhes de todas as aulas da turma especificada.
     */
    @Operation(
            summary = "Recuperar todas as aulas de uma turma",
            description = "Endpoint para recuperar todas as aulas de uma turma específica.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aulas recuperadas com sucesso",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = DetalhesAulaDto.class)))),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/turmas/aulas")
    public ResponseEntity<List<DetalhesAulaDto>> getAulasByTurma(
            @Parameter(description = "ID da turma para a qual as aulas devem ser recuperadas", required = true)
            @Valid @RequestBody IdTurmaDto idTurma) {
        List<DetalhesAulaDto> aulas = professorService.getAulasByTurma(idTurma);
        return ResponseEntity.ok(aulas);
    }

    /**
     * Recupera todas as atividades disponibilizadas em uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma para a qual as atividades foram disponibilizadas.
     * @return Uma lista de DetalhesAtividadeDto contendo os detalhes de todas as atividades disponibilizadas na turma.
     */
    @Operation(
            summary = "Recuperar todas as atividades de uma turma",
            description = "Endpoint para recuperar todas as atividades disponibilizadas em uma turma específica.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades recuperadas com sucesso",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = DetalhesAtividadeDto.class)))),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/turmas/atividades")
    public ResponseEntity<List<DetalhesAtividadeDto>> getAtividadesDisponibilizadas(
            @Parameter(description = "ID da turma para a qual as atividades devem ser recuperadas", required = true)
            @Valid @RequestBody IdTurmaDto idTurma) {
        List<DetalhesAtividadeDto> atividades = professorService.getAtividadesDisponibilizadas(idTurma);
        return ResponseEntity.ok(atividades);
    }

    /**
     * Disponibiliza uma nova atividade para avaliação em uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma onde a atividade será disponibilizada.
     * @param criarAtividadeDto DTO contendo os detalhes da nova atividade a ser disponibilizada.
     * @return DetalhesAtividadeDto contendo os detalhes da atividade criada.
     */
    @Operation(
            summary = "Disponibilizar nova atividade para uma turma",
            description = "Endpoint para disponibilizar uma nova atividade para avaliação em uma turma específica.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividade criada com sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesAtividadeDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/turmas/atividades")
    public ResponseEntity<DetalhesAtividadeDto> disponibilizarAtividade(
            @Parameter(description = "ID da turma onde a atividade será disponibilizada", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Detalhes da nova atividade a ser disponibilizada", required = true)
            @Valid @RequestBody CriarAtividadeDto criarAtividadeDto) {
        DetalhesAtividadeDto atividade = professorService.disponibilizarAtividade(idTurma, criarAtividadeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(atividade);
    }

    /**
     * Cria uma nova turma.
     *
     * @param criarTurmaDto DTO contendo os detalhes da nova turma a ser criada.
     * @return DetalhesTurmaDto contendo os detalhes da turma criada.
     */
    @Operation(
            summary = "Criar nova turma",
            description = "Endpoint para criar uma nova turma.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Turma criada com sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesTurmaDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/turmas")
    public ResponseEntity<DetalhesTurmaDto> criarTurma(
            @Parameter(description = "Detalhes da nova turma a ser criada", required = true)
            @Valid @RequestBody CriarTurmaDto criarTurmaDto) {
        DetalhesTurmaDto turma = professorService.criarTurma(criarTurmaDto);
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
     * @param criarAulaDto DTO contendo os detalhes da nova aula a ser criada.
     * @return DetalhesAulaDto contendo os detalhes da aula criada.
     */
    @Operation(
            summary = "Criar nova aula em uma turma",
            description = "Endpoint para criar uma nova aula em uma turma específica.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aula criada com sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesAulaDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/turmas/aulas")
    public ResponseEntity<DetalhesAulaDto> criarAula(
            @Parameter(description = "ID da turma onde a aula será criada", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Detalhes da nova aula a ser criada", required = true)
            @Valid @RequestBody CriarAulaDto criarAulaDto) {
        DetalhesAulaDto aula = professorService.criarAula(idTurma, criarAulaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(aula);
    }

    /**
     * Apaga uma aula específica em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde a aula foi realizada.
     * @param idAula ID da aula.
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
    @DeleteMapping("/turmas/aulas/{idAula}")
    public ResponseEntity<Void> apagarAula(
            @Parameter(description = "DTO contendo o ID da turma onde a aula foi realizada.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "ID da aula a ser apagada", required = true)
            @PathVariable Long idAula) {
        professorService.apagarAula(idTurma, idAula);
        return ResponseEntity.noContent().build();
    }

    /**
     * Recupera todas as avaliações associadas a uma aula específica em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde a aula foi realizada.
     * @param idAula ID da aula.
     * @return Uma lista de DetalhesAvaliacaoAulaAlunoDto contendo os detalhes de todas as avaliações associadas à aula.
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
    @GetMapping("/turmas/aulas/{idAula}/avaliacoes")
    public ResponseEntity<List<DetalhesAvaliacaoAulaAlunoDto>> getAvaliacoesByAula(
            @Parameter(description = "DTO contendo o ID da turma onde a aula foi realizada.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "ID da aula para a qual as avaliações devem ser recuperadas", required = true)
            @PathVariable Long idAula) {
        List<DetalhesAvaliacaoAulaAlunoDto> avaliacoes = professorService.getAvaliacoesByAula(idTurma, idAula);
        return ResponseEntity.ok(avaliacoes);
    }


    /**
     * Recupera todas as avaliações associadas a uma atividade específica em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde a atividade foi disponibilizada.
     * @param atividadeId O ID da atividade para a qual as avaliações devem ser recuperadas.
     * @return Uma lista de DetalhesAvaliacaoAtivAlunoDto contendo os detalhes de todas as avaliações associadas à atividade.
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
    public ResponseEntity<List<DetalhesAvaliacaoAtivAlunoDto>> getAvaliacoesByAtividade(
            @Parameter(description = "DTO contendo o ID da turma onde a atividade foi disponibilizada.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "ID da atividade para a qual as avaliações devem ser recuperadas", required = true)
            @PathVariable @NotNull @Positive Long atividadeId) {
        List<DetalhesAvaliacaoAtivAlunoDto> avaliacoes = professorService.getAvaliacoesByAtividade(idTurma, atividadeId);
        return ResponseEntity.ok(avaliacoes);
    }

    /**
     * Recupera todas as avaliações de aulas associadas a um aluno específico em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde o aluno está matriculado.
     * @param matricula A matrícula do aluno para o qual as avaliações de aulas devem ser recuperadas.
     * @return Uma lista de DetalhesAvaliacaoAulaAlunoDto contendo os detalhes de todas as avaliações de aulas associadas ao aluno.
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
    public ResponseEntity<List<DetalhesAvaliacaoAulaAlunoDto>> getAvaliacoesAulasByAluno(
            @Parameter(description = "DTO contendo o ID da turma onde o aluno está matriculado.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Matrícula do aluno para o qual as avaliações de aulas devem ser recuperadas", required = true)
            @PathVariable @NotNull @Positive Long matricula) {
        List<DetalhesAvaliacaoAulaAlunoDto> avaliacoes = professorService.getAvaliacoesAulasByAluno(idTurma, matricula);
        return ResponseEntity.ok(avaliacoes);
    }

    /**
     * Recupera todas as avaliações de atividades associadas a um aluno específico em uma turma.
     *
     * @param idTurma DTO contendo o ID da turma onde o aluno está matriculado.
     * @param matricula A matrícula do aluno para o qual as avaliações de atividades devem ser recuperadas.
     * @return Uma lista de DetalhesAvaliacaoAtivAlunoDto contendo os detalhes de todas as avaliações de atividades associadas ao aluno.
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
    public ResponseEntity<List<DetalhesAvaliacaoAtivAlunoDto>> getAvaliacoesAtividadesByAluno(
            @Parameter(description = "DTO contendo o ID da turma onde o aluno está matriculado.", required = true)
            @Valid @RequestBody IdTurmaDto idTurma,
            @Parameter(description = "Matrícula do aluno para o qual as avaliações de atividades devem ser recuperadas", required = true)
            @PathVariable @NotNull @Positive Long matricula) {
        List<DetalhesAvaliacaoAtivAlunoDto> avaliacoes = professorService.getAvaliacoesAtividadesByAluno(idTurma, matricula);
        return ResponseEntity.ok(avaliacoes);
    }

    /**
     * Cria um novo aluno com as informações fornecidas.
     *
     * @param criarUsuarioDto DTO contendo as informações do novo aluno a ser criado.
     * @return O DTO contendo os detalhes do aluno criado.
     */
    @Operation(
            summary = "Criar novo aluno",
            description = "Endpoint para criar um novo aluno com as informações fornecidas.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/alunos")
    public ResponseEntity<DetalhesUsuarioDto> criarNovoAluno(
            @Parameter(description = "DTO contendo as informações do novo aluno a ser criado.", required = true)
            @Valid @RequestBody CriarUsuarioDto criarUsuarioDto) {
        DetalhesUsuarioDto alunoCriado = professorService.criarNovoAluno(criarUsuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCriado);
    }

    /**
     * Recupera todas as atividades disponíveis.
     *
     * @return Uma lista de DetalhesAtividadeDto contendo os detalhes de todas as atividades disponíveis.
     */
    @Operation(
            summary = "Recuperar todas as atividades disponíveis",
            description = "Endpoint para recuperar todas as atividades disponíveis.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atividades recuperadas com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/atividades")
    public ResponseEntity<List<DetalhesAtividadeDto>> getAllAtividades() {
        List<DetalhesAtividadeDto> atividades = professorService.getAllAtividades();
        return ResponseEntity.ok(atividades);
    }

}
