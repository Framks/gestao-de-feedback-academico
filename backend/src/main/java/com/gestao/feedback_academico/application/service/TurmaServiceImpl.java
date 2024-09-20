package com.gestao.feedback_academico.application.service;

import com.gestao.feedback_academico.interfaces.dto.CriarTurmaDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesTurmaDto;
import com.gestao.feedback_academico.domain.entity.Turma;
import com.gestao.feedback_academico.interfaces.repository.TurmaRepository;
import com.gestao.feedback_academico.application.usecase.TurmaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository turmaRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public DetalhesTurmaDto criar(CriarTurmaDto turma) {
        Turma nova = modelMapper.map(turma, Turma.class);
        nova.setId(null);
        return this.modelMapper.map(turmaRepository.save(nova),DetalhesTurmaDto.class);
    }

    @Transactional
    @Override
    public void atualizar(Long id, CriarTurmaDto turma) {
        Turma tuma_antiga = turmaRepository.findById(id).orElseThrow();
        tuma_antiga.setAno(turma.getAno());
        tuma_antiga.setCodigo(turma.getCodigo());
        tuma_antiga.setSemestre(turma.getSemestre());
        tuma_antiga.setDisciplina(turma.getDisciplina());
        turmaRepository.save(tuma_antiga);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        this.turmaRepository.deleteById(id);
    }

    @Override
    public DetalhesTurmaDto buscarPorId(Long id) {
        Turma turma = this.turmaRepository.findById(id).orElseThrow();
        return this.modelMapper.map(turma,DetalhesTurmaDto.class);
    }

    @Override
    public List<DetalhesTurmaDto> listar() {
        List<Turma> turmas = this.turmaRepository.findAll();
        return turmas.stream().map((turma -> this.modelMapper.map(turma,DetalhesTurmaDto.class))).toList();
    }
}
