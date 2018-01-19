public class TipoChar{

  public static void main(String[] args){

    /* Declaração de variáveis Char */

    // Opção 1
    char c1 = 'A';

    // Opção 2 ~ typecast
    char c2 = (char) 'A';

    // Opção 3 ~ classe
    Character c3 = new Character('A');

    System.out.println("\nDeclaracao de variaveis Char: \n");

    System.out.println("comum: char c1 = \'A\' ");
    System.out.println("typecast: char c2 = (char) \'A\' ");
    System.out.println("classe: Character c3 = new Character(\'A\') ");

    System.out.printf("\nValores: %c  %c  %c \n", c1, c2, c3);
  }
}
