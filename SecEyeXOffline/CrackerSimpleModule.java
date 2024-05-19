import java.util.Scanner;

public class CrackerSimpleModule {
    private String password;
    public CrackerSimpleModule(String password){
        this.password = password;
    }


    public void attaque(Scanner in){
        
        String returnedPassword;

        String methode = getMethodeCrackaque(in);


        Cracker cracker = CrackageFactory.createPasswordCracker(methode);
        returnedPassword = cracker.crackerSimplePassword(new StringBuilder(this.password));
        if(returnedPassword == null){
            System.out.println("Sorry! Nous n'avons pu cracker ton mot de passe");
        }else{
            System.out.println("Mot de passe cracke. le mot de passe est : "+returnedPassword);
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
            System.out.print("Fais ton choix : ");
            methodeDeCraquage = in.nextLine();
            if(!(methodeDeCraquage.equalsIgnoreCase("bruteforce") || methodeDeCraquage.equalsIgnoreCase("dictionary"))){
                System.out.print("Choix indisponible");
            }else 
                bon = true;
        }

        return methodeDeCraquage;
    }


}
