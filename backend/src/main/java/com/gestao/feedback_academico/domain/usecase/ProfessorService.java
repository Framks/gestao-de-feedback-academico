package com.gestao.feedback_academico.domain.usecase;


import com.gestao.feedback_academico.domain.dto.*;
import com.gestao.feedback_academico.domain.dto.detalhes.*;
import com.gestao.feedback_academico.domain.entity.User;

import java.util.List;

/**
 * Interface para operações de gerenciamento acadêmico relacionadas a atividades, turmas, aulas e avaliações.
 */
public interface ProfessorService {

    /**
     * Recupera todas as atividades disponíveis.
     *
     * @return Uma lista de {@link DetalhesAtividadeDto} contendo os detalhes de todas as atividades disponíveis.
     */
    List<DetalhesAtividadeDto> getAllAtividades();

    /**
     * Recupera todas as aulas de uma turma específica.
     *
     * @param turmaId O ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAulaDto} contendo os detalhes de todas as aulas da turma especificada.
     */
    List<DetalhesAulaDto> getAulasByTurma(IdTurmaDto turmaId);

    /**
     * Recupera todas as atividades que foram disponibilizadas por um professor em uma turma específica.
     *
     * @param turmaId O ID da turma para a qual as atividades foram disponibilizadas.
     * @return Uma lista de {@link DetalhesAtividadeDto} contendo os detalhes de todas as atividades disponibilizadas na turma.
     */
    List<DetalhesAtividadeDto> getAtividadesDisponibilizadas(IdTurmaDto turmaId);

    /**
     * Disponibiliza uma nova atividade para avaliação em uma turma específica.
     *
     * @param turmaId O ID da turma onde a atividade será disponibilizada.
     * @param criarAtividadeDto DTO contendo os detalhes da nova atividade a ser disponibilizada.
     * @return {@link DetalhesAtividadeDto} contendo os detalhes da atividade criada.
     */
    DetalhesAtividadeDto disponibilizarAtividade(IdTurmaDto turmaId, CriarAtividadeDto criarAtividadeDto);

    /**
     * Cria uma nova turma.
     *
     * @param criarTurmaDto DTO contendo os detalhes da nova turma a ser criada.
     * @return {@link DetalhesTurmaDto} contendo os detalhes da turma criada.
     */
    DetalhesTurmaDto criarTurma(CriarTurmaDto criarTurmaDto);

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
     * @param criarAulaDto DTO contendo os detalhes da nova aula a ser criada.
     * @return {@link DetalhesAulaDto} contendo os detalhes da aula criada.
     */
    DetalhesAulaDto criarAula(IdTurmaDto turmaId, CriarAulaDto criarAulaDto);

    /**
     * Apaga uma aula específica em uma turma.
     *
     * @param turmaId O ID da turma onde a aula foi realizada.
     * @param idAula iD da aula.
     */
    void apagarAula(IdTurmaDto turmaId, Long idAula);

    /**
     * Recupera todas as avaliações associadas a uma aula específica em uma turma.
     *
     * @param turmaId O ID da turma onde a aula foi realizada.
     * @param idAula iD da aula.
     * @return Uma lista de {@link DetalhesAvaliacaoAulaAlunoDto} contendo os detalhes de todas as avaliações associadas à aula.
     */
    List<DetalhesAvaliacaoAulaAlunoDto> getAvaliacoesByAula(IdTurmaDto turmaId, Long idAula);

    /**
     * Recupera todas as avaliações associadas a uma atividade específica em uma turma.
     *
     * @param turmaId O ID da turma onde a atividade foi disponibilizada.
     * @param atividadeId O ID da atividade para a qual as avaliações devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAvaliacaoAtivAlunoDto} contendo os detalhes de todas as avaliações associadas à atividade.
     */
    List<DetalhesAvaliacaoAtivAlunoDto> getAvaliacoesByAtividade(IdTurmaDto turmaId, Long atividadeId);

    /**
     * Recupera todas as avaliações de aulas associadas a um aluno específico em uma turma.
     *
     * @param turmaId O ID da turma onde o aluno está matriculado.
     * @param matricula A matricula do aluno para o qual as avaliações de aulas devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAvaliacaoAulaAlunoDto} contendo os detalhes de todas as avaliações de aulas associadas ao aluno.
     */
    List<DetalhesAvaliacaoAulaAlunoDto> getAvaliacoesAulasByAluno(IdTurmaDto turmaId, Long matricula);

    /**
     * Recupera todas as avaliações de atividades associadas a um aluno específico em uma turma.
     *
     * @param turmaId O ID da turma onde o aluno está matriculado.
     * @param matricula A matricula do aluno para o qual as avaliações de atividades devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAvaliacaoAtivAlunoDto} contendo os detalhes de todas as avaliações de atividades associadas ao aluno.
     */
    List<DetalhesAvaliacaoAtivAlunoDto> getAvaliacoesAtividadesByAluno(IdTurmaDto turmaId, Long matricula);

    /**
     * Cria um novo aluno com as informações fornecidas.
     *
     * @param criarUsuarioDto DTO contendo as informações do novo aluno a ser criado.
     * @return {@link DetalhesUsuarioDto} contendo os detalhes do aluno criado.
     */
    DetalhesUsuarioDto criarNovoAluno(CriarUsuarioDto criarUsuarioDto);

    List<DetalhesUsuarioDto> getAllProfessores();
}