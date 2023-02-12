package ExercisesDefiningClasses.P01OpinionPoll.P06PokémonTrainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String END_COMMAND_POKEMON = "Tournament";
    private static final String END_COMMAND_BATTLE = "End";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<Trainer, Pokemon> trainersMap = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND_POKEMON)) {
            String[] currentInput = scanner.nextLine().split(" ");
            Trainer trainer = new Trainer(currentInput[0]);

            String pokemonName = currentInput[1];
            String pokemonElement = currentInput[2];
            int pokemonHealth = Integer.parseInt(currentInput[3]);

            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,pokemonHealth);

            trainer.setPokemonList(pokemon);

            input = scanner.nextLine();
        }
        System.out.println();

    }
}
