import java.io.File;
import java.io.IOException;

public class Main {

  public static void main(String[] args){
    try {

      File arq = new File("..\\img\\face.jpg");

      Greyscale gIm = new Greyscale(arq); // transforma a imagem para escala de cinza

      System.out.println("largura: " + gIm.getLargura());
      System.out.println("altura: " + gIm.getAltura());
      System.out.println("caminho: " + gIm.getUrlImageGrey()); 


      ImagePixels iPx = new ImagePixels(new File(gIm.getUrlImageGrey()));

      Runtime.getRuntime().exec("notepad ../file/imagem-pixels.txt"); //executar comando cmd


    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }
}
