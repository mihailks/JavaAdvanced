package EncapsulationExercises.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team (String name){
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        //TODO
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
    public double getRating(){
        //TODO

        return 0;
    }
}
