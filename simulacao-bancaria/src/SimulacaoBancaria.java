import java.util.InputMismatchException;
import java.util.Scanner;

public class SimulacaoBancaria {
    static double saldo = 0;

    public static void main(String[] args) throws Exception, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            println("1 - Depositar\n" +
                    "2 - Sacar\n" +
                    "3 - Consultar Saldo\n" +
                    "0 - Encerrar\n");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                        // TODO: Ler o valor a ser depositado e atualizar/imprimir o saldo.
                    try{
                        println("Digite o valor que deseja depositar:");
                        double valorDeposito = scanner.nextDouble();
                        println(depositar(valorDeposito));
                    } catch (BancoException e) {
                        println(e.getMessage());
                    } catch (InputMismatchException e) {
                        println("Entrada inválida!");
                        scanner.next();
                    }
                    break;
                case 2:
                    // TODO: Ler o valor a ser sacado e verificar/imprimir se há saldo suficiente.
                    try{
                        println("Digite o valor que deseja sacar:");
                        double valorSaque = scanner.nextDouble();
                        println(sacar(valorSaque));
                    } catch (BancoException e) {
                        println(e.getMessage());
                    } catch (InputMismatchException e) {
                        println("Entrada inválida!");
                        scanner.next();
                    }
                    break;
                case 3:
                    // TODO: Exibir o saldo atual da conta.
                    println(consultarSaldo());
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
    static void println(Object obj){
        System.out.println(obj);
    }
    static String depositar(double valor) throws BancoException{
        if(valor < 1){
            throw new BancoException("O Valor precisa ser positivo!");
        }
        saldo += valor;
        return String.format("Saldo atual: %.1f",saldo);
    }
    static String sacar(double valor) throws BancoException{
        if (saldo < valor){
            throw new BancoException("Saldo insuficiente.");
        }
        saldo -= valor;
        return String.format("Saldo atual: %.1f", saldo);
    }
    static String consultarSaldo(){
        return String.format("Saldo atual: %.1f", saldo);
    }
}