package EncapsulationExercises.P05FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teamsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals(END_COMMAND)) {
            String[] commands = input.split(";");
            String action = commands[0];
            String teamName = commands[1];
            try {
                switch (action) {
                    case "Team":
                        Team team = new Team(teamName);
                        teamsMap.put(teamName, team);
                        break;

                    case "Add":
                        String playerName = commands[2];
                        int endurance = Integer.parseInt(commands[3]);
                        int sprint = Integer.parseInt(commands[4]);
                        int dribble = Integer.parseInt(commands[5]);
                        int passing = Integer.parseInt(commands[6]);
                        int shooting = Integer.parseInt(commands[7]);
                        if (teamsMap.containsKey(teamName)) {
                            Player player = new Player(playerName,endurance, sprint, dribble, passing, shooting);
                            teamsMap.get(teamName).addPlayer(player);
                        } else {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }
                        break;

                    case "Remove":
                        playerName = commands[2];
                        if (teamsMap.containsKey(teamName)) {
                            teamsMap.get(teamName).removePlayer(playerName);
                        }else {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }
                        break;

                    case "Rating":
                        if (teamsMap.containsKey(teamName)){
                            team = teamsMap.get(teamName);
                            double rating = Math.round(team.getRating());
                            System.out.printf("%s - %d%n", team.getName(),Math.round(rating));
                        } else {
                            System.out.printf("Team %s does not exist.%n",teamName);
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
