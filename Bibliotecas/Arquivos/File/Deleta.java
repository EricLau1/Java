import java.io.File;
import java.io.IOException;

public class Deleta { 

    public static void main(String[] args) throws IOException {

        File arq = new File("arquivo.txt");
        File dir = new File("dir");

        if(arq.exists() && arq.isFile()) { // verifica se o arquivo existe e se é um arquivo

            System.out.println("Path: " + arq.getPath());  // retorna o caminho do arquivo
             
            arq.delete(); // deleta o arquivo

            System.out.println("deletado!");

        } else {
            System.out.println("crie um arquivo");
        }

        if(dir.exists() && dir.isDirectory()) { // verifica se o arquivo existe e se é um diretorio
            
            System.out.println("Path: " + dir.getPath()); // retorna o caminho do diretorio
            
            dir.delete(); // deleta o arquivo

            System.out.println("deletado!");
        
        } else {
            System.out.println("crie um diretorio");
        } 

    }
}