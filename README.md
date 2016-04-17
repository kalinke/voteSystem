# Desafio Globo.com


## Desenvolvedor de software - RJ - Plataforma de Vendas


## Considerações Gerais

Você deverá usar este repositório para desenvolver seu projeto, ou seja, todos os seus commits devem estar registrados 
aqui, pois queremos ver como você trabalha.

Sua solução deve ser simples de ser executada, seguindo as condições abaixo:

* Precisamos conseguir rodar seu código no Mac e Ubuntu;
* Registre tudo: testes que forem executados, ideias que gostaria de implementar se tivesse tempo (explique como você 
as resolveria, se houvesse tempo), decisões que foram tomadas e os seus porquês, arquiteturas que foram testadas e os 
motivos de terem sido modificadas ou abandonadas;
* Documente as dependências necessárias, instruções de compilação, instalação, e execução. Por exemplo:

```
git clone .../repositorio.git
cd repositorio
./configure
make
```


## O Problema

Você deve desenvolver um sistema de votação para o paredão do BBB, em versão Web com HTML/CSS/Javascript e com o 
backend usando Java, Python, Go ou Ruby. 

O paredão do BBB consiste em uma votação que confronta dois integrantes do programa BBB. A votação é apresentada em uma 
interface acessível pela Web, onde os usuários optam por votar em um dos integrantes apresentados. Uma vez realizado o 
voto, o usuário recebe uma tela com a confirmação do sucesso de seu voto e um panorama percentual dos votos por candidato 
até aquele momento.

Aqui neste repositório, você encontrará algumas imagens necessárias para implementação da parte Web: uma com o desenho 
da tela e outra com um sprite de imagens que talvez você deseje usar.


### Regras

1. Os usuários podem votar quantas vezes quiserem independente da opção escolhida, entretanto, a produção do programa 
não gostaria de receber votos oriundos de uma máquina e sim votos de pessoas.
2. A votação é chamada em horário nobre, com isso, é esperado um volume elevado de votos. Para exemplificar, vamos 
trabalhar com 1000 votos/segundo.
3. A interface do produto é extremamente importante pois os organizadores são exigentes. Porém, você não tem muito 
tempo, então faça o melhor possível no tempo que tem.
4. A produção do programa gostaria de consultar numa URL, o total geral de votos, o total por participante e o total de 
votos por hora.


### O que será avaliado na sua solução?

1. Sua solução será submetida a uma bateria de testes de performance para garantir que atende a demanda de uma chamada 
em TV (performance e escalabilidade).
2. Seu código será observado por uma equipe de desenvolvedores que avaliará a simplicidade e clareza da solução, a 
arquitetura, documentação, estilo de código, testes unitários, testes funcionais, nível de automação dos testes, o 
design da interface, implementação do código, e a organização geral projeto.