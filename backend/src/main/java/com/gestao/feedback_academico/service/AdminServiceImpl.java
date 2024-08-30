package com.gestao.feedback_academico.service;


import com.gestao.feedback_academico.domain.dto.CriarUsuarioDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesUsuarioDto;
import com.gestao.feedback_academico.domain.entity.User;
import com.gestao.feedback_academico.domain.usecase.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {


    @Override
    public DetalhesUsuarioDto criar(CriarUsuarioDto user) {
        return null;
    }

    @Override
    public void atualizar(User user) {

    }

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
