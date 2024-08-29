package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.domain.dto.CriarAulaDto;
import com.gestao.feedback_academico.domain.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.usecase.AulaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {
    @Override
    public void criar(CriarAulaDto aula) {

    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public DetalhesAulaDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<DetalhesAulaDto> listar() {
        return List.of();
    }

    @Override
    public void atualizar(Long Id, CriarAulaDto updateAula) {

    }
}
