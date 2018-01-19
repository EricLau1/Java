/*
  compilar o codigo no terminal
  javac -classpath json-simple-1.1.1.jar; *.java

  executar o binario pelo terminal
  java -classpath json-simple-1.1.1.jar; Nome_da_Classe_Principal
*/
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class CreateJSONFile {

  @SuppressWarnings("unchecked")
	public static void main(String[] args) {

		JSONObject obj = new JSONObject();

	    obj.put("name", "Janne Doe");
	    obj.put("location", "USA");

	    JSONArray list = new JSONArray();
	    list.add("Java");
	    list.add("Machine Learning");
	    list.add("Python");

	    obj.put("courses", list);

	    try(FileWriter file = new FileWriter("myJSON.json"))
	    {

	      file.write(obj.toString());
	      file.flush(); // escreve os dados no disco
	      file.close();


	    } catch (IOException e) {
	      System.out.println("Erro : " + e.getMessage());
	    }

	    System.out.println(obj);;

	} // fim main
}
