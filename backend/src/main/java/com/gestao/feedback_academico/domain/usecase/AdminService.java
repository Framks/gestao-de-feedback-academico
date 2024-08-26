package com.gestao.feedback_academico.domain.usecase;

import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;

import java.util.List;

public interface AdminService {

    void criar(User user);
    void atualizar(User user);
    void remover(Long id);
    DetalhesUsuarioDto getAdmin(Long id);
    List<DetalhesUsuarioDto> getAdmins();
}
