import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CrackerDictionnaire extends Cracker {
    
    public String crackerSimplePassword(StringBuilder password) {
        System.out.println("Cracking password using dictionary attack...");


        String returnedPassword;
        long debut = System.currentTimeMillis();

        returnedPassword = parDictionnaire(password, true);
        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut)/(1000);

        System.out.println("temps ecoule : "+tempsEcoule+"s");
        return returnedPassword;

        
    }

    
    public String crackerHashedPassword(StringBuilder password, int initalLength) {
        System.out.println("Hashing password using dictionary algorithm...");


        String returnedPassword;
        long debut = System.currentTimeMillis();

        returnedPassword = parDictionnaire(password, false);

        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut)/(1000);

        System.out.println("temps ecoule : "+tempsEcoule+"s");

        return returnedPassword;
    }

    public String parDictionnaire(StringBuilder password, boolean isSimple){
        try {
            File file = new File("password-bib/french_passwords_top20000.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                if(MdService.mdCompare(password, line, isSimple)){
                    bufferedReader.close();
                    return line;
                }     
            }

            fileReader.close();    
            return null;
            

            
            
        } catch (Exception e) {
            System.out.println("ERRREUR");
        }
        return "";
    }




    
}
