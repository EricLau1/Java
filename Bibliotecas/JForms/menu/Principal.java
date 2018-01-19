import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args){
		
		Tela t1 = new Tela();

		t1.setSize(400, 350); // define a largura e altura da janela
		t1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define os botoes padrão para fechar a janela
		t1.setLocationRelativeTo(null); // metodo que inicializa o form no centro da Tela
		t1.setVisible(true); // visibilidade da janela
	}

}