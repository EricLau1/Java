import java.util.Calendar;
import java.util.Date;

public class Main {

  public static void main(String[] args){

      /* Calculando idade utilizando Calendar */
    System.out.println("Calendar: ");
    Calendar dataNascimentoCalendar = Calendar.getInstance(); // retorna a data atual do sistema

    dataNascimentoCalendar.set(Calendar.DAY_OF_MONTH, 29);
    dataNascimentoCalendar.set(Calendar.MONTH, 10);
    dataNascimentoCalendar.set(Calendar.YEAR, 1991);

    Calendar hoje = Calendar.getInstance();

    long idade = hoje.get(Calendar.YEAR) - dataNascimentoCalendar.get(Calendar.YEAR);

    System.out.println("idade: " + idade);


    Calendar cal = Calendar.getInstance();

    cal.set(2018, 2, 3, 19, 44, 0); // Ano, Mês, Dia, Hora, Minuto, Segundo

    Date data = new Date(cal.getTimeInMillis());

    System.out.println(data);

  }
}
