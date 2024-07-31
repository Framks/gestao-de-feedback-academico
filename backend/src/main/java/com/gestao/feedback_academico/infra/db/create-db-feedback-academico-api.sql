CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       login VARCHAR(255) NOT NULL UNIQUE,
                       senha VARCHAR(255) NOT NULL,
                       primeiro_nome VARCHAR(255) NOT NULL,
                       segundo_nome VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       user_type VARCHAR(50) NOT NULL
);

CREATE TABLE admins (
                        user_id UUID PRIMARY KEY,
                        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE alunos (
                        matricula BIGINT PRIMARY KEY,
                        telegram VARCHAR(255) UNIQUE,
                        user_id UUID,
                        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE professores (
                             matricula BIGINT PRIMARY KEY,
                             user_id UUID,
                             FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Criação das tabelas de turmas, aulas, atividades e avaliações
CREATE TABLE turmas (
                        nome VARCHAR(255) NOT NULL,
                        codigo VARCHAR(255) NOT NULL,
                        semestre INT NOT NULL,
                        PRIMARY KEY (nome, codigo, semestre)
);

CREATE TABLE aulas (
                       id UUID PRIMARY KEY,
                       data_ocorreu TIMESTAMP NOT NULL,
                       data_final_avaliada TIMESTAMP NOT NULL,
                       turma_nome VARCHAR(255),
                       turma_codigo VARCHAR(255),
                       turma_semestre INT,
                       FOREIGN KEY (turma_nome, turma_codigo, turma_semestre) REFERENCES turmas(nome, codigo, semestre) ON DELETE CASCADE
);

CREATE TABLE atividades (
                            id UUID PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            descricao TEXT,
                            disponivel BOOLEAN NOT NULL,
                            turma_nome VARCHAR(255),
                            turma_codigo VARCHAR(255),
                            turma_semestre INT,
                            FOREIGN KEY (turma_nome, turma_codigo, turma_semestre) REFERENCES turmas(nome, codigo, semestre) ON DELETE CASCADE
);

CREATE TABLE avaliacoes (
                            id UUID PRIMARY KEY,
                            descricao TEXT NOT NULL,
                            data TIMESTAMP NOT NULL,
                            nota INT NOT NULL,
                            aluno_matricula BIGINT,
                            aula_id UUID,
                            atividade_id UUID,
                            FOREIGN KEY (aluno_matricula) REFERENCES alunos(matricula) ON DELETE CASCADE,
                            FOREIGN KEY (aula_id) REFERENCES aulas(id) ON DELETE CASCADE,
                            FOREIGN KEY (atividade_id) REFERENCES atividades(id) ON DELETE CASCADE
);
