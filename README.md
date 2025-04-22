# Coworking-clean

O **Coworking** é uma aplicação Java para cadastro de reservas, que pratica os elementos da arquitetura limpa.
A aplicação gerencia dados de reservas com persistência em banco de dados SQL, utilizando Flyway para versionamento de schemas e Docker para containerização, garantindo um ambiente consistente e portátil.

## 🚀 Começando

Estas instruções ajudarão você a obter uma cópia do projeto em funcionamento na sua máquina local para desenvolvimento e testes.

### 📋 Pré-requisitos

Antes de iniciar, certifique-se de ter as seguintes ferramentas instaladas:

- Java Development Kit (JDK) 21 ou superior
- Maven
- Docker


### 🔧 Instalação

Siga os passos abaixo para configurar o ambiente de desenvolvimento:

1. Clone o repositório:

```bash
git clone https://github.com/GuilhermeD9/Coworking-clean.git
```

2. Acesse o diretório do projeto:

```bash
cd coworking-clean
```

3. Construa o projeto com o Maven:

```bash
mvn clean install
```

4. Inicie os containers Docker:

```bash
docker-compose up
```

Após esses passos, a aplicação estará disponível para uso e testes.

## 📦 Implantação

Para implantar a aplicação em um ambiente de produção, siga os passos:

1. Certifique-se de que todas as dependências estejam atualizadas e que os testes passem sem erros.

2. Construa a imagem Docker para produção:

```bash
docker build -t coworclean:latest .
```

3. Inicie o container em modo detach:

```bash
docker run -d -p 8080:8080 coworclean:latest
```

A aplicação estará disponível na porta 8080 do seu servidor.

## 🛠️ Construído com

As principais ferramentas e frameworks utilizados no projeto são:

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework principal para construção da aplicação
* [Flyway](https://flywaydb.org/) - Versionamento de banco de dados
* [Docker](https://www.docker.com/) - Containerização da aplicação


## ✒️ Autores

Mencionamos abaixo os principais contribuidores para o projeto:

* **Guilherme Silva** - *Desenvolvedor Principal* - [GuilhermeD9](https://github.com/GuilhermeD9)

## 📄 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE.md](https://github.com/GuilhermeD9/coworking-clean/blob/main/LICENSE.md) para detalhes.

## 🎁 Expressões de gratidão

* Agradecemos a todos que contribuíram para o desenvolvimento deste projeto.
* Se você gostou do CoworClean, compartilhe com seus amigos e colegas! 📢
