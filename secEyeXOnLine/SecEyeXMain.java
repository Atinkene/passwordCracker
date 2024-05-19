
import java.util.Scanner;

public class SecEyeXMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int methode = 0;
        String returnedPassword;
        
        bienvenue();
        methode = in.nextInt();

        System.out.println("la methode est "+methode);
        SecEyeX secEyeX = SecEyeXFactory.SecEyeXPassword(methode);
        try {
            returnedPassword = secEyeX.attaque("massina");
        } catch (Exception e) {
            e.getMessage();
            in.close();
            return;
        }

        if(returnedPassword == null){
            System.out.println("Bravo mec ! Nous n'avons pu cracker ton mot de passe");
        }else{
            System.out.println("Mot de passe cracke. le mot de passe est : "+returnedPassword);
        }


        in.close();
    }

    public static void bienvenue(){
      System.out.println("Bienvenue dans SecEyeX!");
        System.out.println("+---------------------------------+");
        System.out.println("|           MENU PRINCIPAL        |");
        System.out.println("+---------------------------------+");
        System.out.println("| 1 ---------------- Brute force  |");
        System.out.println("| 2 --------------- Dictionnaire  |");
        System.out.println("+---------------------------------+");
        System.out.print("Saisir votre choix : ");
    }


    

}
