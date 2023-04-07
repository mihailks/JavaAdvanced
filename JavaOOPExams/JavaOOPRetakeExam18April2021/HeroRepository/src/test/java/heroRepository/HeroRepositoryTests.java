package heroRepository;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroRepositoryTests {

    //TODO Create
    @Test(expected = NullPointerException.class)
    public void testCreateHeroNullThrow(){
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroDuplicateHeroThrow(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("name1", 10);
        Hero hero2 = new Hero("name1", 10);
        heroRepository.create(hero1);
        heroRepository.create(hero2);
    }

    @Test
    public void testHeroAddedOk(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("name1", 10);
        String actual = heroRepository.create(hero1);
        String expected = "Successfully added hero name1 with level 10";
        assertEquals(actual, expected);
    }

    //TODO remove
    @Test(expected = NullPointerException.class)
    public void testCreateHeroDuplicateHeroNullThrow(){
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroDuplicateHeroEmptyThrow(){
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove("");
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroDuplicateHeroSpacesThrow(){
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove("   ");
    }

    @Test
    public void testRemoveHero(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("name", 10);
        heroRepository.create(hero);

        boolean expected =heroRepository.remove("name");
        assertEquals(true, expected);
    }

    //TODO getHeroWithHighestLevel
    @Test
    public void testGetHeroWithHighestLevel(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("name1", 10);
        Hero hero2 = new Hero("name2", 20);
        heroRepository.create(hero1);
        heroRepository.create(hero2);

        Hero expected = heroRepository.getHeroWithHighestLevel();

        assertEquals(hero2,expected);
    }

    @Test
    public void testGetHero(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("name1", 10);
        Hero hero2 = new Hero("name2", 20);
        heroRepository.create(hero1);
        heroRepository.create(hero2);

        Hero expected = heroRepository.getHero("name1");

        assertEquals(hero1,expected);
    }

    //TODO getHeroes

//    @Test
//    public void testGetHeros(){
//        HeroRepository heroRepository = new HeroRepository();
//        Hero hero1 = new Hero("name1", 10);
//        Hero hero2 = new Hero("name2", 20);
//        heroRepository.create(hero1);
//        heroRepository.create(hero2);
//
//        Collection<Hero> actual = new ArrayList<>();
//        actual.add(hero1);
//        actual.add(hero2);
//
//        Collection<Hero> expected = heroRepository.getHeroes();
//        assertEquals(actual,expected);
//    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCollections(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("name1", 10);
        Hero hero2 = new Hero("name2", 20);

        heroRepository.getHeroes().clear();
    }


}



















