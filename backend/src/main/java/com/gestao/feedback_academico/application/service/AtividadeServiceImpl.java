package com.gestao.feedback_academico.application.service;

import com.gestao.feedback_academico.interfaces.dto.CriarAtividadeDto;
import com.gestao.feedback_academico.interfaces.dto.detalhes.DetalhesAtividadeDto;
import com.gestao.feedback_academico.domain.entity.Atividade;
import com.gestao.feedback_academico.interfaces.repository.AtividadeRepository;
import com.gestao.feedback_academico.application.usecase.AtividadeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AtividadeServiceImpl implements AtividadeService {

    private final AtividadeRepository atividadeRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public DetalhesAtividadeDto criar(CriarAtividadeDto atividade) {
        Atividade atividadeModel = modelMapper.map(atividade, Atividade.class);
        Atividade atividade1= atividadeRepository.save(atividadeModel);
        return modelMapper.map(atividade1, DetalhesAtividadeDto.class);
    }

    @Override
    public DetalhesAtividadeDto buscarPorId(Long id) {
        Atividade atividade = atividadeRepository.findById(id).orElse(null);
        if (atividade == null) {
            return null;
        }
        return modelMapper.map(atividade, DetalhesAtividadeDto.class);
    }

    @Override
    public List<DetalhesAtividadeDto> listar() {
        List<Atividade> atividades = atividadeRepository.findAll();
        List<DetalhesAtividadeDto> atividadesDto = new ArrayList<>();
        for (Atividade atividade : atividades) {
            atividadesDto.add(modelMapper.map(atividade, DetalhesAtividadeDto.class));
        }
        return atividadesDto;
    }

    @Transactional
    @Override
    public void remover(Long id) {
        this.atividadeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void atualizar(Long id, Atividade atividade) {
        Atividade atividadeAtual = atividadeRepository.findById(id).orElse(null);
        if (atividadeAtual == null) {
            return ;
        }
        atividadeAtual.setPeso(atividade.getPeso());
        atividadeAtual.setNome(atividade.getNome());
        atividadeAtual.setDescricao(atividade.getDescricao());
        atividadeRepository.save(atividadeAtual);
    }

}
