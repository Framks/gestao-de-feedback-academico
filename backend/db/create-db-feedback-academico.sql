\c feedbackAcademico;

CREATE TABLE usuario (
                         id SERIAL PRIMARY KEY,
                         role varchar(10) NOT NULL,
                         p_nome CHARACTER VARYING(100) NOT NULL,
                         s_nome CHARACTER VARYING(100) NOT NULL,
                         email CHARACTER VARYING(100) NOT NULL UNIQUE,
                         senha CHARACTER VARYING(256) NOT NULL,
                         matricula INTEGER UNIQUE,
                         link_telegram CHARACTER VARYING(200)
);

CREATE TABLE turma (
                       id SERIAL PRIMARY KEY,
                       fk_professor SERIAL NOT NULL,
                       codigo CHARACTER VARYING(50) NOT NULL,
                       disciplina CHARACTER VARYING(100) NOT NULL,
                       semestre INTEGER NOT NULL,
                       ano INTEGER NOT NULL,
                       CONSTRAINT uk_codigo_disciplina_semestre_ano UNIQUE (codigo, disciplina, semestre, ano),
                       CONSTRAINT fk_professor_id FOREIGN KEY (fk_professor)
                           REFERENCES Usuario(id)
                           ON UPDATE CASCADE
                           ON DELETE CASCADE,
                       CONSTRAINT chk_semestre1ou2 CHECK (semestre IN (1, 2))
);

CREATE TABLE aula (
                      id SERIAL PRIMARY KEY,
                      fk_turma SERIAL NOT NULL,
                      data_ocorreu DATE NOT NULL,
                      descricao CHARACTER VARYING(300),
                      CONSTRAINT fk_turma_id FOREIGN KEY (fk_turma)
                          REFERENCES Turma(id)
                          ON UPDATE CASCADE
                          ON DELETE CASCADE,
                      CONSTRAINT uk_aula_na_turma UNIQUE (data_ocorreu, fk_turma)
);

CREATE TABLE atividade (
                           id SERIAL PRIMARY KEY,
                           fk_criador SERIAL NOT NULL,
                           nome CHARACTER VARYING(100) NOT NULL UNIQUE,
                           descricao CHARACTER VARYING(300),
                           peso INTEGER DEFAULT 1,
                           disponivel BOOLEAN NOT NULL,
                           CONSTRAINT fk_criador_id FOREIGN KEY (fk_criador)
                               REFERENCES Usuario(id)
                               ON UPDATE CASCADE
                               ON DELETE CASCADE
);

CREATE TABLE aluno_matriculado (
                                   id SERIAL PRIMARY KEY,
                                   fk_aluno INT NOT NULL,
                                   fk_turma INT NOT NULL,
                                   semestre INT NOT NULL,
                                   ano INT NOT NULL,
                                   CONSTRAINT fk_turma_id FOREIGN KEY (fk_turma)
                                       REFERENCES Turma(id)
                                       ON UPDATE CASCADE
                                       ON DELETE CASCADE,
                                   CONSTRAINT fk_aluno_id FOREIGN KEY (fk_aluno)
                                       REFERENCES Usuario(id)
                                       ON UPDATE CASCADE
                                       ON DELETE CASCADE,
                                   CONSTRAINT uk_aluno_turma_semestre UNIQUE (fk_aluno, semestre, ano)
);

CREATE TABLE ativ_disp_turmas (
                                  id SERIAL PRIMARY KEY,
                                  fk_turma SERIAL NOT NULL,
                                  fk_atividade SERIAL NOT NULL,
                                  data_disponibilizada DATE NOT NULL,
                                  data_limite_avaliacao DATE NOT NULL,
                                  CONSTRAINT fk_turma_id FOREIGN KEY (fk_turma)
                                      REFERENCES Turma(id)
                                      ON UPDATE CASCADE
                                      ON DELETE CASCADE,
                                  CONSTRAINT fk_atividade_id FOREIGN KEY (fk_atividade) REFERENCES Atividade(id)
                                      ON UPDATE CASCADE
                                      ON DELETE CASCADE,
                                  CONSTRAINT uk_ativ_disp_turmas UNIQUE (fk_turma, fk_atividade)
);

