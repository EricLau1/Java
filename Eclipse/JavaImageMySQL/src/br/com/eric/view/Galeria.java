package br.com.eric.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import br.com.eric.db.ImageDb;
import br.com.eric.main.Greyscale;
import br.com.eric.model.Imagem;

@SuppressWarnings("serial")
public class Galeria extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Galeria frame = new Galeria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Galeria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagem.setBounds(0, 0, (720 / 2), 441);
		contentPane.add(lblImagem);
		
		List<Imagem> galeria = ImageDb.find();
		
		
		@SuppressWarnings("static-access")
		ImageIcon img = new ImageIcon(galeria.get(0).imgBytes);
		
		lblImagem.setIcon(img);
		
		JLabel lblImageGrey = new JLabel("Greyscale");
		lblImageGrey.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageGrey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblImageGrey.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImageGrey.setBounds(355, 0, 349, 441);
		contentPane.add(lblImageGrey);
		
		Greyscale.convert(galeria.get(0));
		
		ImageIcon imgGrey = new ImageIcon(Greyscale.greyImage);
		
		lblImageGrey.setIcon(imgGrey);
		
	}
}
