package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{


    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        List<String> itemsOnPlanetList = (List<String>) planet.getItems();
        List<Astronaut> astronautList = (List<Astronaut>) astronauts;
        String item = null;
        Astronaut astronaut = null;
        while (!planet.getItems().isEmpty() && !astronauts.isEmpty()){
            item = itemsOnPlanetList.get(0);
            astronaut = ((List<Astronaut>) astronauts).get(0);

            astronaut.getBag().getItems().add(item);

            astronaut.breath();

            itemsOnPlanetList.remove(item);
            if (astronaut.getOxygen()==0){
                astronautList.remove(astronaut);
            }
        }
        planet.getItems().remove(item);
        if (astronaut.getOxygen()==0){
            astronauts.remove(astronaut);
        }


    }
}
