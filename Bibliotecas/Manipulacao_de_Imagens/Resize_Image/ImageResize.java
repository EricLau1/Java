/* 
*
* Autor Original: Zoran Davidovic
*
* Video: https://www.youtube.com/watch?v=YM02Q3s9pbY
*
*/

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageResize {

  public static void main (String []args) {

    File img = new File("test.jpg");
    File resize = new File("resize.jpg");
    resizeImage(img, resize, 100, 100, "jpg");

  }

  public static void resizeImage(File imagemOriginal, File resizeImage, int largura, int altura, String format) {

    try {

      BufferedImage original = ImageIO.read(imagemOriginal);
      BufferedImage resized = new BufferedImage(largura, altura, original.getType());

      Graphics2D g2d = resized.createGraphics();
      g2d.drawImage(original, 0, 0, largura, altura, null);
      g2d.dispose();
      ImageIO.write(resized, format, resizeImage);

    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }

}
