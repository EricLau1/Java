public class TipoDouble {

  public static void main(String[] args){

    /* Declaração de variáveis Double */

    // Opção 1
    double d1 = 3.14159;

    // Opção 2
    double d2 = (double) 3.14159;

    // Opção 3
    Double d3 = new Double(3.14159);

    System.out.println("\nDeclaracao de variaveis Double: \n");

    System.out.println("comum: double d1 = 3.14159;");
    System.out.println("typecast: double d2 = (double) 3.14159;");
    System.out.println("classe: Double d3 = new Double(3.14159);");

    System.out.format("\nValores: %.5f  %.5f  %.5f \n", d1, d2, d3);

  }
}
