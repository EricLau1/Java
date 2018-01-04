import java.util.Locale;
public class IdiomaDoSistema{

    public static void main(String args[]){

        Locale l = Locale.getDefault();

        System.out.println(l.getDisplayLanguage());
        System.out.println(l.getLanguage());

    }
}