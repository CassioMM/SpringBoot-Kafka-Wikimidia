# SpringBoot Kafka Wikimedia

Projeto desenvolvido com **Java + Spring Boot + Apache Kafka** para consumir eventos em tempo real da API pública da Wikimedia e realizar o processamento de mensagens utilizando arquitetura orientada a eventos.

O objetivo deste projeto é praticar conceitos modernos de backend, mensageria assíncrona e integração entre aplicações utilizando o ecossistema Spring. O projeto realiza a captura de eventos da Wikimedia e publica essas mensagens em tópicos Kafka para processamento em tempo real.



## Tecnologias Utilizadas

- Java
- Spring Boot
- Apache Kafka
- Spring Kafka
- Maven
- MySQL
- REST API
- JPA / Hibernate



## Conceitos Aplicados

- Comunicação assíncrona
- Event-Driven Architecture
- Producer e Consumer Kafka
- Integração com APIs externas
- Persistência de dados
- Backend com Spring Boot
- Processamento de eventos em tempo real



## Estrutura do Projeto

O projeto foi dividido em camadas para melhor organização e manutenção:

```bash
src/main/java
│
├── producer
├── consumer
├── config
├── entity
├── repository
├── service
└── controller
```

## Funcionalidades

- Consumo de eventos da API Wikimedia
- Publicação de mensagens em tópicos Kafka
- Consumo de mensagens com Kafka Consumer
- Integração com Spring Boot
- Estrutura backend organizada em camadas
- Persistência de dados com banco relacional

## Como Executar o Projeto
Pré-requisitos

Antes de começar, você precisará ter instalado:

- Java 17+
- Maven
- Apache Kafka
- MySQL
- IDE (IntelliJ, Eclipse ou VSCode)

## Clonar o Repositório
```bash
git clone https://github.com/CassioMM/SpringBoot-Kafka-Wikimidia.git
```

## Executar o Kafka

Inicie o Zookeeper:
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

Inicie o Kafka Server:
```bash
bin/kafka-server-start.sh config/server.properties
```

Crie o tópico Kafka:
```bash
bin/kafka-topics.sh --create \
--topic wikimedia_recentchange \
--bootstrap-server localhost:9092
```

## Executar a Aplicação
```bash
mvn spring-boot:run
```

## Fluxo da Aplicação
```bash
Wikimedia Stream API
        ↓
Kafka Producer
        ↓
Kafka Topic
        ↓
Kafka Consumer
        ↓
Banco de Dados
```

## Autor
Cássio Montenegro Marques
- LinkedIn: www.linkedin.com/in/cassio-montenegro
