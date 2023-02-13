package ExercisesDefiningClasses.P01OpinionPoll.P06PokémonTrainer;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon_01_> pokemonList;


    public Trainer(String name, List<Pokemon_01_> pokemonList) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges() {
        this.badges++;
    }

    public List<Pokemon_01_> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(Pokemon_01_ pokemon) {
        pokemonList.add(pokemon);
    }

    public void commandExecuting(String input) {
        if (itExist(input)){
            badges++;
        } else {
            for (int i = 0; i < pokemonList.size(); i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if (pokemonList.get(i).getHealth() <= 0) {
                    pokemonList.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean itExist(String input) {
        for (Pokemon_01_ pokemon : pokemonList) {
            if (pokemon.getElement().equals(input)) {
                return true;
            }
        }
        return false;

    }
    @Override
    public String toString() {
        return name + " " + badges + " " + pokemonList.size();
    }
}
