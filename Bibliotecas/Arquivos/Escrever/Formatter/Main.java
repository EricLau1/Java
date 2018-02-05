import java.util.Formatter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Formatter arq = new Formatter("arquivo.txt");
        String msg = "Hello world!";
        arq.format("%s", msg);
        arq.close();
    }   

}