import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

/* 
    Escrevendo a partir de um conteudo ja existente
*/

public class Continue {

    public static void main(String[] args) throws IOException {

        File f = new File("arquivo.txt");

        if(f.exists()) {
            
            PrintWriter continua = new PrintWriter(new FileOutputStream(new File("arquivo.txt"), true));

            continua.append("\nimport java.io.PrintWriter;"); 
            continua.flush();
            continua.close();

        } else {
            System.out.println("arquivo ainda não foi criado...");
        }

    }
}