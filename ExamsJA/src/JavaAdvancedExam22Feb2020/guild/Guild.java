package guild;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
            }
        }
    }
    //

    public int count() {
        return this.roster.size();
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = new ArrayList<>();
        Iterator<Player> removeIt = this.roster.iterator();

        while (removeIt.hasNext()) {
            Player player = removeIt.next();
            if (player.getClazz().equals(clazz)) {
                kickedPlayers.add(player);
                removeIt.remove();
            }
        }
        return kickedPlayers.toArray(new Player[0]);
    }

    public String report() {
        String stringPrint = this.roster.stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\n"));
        return String.format("Players in the guild: %s:%n%s", this.getName(), stringPrint);
    }
}
