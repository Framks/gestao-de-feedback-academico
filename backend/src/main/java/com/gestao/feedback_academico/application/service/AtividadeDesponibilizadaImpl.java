package com.gestao.feedback_academico.application.service;

import com.gestao.feedback_academico.interfaces.dto.CriarAtivDispTurmasDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesAtivDispTurmasDto;
import com.gestao.feedback_academico.interfaces.repository.AtivDispTurmasRepository;
import com.gestao.feedback_academico.application.usecase.AtividadeDisponibilizada;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@AllArgsConstructor
public class AtividadeDesponibilizadaImpl implements AtividadeDisponibilizada {

    private final AtivDispTurmasRepository atividadeDispTurmasRepository;
    private final ModelMapper modelMapper;


    @Transactional
    @Override
    public DetalhesAtivDispTurmasDto disponibilizar(CriarAtivDispTurmasDto criarAtivDispTurmasDto) {
        return null;
    }

    @Transactional
    @Override
    public DetalhesAtivDispTurmasDto auterarDataEntrega(Date dataEntrega) {
        return null;
    }
}
