package com.gestao.feedback_academico.application.service;

import com.gestao.feedback_academico.interfaces.dto.CriarAulaDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesAulaDto;
import com.gestao.feedback_academico.domain.entity.Aula;
import com.gestao.feedback_academico.interfaces.repository.AulaRepository;
import com.gestao.feedback_academico.application.usecase.AulaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AulaServiceImpl implements AulaService {

    private final AulaRepository aulaRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public DetalhesAulaDto criar(CriarAulaDto aula) {
        Aula aulaNova = modelMapper.map(aula, Aula.class);
        aulaNova.setId(null);
        return modelMapper.map(this.aulaRepository.save(aulaNova), DetalhesAulaDto.class);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        this.aulaRepository.deleteById(id);
    }

    @Override
    public DetalhesAulaDto buscarPorId(Long id) {
        return modelMapper.map(this.aulaRepository.findById(id).orElseThrow(), DetalhesAulaDto.class);
    }

    @Override
    public List<DetalhesAulaDto> listar() {
        List <Aula> aulas = this.aulaRepository.findAll();
        return aulas.stream().map(aula -> modelMapper.map(aula, DetalhesAulaDto.class)).toList();
    }

    @Transactional
    @Override
    public DetalhesAulaDto atualizar(Long Id, CriarAulaDto updateAula) {
        Aula aula = this.aulaRepository.findById(Id).orElseThrow();
        aula.setDataOcorreu(updateAula.getDataOcorreu());
        aula.setDescricao(updateAula.getDescricao());
        return modelMapper.map(this.aulaRepository.save(aula),DetalhesAulaDto.class);
    }
}
