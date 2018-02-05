import java.io.File;
import java.io.IOException;

public class ListaArquivos { 

    public static void main(String[] args) throws IOException {

        File dir = new File("lista");

        if(dir.isDirectory()) { // verifica se é um diretorio
            System.out.println("Arquivos dentro do diretorio " + dir.getPath() + ": \n");

            String[] lista = dir.list(); // retona todos os arquivos de um diretorio

            for(String arquivo : lista) {
                System.out.println(arquivo);
            }
        }


    }
}