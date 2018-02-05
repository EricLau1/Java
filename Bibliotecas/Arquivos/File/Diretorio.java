import java.io.File;
import java.io.IOException;

public class Diretorio { 

    public static void main(String[] args) throws IOException {

        File dir = new File("dir");

        if(dir.exists()) {
            System.out.println("Diretorio ja foi criado");            
        } else {
            dir.mkdir();
        }

    }
}