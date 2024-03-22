#!/bin/sh

# Executa mvn clean package
echo "Executando mvn clean package..."
mvn clean package

# Verifica se a compilação foi bem-sucedida
if [ $? -ne 0 ]; then
echo "Erro ao compilar o projeto. Abortando o script."
exit 1
fi

# Executa docker-compose up
echo "Executando docker-compose up..."
docker-compose up
echo "Executando mvn clean package..."
mvn clean package

if [ $? -ne 0 ]; then
echo "Erro ao compilar o projeto. Abortando o script."
exit 1
fi

# Executa docker-compose up
echo "Executando docker-compose up..."
docker-compose up