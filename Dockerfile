FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Baixa e copia o arquivo JAR do OpenTelemetry Agent diretamente do repositório Maven central para o diretório de trabalho no contêiner
COPY opentelemetry-javaagent-1.23.0.jar /app/opentelemetry-javaagent.jar

# Copia o arquivo JAR do seu aplicativo para o diretório de trabalho no contêiner
COPY /target/*.jar main.jar

# Define as variáveis de ambiente para configurar o agente Java do OpenTelemetry
ENV JAVA_TOOL_OPTIONS "-javaagent:/app/opentelemetry-javaagent.jar"
ENV OTEL_RESOURCE_ATTRIBUTES="service.name=your-application"

# Comando para iniciar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "main.jar"]
