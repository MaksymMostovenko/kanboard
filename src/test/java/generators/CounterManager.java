package generators;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CounterManager {
    private static final String FILE_PATH = "counter_data.json";
    private static final int DEFAULT_INITIAL_VALUE = 0;

    private Map<String, Integer> counters;

    public CounterManager() {
        loadCountersFromFile();
    }

    public int getCounter(String name) {
        return counters.getOrDefault(name, DEFAULT_INITIAL_VALUE);
    }

    public void incrementCounter(String name) {
        int currentValue = counters.getOrDefault(name, DEFAULT_INITIAL_VALUE);
        counters.put(name, currentValue + 1);
        saveCountersToFile();
    }

    private void loadCountersFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            counters = new HashMap<>();
            return;
        }

        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Integer.class);
            counters = objectMapper.readValue(file, mapType);
        } catch (IOException e) {
            e.printStackTrace();
            counters = new HashMap<>();
        }
    }

    private void saveCountersToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(FILE_PATH);

        try {
            objectMapper.writeValue(file, counters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CounterManager counterManager = new CounterManager();

        // Example usage
        String counterName = "counter1";
        int initialValue = counterManager.getCounter(counterName);
        System.out.println("Initial value of " + counterName + ": " + initialValue);

        counterManager.incrementCounter(counterName);
        int incrementedValue = counterManager.getCounter(counterName);
        System.out.println("Incremented value of " + counterName + ": " + incrementedValue);
    }
}
