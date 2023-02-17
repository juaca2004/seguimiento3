import java.util.Scanner;

import model.List;

public class Main {

   public static Scanner lector = new Scanner(System.in);

   private List list;

   public Main() {
      list = new List();
   }

   public static void main(String[] args) {
      Main objMain = new Main();
      objMain.menu();
   }

   public void menu() {
      int option = 0;
      boolean x = true;

      while (x) {
         System.out.println("1.Dar turno");
         System.out.println("2. Mostrar turno actual");
         System.out.println("3. Pasar turno");
         System.out.println("4. Seguir");
         option = lector.nextInt();
         switch (option) {
            case 1:
               agregar();

               break;
            case 2:
               mostrarTurno();
               break;

            case 3:
               pasarturn();
               break;

            case 4:
               seguir();
               break;

            default:
               x = false;
               break;
         }
      }
   }

   public void agregar() {
      list.agregar();
   }

   public void mostrarTurno() {
      list.printturn();
   }

   public void pasarturn() {
      list.pasar();
   }

   public void seguir() {
      list.seguir();
   }

}
