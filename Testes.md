# Testes Automatizados
Utilizado para verificar se o software entrega corretamente o que propõe. Importante para garantir a qualidade do software a ser entregue.

## Tipos de Teste

### Teste de Unidade
Testa partes individuais do código, como classes ou métodos para verificarem se estão funcionando conforme foram planejados.  
  **Ferramentas:** jUnit. Mockito, TestNG, WireMock, PowerMoc, dbUnit

### Teste de Integração
Testa o software em execução completa, validando as integrações com sistemas externos, bando de dados etc.  
  **Ferramentas:** TestNg, RestAssured, Postman


### Teste de Aceitação
São realizados para verificarem se o comportamento do sistema está conforme o esperado, atendendo aos requisitos de negócio.  
**Ferramentas:** Cucumber, Selenium, JBehave, RestAssured, Serenity, WireMock, JGiven


### Teste de Regressão
Testa se o software continua funcionando corretamente após a implementação de alguma mudança.  
**Ferramentas:** jUnit, Mockito, TestNG, Selenium, 

### Teste de Stress / Performance
Testa como o software responde em situações adversas, como grandes quantidades de requisições ou volume de dados. Avalia, dentre outros, tempo de resposta, escalabilidade, estabilidade etc.  
**Ferramentas:** jMeter, Gatling, Grinder, Tsung

### Teste de Segurança
Usados para identificar vulnerabilidades e resistência em diversos tipos de ataques.  
**Ferramentas:** OWASP Zap, Burp Suite, Netsparker, 

## Ferramentas

### JUnit
É um framework de teste que fornece anotações para definir testes e assertivas para verificar resultados. É usado para escrever e executar testes unitários, com a finalidade de garantir que partes individuais de um programa funcionem conforme o esperado. Utilizado no desenvolvimento ágil e orientado a testes (TDD).
#### Vantagens
* Facilita a execução de testes automatizados.
* Integração com muitas ferramentas de construção e IDEs.
* Suporte a testes parametrizados.
#### Desvantagens
* Algumas funcionalidades mais avançadas exigem o uso de bibliotecas adicionais.
#### Anotações
* @Test: Anotação usada para indicar que é um método de teste.
* @Before: Anotação usada para indicar que um método deve ser executado antes dos métodos de teste.
* @After: Anotação usada para indicar que um método deve ser executado após os métodos de teste.
* @BeforeEach: Indica que um método deve ser executado antes de cada teste.
* @AfterEach: Indica que um método deve ser executado após cada teste.

------------

### Mockito
É um framework que permite criar dinamicamente mocks (simulações) de objetos para isolar o código durante os testes, substituindo dependências por mocks. Oferece métodos para verificar as chamadas dos métodos mockados.
#### Vantagens
* Facilita a criação de testes isolados.
* Permite verificar interações entre objetos.
* Simplifica a simulação de comportamentos específicos.
#### Desvantagens
* Pode ser excessivamente usado, levando a testes frágeis.
* Não é adequado para todos os tipos de testes.
#### Métodos
* When:  Usado para configurar um comportamento esperado em um mock, indicando o que fazer quando um método específico for chamado.
* thenReturn: Usado em conjunto com when para definir o valor que um mock deve retornar quando um método específico for chamado.
* Verify: Usado para verificar se um método específico em um mock foi chamado com argumentos específicos durante o teste. Pode ser usado para garantir que certos métodos foram chamados ou não chamados durante a execução dos testes. Pode ser passado um objeto específico para verificação OU
    * any(): qualquer valor de qualquer tipo.
    * anyString(): qualquer valor de tipo String.
    * anyInt(): qualquer valor de tipo int.
    * anyObject(): qualquer valor de qualquer tipo de objeto
#### Anotações
* @Mock: Usada para criar um mock (simulação) de uma classe ou interface. Mocks são objetos simulados que podem ser configurados para retornar valores específicos durante testes. Quando você anota um campo com @Mock, o Mockito cria automaticamente uma instância simulada para a classe ou interface associada a esse campo.
* @InjectMocks: Usada para injetar automaticamente mocks criados com @Mock em uma instância da classe que está sendo testada. 
* @ExtendWith: Usada no JUnit 5 para estender o modelo de execução de testes. Ela permite adicionar extensões ao ciclo de vida dos testes. Quando você usa o Mockito com o JUnit 5, é comum estender o teste com a classe MockitoExtension usando @ExtendWith(MockitoExtension.class). Isso configura o ambiente para usar as anotações do Mockito, como @Mock e @InjectMocks.

------------

### DbUnit
É uma extensão do JUnit que simplifica o teste de código que interage com bancos de dados.  É usado para criar e manter conjuntos de dados consistentes para testes de banco de dados. Ajuda a garantir que a lógica de negócios não seja afetada por mudanças no esquema do banco de dados.
#### Características
* Permite a inicialização e limpeza de dados de teste em bancos de dados.
* Pode ser usado com várias fontes de dados, como XML, CSV, Excel, entre outros.
#### Vantagens
* Isola testes de banco de dados de mudanças no esquema real do banco de dados.
* Ajuda na criação de ambientes de teste repetíveis.
#### Desvantagens
* Pode ser um pouco complexo de configurar e usar inicialmente.
* Pode requerer algum esforço para manter conjuntos de dados de teste.

------------

### Selenium
É um conjunto de ferramentas para automação de testes de aplicações web.  É usado para automatizar interações com páginas da web, simular ações do usuário e verificar se o comportamento do aplicativo web está de acordo com o esperado.

------------

