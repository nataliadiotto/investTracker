# Etapa 1: Construir a aplicação usando uma imagem Maven
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Copiar o arquivo pom.xml e os arquivos de código-fonte para o contêiner
COPY pom.xml /app/
COPY src /app/src/

# Definir o diretório de trabalho
WORKDIR /app

# Executar a construção da aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Criar a imagem final
FROM eclipse-temurin:21-jre-alpine

# Adicionar metadados sobre a imagem
LABEL authors="DiottoNatalia"

# Copiar o artefato gerado da etapa de construção
COPY --from=build /app/target/*.jar /app/app.jar

# Definir o diretório de trabalho na nova imagem
WORKDIR /app

# Expor a porta que a aplicação usará
EXPOSE 8085

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]


