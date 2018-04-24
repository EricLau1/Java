package br.com.eric.main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import br.com.eric.model.Imagem;

public class Greyscale {
	
	public static byte[] greyImage;
	
	@SuppressWarnings("static-access")
	public static void convert(Imagem img) {
		
		  BufferedImage imagem = null;
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();

		    try {
		      	
		      InputStream in = new ByteArrayInputStream(img.getImgBytes());
		      
		      imagem = ImageIO.read(in);

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

		      ImageIO.write(imagem, "jpg", baos);
		      
		      greyImage = baos.toByteArray();
		      
		      baos.close();
		      
		    } catch (IOException ex) {

		      System.out.println("Erro : " + ex.getMessage());

		    }

		
	}

}
