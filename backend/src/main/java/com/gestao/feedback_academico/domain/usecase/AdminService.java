package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.NovaAtividadeDto;
import com.gestao.feedback_academico.domain.dto.NovoAdminDto;
import com.gestao.feedback_academico.domain.dto.NovoProfessorDto;
import com.gestao.feedback_academico.domain.dto.AdminDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AtividadeDetalhesDto;
import com.gestao.feedback_academico.domain.dto.ProfessorDetalhesDto;
import com.gestao.feedback_academico.domain.dto.UsuarioDetalhesDto;

import java.util.List;

/**
 * Interface para o serviço de operações relacionadas aos admins.
 */

public interface AdminService {

    /**
     * Cria um novo professor.
     *
     * @param novoProfessorDto DTO contendo os detalhes do novo professor a ser criado.
     * @return
     */
    ProfessorDetalhesDto criarProfessor(NovoProfessorDto novoProfessorDto);

    /**
     * Cria um novo admin.
     *
     * @param novoAdminDto DTO contendo os detalhes do novo admin a ser criado.
     * @return
     */
    AdminDetalhesDto criarAdmin(NovoAdminDto novoAdminDto);

    /**
     * Cadastra uma nova atividade.
     *
     * @param atividadeCadastroDto DTO contendo os detalhes da nova atividade a ser cadastrada.
     * @return
     */
    AtividadeDetalhesDto cadastrarAtividade(NovaAtividadeDto atividadeCadastroDto);

    /**
     * Lista todos os usuários.
     *
     * @return Uma lista de {@link UsuarioDetalhesDto} contendo os detalhes de todos os usuários.
     */
    List<UsuarioDetalhesDto> listarUsuarios();

    /**
     * Apaga um usuário específico.
     *
     * @param login
     */
    void apagarUsuario(String login);

    /**
     * Lista todos os professores cadastrados.
     *
     * @return Uma lista de {@link ProfessorDetalhesDto} contendo os detalhes de todos os professores cadastrados.
     */
    List<ProfessorDetalhesDto> listarProfessores();

    /**
     * Lista todos os admins cadastrados.
     *
     * @return Uma lista de {@link AdminDetalhesDto} contendo os detalhes de todos os admins cadastrados.
     */
    List<AdminDetalhesDto> listarAdmins();

    /**
     * Obtém os detalhes de um professor específico pela matrícula.
     *
     * @param matricula A matrícula do professor a ser consultado.
     * @return Os detalhes do professor.
     */
    ProfessorDetalhesDto obterDetalhesProfessor(Long matricula);
}
