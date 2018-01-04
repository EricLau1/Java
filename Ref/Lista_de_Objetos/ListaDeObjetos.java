import java.util.ArrayList;
import java.util.List;

public class ListaDeObjetos {

	public static void main(String[] args){

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		Pessoa p1 = new Pessoa("Jane", 18);
		Pessoa p2 = new Pessoa("Joe", 25);
		
		/* Adicionando objetos a Lista*/
		pessoas.add(p1);
		pessoas.add(p2);

		/* Percorrendo a lista de Objetos */
		for(Pessoa p : pessoas){
			System.out.println(p.getNome());
		}

	} 
}