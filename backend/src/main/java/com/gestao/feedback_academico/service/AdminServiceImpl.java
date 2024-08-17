package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.usecase.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public DetalhesUsuarioDto criarProfessor(CriarUsuarioDto criarUsuarioDto) {
        return null;
    }

    @Override
    public DetalhesUsuarioDto criarAdmin(CriarUsuarioDto criarUsuarioDto) {
        return null;
    }

    @Override
    public DetalhesAtividadeDto cadastrarAtividade(CriarAtividadeDto atividadeCadastroDto) {
        return null;
    }

    @Override
    public List<DetalhesUsuarioDto> listarUsuarios() {
        return List.of();
    }

    @Override
    public void apagarUsuario(String login) {

    }

    @Override
    public List<DetalhesUsuarioDto> listarProfessores() {
        return List.of();
    }

    @Override
    public List<DetalhesUsuarioDto> listarAdmins() {
        return List.of();
    }

    @Override
    public DetalhesUsuarioDto obterDetalhesProfessor(Long matricula) {
        return null;
    }
}
