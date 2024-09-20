package com.gestao.feedback_academico.application.service;


import com.gestao.feedback_academico.interfaces.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.application.usecase.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    @Transactional
    @Override
    public DetalhesUsuarioDto criar(CriarUsuarioDto user) {
        return null;
    }

    @Transactional
    @Override
    public void atualizar(User user) {

    }

    @Transactional
    @Override
    public void remover(Long id) {

    }

    @Override
    public DetalhesUsuarioDto buscarAdminPorID(Long id) {
        return null;
    }

    @Override
    public List<DetalhesUsuarioDto> listar() {
        return List.of();
    }

}
