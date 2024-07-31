package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface para operações de gerenciamento acadêmico relacionadas a atividades, turmas, aulas e avaliações.
 */
public interface ProfessorService {

    /**
     * Recupera todas as atividades disponíveis.
     *
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades disponíveis.
     */
    List<AtividadeDetalhesDto> getAllAtividades();

    /**
     * Recupera todas as aulas de uma turma específica.
     *
     * @param turmaId O ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de {@link AulaDetalhesDto} contendo os detalhes de todas as aulas da turma especificada.
     */
    List<AulaDetalhesDto> getAulasByTurma(IdTurmaDto turmaId);

    /**
     * Recupera todas as atividades que foram disponibilizadas por um professor em uma turma específica.
     *
     * @param turmaId O ID da turma para a qual as atividades foram disponibilizadas.
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades disponibilizadas na turma.
     */
    List<AtividadeDetalhesDto> getAtividadesDisponibilizadas(IdTurmaDto turmaId);

    /**
     * Disponibiliza uma nova atividade para avaliação em uma turma específica.
     *
     * @param turmaId O ID da turma onde a atividade será disponibilizada.
     * @param novaAtividadeDto DTO contendo os detalhes da nova atividade a ser disponibilizada.
     * @return {@link AtividadeDetalhesDto} contendo os detalhes da atividade criada.
     */
    AtividadeDetalhesDto disponibilizarAtividade(IdTurmaDto turmaId, NovaAtividadeDto novaAtividadeDto);

    /**
     * Cria uma nova turma.
     *
     * @param novaTurmaDto DTO contendo os detalhes da nova turma a ser criada.
     * @return {@link TurmaDetalhesDto} contendo os detalhes da turma criada.
     */
    TurmaDetalhesDto criarTurma(NovaTurmaDto novaTurmaDto);

    /**
     * Apaga uma turma específica.
     *
     * @param turmaId O ID da turma a ser apagada.
     */
    void apagarTurma(IdTurmaDto turmaId);

    /**
     * Cria uma nova aula em uma turma específica.
     *
     * @param turmaId O ID da turma onde a aula será criada.
     * @param novaAulaDto DTO contendo os detalhes da nova aula a ser criada.
     * @return {@link AulaDetalhesDto} contendo os detalhes da aula criada.
     */
    AulaDetalhesDto criarAula(IdTurmaDto turmaId, NovaAulaDto novaAulaDto);

    /**
     * Apaga uma aula específica em uma turma.
     *
     * @param turmaId O ID da turma onde a aula foi realizada.
     * @param dataOcorreu A data e hora em que a aula ocorreu.
     */
    void apagarAula(IdTurmaDto turmaId, LocalDateTime dataOcorreu);

    /**
     * Recupera todas as avaliações associadas a uma aula específica em uma turma.
     *
     * @param turmaId O ID da turma onde a aula foi realizada.
     * @param dataOcorreu A data e hora em que a aula ocorreu.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações associadas à aula.
     */
    List<AvaliacaoDetalhesDto> getAvaliacoesByAula(IdTurmaDto turmaId, LocalDateTime dataOcorreu);

    /**
     * Recupera todas as avaliações associadas a uma atividade específica em uma turma.
     *
     * @param turmaId O ID da turma onde a atividade foi disponibilizada.
     * @param atividadeId O ID da atividade para a qual as avaliações devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações associadas à atividade.
     */
    List<AvaliacaoDetalhesDto> getAvaliacoesByAtividade(IdTurmaDto turmaId, Long atividadeId);

    /**
     * Recupera todas as avaliações de aulas associadas a um aluno específico em uma turma.
     *
     * @param turmaId O ID da turma onde o aluno está matriculado.
     * @param matricula A matricula do aluno para o qual as avaliações de aulas devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações de aulas associadas ao aluno.
     */
    List<AvaliacaoDetalhesDto> getAvaliacoesAulasByAluno(IdTurmaDto turmaId, Long matricula);

    /**
     * Recupera todas as avaliações de atividades associadas a um aluno específico em uma turma.
     *
     * @param turmaId O ID da turma onde o aluno está matriculado.
     * @param matricula A matricula do aluno para o qual as avaliações de atividades devem ser recuperadas.
     * @return Uma lista de {@link AvaliacaoDetalhesDto} contendo os detalhes de todas as avaliações de atividades associadas ao aluno.
     */
    List<AvaliacaoDetalhesDto> getAvaliacoesAtividadesByAluno(IdTurmaDto turmaId, Long matricula);
}