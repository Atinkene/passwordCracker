public class SecEyeXFactory {

    public static SecEyeX SecEyeXPassword(int methode) {
        if (methode == 1) {
            return new SecEyeXBruteForce();
        } else if (methode == 2) {
            return new SecEyeXDico();
        } else {
            System.out.println("La methode de crackage"+methode+"est invalide");
        }
        return null;
    }
}
