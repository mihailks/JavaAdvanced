package ExercisesDefiningClasses.P01OpinionPoll.P06PokémonTrainer;

public class Pokemon_01_ {
    private String pokemonName;
    private String element;
    private int health;

    public Pokemon_01_(String pokemonName, String element, int health) {
        this.pokemonName = pokemonName;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return pokemonName;
    }

    public void setName(String name) {
        this.pokemonName = name;
    }

    public String getElement() {
        return element;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}