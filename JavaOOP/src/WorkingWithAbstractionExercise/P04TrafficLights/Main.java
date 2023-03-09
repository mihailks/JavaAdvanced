package WorkingWithAbstractionExercise.P04TrafficLights;

import sun.misc.Signal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String trafficLine = scanner.nextLine();
        String[] trafficLightsAsStrings = trafficLine.split("\\s+");

        TrafficLight[] trafficLights = new TrafficLight[trafficLightsAsStrings.length];

        for (int i = 0; i < trafficLightsAsStrings.length; i++) {
            String trafficLightsAsString = trafficLightsAsStrings[i];
            TrafficLight.Signal signal = TrafficLight.Signal.valueOf(trafficLightsAsString);
            trafficLights[i] = new TrafficLight(signal);

        }
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            updateTrafficLights(trafficLights);
            printTrafficLights(trafficLights);
        }

    }

    private static void printTrafficLights(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            System.out.print(trafficLight.getSignal() + " ");
        }
        System.out.println();
    }

    private static void updateTrafficLights(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.update();
        }
    }
}
