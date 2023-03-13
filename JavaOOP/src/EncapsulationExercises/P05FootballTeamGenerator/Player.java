package EncapsulationExercises.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Player> players;

    public Player (String name){
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {

    }

    public String getName() {
        return name;
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public void removePlayer(String playerName){
        boolean removed = players.removeIf(p -> p.getName().equals(playerName));
        if (!removed){
            String exceptionMessage = String.format("Player %s is not in %s team.",playerName,name);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
    //TODO...finish
}
