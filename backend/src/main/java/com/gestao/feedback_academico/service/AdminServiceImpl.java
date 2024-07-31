package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.usecase.AdminService;
import com.gestao.feedback_academico.domain.dto.NovaAtividadeDto;
import com.gestao.feedback_academico.domain.dto.NovoAdminDto;
import com.gestao.feedback_academico.domain.dto.NovoProfessorDto;
import com.gestao.feedback_academico.domain.dto.AdminDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AtividadeDetalhesDto;
import com.gestao.feedback_academico.domain.dto.ProfessorDetalhesDto;
import com.gestao.feedback_academico.domain.dto.UsuarioDetalhesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public ProfessorDetalhesDto criarProfessor(NovoProfessorDto novoProfessorDto) {
        return null;
    }

    @Override
    public AdminDetalhesDto criarAdmin(NovoAdminDto novoAdminDto) {
        return null;
    }

    @Override
    public AtividadeDetalhesDto cadastrarAtividade(NovaAtividadeDto atividadeCadastroDto) {
        return null;
    }

    @Override
    public List<UsuarioDetalhesDto> listarUsuarios() {
        return List.of();
    }

    @Override
    public void apagarUsuario(String login) {

    }

    @Override
    public List<ProfessorDetalhesDto> listarProfessores() {
        return List.of();
    }

    @Override
    public List<AdminDetalhesDto> listarAdmins() {
        return List.of();
    }

    @Override
    public ProfessorDetalhesDto obterDetalhesProfessor(Long matricula) {
        return null;
    }
}
