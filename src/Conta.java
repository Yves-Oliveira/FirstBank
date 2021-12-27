import java.util.Scanner;

public class Conta {
    //Class Variaveis
    int saldo;
    int transacaoAnterior;
    String clienteNome;
    String clienteAg;
    String clienteConta;

    //Class Construtor
    Conta(String cnome, String cag, String cconta) {
        clienteNome = cnome;
        clienteAg = cag;
        clienteConta = cconta;
    }

    //Função para Depositar Dinheiro
    void deposito(int quantidade) {
        if (quantidade != 0) {
            saldo = saldo + quantidade;
            transacaoAnterior = quantidade;
        }
    }

    //Função para Sacar dinheiro
    void sacar(int quantidade) {
        if (quantidade != 0) {
            saldo = saldo - quantidade;
            transacaoAnterior = -quantidade;
        }
    }

    //Função mostrando a Transação anterior
    void getTransacaoAnterior() {
        if (transacaoAnterior > 0) {
            System.out.println("Valor depositado: R$ " + transacaoAnterior);
        } else if (transacaoAnterior < 0) {
            System.out.println("Saque de: R$ " + Math.abs(transacaoAnterior));
        } else {
            System.out.println("Nenhuma transação ocorreu.");
        }
    }

    //Função de Calcular os juros deste fundo de investimentos por um número x de anos
    void calculandoJuros(int anos) {
        double taxaJuros = .10;
        double novoSaldo = (saldo * taxaJuros * anos) + saldo;
        System.out.println("A taxa de juros atual é de " + (100 * taxaJuros) + "% a.a.");
        System.out.println("Após " + anos + " ano(s), seu saldo será de: R$ " + novoSaldo);
    }

    //Função mostrar Menu Principal
    void mostrarMenu() {
        char opcao = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja bem-vindo, " + clienteNome + "!");
        System.out.println("Sua agência é a: " + clienteAg + ". E sua conta é a: " + clienteConta);
        System.out.println();
        System.out.println("O que você gostaria de fazer hoje?");
        System.out.println();
        System.out.println("A. Verificar seu saldo?");
        System.out.println("B. Fazer um depósito?");
        System.out.println("C. Fazer um saque?");
        System.out.println("D. Ver as transações anteriores?");
        System.out.println("E. Calcular sua rentabilidade esperada?");
        System.out.println("F. Sair!");

        do {
            System.out.println();
            System.out.println("Selecione uma opção: ");
            char opcao1 = scanner.next().charAt(0);
            opcao = Character.toUpperCase(opcao1);
            System.out.println();

            switch (opcao) {
                //Caso o cliente selecione a opção "A" mostre o saldo na conta
                case 'A':
                    System.out.println("====================");
                    System.out.println("Saldo = R$ " + saldo);
                    System.out.println("====================");
                    System.out.println();
                    break;
                //Caso o cliente escolha a opção "B" deixe o cliente depositar dinheiro na conta dele.
                case 'B':
                    System.out.println("Deposite um valor: R$ ");
                    int quantidade = scanner.nextInt();
                    deposito(quantidade);
                    System.out.println();
                    break;
                //Caso o cliente selecione a opção "C" permita que ele saque seu dinheiro
                case 'C':
                    System.out.println("Qual valor você quer sacar? R$ ");
                    int quantidade2 = scanner.nextInt();
                    sacar(quantidade2);
                    System.out.println();
                    break;
                //Caso ele escolha a opção "D" permita que ele veja a última transação realizada
                case 'D':
                    System.out.println("====================");
                    getTransacaoAnterior();
                    System.out.println("====================");
                    System.out.println();
                    break;
                //Caso ele escolha a opção "E" mostre a previsão de saldo em sua conta
                case 'E':
                    System.out.println("Selecione quantos anos deseja investir conosco: ");
                    int anos = scanner.nextInt();
                    calculandoJuros(anos);
                    break;
                //Caso selecione a opção "F" saia da conta.
                case 'F':
                    System.out.println("====================");
                    break;
                //A opção padrão informa ao usuário que a opção escolhida é inválida
                default:
                    System.out.println("Error: Opção inválida. Selecione as opções A, B, C, D, E ou F");
                    break;
            }
        } while (opcao != 'F');
        System.out.println("Nosso banco só é perfeito para nós, quando é perfeito para você! Obrigado por fazer parte desta transformação!");
    }

}













