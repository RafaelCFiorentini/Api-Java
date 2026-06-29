# Api-Java 🚀

> ⚠️ **Projeto em Desenvolvimento** - Este projeto ainda não está completo e está em fase inicial de desenvolvimento.

Projeto de **consumo de API externa** desenvolvido em **Java com Spring Boot 3.4.7**. A aplicação consome dados da **OMDB API** para buscar informações sobre séries de TV, temporadas e episódios.

## 📋 Sobre o Projeto

Uma aplicação backend que consome a **Open Movie Database (OMDB API)** para:
- 🔍 Buscar informações sobre séries de TV
- 📺 Listar temporadas de uma série
- 🎬 Exibir detalhes de episódios
- 📊 Processar e formatar dados JSON recebidos da API

## 🎯 Funcionalidades Principais

- **Consumo de API Externa**: Integração com OMDB API usando HttpClient
- **Conversão de Dados**: Desserialização de JSON para objetos Java usando Jackson
- **Menu Interativo**: Interface de linha de comando para buscar séries
- **Arquitetura em Camadas**: Separação clara entre camadas de modelo, serviço e apresentação

## 🛠️ Tecnologias

- **Java 21** - Linguagem de programação
- **Spring Boot 3.4.7** - Framework web e CLI
- **Maven** - Gerenciador de dependências
- **Jackson** - Serialização/Desserialização JSON
- **OMDB API** - API externa para dados de filmes e séries

## 📦 Dependências Principais

```xml
- spring-boot-starter
- jackson-databind (2.15.2) - Para processar JSON da API
```

## 🏗️ Arquitetura e Estrutura

```
src/main/java/com/rafael/springframework/
├── SpringframeworkApplication.java    # Classe principal da aplicação
├── model/                              # Modelos de dados
│   ├── DadosSerie.java                # Dados da série
│   ├── DadosTemporada.java            # Dados da temporada
│   ├── DadosEpisodio.java             # Dados do episódio
│   └── Episodio.java                  # Entidade Episódio
├── service/                            # Serviços de negócio
│   ├── ConsumirApi.java               # Consumo da OMDB API
│   ├── ConverterDados.java            # Conversão JSON → Objetos
│   └── IConverteDados.java            # Interface do conversor
└── principal/                          # Apresentação
    └── Principal.java                 # Menu e interação com usuário
```

## 🚀 Como Executar

### Pré-requisitos
- Java 21 ou superior
- Maven 3.6+
- Chave de acesso da OMDB API ([obter aqui](http://www.omdbapi.com/apikey.aspx))

### Configuração

1. **Clone o repositório**
   ```bash
   git clone https://github.com/RafaelCFiorentini/Api-Java.git
   cd Api-Java
   ```

2. **Configure a chave da API**
   
   Crie ou edite o arquivo `src/main/resources/application.properties`:
   ```properties
   omdb.api.key=SUA_CHAVE_AQUI
   ```

3. **Execute a aplicação**
   ```bash
   ./mvnw spring-boot:run
   ```

   Ou no Windows:
   ```bash
   mvnw.cmd spring-boot:run
   ```

4. **Build da aplicação**
   ```bash
   ./mvnw clean package
   ```

## 📡 Como Funciona

### Fluxo de Dados

```
Usuário (CLI)
     ↓
Principal.java (Menu)
     ↓
ConsumirApi.java (Faz requisição HTTP)
     ↓
OMDB API (Retorna JSON)
     ↓
ConverterDados.java (Converte JSON)
     ↓
Modelos (DadosSerie, DadosEpisodio...)
     ↓
Exibição dos dados formatados
```

## 🔌 Integração com OMDB API

A aplicação usa a classe `ConsumirApi` para fazer requisições à API externa:

```java
// Exemplo de busca de série
String url = "https://www.omdbapi.com/?t=" + nomeSerie + "&type=series&apikey=" + chave;
```

Os dados retornados em JSON são processados pelo `Jackson` e convertidos para os modelos Java correspondentes.

## 📝 Configuração

Configure a chave da OMDB API no arquivo de propriedades:
```properties
# src/main/resources/application.properties
omdb.api.key=SEU_API_KEY_AQUI
```

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se livre para:
- Reportar bugs
- Sugerir novas features
- Enviar pull requests
- Melhorar a documentação

## 📄 Licença

Este projeto está sob licença aberta. Verifique o arquivo LICENSE para mais detalhes.

## 👨‍💻 Autor

**Rafael C. Fiorentini**
- GitHub: [@RafaelCFiorentini](https://github.com/RafaelCFiorentini)

---

**Status do Projeto:** Em desenvolvimento 🔧

Para mais informações, abra uma issue ou entre em contato!
