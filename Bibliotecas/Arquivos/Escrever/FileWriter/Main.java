import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {

        File f = new File("arquivo.txt");

        FileWriter arq = new FileWriter(f);

        arq.write("Classe FileWriter");

        arq.write("\nimport java.io.FileWriter;");

        arq.flush();

        arq.close();
    }
}