package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.domain.dto.CriarAulaDto;
import com.gestao.feedback_academico.domain.dto.CriarTurmaDto;
import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.IdTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAtivAlunoDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAvaliacaoAulaAlunoDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.entity.UserRole;
import com.gestao.feedback_academico.domain.repository.ProfessorRepository;
import com.gestao.feedback_academico.domain.usecase.ProfessorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@AllArgsConstructor
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;
    private ModelMapper modelMap;

    public List<DetalhesUsuarioDto> getAllProfessores(){
        List<User> usuarios = this.professorRepository.findAllByRole(UserRole.PROFESSOR).orElseThrow();
        return usuarios.stream().map(user -> this.modelMap.map(user, DetalhesUsuarioDto.class)).toList();
    }

    @Override
    public List<DetalhesUsuarioDto> listar() {
        return List.of();
    }

    @Override
    public DetalhesUsuarioDto buscarProfessorPorEmail(String email) {
        return null;
    }

    @Override
    public DetalhesUsuarioDto criar(CriarUsuarioDto novoProfessor) {
        return null;
    }

    @Override
    public DetalhesUsuarioDto atualizar(DetalhesUsuarioDto detalhesUsuarioDto) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }
}
