import java.awt.Dimension;
import java.awt.Toolkit;

public class Main {

    public static void main(String[] args) {

        Toolkit tkit = Toolkit.getDefaultToolkit();

        Dimension resolucao = tkit.getScreenSize();

        System.out.println("A Resolucao do Sistema e: " + resolucao.width + " x " + resolucao.height);
    }

}
