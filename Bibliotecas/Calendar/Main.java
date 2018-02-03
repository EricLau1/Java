import java.util.Calendar;
import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2018, 2, 3, 19, 44, 0); // Ano, Mês, Dia, Hora, Minuto, Segundo
		
		Date data = new Date(cal.getTimeInMillis());
		
		System.out.println(data);
		
	}

}