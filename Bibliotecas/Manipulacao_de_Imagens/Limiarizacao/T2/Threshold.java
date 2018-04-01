import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;
import java.awt.Color;

import javax.imageio.ImageIO;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Threshold {

    public static void main(String[] args) {

        Color cor = null;
        File img = new File("imagem.jpg");

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
                
                    if (lum <= .5) {

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