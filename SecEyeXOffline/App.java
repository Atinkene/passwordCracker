import java.util.Scanner;

public class App{
    public static void main(String args[]){
        boolean continuer = true;
        Scanner scanner = new Scanner(System.in);
        
        while (continuer) {
            Menu menu = new Menu();
            menu.demarrer(scanner);
            System.out.print("Voulez-vous recommencer Y/N : ");
            
            String reponse = scanner.nextLine();
            if(!reponse.equalsIgnoreCase("y"))
                continuer = false;

            System.out.flush();
            
        }

        scanner.close();
    }
       
}