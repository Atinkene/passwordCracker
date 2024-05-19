import java.util.Scanner;

public class CrackerHashedModule {
    private String password;
    public CrackerHashedModule(String password){
        this.password = password;
    }

    public void attaque(Scanner in){
        String returnedPassword;

        int nbreLettre = 0;

        String methode = getMethodeCrackaque(in);

        System.out.print("Aide-nous en nous disant le nombre de caractere avant le hash : ");
        nbreLettre = in.nextInt();
        in.nextLine();
        System.out.println("C'est partie");


        Cracker cracker = CrackageFactory.createPasswordCracker(methode);
        returnedPassword = cracker.crackerHashedPassword(new StringBuilder(this.password), nbreLettre);
        if(returnedPassword == null){
            System.out.println("Sorry! Nous n'avons pu cracker le mot de passe");
        }else{
            System.out.println("mot de passe cracke. le mot de passe est : "+returnedPassword);
        }
        
        
    }


    public String getMethodeCrackaque(Scanner in){
        boolean bon = false;
        String methodeDeCraquage=null;
        while (!bon) {
            
            System.out.println("=============================================");
            System.out.println("= bruteforce                                =");
            System.out.println("=============================================");
            System.out.println("= dictionary                                =");
            System.out.println("=============================================");
    
            methodeDeCraquage = in.nextLine();
            if(!(methodeDeCraquage.equalsIgnoreCase("bruteforce") || methodeDeCraquage.equalsIgnoreCase("dictionary"))){
                System.out.print("choix indisponible");
            }else 
                bon = true;
        }

        return methodeDeCraquage;
    }


}
