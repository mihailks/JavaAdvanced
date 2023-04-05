package petStore;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PetStoreTests {
    @Test
    public void testGetAnimalWithMaxKg(){
       PetStore petStore = new PetStore();
       Animal animal = new Animal("dog", 10, 20.5);
       Animal animal1 = new Animal("dog1", 11, 20.5);
       Animal animal2 = new Animal("dog2", 12, 20.5);
       petStore.addAnimal(animal);
       petStore.addAnimal(animal1);
       petStore.addAnimal(animal2);

        List<Animal> expected = new ArrayList<>();
        expected.add(animal1);
        expected.add(animal2);
        assertEquals(expected, petStore.findAllAnimalsWithMaxKilograms(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullAnimalTrows(){
        PetStore petStore = new PetStore();
        petStore.addAnimal(null);
    }

    @Test
    public void testAddAnimal(){
        PetStore petStore = new PetStore();
        Animal animal = new Animal("dog", 10, 20.5);
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test
    public void testMostExpensiveAnimal(){
        PetStore petStore = new PetStore();
        Animal animal = new Animal("dog", 10, 20.5);
        Animal animal1 = new Animal("dog1", 11, 33.5);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal1);
        assertEquals(animal1, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testMostExpensiveAnimalNull(){
        PetStore petStore = new PetStore();
        assertEquals(null, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testGetAllAnimalBySpecie(){
        PetStore petStore = new PetStore();
        Animal animal = new Animal("dog", 10, 20.5);
        Animal animal1 = new Animal("dog1", 11, 33.5);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal1);
        List<Animal> expected = new ArrayList<>();
        expected.add(animal);

        assertEquals(expected, petStore.findAllAnimalBySpecie(animal.getSpecie()));
    }




}

