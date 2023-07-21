package generators;

public class TaskNameGenerator {
    private static String taskCounter = "taskCounter";
    public static String newProject() {
        CounterManager countManager = new CounterManager();
        countManager.incrementCounter(taskCounter);
        return "task#" + countManager.getCounter(taskCounter);
    }
}

