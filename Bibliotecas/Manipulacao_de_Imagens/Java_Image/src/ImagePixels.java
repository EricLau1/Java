import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class ImagePixels {

  public ImagePixels(File img) {

    Color cor = null;

    try {

      BufferedImage buff = ImageIO.read(img);
      PrintWriter filePixels = new PrintWriter("..\\file\\imagem-pixels.txt");

      for(int lin = 0; lin < buff.getWidth(); lin++) {
        for(int col = 0; col < buff.getHeight(); col++) {

          cor = new Color(buff.getRGB(lin, col));

          int r = cor.getRed();
          int g = cor.getGreen();
          int b = cor.getBlue();

          filePixels.print(r + " " + g + " " + b + " ");

        }
      }

      filePixels.close();
      System.out.println("sucess!");

    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }

}
