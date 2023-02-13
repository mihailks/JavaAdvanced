package ExercisesDefiningClasses.P01OpinionPoll.P06PokémonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String END_COMMAND_POKEMON = "Tournament";
    private static final String END_COMMAND_BATTLE = "End";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, List<Pokemon_01_>> pokemonByTrainer = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND_POKEMON)) {
            String[] currentInput = input.split(" ");

            String pokemonName = currentInput[1];
            String pokemonElement = currentInput[2];
            int pokemonHealth = Integer.parseInt(currentInput[3]);

            Pokemon_01_ pokemon = new Pokemon_01_(pokemonName, pokemonElement, pokemonHealth);

            pokemonByTrainer.putIfAbsent(currentInput[0], new ArrayList());
            pokemonByTrainer.get(currentInput[0]).add(pokemon);

            input = scanner.nextLine();
        }

        List<Trainer> trainerList = pokemonByTrainer.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        input = scanner.nextLine();
        while (!input.equals(END_COMMAND_BATTLE)) {
            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(input);
            }

            input = scanner.nextLine();
        }
        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
}
