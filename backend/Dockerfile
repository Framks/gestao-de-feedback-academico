# Use uma imagem base com Maven e Java
FROM maven:3-amazoncorretto-17-debian AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml e outros arquivos de configuração do Maven
COPY pom.xml ./
COPY src ./src

# Instale as dependências e faça o build da aplicação, incluindo testes
RUN mvn clean package -DskipTests=false

# Segunda fase - runtime do JAR
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho para a aplicação no contêiner final
WORKDIR /app

# Copie o JAR da fase de build para o contêiner
COPY --from=build /app/target/feedback-academico-0.0.1-SNAPSHOT.jar /app/feedback-academico.jar

# Exponha a porta que a aplicação usará
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "feedback-academico.jar"]
