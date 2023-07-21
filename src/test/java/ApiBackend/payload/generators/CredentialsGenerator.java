package ApiBackend.payload.generators;


public class CredentialsGenerator {
    private static int uCounter = 100;
    private static int pCounter = 100;

    public static String newUsername() {
        uCounter++;
        return "username#" + uCounter;
    }
    public static String newPassword() {
        pCounter++;
        return "paswword#" + pCounter;
    }
}