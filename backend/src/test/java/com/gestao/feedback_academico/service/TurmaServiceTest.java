package com.gestao.feedback_academico.service;

import com.gestao.feedback_academico.application.usecase.TurmaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TurmaServiceTest {

    private TurmaService turmaService;

    @BeforeEach
    public void setup(){
        this.turmaService = Mockito.mock(TurmaService.class);
    }

    @Test
    public void findAll(){

    }
}
