package br.com.eric.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import javax.swing.ImageIcon;

public class LocalizarImagem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalizarImagem frame = new LocalizarImagem();
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
	public LocalizarImagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblImagem.setBounds(222, 180, 280, 260);
		contentPane.add(lblImagem);
		
		/* Objeto para acessar o sistema de arquivos do computador */
		final JFileChooser fc = new JFileChooser();
		/* Objeto para filtrar o tipo de arquivo que será acessado */
		FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE FILES", "png", "jpg", "jpeg");
		
		fc.setFileFilter(filter);
		
		
		JButton btnProcurarImagem = new JButton("Procurar Imagem");
		btnProcurarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/* Acessando o sistema de arquivos */
				try {
					
					fc.showOpenDialog(btnProcurarImagem);
					
					//JOptionPane.showMessageDialog(null, "" + fc.getSelectedFile().getAbsolutePath());
					
					String path = "" + fc.getSelectedFile().getAbsolutePath();
					String url = "";
					
					for(int i = 0; i < path.length(); i++) {
						
						if(path.charAt(i) == '\\') {
							url += path.charAt(i);
							url += "\\";
						} else {
							url += path.charAt(i);
						}
						
					}
					
					//JOptionPane.showMessageDialog(null, "" + url);
					
					lblImagem.setIcon(new ImageIcon(url));
												
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
				
				
			}
		});
		btnProcurarImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProcurarImagem.setBounds(222, 62, 280, 40);
		contentPane.add(btnProcurarImagem);
		
		/* centralizar o panel */
		setLocationRelativeTo(null);
		
		setResizable(false); // bloqueia alteração das bordas do panel em execução
	}
}
