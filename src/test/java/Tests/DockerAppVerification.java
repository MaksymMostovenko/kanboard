package Tests;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DockerAppVerification {
    private static final String CONTAINER_NAME = "capstoneproject";

    public static void dockerAppVerification() {
        // Create a Docker client
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();

        // Check if the container is running
        boolean isRunning = isContainerRunning(dockerClient, CONTAINER_NAME);

        if (isRunning) {
            System.out.println("The Docker application is running.");
        } else {
            System.out.println("The Docker application is not running. Starting the container...");

            // Start the Docker container using docker-compose up
            startDockerContainer();

            // Wait for the container to start
            waitForContainerToStart(dockerClient, CONTAINER_NAME);

            // Check if the container is running again
            isRunning = isContainerRunning(dockerClient, CONTAINER_NAME);

            if (isRunning) {
                System.out.println("The Docker application has been started successfully.");
            } else {
                System.out.println("Failed to start the Docker application.");
            }
        }
    }

    private static boolean isContainerRunning(DockerClient dockerClient, String containerName) {
        // Get a list of running containers
        List<Container> containers = dockerClient.listContainersCmd().exec();

        // Check if the container with the specified name is running
        return containers.stream().anyMatch(container -> Arrays.asList(container.getNames()).contains("/" + containerName));
    }

    private static void startDockerContainer() {
        // Execute the docker-compose up command to start the container
        // You can use a command line execution library like Apache Commons Exec or ProcessBuilder to execute the command
        // Here's an example using ProcessBuilder:
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("docker-compose", "up");
            Process process = processBuilder.start();
            process.waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void waitForContainerToStart(DockerClient dockerClient, String containerName) {
        // Wait for a specific amount of time or check the container status periodically until it is running
        // You can use the Docker Java API to check the container status
        // Here's an example waiting for 30 seconds:
        long startTime = System.currentTimeMillis();
        long timeout = 30000; // Timeout in milliseconds

        while (System.currentTimeMillis() - startTime < timeout) {
            boolean isRunning = isContainerRunning(dockerClient, containerName);
            if (isRunning) {
                return;
            }

            try {
                Thread.sleep(1000); // Sleep for 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Timeout reached, the container did not start within the specified time
        System.out.println("Timeout reached. The Docker container did not start within the specified time.");
    }
}
