public class CrackerBruteForce extends Cracker {

    private static final char[] CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{};:'\"\\|,<.>/?".toCharArray();

    private static final int MAX_PASSWORD_LENGTH = 8;

    public String crackerSimplePassword(StringBuilder password) {
        System.out.println("Craquage en utilisant brute force...");

        String returnedPassword = null;
        long debut = System.currentTimeMillis();

        for (int length = 1; length <= MAX_PASSWORD_LENGTH; length++) {
            char[] passwordToGenerate = new char[length];
            returnedPassword = forceBrute(password, passwordToGenerate, 0, length, true);
            if (returnedPassword != null) {
                break;
            }
        }

        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut) / 1000;
        System.out.println("temps ecoule : " + tempsEcoule + "s");

        return returnedPassword;
    }

    public String crackerHashedPassword(StringBuilder password, int initialLength) {
        System.out.println("   Hashage en utilisant l'algorithme brute force ...");

        String returnedPassword = null;
        long debut = System.currentTimeMillis();

        for (int length = 1; length <= MAX_PASSWORD_LENGTH; length++) {
            char[] passwordToGenerate = new char[length];
            returnedPassword = forceBrute(password, passwordToGenerate, 0, length, false);
            if (returnedPassword != null) {
                break;
            }
        }

        long fin = System.currentTimeMillis();
        long tempsEcoule = (fin - debut) / 1000;
        System.out.println("temps ecoule : " + tempsEcoule + "s");

        return returnedPassword;
    }

    public String forceBrute(StringBuilder password, char[] chain, int position, int length, boolean isSimple) {
        if (position == length - 1) {
            for (char c : CHARSET) {
                chain[position] = c;
                String combination = new String(chain);
                System.out.println("Test de combination: " + combination);
                if (MdService.mdCompare(password, combination, isSimple)) {
                    return combination;
                }
            }
            return null;
        } else {
            for (char c : CHARSET) {
                chain[position] = c;
                String result = forceBrute(password, chain, position + 1, length, isSimple);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }
    }
}
