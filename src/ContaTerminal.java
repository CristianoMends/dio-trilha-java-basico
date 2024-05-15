
import javax.security.auth.callback.Callback;
import java.util.Scanner;

class Account{
    private int number;
    private String agency;
    private String customerName;
    private Float balance;

    public void setNumber(int number) {this.number = number;}
    public void setAgency(String agency) {this.agency = agency;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setBalance(Float balance) {this.balance = balance;}

    public int getNumber() {return number;}

    public String getAgency() {return agency;}

    public String getCustomerName() {return customerName;}

    public Float getBalance() {return balance;}
}
class System{
    static Scanner scanner = new Scanner(java.lang.System.in);
    private Account account = new Account();

    public static int toInt(String text){
        return Integer.parseInt(text);
    }
    public static Float toFloat(String text){
        return Float.parseFloat(text);
    }
    public static void println(Object obj){java.lang.System.out.println(obj);}
    public static void print(Object obj){java.lang. System.out.print(obj);}
    public static String input (){return scanner.nextLine();}

    void registerCustomer(){
        println("Bem vindo ao Banco Do Cristiano!");
        println("Por favor, informe os dados abaixo para cadastro no sistema!");

        print("Seu nome:");
        this.account.setCustomerName(input());

        print("Numero da conta:");
        while (true){
            try{
                this.account.setNumber(toInt(input()));
                break;
            }catch (Exception e){
                println("Digite apenas numeros!");
            }
        }

        print("Agencia:");
        this.account.setAgency(input());

        print("Saldo:");
        while (true){
            try{
                this.account.setBalance(toFloat(input()));
                break;
            }catch (Exception e){
                println("Digite apenas numeros!");
            }
        }
    }
    void showMessage(){
        println("Olá "
                +this.account.getCustomerName()+ ", obrigado por criar uma conta em nosso banco, sua agência é "
                +this.account.getAgency()+", conta "
                +this.account.getNumber()+" e seu saldo de "
                + "%.2f".formatted(this.account.getBalance()) + " já está disponível para saque");
    }

}


public class ContaTerminal {
    public static void main(String[] args) throws Exception{
        System system = new System();
        system.registerCustomer();
        system.showMessage();

    }

}