import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MdService {
    public MdService(){
    }

    public static String mdHasheur(String algo, String chaine){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algo);
            byte[] hashBytes = messageDigest.digest(chaine.getBytes(StandardCharsets.UTF_8));
            messageDigest.reset();


            BigInteger hashInt = new BigInteger(1, hashBytes);
            String hashString = hashInt.toString(16);
            while (hashString.length() < hashBytes.length * 2) {
                hashString = "0" + hashString;
            }


            return hashString;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("Mec defal algo hash bou baax");
            System.exit(0);
        }
        return "";
        
    }
    
    public static void afficherHash(byte[] hash){

        System.out.println("votre hash est de taille : "+hash.length);
        for (int i = 0; i < hash.length; i++) {
            System.out.println(hash[i]);
        }
        System.out.print("");
    }


    public static boolean mdCompare(StringBuilder password, String chaine, boolean isSimple){
        boolean retour;
        if(isSimple){
            retour = mdSimpleCompare(password, chaine);
        }else{
            retour = mdHashedCompare(password, chaine);
        }

        return retour;
    }
    public static boolean mdSimpleCompare(StringBuilder password, String chaine){
        if(chaine.equals(password.toString())){
            return true;
        }
        return false;
    }
    public static boolean mdHashedCompare(StringBuilder password, String chaine){
        String[] algos = {"MD2", "MD5", "SHA-224", "SHA-1", "SHA-256", "SHA-384", "SHA-512/224", "SHA-512/256", "SHA3-224", "SHA3-256", "SHA3-384", "SHA3-512"};
        for (int i = 0; i < algos.length; i++) {
            String chaineHashe = MdService.mdHasheur(algos[i], chaine);
            if(chaineHashe.equals(password.toString())){
                return true;

            }
        }

        return false;
    }

    


}
