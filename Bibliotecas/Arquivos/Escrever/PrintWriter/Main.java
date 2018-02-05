import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {

        PrintWriter arq = new PrintWriter("arquivo.txt"); // construtor tbm recebe aceita a classe File

        arq.println("Classe PrintWriter"); //escreve e um pula a linha

        arq.write("Escrevendo em arquivos txt"); // escreve

        arq.flush();

        arq.close();

    }
}