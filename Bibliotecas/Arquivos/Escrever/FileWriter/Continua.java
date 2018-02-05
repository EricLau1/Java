import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Continua {

    public static void main(String[] args) throws IOException {

        FileWriter continua = new FileWriter("arquivo.txt", true); // escreve após o conteudo do arquivo

        continua.write("\nto be continued...");
        continua.close();
    }
}