20221TADSSAJ0003


[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/mthoTxu2)
# Descrição da Atividade - Sistema de Gestão de Finanças Pessoais

## Objetivos

O objetivo desta atividade é desenvolver uma aplicação para a gestão simplificada de finanças pessoais, enfatizando a programação orientada a objetos. O sistema permitirá ao usuário o registro de *transações financeiras* em uma única conta controlada pela aplicação, abrangendo despesas e receitas recorrentes. Para facilitar o gerenciamento e exclusão de registros, as recorrências serão organizadas em séries de transações.

## Características Principais:

1. **Registro de Transações**: Os usuários poderão adicionar transações financeiras, fornecendo informações sobre o tipo (despesa ou receita), o valor e a data da transação. As transações podem ser efetivadas ou não efetivadas, possibilitando ao usuário planejar suas finanças com antecedência.

1. **Transações Recorrentes**: O sistema possibilitará a definição de transações recorrentes que ocorrem mensalmente. Os usuários poderão configurar a recorrência indicando o período de validade das transações recorrentes, expresso em quantidade de meses. Por exemplo, ao criar uma despesa de aluguel com recorrência de 24 vezes, o sistema gerará registros como "aluguel 1/24", "aluguel 2/24", até o "aluguel 24/24", acrescentando um mês à data da transação em cada registro subsequente. As recorrências serão agrupadas em uma série, e caso o usuário opte por apagar um registro de uma série, o sistema oferecerá a opção de apagar toda a série.

    ```java
    import java.time.LocalDate;

    public class SerieTransacoes ... {

        // Independete de qual TransacaoFinanceira (Despesa ou Receita) a SerieTransacoes cria todas as TransacaoFinanceira da Serie.
        private void gerarTransacoes(TransacaoFinanceira transacaoInicial) {
            String novoNome = getNome() + " " + (getQuantidadeTransacoes() + 1) + "/"+getTotalTransacoes();
            transacaoInicial.setDescricao(novoNome);
            transacoes.add(transacaoInicial);
            transacaoInicial.setSerieTransacoes(this);
            TransacaoFinanceira transacaoReferencia = transacaoInicial;
            while (getQuantidadeTransacoes() < getTotalTransacoes()) {
                LocalDate novaData = transacaoReferencia.getData().plusMonths(1);
                novoNome = getNome() + " " + (getQuantidadeTransacoes() + 1) + "/"+getTotalTransacoes();
                transacaoReferencia = transacaoReferencia.copia();
                transacaoReferencia.setData(novaData);
                transacaoReferencia.setDescricao(novoNome);
                transacoes.add(transacaoReferencia);
            }
        }

    ```

1. **Organização em Séries de Transações**: As transações recorrentes serão agrupadas em séries, facilitando a manipulação de registros relacionados. Se uma transação fizer parte de uma série e for excluída, o usuário será questionado sobre a ação a ser tomada: excluir apenas a transação selecionada, todas as transações da série ou a transação selecionada e todas as seguintes.

1. **Cálculo do Saldo da Conta**: O sistema manterá o saldo atualizado com base nas transações efetivadas, refletindo os valores de despesas e receitas na conta do usuário. Quando uma transação é efetivada, o valor será refletido no saldo disponível. Se uma transação efetivada for excluída, o saldo da conta será recalculado. Quanto uma transação financeira é inserida ja efetivada o valor do saldo deve ser alterado de imediato.

    ```java
    class Conta{

        //Ao inserir transação ja efetivada o valor de getValorAplicadoNaConta deve refletir no saldo
        public static void inserirTransacao(TransacaoFinanceira transacaoFinanceira)  {
            transacoes.add(transacaoFinanceira);
            if (transacaoFinanceira.isEfetivada()) {
                efetivarTransacao(transacaoFinanceira);
            }
        }

        public static void removerTransacao(TransacaoFinanceira transacaoFinanceira)  {
            transacoes.remove(transacaoFinanceira);
            if (transacaoFinanceira.isEfetivada()) {
                desefetivarTransacao(transacaoFinanceira);
            }
        }
        //...
        //...efetivarTransacao... utiliza polimorfismo para saber qual valor aplicar no saldo.
        saldo ... transacaoFinanceira.getValorAplicadoNaConta();
        //...
    }

    ```

1. **Efetivar e Desefetivar Transações**: Deve ser possível Efetivar e Desefetivar transações em qualquer momento, e essa ação deve ser refletida no saldo da conta.

1. **Previsão de Saldo**: Os usuários poderão calcular uma previsão do saldo para uma data específica. O sistema levará em consideração todas as transações registradas, mesmo as não efetivadas, até a data informada, para fornecer uma estimativa do saldo da conta na data desejada.

    ```java
    class Conta{
        //...
        // O método calcularSaldoPrevisto está filtrando
        // apenas as despesas não efetivadas e cuja data é anterior à data de
        // referência, e então calculando a diferença do saldo atual para o saldo
        // previsto na data passada por parâmetro
        public static double calcularSaldoPrevisto(LocalDate dataReferencia) {
            double diferencaSaldo = transacoes.stream()
                    .filter(despesaf -> !despesaf.isEfetivada() && despesaf.getData().isBefore(dataReferencia))
                    .mapToDouble(TransacaoFinanceira::getValorAplicadoNaConta)
                    .sum();

            return getSaldo() + diferencaSaldo;
        }
    }
    ```

1. **Identificador Único**: Todas as entidades terão um mecanismo para criar valores únicos de identificação, que serão utilizados para comparação entre instâncias. 


Esse projeto ja possui o Maven Wrapper. Para executar basta rodar no terminal do VSCode o seguinte comando:

```shell
./mvnw
```

Exemplo de uso do app:

![](Animação.gif)
