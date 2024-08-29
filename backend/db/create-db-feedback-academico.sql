\c feedback-academico;

-- Cria um novo esquema chamado 'feedback-academico' no banco de dados atual
create schema feedbackAcademico;

-- Concede todas as permissões no esquema 'feedback-academico' ao usuário 'postgres'.
grant all on schema feedbackAcademico to postgres;

-- Configura o caminho de pesquisa de esquemas (search_path) para incluir apenas o esquema 'feedback-academico'.
set search_path to feedbackAcademico;

-- Configura o caminho de pesquisa padrão para o banco de dados 'feedback-academico' para incluir apenas o esquema 'feedback-academico'.
-- Isso significa que todas as sessões futuras conectadas a esse banco de dados usarão 'feedback-academico' como o esquema padrão,
-- a menos que seja explicitamente alterado na sessão.
alter database "feedbackAcademico" set search_path to feedbackAcademico;
    
CREATE TYPE USUARIO_ROLES AS ENUM ('ADMIN', 'ALUNO', 'PROFESSOR');

CREATE TABLE usuario (
                         id SERIAL PRIMARY KEY,
                         role USUARIO_ROLES NOT NULL,
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
    -- Garante que a combinação 02A, POO, 1, 2024 não se repete.  
                       CONSTRAINT uk_codigo_disciplina_semestre_ano UNIQUE (codigo, disciplina, semestre, ano),
                       CONSTRAINT fk_professor_id FOREIGN KEY (fk_professor)
                           REFERENCES Usuario(id)
                           ON UPDATE CASCADE
                           ON DELETE CASCADE,
    -- Valida que o valor na coluna semestre só pode ser 1 ou 2.
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
    --Não deve haver mais de uma aula ocorrendo para a mesma turma na mesma data.
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
    -- Restrição para garantir que um aluno só possa estar em uma turma por semestre e ano.
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
    --Não deve haver mais de uma combinação entre fk_turma e fk_atividade,
    --pois uma atividade não pode ser disponibilizada mais de uma vez na mesma turma.
    --Cada combinação de turma e atividade deve ser única.
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
    --Não deve haver mais de uma avaliação para o mesmo aluno em uma única aula.
    --Cada combinação de aluno e aula deve ser única, pois um aluno só pode realizar uma avaliação por aula.
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
    --Não deve haver mais de uma combinação entre fk_ativ_disp_turmas e fk_aluno,
    --pois cada aluno pode ter apenas uma avaliação por atividade.
    --Assim, cada combinação de atividade disponibilizada e aluno deve ser única.
                                      CONSTRAINT uk_avaliacao_atividade_aluno UNIQUE (fk_ativ_disp_turmas, fk_aluno)
);
