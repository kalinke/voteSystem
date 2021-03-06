# Desafio XXXX

# Pré-requisitos
- Oracle JDK 8
- MySQL 5
- Maven 3

# Configurações Gerais
- Spring Boot 1.3.3 para o back-end
- AngularJS e Bootstrap para o front-end
- Maven 3 para controle de dependências no back-end
- Bower para controle de dependências do front-end
- Testes com JUnit e Mockito

# Considerações back-end
Após ler alguns artigos optei pela simplicidade do Spring Boot. Alguns autores fizeram sistemas e testes com até 2000 requests/segundo com resposta média de até 2 segundos. Como o Spring Boot já possui um Tomcat internamente a facilidade para fazer a aplicação rodar é grande. Optei pela utilização do MySQL como base de dados pois além de ser uma boa solução grátis, é um dos bancos de dados mais utilizados.
Rodei vários testes com JMeter utilizando o meu próprio computador, o hardware não é muito novo, então acredito que o desempenho para essa configuração esteja bem satisfatório. 

O Spring por padrão trabalha com o chamado Blocking REST que faz o lock da thread até o response, isso é um problema quando dependemos de um processo externo como consultar outro sistema ou o retorno do banco de dados. Por isso também fiz alguns testes utilizando Non-Blocking REST, para isso o Spring disponibiliza a classe DefferedResult, o processamento é feito, a thread continua a execução e no futuro alguma outra thread assume o retorno do processamento. 

- Os testes:
Inicialmente, com 200 threads do tomcat e um serviço blocking, testei com 1500 req/seg e obtive entre todas as responses uma média de 2 segundos, tendo alguns responses com picos de até 4 segundos. 
Depois disso, fiz o mesmo teste com 2000 threads no tomcat, o resultado não foi muito diferente, acredito que por limitação do hardware, pois a todo momento o processamento estava a 99%, mas o consumo de memória não foi alto.
Infelizmente, os testes com DefferedResult não diferenciaram o suficiente para justificar a utilização dele aqui, a média não foi muito mais baixa. Como o único recurso externo utilizado foi o banco de dados, credito a isso.

# Considerações front-end:
Por se tratar de um sistema com uma tela relativamente simples optei pelo básico de AngularJS + Bootstrap.
A produtividade com os dois é muito rápida, os dois frameworks são bastantes estáveis e maduros, além de ter muito suporte de toda uma comunidade. 
Em uma breve análise identifiquei todos os componentes que seriam necessários para o desenvolvimento e já sabia que o AngularJS teria bibliotecas prontas para eles, bastando apenas soliciar o download no bower e importa-las nos módulos do AngularJS.
Outro fator que chama a atenção no AngularJS é o two way binding para a camada REST evitando o refresh de tela a todo momento.
No caso do Bootstrap é a facilidade com que conseguimos incluir e modificar os componentes na tela com seus componentes prontos e as classes já com alinhamentos.
Em geral nas empresas que trabalhei todas possuem os componentes como a barra superior da globo.com já desenvolvido e em um repositório para uso comum, por isso tentei apenas simular no layout a inclusão da barra da globo.com e o header do big brother brasil. 

# Execução

Download 
```
git clone https://github.com/kalinke.git
cd "diretorio_de_download"
mvn package
```

Editar as configurações do banco de dados com informações da string de conexão do mysql e usuário e senha no arquivo src/main/resources/application.properties. O JPA está configurado para crias as tabelas automáticamente.

```
spring.datasource.url: jdbc:mysql://IP:PORT/DATABASE
spring.datasource.username=USER
spring.datasource.password=PASSWORD
```

Caso o serviço não seja executado localmente, é necessário desativar o reCAPTCHA pois ele depende de uma key de API para cada domínio.
Para a desativação para editar o arquivo src/main/resources/static/angular.property
```
"enableCaptcha": false
```

Para rodar a aplicação com o próprio Spring
```
mvn spring-boot:run 
```
Ou é possível utilizar a própria JVM para execução
```
cd target/
java -jar bbbvoting-"versao".jar
```
Por padrão acessar a URL http://ip:8080 que o sistema já estará iniciado, também é possível configurar porta e ContextRoot adicionando as seguintes configurações ao arquivo application.properties
```
server.contextPath=/contextroot
server.port=1234
```

- Serviços REST estão na URL http://ip:porta/"serviço"
  - http://ip:porta/vote GET - retorna o percentual atual da votação
  - http://ip:porta/report GET - retorna as informações para o relatório
  - http://ip:porta/vote POST(Object vote {"option":""}) envia o voto do usuário

- URL Relatório Resultados: http://ip:porta/#/relatorio

# Testes 
- Criei alguns testes unitários com mock para a camada de serviço e banco de dados e de integração para o consumo do serviço rest.
- /src/test/java

# Outras considerações e melhorias

- O Bower acabou baixando todo o source dos plugins dos repositorios do github, não me preocupei com isso nesse primeiro momento, basta apenas fazer um filtro e excluir os arquivos não utilizados do mesmo.
- É possível fazer uma análise bem detalhada de dependencias e testes com o maven site, basta executar "mvn site" e acompanhar o resultado que é exportado na pasta target do sistema, a primeira intenção era fazer a integração com o próprio GitHub para deploy das estatísticas para o acompanhamento aqui, o GitHub tem todas as bibliotecas necessárias para isso.
- Como solicitado o relatório está bem simples, optei pelo JDBC Template e um módulo simples de AngularJS pois era mais fácil, rápido e organizado apenas escrever uma query e popular o grid, mas acredito que poderia sim obter muito mais informações nos votos, como por exemplo a localização do usuário e utilizar algum framework de reports para análises estatísticas dos votos.
- O Catpcha foi apenas uma das soluções que pensei para evitar votos de robos, acredito também que é necessário uma proteção adicional na chamada do POST algo como troca de chaves entre back-end e front-end, limitação temporal de votos, limitação do IP, algo a ser discutido com segurança/infraestrutura acredito. - Não executei nenhum tipo de tunning para o MySQL mas sei que nas configurações dele é bem possível.
- O Spring tem integração com muitos frameworks de cluster e escalabilidade, posso citar como exemplo o Spring for Apache Hadoop (http://projects.spring.io/spring-hadoop).
- Implementei apenas um mock do tempo para fim da votação, o que faria seria a inclusão de uma tabela com propriedades do sistema com a data limite do sistema e não permitiria a votação após o tempo excedido, caso o usuário entrasse na URL para votar após o tempo iria ser redirecionado até a tela de resultados.

