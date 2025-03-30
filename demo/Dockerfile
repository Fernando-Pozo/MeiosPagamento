# Usando a imagem do Maven para compilar o aplicativo
FROM jelastic/maven:3.9.5-openjdk-21 AS builder

# Definindo o diretório de trabalho no contêiner
WORKDIR /app

# Copiando o arquivo de definição de projeto e os arquivos de código-fonte
COPY pom.xml .
COPY src ./src

# Compilando o aplicativo e gerando o arquivo JAR
RUN mvn clean install -Ppackage -DskipTests=true

# Usando a imagem do Amazon Corretto para executar o aplicativo
FROM amazoncorretto:21-al2-jdk

WORKDIR /app

# Copie o JAR gerado a partir da etapa anterior para o contêiner
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar .
COPY --from=builder /app/target/*.properties .

# Expondo a porta que o aplicativo está ouvindo
EXPOSE 8080

# Comando para iniciar o aplicativo
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]