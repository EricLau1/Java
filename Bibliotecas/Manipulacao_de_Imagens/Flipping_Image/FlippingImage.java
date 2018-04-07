/*
 * Autor Original: Zoran Davidović
 *
 * Video: https://www.youtube.com/watch?v=HJXl2hmapdo
 *
 * */

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FlippingImage {

	public static final int FLIP_VERTICAL = 1;
	public static final int FLIP_HORIZONTAL = -1;

	public static void flip(File input, File output, int direcao) {

		try {

			BufferedImage imagem = ImageIO.read(input);
			int largura = imagem.getWidth();
			int altura = imagem.getHeight();
			BufferedImage flipped = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

			for(int y = 0; y < altura; y++) {

				for(int x = 0; x < largura; x++) {

					switch(direcao) {

					case FLIP_HORIZONTAL:
						flipped.setRGB((largura - 1) - x, y, imagem.getRGB(x, y));
						break;
					case FLIP_VERTICAL:
						flipped.setRGB(x, (altura - 1) - y, imagem.getRGB(x, y));
						break;

					} // fim switch


				}
			}

			ImageIO.write(flipped, "jpg", output);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	} // fim metodo

  public static void main(String[] args) {
    File input = new File("rotated90.jpg");
		File output = new File("flipped.jpg");

		FlippingImage.flip(input, output, FlippingImage.FLIP_VERTICAL);

		System.out.println("Flipping de imagem realizado com sucesso!" );
  }



}
