/*
  compilar o codigo no terminal
  javac -classpath json-simple-1.1.1.jar; *.java

  executar o binario pelo terminal
  java -classpath json-simple-1.1.1.jar; Nome_da_Classe_Principal

*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFile {

  @SuppressWarnings("unchecked")
	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		try
		{
			Object obj = parser.parse(new FileReader("myJson.json"));

			JSONObject jsonObject = (JSONObject) obj;

			String nome = (String) jsonObject.get("name");
			System.out.println("Nome: " + nome);

			String location = (String) jsonObject.get("location");
			System.out.println("Location: " + location);


			JSONArray listCourses = (JSONArray) jsonObject.get("courses");

			//Percorrendo uma lista em JSON de forma Simples
			System.out.print("Courses: ");

			for(Object j : listCourses) {
				System.out.print(j.toString() + ", ");
			}
			System.out.println();

			Iterator<String> iterator = listCourses.iterator();

			/* Percorrendo a lista de cursos JSON usando Iterator */
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			} // fim while

		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR! : "+ e.getMessage());
		}
		catch(IOException e) {
			System.out.println("ERROR! : "+ e.getMessage());
		}
		catch(ParseException e) {
			System.out.println("ERROR! : "+ e.getMessage());
		}
		catch(Exception e) {
			System.out.println("ERROR! : "+ e.getMessage());
		}

	} // fim main
}
