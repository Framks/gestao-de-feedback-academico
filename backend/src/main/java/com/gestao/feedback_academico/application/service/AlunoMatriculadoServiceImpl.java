package com.gestao.feedback_academico.application.service;

import com.gestao.feedback_academico.interfaces.dto.CriarAlunoMatriculadoDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesAlunoMatriculadoDto;
import com.gestao.feedback_academico.interfaces.repository.AlunoMatriculadoRepository;
import com.gestao.feedback_academico.domain.entity.AlunoMatriculado;
import com.gestao.feedback_academico.application.usecase.AlunoMatriculadoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AlunoMatriculadoServiceImpl implements AlunoMatriculadoService {

    private final AlunoMatriculadoRepository alunoMatriculadoRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public DetalhesAlunoMatriculadoDto registrarAlunoTurma(CriarAlunoMatriculadoDto criarAlunoMatriculadoDto) {
        AlunoMatriculado alunoMatriculado = this.modelMapper.map(criarAlunoMatriculadoDto, AlunoMatriculado.class);
        return  this.modelMapper.map(this.alunoMatriculadoRepository.save(alunoMatriculado),DetalhesAlunoMatriculadoDto.class);
    }

    @Transactional
    @Override
    public void desmatricularAlunoTurma(Long id) {
        this.alunoMatriculadoRepository.deleteById(id);
    }
}
