package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.entity.UserRole;
import com.gestao.feedback_academico.domain.repository.AlunoRepository;
import com.gestao.feedback_academico.domain.usecase.AlunoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    private final ModelMapper modelMap;

    @Override
    public DetalhesUsuarioDto criar(CriarUsuarioDto user) {
        return null;
    }

    @Override
    public DetalhesUsuarioDto atualizar(CriarUsuarioDto user) {
        return null;
    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public DetalhesUsuarioDto buscarAlunoPorId(Long id) {
        return null;
    }

    @Override
    public List<DetalhesUsuarioDto> listar() {
    List<User> usuarios = alunoRepository.findAllByRole(UserRole.ALUNO).orElseThrow();
        return usuarios.stream().map(user -> this.modelMap.map(user, DetalhesUsuarioDto.class)).toList();
    }

}
