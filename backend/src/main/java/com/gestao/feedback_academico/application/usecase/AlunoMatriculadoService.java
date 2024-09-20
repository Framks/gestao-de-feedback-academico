package com.gestao.feedback_academico.application.usecase;

import com.gestao.feedback_academico.interfaces.dto.CriarAlunoMatriculadoDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesAlunoMatriculadoDto;

public interface AlunoMatriculadoService {
    DetalhesAlunoMatriculadoDto registrarAlunoTurma(CriarAlunoMatriculadoDto criarAlunoMatriculadoDto);
    void desmatricularAlunoTurma(Long id);

}
