package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.usecase.AulaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/aula")
public class AulaController {

    private final AulaService aulaService;
}
