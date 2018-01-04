import java.util.Scanner;

public class Main {

  public static void main(String[] args){

    Scanner tec = new Scanner(System.in);

    System.out.print("Digite seu nome: ");
    String nome = tec.nextLine();

    System.out.println("Ola! " + nome);

    System.out.print("Qual a sua idade? ");
    int idade = tec.nextInt();

    if(idade < 18) {
      System.out.println("Voce ainda nao pode dirigir :(");
    }
    else{
      System.out.println("Dirija com seguranca!");
    }

  }
}
