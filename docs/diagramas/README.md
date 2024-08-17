## Diagramas de Classe e de Atividade

Este repositório contém os diagramas que representam a estrutura e o fluxo de atividades do nosso sistema.

### Diagrama de Classe

O diagrama de classe fornece uma visão geral das entidades e relacionamentos no sistema. Este diagrama é uma representação estática da estrutura do sistema, mostrando as classes, seus atributos e métodos, bem como as relações entre elas.

- [Link para o Diagrama de Classe](https://drive.google.com/file/d/1vWNx628R4ReCDQqqT5ygoukLAJcE5A9M/view?usp=sharing)

  > **Nota:** Este diagrama pode ser sujeito a alterações conforme o projeto avança e novas necessidades surgem.

### Diagrama de Atividade

O diagrama de Atividade de acordo com os requisitos elicitados do projeto esta disponível em 

- [Link para o Digrama de Atividades](https://drive.google.com/file/d/1t5F50NXE7QOQRADiIpuY9_WHs3lz7BEF/view?usp=sharing)

  > **Nota:** Este diagrama está sujeito a atualizações à medida que o projeto avança e novas necessidades são identificadas. Recomendamos que revisões periódicas sejam realizadas para assegurar que ele reflita com precisão o estado atual do sistema.

#### Visão Geral do Diagrama de Atividades 
  O diagrama captura as interações entre os diferentes atores do sistema (alunos e professores) e as ações que eles realizam para completar as tarefas mencionadas. O fluxo de atividades é projetado para maximizar a usabilidade e eficiência, garantindo que as ações sejam intuitivas e o sistema responda de forma previsível.

  * Sequência Lógica: As atividades são organizadas de maneira sequencial e lógica, refletindo o fluxo típico de trabalho dos usuários. Cada decisão ou bifurcação no fluxo é claramente representada, com as condições que levam a cada caminho bem definidas.

  * Simplicidade e Clareza: O diagrama foi desenhado com um foco na simplicidade e clareza, assegurando que todos os processos sejam facilmente compreendidos. Isso é particularmente importante para garantir que tanto desenvolvedores quanto partes interessadas não técnicas possam interpretar o diagrama corretamente.

  * Flexibilidade: Apesar de focado nas funcionalidades principais, o diagrama foi elaborado para ser flexível o suficiente para acomodar futuras expansões e modificações, conforme novas funcionalidades sejam incorporadas ao sistema.

### Arquitetura do sistema

Estamos desenvolvendo uma aplicação web que utiliza uma arquitetura de microsserviços. O front-end é implementado em React e será executado em um container Docker separado. O back-end é desenvolvido em Java, utilizando o framework Spring Boot, e também será executado em um container distinto. O banco de dados escolhido para a aplicação é o PostgreSQL, que será utilizado para armazenar os dados. Essa separação facilita a escalabilidade, manutenção e implantação da aplicação, além de permitir uma clara divisão de responsabilidades entre a interface de usuário e a lógica de negócio.

- [Link para o Diagrama da Arquitetura do sistema](https://drive.google.com/file/d/1aA-7tzJ8oJapOLWOq9kWKD3yIyrNa6Ze/view?usp=drive_link)
  
  > **Nota:** Este diagrama pode ser sujeito a alterações conforme o projeto avança e novas necessidades surgem.

### Diagramas de Entidade

Aqui estão os diagramas que representam diferentes tipos de entidades no sistema:

#### Usuário

![Diagrama de Entidade: Usuário](images/usuario.png)

#### Professor (Herda de Usuário)

![Diagrama de Entidade: Professor](images/professor.png)

#### Aluno (Herda de Usuário)

![Diagrama de Entidade: Aluno](images/aluno.png)

#### Administrador (Herda de Usuário)

![Diagrama de Entidade: Administrador](images/administrador.png)

#### Turma

![Diagrama de Entidade: Turma](images/turma.png)

#### Avaliação

![Diagrama de Entidade: Avaliação](images/avaliacao.png)

#### Atividade

![Diagrama de Entidade: Atividade](images/atividade.png)

Estes diagramas fornecem uma compreensão visual das entidades principais e suas relações dentro do sistema, ajudando no processo de desenvolvimento e comunicação entre os membros da equipe.
