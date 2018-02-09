import java.time.LocalDateTime; // API ~ JAVA 8
import java.time.LocalDate;
import java.time.Month;

public class Main {

  public static void main(String[] args) {
    /* LocalDateTime */
		System.out.println("\n LocalDateTime: ");
		LocalDateTime dataTime1 = LocalDateTime.now(); // data e hora atual do sistema
		LocalDateTime dataTime2 = LocalDateTime.of(1998, 1, 3, 11, 4, 12); // Ano, Mes, Dia, Hora, Minutos, Segundos
		System.out.println("\n dataTime1: " + dataTime1);
		System.out.println("\n dataTime2: " + dataTime2);

    // Configurando a hora de um LocalDate
    LocalDate data = LocalDate.of(2015, Month.JULY, 30);
		LocalDateTime dataTime3 = data.atTime(15, 22, 11); // hora, minuto, segundo
		System.out.println("\n dataTime3: " + dataTime3);
  }
}
