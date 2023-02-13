package ExercisesDefiningClasses.P01OpinionPoll.P07Google;

import ExercisesDefiningClasses.P01OpinionPoll.P06PokémonTrainer.Pokemon_01_;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon_01_> pokemon;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(){
        this.parents= new ArrayList<>();
        this.pokemon = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(Company company, List<Pokemon_01_> pokemon, List<Parent> parents, List<Child> children, Car car) {
        this.company = company;
        this.pokemon = pokemon;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon_01_> getPokemon() {
        return this.pokemon;
    }

    public void setPokemon(List<Pokemon_01_> pokemon) {
        this.pokemon = pokemon;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
