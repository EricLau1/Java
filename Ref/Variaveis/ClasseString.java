public class ClasseString{

  public static void main(String[] args){

    String frase1 = "Ola mundo! ";
    String frase2 = new String("Seja bem vindo!");

    System.out.printf("%s\n", frase1);
    System.out.format("%s\n", frase2);

    /* juntando duas strings */
    frase1 += frase2;

    System.out.printf("%s tem %d caracteres ", frase1, frase1.length());
  }

}
