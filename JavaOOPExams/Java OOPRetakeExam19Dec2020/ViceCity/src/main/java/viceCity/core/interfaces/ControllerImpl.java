package viceCity.core.interfaces;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    GangNeighbourhood gangNeighbourhood;

    private Player mainPlayer;
    private Collection<Player> players;
    private GunRepository gunRepository;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new ArrayList<>();
        this.gunRepository = new GunRepository();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        players.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else {
            return GUN_TYPE_INVALID;
        }
        gunRepository.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        for (Gun firstGunToAdd : gunRepository.getModels()) {
            if (name.equals("Vercetti")) {
                mainPlayer.getGunRepository().add(firstGunToAdd);
                gunRepository.remove(firstGunToAdd);
                return String.format(GUN_ADDED_TO_MAIN_PLAYER, firstGunToAdd.getName(), mainPlayer.getName());
            }


            Player currentPlayer = null;
            for (Player player : players) {
                if (player.getName().equals(name)) {
                    currentPlayer = player;
                }
            }


            if (currentPlayer == null) {
                return String.format(CIVIL_PLAYER_DOES_NOT_EXIST);
            }


            currentPlayer.getGunRepository().add(firstGunToAdd);
            gunRepository.remove(firstGunToAdd);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, firstGunToAdd.getName(), currentPlayer.getName());
        }
        return GUN_QUEUE_IS_EMPTY;
    }

    @Override
    public String fight() {
        int totalCivilPeople = players.size();
        int sumHpCivilPlayers = players.stream().mapToInt(Player::getLifePoints).sum();
        gangNeighbourhood.action(mainPlayer, players);
        int peopleDead = totalCivilPeople - players.size();
        if (mainPlayer.getLifePoints() == 100 && sumHpCivilPlayers == players.size() * 50) {
            return FIGHT_HOT_HAPPENED;
        }
        return String.format("A fight happened:%n" +
                        "Tommy live points: %d!%n" +
                        "Tommy has killed: %d players!%n" +
                        "Left Civil Players: %d!"
                , mainPlayer.getLifePoints(), peopleDead, players.size());

    }
}
