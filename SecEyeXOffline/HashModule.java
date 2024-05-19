import java.util.Scanner;

public class HashModule {
    private String password;
    public HashModule(String password){
        this.password = password;
    }

    public void hasher(Scanner in){
        System.out.println("Excellent choix!");
        

        System.out.println("=========================================");
        System.out.println("=   Veuillez choisir l'algo de hashage :=");
        System.out.println("=========================================");
        System.out.println("= MD2                                   =");
        System.out.println("=========================================");
        System.out.println("= MD5                                   =");
        System.out.println("=========================================");
        System.out.println("= SHA-224                               =");
        System.out.println("=========================================");
        System.out.println("= SHA-1                                 =");
        System.out.println("=========================================");
        System.out.println("= SHA-256                               =");
        System.out.println("=========================================");
        System.out.println("= SHA-384                               =");
        System.out.println("=========================================");
        System.out.println("= SHA-512/224                           =");
        System.out.println("=========================================");
        System.out.println("= SHA-512/256                           =");
        System.out.println("=========================================");
        System.out.println("= SHA3-224                              =");
        System.out.println("=========================================");
        System.out.println("= SHA3-256                              =");
        System.out.println("=========================================");
        System.out.println("= SHA3-384                              =");
        System.out.println("=========================================");
        System.out.println("= SHA3-512                              =");
        System.out.println("=========================================");
        System.out.println("Choix :");



        String algo = in.nextLine();
        
        System.out.println("l'algo de hash est : "+algo);
        String hashedPassword = MdService.mdHasheur(algo, password);
        System.out.println("le hash de "+password+" par l'ago " + algo +" est : " + hashedPassword);

    }
}
