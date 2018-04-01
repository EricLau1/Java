import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Greyscale {

  private BufferedImage imagem;
  private int largura;
  private int altura;
  private String urlImage;

  public Greyscale(File arquivo){

    try {

      this.imagem = ImageIO.read(arquivo);

    } catch (IOException ex) {
      System.err.println("Erro: " + ex.getMessage());
    }

    this.largura = imagem.getWidth();
    this.altura = imagem.getHeight();

    for(int x = 0; x < this.largura; x++) {
      for(int y = 0; y < this.altura; y++) {

        int pixel = this.imagem.getRGB(x, y);

        int alpha = (pixel >> 24)&0xff;
        int red = (pixel >> 16)&0xff;
        int green = (pixel >> 8)&0xff;
        int blue = pixel&0xff;

        int media = (red + green + blue) / 3;

        pixel = (alpha << 24) | (media << 16) | (media << 8) | media;

        this.imagem.setRGB(x, y, pixel);

      }
    }

    try {

      this.urlImage = "..\\img\\greyscale-imagem.jpg";
      arquivo = new File(this.urlImage);
      ImageIO.write(imagem, "jpg", arquivo);
      System.out.println("Uma imagem foi transformada para escala de cinza no diretorio img/");

    } catch (IOException ex) {
      System.err.println("Erro: " + ex.getMessage());
    }


  } // fim construtor

  public String getUrlImageGrey() {
    return this.urlImage;
  }

  public int getLargura(){
    return this.largura;
  }

  public int getAltura(){
    return this.altura;
  }

}
