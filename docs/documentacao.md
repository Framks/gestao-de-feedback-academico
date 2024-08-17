## **Arquitetura da Aplicação**

  A aplicação é desenvolvida utilizando uma arquitetura baseada em microserviços, o que permite uma maior modularidade, escalabilidade e facilidade de manutenção. Cada componente do sistema é executado em um container Docker separado, garantindo isolamento e facilidade de implantação. Abaixo estão descritos os principais componentes:

## **Front-end (React)**

O front-end da aplicação é implementado utilizando React, na versão **18.3.1**, e Bootstrap, na versão **5.3.3**, para a estilização e responsividade. Este componente é responsável por fornecer a interface gráfica do usuário (UI), onde os usuários interagem com o sistema. O front-end é encapsulado em um container Docker, o que facilita a implantação e atualização de novas versões da interface. As principais responsabilidades deste microserviço incluem:

  - Renderização de páginas e componentes dinâmicos.
  - Comunicação com o back-end via API RESTful.
  - Implementação de lógica de validação no cliente e experiência do usuário (UX).

## **Back-end (Spring Boot)**
O back-end é desenvolvido com Spring Boot, uma framework robusta e flexível para o desenvolvimento de aplicações Java. Este serviço é responsável por processar a lógica de negócio, autenticar e autorizar usuários, e fornecer uma API RESTful para interação com o front-end. Executado em um container Docker, o back-end é isolado e pode ser escalado independentemente. Suas principais funcionalidades incluem:

   - Gestão de autenticação e autorização de usuários.
   - Processamento de lógica de negócio, como o gerenciamento de feedbacks.
   - Exposição de endpoints REST para consumo pelo front-end.
   - Integração com o banco de dados PostgreSQL.

## **Banco de Dados (PostgreSQL)**
O armazenamento de dados é gerenciado por um banco de dados PostgreSQL, conhecido por sua robustez e conformidade com o padrão SQL. Este banco de dados é executado em um container Docker dedicado, garantindo isolamento e segurança dos dados. As responsabilidades incluem:

   - Armazenamento de informações críticas, como dados de usuários, feedbacks, e outras entidades do sistema.
   - Garantia de integridade e consistência dos dados.
   - Execução de consultas SQL para atender às solicitações do back-end.
   - Comunicação e Integração

Os componentes da aplicação se comunicam principalmente através de APIs RESTful. O front-end faz requisições HTTP ao back-end, que processa as solicitações, interage com o banco de dados conforme necessário e retorna as respostas apropriadas. Esta separação clara de responsabilidades permite que cada componente seja desenvolvido, testado e implantado de forma independente, facilitando a manutenção e escalabilidade do sistema.

## **Implantação e Orquestração**
A aplicação é composta por três principais containers Docker, cada um executando um dos componentes descritos. A orquestração dos containers pode ser gerenciada utilizando ferramentas como Docker Compose ou Kubernetes, permitindo a configuração de redes internas, volumes para persistência de dados, e regras de escalabilidade.