CREATE TABLE avaliacao_aula_aluno (
                                      id SERIAL PRIMARY KEY,
                                      fk_aula SERIAL NOT NULL,
                                      fk_aluno_matriculado SERIAL NOT NULL,
                                      data_avaliacao DATE NOT NULL,
                                      nota INTEGER NOT NULL,
                                      descricao CHARACTER VARYING(300),
                                      CONSTRAINT fk_aula_id FOREIGN KEY (fk_aula)
                                          REFERENCES Aula(id)
                                          ON UPDATE CASCADE
                                          ON DELETE CASCADE,
                                      CONSTRAINT fk_aluno_matriculado_id FOREIGN KEY (fk_aluno_matriculado)
                                          REFERENCES Aluno_matriculado(id)
                                          ON UPDATE CASCADE
                                          ON DELETE CASCADE,
                                      CONSTRAINT uk_avaliacao_aula_aluno UNIQUE (fk_aula, fk_aluno_matriculado)
);

CREATE TABLE avaliacao_ativ_aluno (
                                      id SERIAL PRIMARY KEY,
                                      fk_ativ_disp_turmas SERIAL NOT NULL,
                                      fk_aluno SERIAL NOT NULL,
                                      data_avaliacao DATE NOT NULL,
                                      nota INTEGER NOT NULL,
                                      descricao CHARACTER VARYING(300),
                                      CONSTRAINT fk_ativ_disp_turmas_id FOREIGN KEY (fk_ativ_disp_turmas)
                                          REFERENCES Ativ_disp_turmas(id)
                                          ON UPDATE CASCADE
                                          ON DELETE CASCADE,
                                      CONSTRAINT fk_aluno_id FOREIGN KEY (fk_aluno)
                                          REFERENCES Usuario(id)
                                          ON UPDATE CASCADE
                                          ON DELETE CASCADE,
                                      CONSTRAINT uk_avaliacao_atividade_aluno UNIQUE (fk_ativ_disp_turmas, fk_aluno)
);

-- Inserindo dados na tabela Usuario
INSERT INTO usuario (role, p_nome, s_nome, email, senha, matricula, link_telegram) VALUES
        ('ADMIN', 'Joao', 'Silva', 'joao.silva@admin.com', 'senha123', 20230102, NULL),
        ('ALUNO', 'Maria', 'Oliveira', 'maria.oliveira@aluno.com', 'senha123', 20230101, 'https://t.me/maria_oliveira'),
        ('PROFESSOR', 'Carlos', 'Santos', 'carlos.santos@prof.com', 'senha123', 20230105, 'https://t.me/carlos_santos');

-- Inserindo dados na tabela Turma
INSERT INTO turma (fk_professor, codigo, disciplina, semestre, ano) VALUES
        (3, 'INF101', 'Introdução à Informática', 1, 2024),
        (3, 'INF102', 'Algoritmos e Estruturas de Dados', 2, 2024);

-- Inserindo dados na tabela Aula
INSERT INTO aula (fk_turma, data_ocorreu, descricao) VALUES
    (1, '2024-02-10', 'Introdução ao curso e apresentação da disciplina'),
    (1, '2024-02-17', 'Histórico da Computação'),
    (2, '2024-08-05', 'Introdução aos Algoritmos');

-- Inserindo dados na tabela Atividade
INSERT INTO atividade (fk_criador, nome, descricao, peso, disponivel) VALUES
    (3, 'Atividade 1', 'Primeira atividade do curso', 2, true),
    (3, 'Atividade 2', 'Segunda atividade do curso', 1, false);

-- Inserindo dados na tabela Aluno_matriculado
INSERT INTO aluno_matriculado (fk_aluno, fk_turma, semestre, ano) VALUES
    (2, 1, 1, 2024),
    (2, 2, 2, 2024);

-- Inserindo dados na tabela Ativ_disp_turmas
INSERT INTO ativ_disp_turmas (fk_turma, fk_atividade, data_disponibilizada, data_limite_avaliacao) VALUES
    (1, 1, '2024-02-15', '2024-02-28'),
    (2, 2, '2024-08-10', '2024-08-25');

-- Inserindo dados na tabela Avaliacao_aula_aluno
INSERT INTO avaliacao_aula_aluno (fk_aula, fk_aluno_matriculado, data_avaliacao, nota, descricao) VALUES
    (1, 1, '2024-02-18', 8, 'Boa aula, conteúdo interessante.'),
    (2, 1, '2024-02-25', 9, 'Explicação muito clara.');

-- Inserindo dados na tabela Avaliacao_ativ_aluno
INSERT INTO avaliacao_ativ_aluno (fk_ativ_disp_turmas, fk_aluno, data_avaliacao, nota, descricao) VALUES
      (1, 2, '2024-02-20', 7, 'Atividade bem formulada.'),
      (2, 2, '2024-08-15', 8, 'Exigiu um bom entendimento do conteúdo.');