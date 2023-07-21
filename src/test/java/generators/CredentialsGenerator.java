package generators;

public class CredentialsGenerator {
    private static int uCounter = 100;
    private static int pCounter = 100;
    private static final String usNameCounter = "uCounter";
    private static final String psNameCounter = "pCounter";

    public static String newUsername() {
        CounterManager countManager = new CounterManager();
        countManager.incrementCounter(usNameCounter);
        return "username#" + countManager.getCounter(usNameCounter);
    }
    public static String newPassword() {
        CounterManager countManager = new CounterManager();
        countManager.incrementCounter(psNameCounter);
        return "paswword#" + countManager.getCounter(psNameCounter);
    }
}