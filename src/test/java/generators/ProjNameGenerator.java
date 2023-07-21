package generators;

public class ProjNameGenerator {
    private static final String counterName = "projCounter";
    public static String newProject() {
        CounterManager countManager = new CounterManager();
        countManager.incrementCounter(counterName);
        return "project#" + countManager.getCounter(counterName);
    }
}
