import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class Main {

  public static void main(String[] args){
    imagem();
  }

  public static void imagem(){

    File arquivo = new File("RGB.png");
    Color cor;
    int hex;

    try {

      BufferedImage buff = ImageIO.read(arquivo);

      for(int x = 0; x < buff.getWidth(); x++) {

        for(int y = 0; y < buff.getHeight(); y++) {

          cor = new Color(buff.getRGB(x, y));
          hex = buff.getRGB(x, y);
          // imprime a cor do pixel de acordo com o padrão RGB
          System.out.print(cor);
          System.out.printf(" => %x \n", hex); // convertendo para hexadecimal
        }

      }


    } catch(IOException e) {
      System.err.println("Erro: " + e.getMessage());
    }

  }

}
