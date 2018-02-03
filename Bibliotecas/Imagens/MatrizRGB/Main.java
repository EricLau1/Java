import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

  public static void main(String[] args){

    File imagem = new File("img\\google.png");

    BufferedImage img = null;

    try {

      img = ImageIO.read(imagem);

      BufferedImage imagem_cinza = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);

      for(int i = 0; i < img.getWidth(); i++) {
        for(int j = 0; j < img.getHeight(); j++) {

          Color cor = new Color(img.getRGB(i, j));

          int red = cor.getRed();
          int green = cor.getGreen();
          int blue = cor.getBlue();
          int alpha = cor.getAlpha();
          System.out.printf("[%d, %d, %d] ", red, green, blue);
        }
        System.out.println();
      }

      System.out.println("Total pixels: " + (img.getWidth() * img.getHeight()));

    } catch (IOException ex) {
      System.err.println("Erro: " + ex.getMessage());
    }

  }

}
