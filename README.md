# Hamburgueria — Padrões de Projeto

Projeto em **Java 17 + Maven + JUnit 5** que modela uma hamburgueria e
aplica os padrões de projeto vistos em aula. Construído de forma
incremental: cada padrão é introduzido conforme avança a disciplina.

## Padrões aplicados

| Padrão              | Status |
|---------------------|--------|
| Abstract (classe abstrata + Template Method) | implementado |
| Decorator           | implementado |
| Abstract Factory    | implementado |
| Bridge              | implementado |
| Builder             | implementado |
| Singleton           | implementado |
| Factory Method      | implementado |
| Observer            | implementado |

## Requisitos

### Funcionais
1. Montar um lanche concreto (Hambúrguer, X-Burguer, X-Salada, X-Tudo).
2. Adicionar um ou vários adicionais a um lanche (Bacon, Queijo Extra, Ovo,
   Catupiry), acumulando preço e descrição automaticamente.
3. Montar um combo (Lanche + Bebida + Acompanhamento) de uma família
   coerente (Tradicional, Vegano, Infantil) e aplicar desconto de combo.
4. Criar um pedido em uma modalidade (Balcão ou Delivery) e associar uma
   forma de pagamento (Pix, Cartão, Dinheiro), combinando modalidade e
   pagamento livremente.
5. Emitir o cupom do pedido com itens, subtotal, taxas/descontos e total.
6. Acompanhar o ciclo de vida do pedido (Recebido → Preparando → Pronto →
   Entregue), notificando observadores (cozinha, painel do cliente).

### Não-funcionais
- Java 17 (bytecode de destino).
- Dependência única: JUnit Jupiter 5.10.2 (escopo de teste).
- Nenhum framework externo, apenas biblioteca padrão.
- Todos os casos de teste devem passar (`mvn test`).

## Padrões aplicados — rastreabilidade

Os nomes das classes refletem o domínio (hamburgueria), não o padrão.
A coluna abaixo mapeia cada classe ao papel que ela exerce no padrão GoF
correspondente.

| Padrão           | Papel                      | Classes                                                    |
|------------------|----------------------------|------------------------------------------------------------|
| **Abstract**     | Classes base abstratas     | `Lanche`, `Bebida`, `Acompanhamento`                       |
| Abstract         | Template Method            | `Lanche.imprimirFicha()` (esqueleto final usa getters abstratos) |
| **Decorator**    | Component                  | `Lanche`                                                   |
| Decorator        | Concrete Components        | `HamburguerSimples`, `XBurguer`, `XSalada`, `XTudo`        |
| Decorator        | Decorator base             | `Adicional`                                                |
| Decorator        | Concrete Decorators        | `Bacon`, `QueijoExtra`, `Ovo`, `Catupiry`                  |
| **Abstract Factory** | Abstract Factory       | `Cardapio`                                                 |
| Abstract Factory | Concrete Factories         | `CardapioTradicional`, `CardapioVegano`, `CardapioInfantil`|
| Abstract Factory | Abstract Products          | `Lanche`, `Bebida`, `Acompanhamento`                       |
| Abstract Factory | Aggregate Product          | `Combo`                                                    |
| **Bridge**       | Abstraction                | `Pedido`                                                   |
| Bridge           | Refined Abstractions       | `PedidoBalcao`, `PedidoDelivery`                           |
| Bridge           | Implementor                | `FormaPagamento`                                           |
| Bridge           | Concrete Implementors      | `PagamentoPix`, `PagamentoCartao`, `PagamentoDinheiro`     |
| **Builder**      | Builder                    | `MontagemPedido`                                           |
| Builder          | Product                    | `Pedido` (`PedidoBalcao` / `PedidoDelivery`)               |
| Builder          | Método terminal            | `MontagemPedido.fechar()`                                  |
| **Singleton**    | Singleton                  | `ConfiguracaoLoja` (`getInstancia()`, construtor privado)  |
| **Factory Method**| Factory                   | `Atendente.prepararPagamento(String)`                      |
| Factory Method   | Produtos                   | `PagamentoPix`, `PagamentoCartao`, `PagamentoDinheiro`     |
| **Observer**     | Subject                    | `Pedido` (`adicionarAcompanhante`, `mudarStatus`)          |
| Observer         | Observer (interface)       | `Acompanhante`                                             |
| Observer         | Concrete Observers         | `Cozinha`, `PainelCliente`                                 |
| Observer         | Estados notificados        | `Status` (RECEBIDO, PREPARANDO, PRONTO, ENTREGUE)          |

