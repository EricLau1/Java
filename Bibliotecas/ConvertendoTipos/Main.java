public class Main {

  public static void main(String[] args){

    /* Convertendo tipos */

  int n = 100;

  // convertendo inteiro pra caractere
  String num = Integer.toString(n);

  // convertendo caractere para inteiro
  int x = Integer.parseInt(num) - 10;


  String r = "3.14159";

  // convertendo caractere para double
  double pi = Double.parseDouble(r);

  boolean b = false;
  // convertendo boolean pra caractere
  String falso = Boolean.toString(b);

  b = Boolean.parseBoolean(falso);

  System.out.format("String(%s), int(%d), double(%f), boolean(%b)", num, x, pi, b);

  }

}
