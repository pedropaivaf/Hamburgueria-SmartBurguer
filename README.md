# Hamburgueria SmartBurguer

![Diagrama de Classes](diagrama.png)

---

## Dominio

A SmartBurguer e uma hamburgueria moderna que opera tanto no balcao quanto via delivery. O sistema gerencia o ciclo completo de um pedido: montagem do lanche, escolha da forma de pagamento, envio para a cozinha, rastreamento do status, aplicacao de descontos e integracao com plataformas externas de entrega.

---

## Padroes aplicados

### Criacionais (5)

| Padrao | Classes principais | Funcao no dominio |
|---|---|---|
| **Singleton** | `ConfiguracaoLoja` | Instancia unica com nome da loja e taxa de delivery |
| **Factory Method** | `Atendente.prepararPagamento(String)` | Cria `FormaPagamento` concreta a partir de um codigo ("pix", "cartao", "dinheiro") |
| **Abstract Factory** | `Cardapio` + `CardapioTradicional` / `CardapioVegano` / `CardapioInfantil` | Familias coerentes de lanche, bebida e acompanhamento |
| **Builder** | `MontagemPedido` | Monta um `Pedido` passo a passo com encadeamento fluente |
| **Prototype** | `Clonavel` + `PedidoRapido.clonar()` | Repete um pedido salvo ("o de sempre") sem recriar do zero |

### Estruturais (7)

| Padrao | Classes principais | Funcao no dominio |
|---|---|---|
| **Adapter** | `AdaptadorIFood` → `ApiIFood` → `PlataformaDeliveryExterno` | Adapta a API incompativel do iFood para a interface interna de delivery |
| **Bridge** | `Pedido` × `FormaPagamento` | Qualquer modalidade (balcao/delivery) combina com qualquer pagamento sem heranca cruzada |
| **Composite** | `ItemMenu` / `ProdutoMenu` (folha) / `CategoriaMenu` (galho) | Cardapio com categorias aninhadas; preco da categoria e soma dos filhos |
| **Decorator** | `Adicional` + `Bacon` / `QueijoExtra` / `Ovo` / `Catupiry` | Adiciona ingredientes ao lanche em tempo de execucao, empilhando preco e descricao |
| **Flyweight** | `TipoIngrediente` + `FabricaIngredientes` + `UsoIngrediente` | Compartilha dados fixos de ingredientes; parte extrinse­ca (quantidade, obs.) fica no uso |
| **Proxy** | `SistemaAdminProxy` → `SistemaAdmin` + `Funcionario` / `Cargo` | Controla acesso a operacoes sensiveis (desconto, cancelamento, relatorio) pelo cargo |
| **Facade** | `SmartBurguerFachada` | Ponto de entrada unico: realiza pedido, conclui, entrega e aplica desconto em uma chamada |

### Comportamentais (11)

| Padrao | Classes principais | Funcao no dominio |
|---|---|---|
| **Chain of Responsibility** | `ValidadorEstoque` → `ValidadorPagamento` → `ValidadorHorario` | Cadeia de validacao antes de confirmar um pedido |
| **Command** | `ComandoPedido` / `AdicionarLancheNaFicha` / `RemoverLancheDaFicha` + `ControleOrdens` | Operacoes reversiveis sobre pedidos com historico de desfazer |
| **Interpreter** | `CriterioNomeLanche` / `CriterioPrecoLanche` / `CriterioLancheE` / `CriterioLancheOU` | Filtros compostos de lanches por nome, preco e operadores E/OU |
| **Iterator** | `IteradorMenu` + `ColecaoItensMenu` + `IteradorColecaoMenu` | Percorre os itens do cardapio sem expor a lista interna |
| **Mediator** | `CentralPedidos` + `SetorBalcao` / `SetorCozinha` / `SetorEntrega` | Setores se comunicam apenas pela central, sem referencias diretas entre si |
| **Memento** | `SnapshotFicha` + `HistoricoFicha` | Salva e restaura estados anteriores da ficha de cozinha |
| **Observer** | `Acompanhante` (`Cozinha`, `PainelCliente`) | Notificados automaticamente a cada mudanca de `Status` no `Pedido` |
| **State** | `FichaEstado` (abstrata) + `FichaEstadoPendente` / `EmPreparo` / `Pronta` / `Entregue` / `Cancelada` (Singletons) | Ficha de cozinha delega cada transicao ao estado atual; transicoes invalidas retornam false |
| **Strategy** | `PoliticaDesconto` + `SemPoliticaDesconto` / `DescontoClubeFidelidade` / `DescontoCupomPromocional` / `DescontoProgressivo` + `CaixaRegistradora` | Politica de desconto trocavel em tempo de execucao |
| **Template Method** | `Lanche.imprimirFicha()` | Esqueleto fixo de impressao; `getDescricao()` e `getPreco()` definidos pelas subclasses |
| **Visitor** | `VisitanteCardapio` + `CalculoNutricional` / `CalculoFiscal` + `LancheCardapio` / `BebidaCardapio` / `SobremesaCardapio` | Percorre elementos do cardapio calculando calorias ou impostos sem alterar as classes |

---

122 testes passando.