## Estrutura

Todas as classes vivem em um único pacote `br.com.hamburgueria`,
sem subdivisões:

```
src/main/java/br/com/hamburgueria/
├── Main.java                     (demo ponta a ponta)
├── Lanche.java                   (Component / classe abstrata)
├── HamburguerSimples.java
├── XBurguer.java
├── XSalada.java
├── XTudo.java
├── Adicional.java                (Decorator base)
├── Bacon.java
├── QueijoExtra.java
├── Ovo.java
├── Catupiry.java
├── Bebida.java
├── Refrigerante.java
├── Suco.java
├── Agua.java
├── Acompanhamento.java
├── BatataFrita.java
├── OnionRings.java
├── Salada.java
├── Cardapio.java                 (Abstract Factory)
├── CardapioTradicional.java
├── CardapioVegano.java
├── CardapioInfantil.java
├── Combo.java                    (produto agregado)
├── Pedido.java                   (Bridge — abstraction; Observer — subject)
├── PedidoBalcao.java
├── PedidoDelivery.java
├── FormaPagamento.java           (Bridge — implementor)
├── PagamentoPix.java
├── PagamentoCartao.java
├── PagamentoDinheiro.java
├── MontagemPedido.java           (Builder de Pedido)
├── ConfiguracaoLoja.java         (Singleton)
├── Atendente.java                (Factory Method de FormaPagamento)
├── Status.java                   (estados do Pedido)
├── Acompanhante.java             (Observer — interface)
├── Cozinha.java                  (Observer concreto)
└── PainelCliente.java            (Observer concreto)

src/test/java/br/com/hamburgueria/
├── LancheTest.java
├── AdicionalTest.java
├── CardapioTest.java
├── PedidoTest.java
├── MontagemPedidoTest.java
├── ConfiguracaoLojaTest.java
├── AtendenteTest.java
└── AcompanhanteTest.java
```

## Como executar

Pré-requisito: JDK 17+ e Maven instalados.

```bash
mvn test                                                            # roda todos os testes
mvn compile exec:java -Dexec.mainClass="br.com.hamburgueria.Main"   # roda o demo
# ou, mais direto:
mvn package
java -cp target/classes br.com.hamburgueria.Main
```

No IntelliJ / Eclipse: abrir como projeto Maven e rodar `Main` ou os
testes diretamente pelo IDE.

## Casos de teste (JUnit 5)

- **LancheTest** — cada lanche retorna descrição e preço esperados; o
  Template Method formata a ficha no padrão combinado.
- **AdicionalTest** — cada adicional soma sua parte; múltiplos
  adicionais empilhados acumulam corretamente; ordem não afeta o preço.
- **CardapioTest** — cada cardápio (Tradicional, Vegano, Infantil)
  produz o trio de produtos coerente; `montarCombo()` aplica desconto
  de 10% sobre a soma.
- **PedidoTest** — todas as 6 combinações de `Pedido × FormaPagamento`
  geram o total esperado; delivery soma R\$ 8,00; Pix dá 5% off; Cartão
  cobra 3% de taxa; Dinheiro é neutro.
- **MontagemPedidoTest** — o Builder monta `PedidoBalcao` e `PedidoDelivery`
  passo a passo, em qualquer ordem das chamadas; modalidade default é
  balcão; falta de forma de pagamento dispara `IllegalStateException` no
  `fechar()`.
- **ConfiguracaoLojaTest** — `getInstancia()` sempre devolve a mesma
  instância; alterações em `taxaEntrega`/`descontoPix`/`descontoCombo`
  refletem em `PedidoDelivery`, `PagamentoPix` e `Combo`.
- **AtendenteTest** — `prepararPagamento("pix"|"cartao"|"dinheiro")`
  produz a forma de pagamento correta; aceita variações de caixa e
  acento; código desconhecido ou nulo dispara `IllegalArgumentException`.
- **AcompanhanteTest** — pedido começa com status `RECEBIDO`;
  `mudarStatus()` notifica todos os acompanhantes registrados; remoção
  de um acompanhante interrompe suas notificações; `Cozinha` e
  `PainelCliente` se registram normalmente.
