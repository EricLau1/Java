import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GreyscaleImage {

  public static void main(String[] args) {

    BufferedImage imagem = null;
    File arquivo = null;

    try {

      arquivo = new File("C:\\GitHub\\Java\\Ref\\Imagens\\Greyscale\\modelo.jpg");
      imagem = ImageIO.read(arquivo);

    } catch(IOException ex) {
      System.out.println("Erro : " + ex.getMessage());
    }

    int largura = imagem.getWidth();
    int altura = imagem.getHeight();

    // Percorrendo pixel por pixel
    for (int y = 0; y < altura; y++) {
      for (int x = 0; x < largura; x++) {

        int p = imagem.getRGB(x, y);

        // a = alpha ~ transparencia da imagem
        int a = (p>>24)&0xff;

        int r = (p>>16)&0xff;

        int g = (p>>8)&0xff;

        int b = p&0xff;

        int media = (r + g + b) / 3;

        p = (a<<24) | (media<<16) | (media<<8) | media;

        imagem.setRGB(x, y, p);

      }
    }

    try {

      arquivo = new File("C:\\GitHub\\Java\\Ref\\Imagens\\Greyscale\\cinza\\modelo-cinza.jpg");
      ImageIO.write(imagem, "jpg", arquivo);

    } catch (IOException ex) {

      System.out.println("Erro : " + ex.getMessage());

    }


  } // fim main

}
