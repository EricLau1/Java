import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {

            Scanner leitor = new Scanner(new File("FILES/arq2.txt"));

            while(leitor.hasNext()) {
                System.out.println(leitor.next()); // le o conteudo até achar espaço em branco ou quebra de linha
                //System.out.println(leitor.nextLine()); // le a linha inteira até encontrar uma quebra de linha
            }

            leitor.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}