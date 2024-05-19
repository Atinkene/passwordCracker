import java.util.Scanner;

public class Menu {
    public Menu(){
        bienvenue();
    }


    public void demarrer(Scanner in){

        int choice=0;

        choice = in.nextInt();
        in.nextLine();

        System.out.print("Veuillez saisir votre mot de passe : ");
        String password = in.nextLine();

        switch (choice) {
            case 1:
                HashModule hashModule = new HashModule(password);
                hashModule.hasher(in);
                break;
            
            case 2:
                CrackerSimpleModule crackerSimpleModule = new CrackerSimpleModule(password);
                crackerSimpleModule.attaque(in);
                break;
            
            case 3:
                CrackerHashedModule crackerHashedModule = new CrackerHashedModule(password);
                crackerHashedModule.attaque(in);
                break;   

        
            default:
                System.out.println("Choix innexistant");
                break;
        }



    }

    public void bienvenue() {
        System.out.println("=========================================");
        System.out.println("=                                       =");
        System.out.println("=         BIENVENUE !!!!                =");
        System.out.println("=                                       =");
        System.out.println("=========================================");
        System.out.println("=                                       =");
        System.out.println("= 1. Pour hasher un mot de passe        =");
        System.out.println("=                                       =");
        System.out.println("=========================================");
        System.out.println("=                                       =");
        System.out.println("= 2. Pour casser un mot de passe simple =");
        System.out.println("=                                       =");
        System.out.println("=========================================");
        System.out.println("=                                       =");
        System.out.println("= 3. Pour casser un mot de passe hashe  =");
        System.out.println("=                                       =");
        System.out.println("=========================================\n");

        System.out.print("Saisir votre choix : ");
    }
}

