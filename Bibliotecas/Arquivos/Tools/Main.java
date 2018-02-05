import java.io.PrintWriter;
import java.io.IOException;


public class Main {

  public static void main(String[] args) {

    try {
      PrintWriter out = new PrintWriter("out.txt");

      createToolFiles(4, out);

      out.close();
      //System.out.println("sucess!");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  } // fim main


  public static void createToolFiles(int option, PrintWriter arq){
    switch(option) {
      case 1 : {
        toolOne("*", arq);
        break;
      }
      case 2 : {
        toolTwo("*", arq);
        break;
      }
      case 3 : {
        toolThree("*", arq);
        break;
      }
      default:{
        toolFour("*", arq);
      }
    } // fim switch
  }

  public static void toolOne(String sym, PrintWriter arq){
    for(int row = 0; row < 64; row++) {
      for(int col = 0; col < 64; col++) {

        arq.print(sym);

      }
      arq.println("");
    }
  }

  public static void toolTwo(String sym, PrintWriter arq){
    for(int row = 0; row < 64; row++) {
      for(int col = 0; col < 64; col++) {

        if(col % 2 == 0) {
          arq.print(sym);
        } else {
          arq.print(" ");
        }

      }
      arq.println("");
    }
  }

  public static void toolThree(String sym, PrintWriter arq){
    for(int row = 0; row < 64; row++) {
      for(int col = 0; col < 64; col++) {

        if((col + row) % 2 == 0) {
          arq.print(sym);
        } else {
          arq.print(" ");
        }

      }
      arq.println("");
    }
  }

  public static void toolFour(String sym, PrintWriter arq){
    for(int row = 0; row < 64; row++) {
      for(int col = 0; col < 64; col++) {

        if((col * row) % (row + 1) == 0) {
          arq.print(sym);
        } else {
          arq.print(" ");
        }

      }
      arq.println("");
    }
  }

}
