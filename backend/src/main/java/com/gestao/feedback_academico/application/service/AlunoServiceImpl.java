package com.gestao.feedback_academico.application.service;

import com.gestao.feedback_academico.interfaces.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.entity.UserRole;
import com.gestao.feedback_academico.interfaces.repository.AlunoRepository;
import com.gestao.feedback_academico.application.usecase.AlunoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    private final ModelMapper modelMap;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public DetalhesUsuarioDto criar(CriarUsuarioDto user) {
        User novo = modelMap.map(user, User.class);
        novo.setSenha(passwordEncoder.encode(user.getSenha()));
        novo = this.alunoRepository.save(novo);
        return modelMap.map(novo, DetalhesUsuarioDto.class);
    }

    @Transactional
    @Override
    public DetalhesUsuarioDto atualizar(Long id, CriarUsuarioDto user) {
        User antigo =  this.alunoRepository.findById(id).orElseThrow();
        antigo.setSegundoNome(user.getSegundoNome());
        antigo.setPrimeiroNome(user.getPrimeiroNome());
        antigo.setLinkTelegram(user.getLinkTelegram());
        antigo.setEmail(user.getEmail());
        antigo.setMatricula(user.getMatricula());
        antigo = this.alunoRepository.save(antigo);
        return modelMap.map(antigo, DetalhesUsuarioDto.class);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        this.alunoRepository.deleteById(id);
    }

    @Override
    public DetalhesUsuarioDto buscarAlunoPorId(Long id) {
        User aluno = this.alunoRepository.findById(id).orElseThrow();
        return this.modelMap.map(aluno, DetalhesUsuarioDto.class);
    }

    @Override
    public List<DetalhesUsuarioDto> listar() {
    List<User> usuarios = alunoRepository.findAllByRole(UserRole.ALUNO).orElseThrow();
        return usuarios.stream().map(user -> this.modelMap.map(user, DetalhesUsuarioDto.class)).toList();
    }

}
