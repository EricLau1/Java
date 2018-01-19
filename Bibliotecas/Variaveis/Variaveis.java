public class Variaveis {

  public static void main(String[] args){

    /*
      Tabela de Variáveis do Java

      Família - Tipo Primitivo - Classe Invólucro - Tamanho - Exemplo

      ************************************************************************************************************************

      Lógico     boolean          Boolean            1 bit    true

      ************************************************************************************************************************

      Literais  char            Character           1 byte      'A'
                 -               String           1 byte/cada  "Java"

      ************************************************************************************************************************

                byte              Byte              1 byte    ( -128 ) á ( 127 )

      Inteiros  short            Short              2 bytes   ( -32768 ) á ( 32767 )

                int             Integer             4 bytes   ( -2 147 483 648 ) á ( 2 147 483 647 )

                long             Long               8 bytes   ( -4 611 686 018 427 387 904 ) á ( 4 611 686 018 427 387 903 )

      ************************************************************************************************************************

      Reais    float            Float              4 bytes   3.4 e +38
               double           Double             8 bytes   1.8 e +308

      ************************************************************************************************************************

    */

    System.out.println("\nTamanho de Variaveis");

    System.out.println("\n1 byte tem 8 bits e cada bit tem dois estados ");

    System.out.println("\nPara saber o valor maximo suportado por uma variavel, pegue a...");

    System.out.println("\nQuantidade de bits elevado a 2 sendo que...");

    System.out.println("\nO valor obtido e divido por 2 para incluir os numeros negativos.");

    System.out.println("\nExemplos: ");

    byte b1, b2;

    b1 = -128;
    b2 = 127;
    System.out.printf("\n1 byte => 8 bits => 2^8 => %d / 2 => (%d a %d) \n", (int)Math.pow(2,8), b1, b2);

    short s1, s2;

    s1 = -32768;
    s2 = 32767;
    System.out.printf("\n2 bytes => 2 * 8 (16 bits) => 2^16 => %d / 2 => (%d a %d) \n", (int)Math.pow(2,16), s1, s2);

    int i1, i2;

    i1 = -2147483648;
    i2 = 2147483647;
    System.out.printf("\n4 bytes => 4 * 8 (32 bits) => 2^32 => %d / 2 => (%d a %d) \n", (int)Math.pow(2,32), i1, i2);

    long l1, l2;

    l1 = -(long)(Math.pow(2, 63) / 2);
    l2 = (long) (Math.pow(2, 63) / 2) - 1;
    System.out.printf("\n8 bytes => 8 * 8 (64 bits) => 2^(64 - 1) => %d / 2 => (%d a %d) \n", (long)Math.pow(2,64), l1, l2);

  }
}
