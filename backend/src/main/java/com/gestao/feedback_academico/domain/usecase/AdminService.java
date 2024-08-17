package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;

import java.util.List;

/**
 * Interface para o serviço de operações relacionadas aos admins.
 */

public interface AdminService {

    /**
     * Cria um novo professor.
     *
     * @param criarUsuarioDto DTO contendo os detalhes do novo professor a ser criado.
     * @return
     */
    DetalhesUsuarioDto criarProfessor(CriarUsuarioDto criarUsuarioDto);

    /**
     * Cria um novo admin.
     *
     * @param criarUsuarioDto DTO contendo os detalhes do novo admin a ser criado.
     * @return
     */
    DetalhesUsuarioDto criarAdmin(CriarUsuarioDto criarUsuarioDto);

    /**
     * Cadastra uma nova atividade.
     *
     * @param atividadeCadastroDto DTO contendo os detalhes da nova atividade a ser cadastrada.
     * @return
     */
    DetalhesAtividadeDto cadastrarAtividade(CriarAtividadeDto atividadeCadastroDto);

    /**
     * Lista todos os usuários.
     *
     * @return Uma lista de {@link DetalhesUsuarioDto} contendo os detalhes de todos os usuários.
     */
    List<DetalhesUsuarioDto> listarUsuarios();

    /**
     * Apaga um usuário específico.
     *
     * @param login
     */
    void apagarUsuario(String login);

    /**
     * Lista todos os professores cadastrados.
     *
     * @return Uma lista de {@link DetalhesUsuarioDto} contendo os detalhes de todos os professores cadastrados.
     */
    List<DetalhesUsuarioDto> listarProfessores();

    /**
     * Lista todos os admins cadastrados.
     *
     * @return Uma lista de {@link DetalhesUsuarioDto} contendo os detalhes de todos os admins cadastrados.
     */
    List<DetalhesUsuarioDto> listarAdmins();

    /**
     * Obtém os detalhes de um professor específico pela matrícula.
     *
     * @param matricula A matrícula do professor a ser consultado.
     * @return Os detalhes do professor.
     */
    DetalhesUsuarioDto obterDetalhesProfessor(Long matricula);
}
