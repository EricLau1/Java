import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class Tela extends JFrame {

	public Tela() {
	
		super("Tela JFrame");
		criarMenu();
	
	}

	public void criarMenu(){
		
		JMenu arquivo = new JMenu("Arquivo");

		JMenuItem itemNovo = new JMenuItem("novo");

		arquivo.add(itemNovo); // adicionado item ao menu arquivo

		JMenuItem itemSalvar = new JMenuItem("salvar");

		arquivo.add(itemSalvar);

		JMenuItem itemFechar = new JMenuItem("fechar");

		arquivo.add(itemFechar);

		JMenu ajuda = new JMenu("Ajuda");

		JMenuItem itemSobre = new JMenuItem("sobre");

		ajuda.add(itemSobre);
		
		// Criando a barra de menus 
		JMenuBar barraMenu = new JMenuBar();

		setJMenuBar(barraMenu);
		barraMenu.add(arquivo);
		barraMenu.add(ajuda);
	}
	
}