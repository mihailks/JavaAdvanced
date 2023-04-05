package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.capacity >= players.size()) {
            this.players.add(player);
        } else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        int supplementsCount = supplements.size();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder playerByNameSb = new StringBuilder();

        stringBuilder.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        if (this.getPlayers().size() == 0) {
            stringBuilder.append("Player: none")
                    .append(System.lineSeparator());
        } else {
            for (Player player : players) {
                playerByNameSb.append(player.getName()).append(" ");
            }
            stringBuilder.append(String.format("Player: %s", playerByNameSb.toString().trim()))
                    .append(System.lineSeparator());
        }
        stringBuilder.append(String.format("Supplement: %d", supplementsCount))
                .append(System.lineSeparator())
                .append(String.format("Energy: %d", sumEnergy()));
        return stringBuilder.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(players);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(supplements);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
