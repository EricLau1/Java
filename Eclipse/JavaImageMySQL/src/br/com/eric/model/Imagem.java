package br.com.eric.model;

import java.io.FileInputStream;

public class Imagem {

	public static Long id;
	public static String descricao;
	public static FileInputStream imagem;
	public static byte[] imgBytes;
	
	public static Long getId() {
		return id;
	}
	public static void setId(Long id) {
		Imagem.id = id;
	}
	public static String getDescricao() {
		return descricao;
	}
	public static void setDescricao(String descricao) {
		Imagem.descricao = descricao;
	}
	public static FileInputStream getImagem() {
		return imagem;
	}
	public static void setImagem(FileInputStream imagem) {
		Imagem.imagem = imagem;
	}
	public static byte[] getImgBytes() {
		return imgBytes;
	}
	public static void setImgBytes(byte[] imgBytes) {
		Imagem.imgBytes = imgBytes;
	}

}
