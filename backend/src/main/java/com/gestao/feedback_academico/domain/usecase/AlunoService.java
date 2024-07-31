package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.*;

import java.util.List;

/**
 * Interface para o serviço de operações relacionadas aos alunos.
 */
public interface AlunoService {

    /**
     * Avalia uma atividade.
     *
     * @param avaliacaoAtividadeDto DTO contendo os detalhes da avaliação da atividade.
     * @return Detalhes da avaliação realizada, incluindo os dados da atividade e a nota atribuída.
     */
    AvaliacaoAtividadeDto avaliarAtividade(AvaliacaoAtividadeDto avaliacaoAtividadeDto);

    /**
     * Avalia uma aula.
     *
     * @param avaliacaoAulaDto DTO contendo os detalhes da avaliação da aula.
     * @return Detalhes da avaliação realizada, incluindo os dados da aula e a nota atribuída.
     */
    AvaliacaoAulaDto avaliarAula(AvaliacaoAulaDto avaliacaoAulaDto);

    /**
     * Obtém todas as aulas de uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de {@link AulaDetalhesDto} contendo os detalhes de todas as aulas da turma especificada.
     */
    List<AulaDetalhesDto> getAulasByTurma(IdTurmaDto idTurma);

    /**
     * Obtém todas as aulas que o aluno avaliou.
     *
     * @param matricula A matrícula do aluno para o qual as aulas avaliadas devem ser recuperadas.
     * @return Uma lista de {@link AulaDetalhesDto} contendo os detalhes de todas as aulas avaliadas pelo aluno.
     */
    List<AulaDetalhesDto> getAulasAvaliadasByAluno(Long matricula);

    /**
     * Obtém todas as atividades de uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma para a qual as atividades devem ser recuperadas.
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades da turma especificada.
     */
    List<AtividadeDetalhesDto> getAtividadesByTurma(IdTurmaDto idTurma);

    /**
     * Obtém todas as atividades que o aluno avaliou.
     *
     * @param matricula A matrícula do aluno para o qual as atividades avaliadas devem ser recuperadas.
     * @return Uma lista de {@link AtividadeDetalhesDto} contendo os detalhes de todas as atividades avaliadas pelo aluno.
     */
    List<AtividadeDetalhesDto> getAtividadesAvaliadasByAluno(Long matricula);
}

