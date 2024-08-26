package com.gestao.feedback_academico.service;


import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.usecase.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    @Override
    public void criar(User user) {

    }

    @Override
    public void atualizar(User user) {

    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public DetalhesUsuarioDto getAdmin(Long id) {
        return null;
    }

    @Override
    public List<DetalhesUsuarioDto> getAdmins() {
        return List.of();
    }
}