### JMeter
É uma ferramenta de teste de carga e desempenho, usado para simular cargas pesadas em servidores, medir o desempenho e analisar o comportamento do sistema sob diferentes condições. 
Suporta vários tipos de testes, incluindo testes de carga, estresse, desempenho e funcionalidade. Pode ser usado para testar vários protocolos, como HTTP, FTP, JDBC, entre outros.
#### Vantagens
* Facilita a criação de cenários complexos de teste de carga.
* Fornece relatórios detalhados sobre o desempenho do sistema.
#### Desvantagens
* Pode ter uma curva de aprendizado íngreme para usuários iniciantes.
* A configuração adequada pode ser crítica para obter resultados precisos.

------------

### WireMock
É uma ferramenta para simulação de serviços HTTP, usado para criar mocks de serviços HTTP, permitindo que você simule respostas de serviços reais durante testes.
#### Vantagens:
* Facilita o isolamento de serviços para testes unitários e de integração.
* Permite a simulação de diferentes cenários de resposta.
#### Desvantagens:
* Limitado a simulações de serviços HTTP.

------------

### Cucumber
É uma ferramenta BDD que permite escrever testes em linguagem natural, usado para escrever testes de aceitação.

------------

### JBehave
É um framework BDD que segue a sintaxe "Given/When/Then" usado para escrever testes de aceitação em uma linguagem natural e estruturada.

------------

### JGiven
É um framework BDD usado para criar testes de aceitação com uma sintaxe clara e compreensível.

------------

### RestAssured
É uma biblioteca usada para automatizar testes em APIs RESTful, permitindo validação de respostas JSON e XML.

------------

### Serenity BDD
É um framework que combina BDD, teste de aceitação e gera relatórios detalhados.

------------

### OWASP ZAP (Zed Attack Proxy)
É uma ferramenta de teste de segurança de código aberto projetada para encontrar vulnerabilidades em aplicações web, como injeção SQL, XSS, CSRF, entre outras.
#### Características:
* Scanner de segurança automatizado.
* Varredura passiva e ativa.
* Interceptação de tráfego para análise manual.
* Suporte a testes automatizados e integração com pipelines de CI/CD.
#### Vantagens:
* Gratuito e de código aberto.
* Atualizações frequentes e comunidade ativa.
* Interface gráfica amigável.
#### Desvantagens:
* Pode gerar falsos positivos/negativos.
* Exige conhecimento em segurança web para análise efetiva.

------------

### Burp Suite
É uma ferramenta abrangente para testes de segurança de aplicações web, incluindo scanner de vulnerabilidades, proxy e ferramentas para análise manual.
#### Características:
* Scanner de segurança automatizado.
* Proxy para interceptação e modificação de tráfego.
* Ferramentas para análise manual.
* Suporte a extensões.
#### Vantagens:
* Poderosa e versátil.
* Suporte extensivo à comunidade.
* Atualizações regulares.
#### Desvantagens:
* A versão completa é paga.
* Pode ter uma curva de aprendizado íngreme.

------------

### Netsparker
É uma ferramenta de segurança automatizada que verifica automaticamente vulnerabilidades em aplicações web.
#### Características:
* Scanner de segurança automatizado.
* Identificação de vulnerabilidades como injeção SQL, XSS, etc.
* Relatórios detalhados.
#### Vantagens:
* Interface amigável.
* Detecção automática de vulnerabilidades.
* Relatórios detalhados e compreensíveis.
#### Desvantagens:
* Versão completa é paga.
* Pode gerar falsos positivos/negativos.

------------

### Gatling
É uma ferramenta de teste, usado para avaliar o desempenho de aplicações web por meio de testes de carga e stress.
#### Características:
* DSL (Domain Specific Language) fluente para escrever scripts.
* Suporte a execução distribuída.
* Relatórios detalhados em HTML.
#### Vantagens:
* Eficiente e escalável.
* Sintaxe fluente para criação de scripts.
* Geração de relatórios detalhados.
#### Desvantagens:
* Curva de aprendizado para usuários não familiares com Scala.

------------

### Tsung
É uma ferramenta de teste de estresse de código aberto que suporta vários protocolos, incluindo HTTP e WebSocket.
#### Características:
* Suporte a testes distribuídos.
* Pode ser estendido por meio de scripts Lua.
* Geração de relatórios.
#### Vantagens:
* Suporte a testes distribuídos.
* Pode ser estendido por meio de scripts Lua.
* Geração de relatórios detalhados.
#### Desvantagens:
* Pode exigir conhecimento em Lua para extensibilidade.

## JaCoCo
O JaCoCo (Java Code Coverage) é uma ferramenta de análise de cobertura de  que ajuda a medir a eficácia dos seus testes unitários, mostrando quais partes do código foram cobertas pelos testes e quais partes ainda precisam ser testadas. O relatório do JaCoCo, obtém uma visão detalhada da cobertura de código do seu projeto. 
### Geração do Relatório:
Depois de executar os testes, você pode gerar o relatório JaCoCo. Isso pode ser feito executando um comando específico ou usando um **goal/plugin** do Maven ou Gradle, dependendo de como você configurou o JaCoCo.

```
mvn clean test jacoco:report 
```

### Visualização do Relatório:
Os relatórios geralmente são gerados no diretório **target/site/jacoco** (Maven) ou **build/reports/jacoco/test** (Gradle). Abra o arquivo **index.html** no seu navegador para visualizar o relatório.
O relatório geralmente inclui informações como:
* Cobertura por Classe: Mostra quais classes foram cobertas pelos testes e em que percentagem.
* Cobertura por Método: Detalha a cobertura de cada método dentro das classes.
* Cobertura por Linha: Indica quais linhas de código foram executadas durante os testes.
