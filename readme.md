# Desafio crud clickbus

Esse é o desafio da clickbus(https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer) implementado usando as idéias do meu artigo DDD para aplicações web modernas(https://github.com/asouza/pilares-design-codigo/blob/master/ddd-da-massa.md).

A ideia é sempre começar com o código suficiente para resolver o problema e avaliar a divisão de responsabilidades pelo olhar da teoria da carga cognitiva e não por uma idea já definida em algum livro. Sugiro que fique de mente aberta quando olhar o fonte :). 

## Como é a contagem de pontos cognitivos para identifcar divisão de responsabilidades

Abaixo você tem a lista do que é levado em consideração neste momento por arquivo(hipótese atual)

- Acoplamento contextual conta um ponto. Aqui só é considerado acoplamento quando você utiliza uma classe que não faz parte das tecnologias fundamentais da sua aplicação. 
- if,else,loop,try,catch e qualquer operação operacao booleana(||,&&,?,:)
- Utilização de função como argumento também conta, já que é uma branch de código(ainda está sob forte análise).
- Todo novo arquivo também conta um ponto. 

A regra é simples: cada um dos itens listados acima conta um ponto cognitivo. 

- Classes com estado inteligente(aquelas que tem realmente atributos que você pode fazer lógica em cima) tem um limite de 9 pontos. Neste projeto o exemplo está em ```Place```, ```BasicPlaceRequest``` e ```BasicPlaceResponse```. 
- Classes que não possuem estado inteligente tem um limite de 7 pontos. Neste projeto o único exemplo é ```CrudPlacesController```. 

## Existe uma branch chamada springwebflow

Nessa branch tem o exemplo de código utilizando uma lib que estou desenvolvendo construída em cima do Spring e das ideias que tenho sobre desenvolvimento simples e eficiente. Fique a vontade para dar uma olhada. 

O legal é que levando em consideração minhas regras de pontos cognitivos, o código do controller quebra com o uso da lib. Essa vai ser mais uma hipótese a ser avaliada: funções como argumento devem ser levadas em consideração?


## Saiba mais sobre mim :). 
- https://deveficiente.com/ (aqui você se inscreve para saber da próxima turma do(a) dev eficiente)
- https://www.youtube.com/c/deveficiente
- https://twitter.com/alberto_souza
- https://www.facebook.com/deveficiente/
- https://medium.com/@albertosouza_47783