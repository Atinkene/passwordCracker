public abstract class Cracker {
    public abstract String crackerSimplePassword(StringBuilder motDePasse);
    public abstract String crackerHashedPassword(StringBuilder motDePasse, int initalLength);
}