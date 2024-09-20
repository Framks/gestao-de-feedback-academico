package com.gestao.feedback_academico.application.service;

import com.gestao.feedback_academico.interfaces.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.interfaces.dto.UpdateUser;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.entity.UserRole;
import com.gestao.feedback_academico.interfaces.repository.ProfessorRepository;
import com.gestao.feedback_academico.application.usecase.ProfessorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;
    private ModelMapper modelMap;
    private PasswordEncoder passwordEncoder;

    @Override
    public List<DetalhesUsuarioDto> listar() {
        List<User> usuarios = this.professorRepository.findAllByRole(UserRole.PROFESSOR).orElseThrow();
        return usuarios.stream().map(user -> this.modelMap.map(user, DetalhesUsuarioDto.class)).toList();
    }

    @Override
    public DetalhesUsuarioDto buscarProfessorPorEmail(String email) {
        return null;
    }

    @Override
    public DetalhesUsuarioDto buscarPorId(Long id) {
        User usuario = this.professorRepository.findById(id).orElseThrow();
        return this.modelMap.map(usuario, DetalhesUsuarioDto.class);
    }

    @Transactional
    @Override
    public DetalhesUsuarioDto criar(CriarUsuarioDto novoProfessor) {
        User user = this.modelMap.map(novoProfessor, User.class);
        user.setSenha(passwordEncoder.encode(novoProfessor.getSenha()));
        professorRepository.save(user);
        User novo = professorRepository.findByEmail(user.getEmail()).orElseThrow();
        return this.modelMap.map(novo, DetalhesUsuarioDto.class);
    }

    @Transactional
    @Override
    public DetalhesUsuarioDto atualizar(Long id, UpdateUser professor) {
        User user = this.professorRepository.findById(id).orElseThrow();
        user.setPrimeiroNome(professor.getPrimeiroNome());
        user.setSegundoNome(professor.getSegundoNome());
        user.setEmail(professor.getEmail());
        user.setLinkTelegram(professor.getLinkTelegram());
        user.setMatricula(professor.getMatricula());
        professorRepository.save(user);
        return this.modelMap.map(user, DetalhesUsuarioDto.class);
    }

    @Transactional
    @Override
    public void deletar(Long id) {
        this.professorRepository.deleteById(id);
    }
}
