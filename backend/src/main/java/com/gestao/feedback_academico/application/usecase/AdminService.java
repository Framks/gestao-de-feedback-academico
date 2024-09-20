package com.gestao.feedback_academico.application.usecase;

import com.gestao.feedback_academico.interfaces.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;

import java.util.List;

public interface AdminService {

    DetalhesUsuarioDto criar(CriarUsuarioDto user);
    void atualizar(User user);
    void remover(Long id);
    DetalhesUsuarioDto buscarAdminPorID(Long id);
    List<DetalhesUsuarioDto> listar();
}
