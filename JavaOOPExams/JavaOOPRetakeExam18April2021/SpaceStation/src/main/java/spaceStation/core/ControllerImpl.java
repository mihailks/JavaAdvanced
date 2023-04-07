package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;

    private int exploredPlanetsCount;

    private List<Astronaut> astronautList;
    private Mission mission;

    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
        mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        List<String> itemsPerPlanet = Arrays.asList(items);

        planet.getItems().addAll(itemsPerPlanet);

        this.planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = null;
        for (Astronaut a : astronautRepository.getModels()) {
            if (a.getName().equals(astronautName)) {
                astronaut = a;
            }
        }

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronautRepository.remove(astronaut);

        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        Planet planet = planetRepository.findByName(planetName);

        astronautList = astronautRepository.getModels()
                .stream().filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (astronautList.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        int initialNumberOfAstronauts = astronautList.size();

        mission.explore(planet, astronautList);
        exploredPlanetsCount++;

        int dead = initialNumberOfAstronauts - astronautList.size();

        return String.format(PLANET_EXPLORED, planetName, dead);
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(String.format("%d planets were explored!",exploredPlanetsCount))
//                .append(System.lineSeparator())
//                .append("Astronauts info:")
//                .append(System.lineSeparator());

        String report = String.format("%d planets were explored!%n" +
                        "Astronauts info:%n"
                , exploredPlanetsCount);

        for (Astronaut astronaut : astronautRepository.getModels()) {

            String bagItems = astronaut.getBag().getItems().isEmpty() ? "none"
                    : astronaut.getBag().getItems().stream().collect(Collectors.joining(", "));

            stringBuilder.append(String.format("Name: %s", astronaut.getName()))
                    .append(System.lineSeparator())
                    .append(String.format("Oxygen: %.0f", astronaut.getOxygen()))
                    .append(System.lineSeparator())
                    .append(String.format("Bag items: %s", bagItems))
                    .append(System.lineSeparator());
        }

        return report + stringBuilder.toString().trim();
    }
}
