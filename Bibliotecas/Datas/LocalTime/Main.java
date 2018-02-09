import java.time.LocalTime; // API ~ JAVA 8

public class Main {

  public static void main(String[] args) {
    // LocalTime
		System.out.println("LocalTime: ");
		LocalTime hora = LocalTime.of(12, 2, 30); // H:M:S
		System.out.println("HH:MM:SS => " + hora);
		System.out.println("Hora: " + hora.getHour());
		System.out.println("Minutos: " + hora.getMinute());
		System.out.println("Segundos: " + hora.getSecond());

    /* Utilizando Parse */
		System.out.println("Parsing: ");
		LocalTime parseTime = LocalTime.parse("17:05:58");
		System.out.println(parseTime);

  }
}
