package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;

import java.util.List;

/**
 * Interface para o serviço de operações relacionadas aos alunos.
 */
public interface AlunoService {

    /**
     * Avalia uma atividade.
     *
     * @param criarAvaliacaoAtivAlunoDto DTO contendo os detalhes da avaliação da atividade.
     * @return Detalhes da avaliação realizada, incluindo os dados da atividade e a nota atribuída.
     */
    DetalhesAvaliacaoAtivAlunoDto avaliarAtividade(CriarAvaliacaoAtivAlunoDto criarAvaliacaoAtivAlunoDto);

    /**
     * Avalia uma aula.
     *
     * @param criarAvaliacaoAulaAlunoDto DTO contendo os detalhes da avaliação da aula.
     * @return Detalhes da avaliação realizada, incluindo os dados da aula e a nota atribuída.
     */
    DetalhesAvaliacaoAtivAlunoDto avaliarAula(CriarAvaliacaoAulaAlunoDto criarAvaliacaoAulaAlunoDto);

    /**
     * Obtém todas as aulas de uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma para a qual as aulas devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAulaDto} contendo os detalhes de todas as aulas da turma especificada.
     */
    List<DetalhesAulaDto> getAulasByTurma(IdTurmaDto idTurma);

    /**
     * Obtém todas as aulas que o aluno avaliou.
     *
     * @param matricula A matrícula do aluno para o qual as aulas avaliadas devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAulaDto} contendo os detalhes de todas as aulas avaliadas pelo aluno.
     */
    List<DetalhesAulaDto> getAulasAvaliadasByAluno(Long matricula);

    /**
     * Obtém todas as atividades de uma turma específica.
     *
     * @param idTurma DTO contendo o ID da turma para a qual as atividades devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAtividadeDto} contendo os detalhes de todas as atividades da turma especificada.
     */
    List<DetalhesAtividadeDto> getAtividadesByTurma(IdTurmaDto idTurma);

    /**
     * Obtém todas as atividades que o aluno avaliou.
     *
     * @param matricula A matrícula do aluno para o qual as atividades avaliadas devem ser recuperadas.
     * @return Uma lista de {@link DetalhesAtividadeDto} contendo os detalhes de todas as atividades avaliadas pelo aluno.
     */
    List<DetalhesAtividadeDto> getAtividadesAvaliadasByAluno(Long matricula);
}

