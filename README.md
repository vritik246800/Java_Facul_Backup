# Conjunto de Projetos Java

Uma coleção de projetos Java demonstrando diferentes conceitos, padrões e tecnologias do ecossistema Java.

## 📋 Índice

- [Visão Geral](#visão-geral)
- [Projetos Incluídos](#projetos-incluídos)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
- [Como Executar](#como-executar)
- [Estrutura dos Projetos](#estrutura-dos-projetos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Padrões e Práticas](#padrões-e-práticas)
- [Testes](#testes)
- [Documentação](#documentação)
- [Contribuição](#contribuição)
- [Licença](#licença)

## 🎯 Visão Geral

Este repositório contém uma coleção de projetos Java desenvolvidos para demonstrar boas práticas de programação, padrões de design, e diferentes tecnologias do ecossistema Java. Cada projeto é independente e focado em aspectos específicos do desenvolvimento Java.

## 📁 Projetos Incluídos

### 1. **projeto-core**
- **Descrição**: Funcionalidades básicas e utilitários comuns
- **Tecnologias**: Java 17, Maven
- **Foco**: Algoritmos, estruturas de dados, utilitários

### 2. **projeto-web**
- **Descrição**: Aplicação web RESTful
- **Tecnologias**: Spring Boot, Spring MVC, JPA
- **Foco**: APIs REST, persistência de dados

### 3. **projeto-microservices**
- **Descrição**: Arquitetura de microserviços
- **Tecnologias**: Spring Cloud, Docker, Eureka
- **Foco**: Distribuição, comunicação entre serviços

### 4. **projeto-desktop**
- **Descrição**: Aplicação desktop
- **Tecnologias**: JavaFX, FXML
- **Foco**: Interface gráfica, eventos

### 5. **projeto-cli**
- **Descrição**: Aplicação de linha de comando
- **Tecnologias**: Picocli, GraalVM
- **Foco**: Processamento de argumentos, performance

## 🔧 Pré-requisitos

- **Java**: JDK 17 ou superior
- **Maven**: 3.8+ ou **Gradle**: 7.0+
- **Docker**: Para projetos containerizados
- **IDE**: IntelliJ IDEA, Eclipse, ou VS Code

### Verificar Instalação

```bash
java -version
mvn -version
docker --version
```

## 🚀 Instalação e Configuração

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/projetos-java.git
cd projetos-java
```

### 2. Instalar Dependências (Maven)

```bash
# Para todos os projetos
mvn clean install

# Para um projeto específico
cd projeto-web
mvn clean install
```

### 3. Configurar Variáveis de Ambiente

```bash
# Configurações do banco de dados
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=projeto_db
export DB_USER=usuario
export DB_PASSWORD=senha

# Configurações da aplicação
export APP_PORT=8080
export APP_PROFILE=dev
```

### 4. Configurar Banco de Dados (se aplicável)

```bash
# Docker Compose para serviços auxiliares
docker-compose up -d
```

## ▶️ Como Executar

### Executar Todos os Testes

```bash
mvn test
```

### Executar Projeto Web

```bash
cd projeto-web
mvn spring-boot:run
```

### Executar Projeto CLI

```bash
cd projeto-cli
mvn compile exec:java -Dexec.mainClass="com.exemplo.cli.Main" -Dexec.args="--help"
```

### Executar com Docker

```bash
# Build da imagem
docker build -t projeto-java .

# Executar container
docker run -p 8080:8080 projeto-java
```

## 📂 Estrutura dos Projetos

```
projetos-java/
├── projeto-core/
│   ├── src/
│   │   ├── main/java/
│   │   ├── main/resources/
│   │   └── test/java/
│   ├── pom.xml
│   └── README.md
├── projeto-web/
│   ├── src/
│   │   ├── main/java/
│   │   │   └── com/exemplo/web/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       └── config/
│   │   ├── main/resources/
│   │   └── test/java/
│   ├── Dockerfile
│   ├── pom.xml
│   └── README.md
├── docker-compose.yml
├── pom.xml (parent)
└── README.md
```

## 🛠️ Tecnologias Utilizadas

### Core Java
- **Java 17**: LTS com features modernas
- **Maven/Gradle**: Gerenciamento de dependências
- **JUnit 5**: Framework de testes
- **Mockito**: Mocking para testes

### Frameworks
- **Spring Boot**: Framework para aplicações Java
- **Spring Security**: Segurança e autenticação
- **Spring Data JPA**: Persistência de dados
- **Hibernate**: ORM
- **Jackson**: Serialização JSON

### Ferramentas de Desenvolvimento
- **Lombok**: Redução de boilerplate
- **MapStruct**: Mapeamento de objetos
- **SLF4J + Logback**: Logging
- **Swagger/OpenAPI**: Documentação de APIs

### Containerização e Cloud
- **Docker**: Containerização
- **Docker Compose**: Orquestração local
- **Kubernetes**: Orquestração em produção

## 📐 Padrões e Práticas

### Arquitetura
- **Clean Architecture**: Separação de responsabilidades
- **Dependency Injection**: Inversão de controle
- **Repository Pattern**: Abstração de dados
- **Service Layer**: Lógica de negócio

### Código
- **SOLID Principles**: Princípios de design
- **DRY (Don't Repeat Yourself)**: Evitar duplicação
- **KISS (Keep It Simple, Stupid)**: Simplicidade
- **Convention over Configuration**: Convenções padrão

### Qualidade
- **Code Coverage**: Mínimo de 80%
- **Static Analysis**: SonarQube, SpotBugs
- **Code Style**: Google Java Style Guide
- **Documentation**: Javadoc para APIs públicas

## 🧪 Testes

### Estrutura de Testes

```
src/test/java/
├── unit/          # Testes unitários
├── integration/   # Testes de integração
└── e2e/          # Testes end-to-end
```

### Executar Testes

```bash
# Todos os testes
mvn test

# Testes específicos
mvn test -Dtest=NomeDaClasse

# Com cobertura
mvn jacoco:prepare-agent test jacoco:report
```

### Relatórios
- **JaCoCo**: Cobertura de código
- **Surefire**: Relatórios de teste
- **Allure**: Relatórios avançados

## 📚 Documentação

### APIs
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI Spec**: `http://localhost:8080/v3/api-docs`

### Javadoc
```bash
mvn javadoc:javadoc
# Documentação disponível em target/site/apidocs/
```

### Arquitectura
- Diagramas disponíveis em `docs/architecture/`
- Documentação técnica em `docs/technical/`

## 🤝 Contribuição

### Como Contribuir

1. **Fork** o projeto
2. **Crie** uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. **Commit** suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. **Push** para a branch (`git push origin feature/nova-feature`)
5. **Abra** um Pull Request

### Padrões de Commit
- `feat:` Nova funcionalidade
- `fix:` Correção de bug
- `docs:` Documentação
- `style:` Formatação
- `refactor:` Refatoração
- `test:` Testes
- `chore:` Manutenção

### Code Review
- Todos os PRs devem ser revisados
- Testes devem passar
- Cobertura de código mantida
- Documentação atualizada

## 📋 Roadmap

- [ ] Implementar autenticação JWT
- [ ] Adicionar cache Redis
- [ ] Integração com Kafka
- [ ] Deploy no Kubernetes
- [ ] Monitoramento com Prometheus
- [ ] CI/CD com GitHub Actions

## 🐛 Issues Conhecidos

- Performance da query X pode ser otimizada
- Timeout ocasional no serviço Y
- Documentação do módulo Z precisa ser atualizada

## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## 👥 Autores

- **Seu Nome** - *Desenvolvimento inicial* - [seu-github](https://github.com/seu-usuario)

## 🙏 Agradecimentos

- Comunidade Java
- Contribuidores do projeto
- Bibliotecas e frameworks utilizados

---

**📞 Contato**

Para dúvidas ou sugestões, abra uma issue ou entre em contato:
- Email: seu.email@exemplo.com
- LinkedIn: [seu-perfil](https://linkedin.com/in/seu-perfil)

---

*Última atualização: Setembro 2025*
