public class TipoFloat {

  public static void main(String[] args){

    /* Declaração de variáveis Float */

    // Opcao 1
    float f1 = 123.45f;

    // Opcao 2 ~ typecast
    float f2 = (float) 123.45;

    // Opcao 3 ~ classe
    Float f3 = new Float(123.45);

    System.out.println("\nDeclaracao de variaveis Float: \n");

    System.out.println("comum: float f1 = 123.45f;");
    System.out.println("typecast: float f2 = (float) 123.45;");
    System.out.println("classe: Float f3 = new Float(123.45);");

    System.out.printf("\nValores: %.2f  %.2f  %.2f \n", f1, f2, f3);

  }
}
