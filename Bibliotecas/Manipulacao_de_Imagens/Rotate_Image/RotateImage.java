/*
 * Autor Original: Zoran Davidović
 *
 * Video: https://www.youtube.com/watch?v=RLHG1dR3TsI
 *
 * */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class RotateImage {

	public static final int ROTATE_LEFT = 1;
	public static final int ROTATE_RIGHT = -1;

	public static void rotate90(File input, File output, int direcao) {

		try {

			ImageInputStream iis = ImageIO.createImageInputStream(input);

			Iterator<ImageReader> iterator = ImageIO.getImageReaders(iis);

			ImageReader reader = iterator.next();

			String formato = reader.getFormatName();

			BufferedImage imagem = ImageIO.read(iis);
			int largura = imagem.getWidth();
			int altura = imagem.getHeight();

			BufferedImage rotated = new BufferedImage(altura, largura, imagem.getType());


			for(int y = 0; y < altura; y++) {

				for(int x = 0; x < largura; x++) {

					switch(direcao) {

					case ROTATE_LEFT :
						rotated.setRGB(y, (largura - 1) - x, imagem.getRGB(x, y));
						break;
					case ROTATE_RIGHT :
						rotated.setRGB((altura - 1) - y, x, imagem.getRGB(x, y));

					} // fim switch

				}

			}

			ImageIO.write(rotated, formato, output);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	} // fim metodo

  public static void main(String[] args) {
    File input = new File("one.jpg");
		File output = new File("rotated90.jpg");

		RotateImage.rotate90(input, output, RotateImage.ROTATE_LEFT);
		System.out.println("Imagem rotacionada com sucesso!");
  }

}
