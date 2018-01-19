public class TipoBoolean {

  public static void main(String[] args){

    /* Declaração de variáveis Boolean */

    // Opção 1
    boolean b1 = false;

    // Opção 2 ~ typecast
    boolean b2 = (boolean) true;

    // Opção 3 ~ classe
    Boolean b3 = new Boolean(false);

    System.out.println("\nDeclaracao de variaveis Boolean: \n");

    System.out.println("comum: boolean b1 = false;");
    System.out.println("typecast: boolean b2 = (boolean) true;");
    System.out.println("classe: Boolean b3 = new Boolean(false);");

    System.out.printf("\nValores: %b  %b  %b \n", b1, b2, b3);
  }
}
