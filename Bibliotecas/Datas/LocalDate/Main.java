import java.time.LocalDate; // API ~ Java 8
import java.time.Month;

public class Main {

  public static void main(String[] args) {
      // LocalDate
    System.out.println("LocalDate: ");
    LocalDate data = LocalDate.of(2018, Month.FEBRUARY, 9);

    System.out.println(data.getYear());
    System.out.println(data.getMonth()); // imprime o mes por nome
    System.out.println(data.getMonthValue()); // imprime o mes por numero
    System.out.println(data.getDayOfWeek()); // imprime o dia da semana por nome
    System.out.println(data.getDayOfMonth()); // imprime o dia por numero

    LocalDate now = LocalDate.now(); // retorna a data atual
    System.out.println("hoje: " + now);

    /* Utilizando Parse */
		System.out.println("Parsing: ");
		LocalDate parseDate = LocalDate.parse("2000-05-21");
		System.out.println(parseDate);

  }
}
