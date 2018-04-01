import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;
import java.awt.Color;

import javax.imageio.ImageIO;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

import java.util.Random;

public class Threshold {

    private static double[] threshold = { 0.25, 0.26, 0.27, 0.28, 0.29, 0.30, 0.31, 0.32, 0.33, 0.34, 0.35, 0.36, 0.37, 0.38, 0.39,
			0.40, 0.41, 0.42, 0.43, 0.44, 0.45, 0.46, 0.47, 0.48, 0.49, 0.50, 0.51, 0.52, 0.53, 0.54, 0.55, 0.56, 0.57,
			0.58, 0.59, 0.60, 0.61, 0.62, 0.63, 0.64, 0.65, 0.66, 0.67, 0.68, 0.69 };

    public static void main(String[] args) {

        Color cor = null;
        File img = new File("imagem.jpg");

	Random rand = new Random();

        try {

            BufferedImage buff = ImageIO.read(img);

            BufferedImage outputImage = new BufferedImage(buff.getWidth(), buff.getHeight(), TYPE_INT_RGB);

            System.out.printf("Image => Largura: %d, Altura: %d \n", buff.getWidth(), buff.getHeight());

            double media = 0;

            for(int row = 0; row < buff.getWidth(); row++) {
                for(int col = 0; col < buff.getHeight(); col++) {

                    cor = new Color(buff.getRGB(row, col));

                    int r = cor.getRed();
                    int g = cor.getGreen();
                    int b = cor.getBlue();

                    media += (r * 0.21f + g * 0.71f + b * 0.07f) / 255;        
                    
                }
            }

            media /= (buff.getHeight() * buff.getWidth());

            for(int row = 0; row < buff.getWidth(); row++) {
                for(int col = 0; col < buff.getHeight(); col++) {

                    cor = new Color(buff.getRGB(row, col));

                    int r = cor.getRed();
                    int g = cor.getGreen();
                    int b = cor.getBlue();

                    double lum = (r * 0.21f + g * 0.71f + b * 0.07f) / 255;        
                
                    if (lum <= threshold[rand.nextInt(threshold.length)]) {

                        outputImage.setRGB(row, col, 0x000000);

                    } else {

                        outputImage.setRGB(row, col, 0xFFFFFF);

                    }
                }
            }

            File file = new File("imagem-binaria.png");
            ImageIO.write(outputImage, "png", file);
            System.out.println("\nsuccess!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}