public class TipoInt {

  public static void main(String[] args){

        /* Declaração de variáveis Inteiras*/

        // Opção 1
        int i1 = 5;

        // Opção 2 ~ typecast
        int i2 = (int) 5;

        // Opção 3 ~ classe
        Integer i3 = new Integer(5);


        System.out.println("\nDeclaracao de variaveis Int: \n");

        System.out.println("comum: int i1 = 5;");
        System.out.println("typecast: int i2 = (int) 5;");
        System.out.println("classe: Integer i3 = new Integer(5);");

        System.out.printf("\nValores: %d  %d  %d \n", i1, i2, i3);

  }
}
