import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader arq = new FileReader("FILES/arq1.txt");
        BufferedReader leitor = new BufferedReader(arq); 

        while(leitor.ready()) {
            System.out.println(leitor.readLine()); // retorna a linha inteira do arquivo até encontrar uma quebra de linha
        }

        
        arq.close();
        leitor.close();

    }
}