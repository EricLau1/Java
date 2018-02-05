import java.io.File;
import java.io.IOException;

public class Arquivo { 

    public static void main(String[] args) throws IOException {

        File arquivo = new File("arquivo.txt");

        boolean existe = arquivo.exists(); // verifica se o arquivo ou diretorio existe

        arquivo.createNewFile();

    }
}