package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        List<Gun> mainPlayerGuns = (List<Gun>) mainPlayer.getGunRepository().getModels();
        List<Player> civilPlayerList = new ArrayList<>(civilPlayers);

        while (!mainPlayerGuns.isEmpty() && !civilPlayers.isEmpty()) {

            Gun currentGun = mainPlayerGuns.get(0);
            Player currentCivilPlayer = civilPlayerList.get(0);

            int bulletsLeft = currentGun.getTotalBullets();
            int hp = currentCivilPlayer.getLifePoints();

            while (hp > 0 && bulletsLeft > 0) {
                int damage = currentGun.fire();
                hp -= damage;
                bulletsLeft -= damage;
            }

            if (hp <= 0) {
                civilPlayerList.remove(currentCivilPlayer);
                civilPlayers.remove(currentCivilPlayer);
            }
            if (bulletsLeft <= 0) {
                mainPlayerGuns.remove(currentGun);
                mainPlayer.getGunRepository().remove(currentGun);
            }
        }
        while (!civilPlayerList.isEmpty() && mainPlayerGuns.isEmpty() && mainPlayer.isAlive()) {
            Player currentCivilPlayer = civilPlayerList.get(0);
            List<Gun> civilGuns = (List<Gun>) currentCivilPlayer.getGunRepository().getModels();
            Gun currentGun= null;
            while (!civilGuns.isEmpty()){
                currentGun = civilGuns.get(0);

                if (mainPlayer.getLifePoints()==0){
                    break;
                }
                while (mainPlayer.getLifePoints() > 0 && currentGun.canFire()) {
                    mainPlayer.takeLifePoints(currentGun.fire());
                }

            }
            civilGuns.remove(currentGun);
            civilPlayerList.remove(currentCivilPlayer);
        }
    }
}
