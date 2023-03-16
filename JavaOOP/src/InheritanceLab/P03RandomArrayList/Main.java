package InheritanceLab.P03RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        randomArrayList.add(5);
        randomArrayList.add(6);
        randomArrayList.add(7);
        randomArrayList.add(8);
        randomArrayList.add(9);

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());

    }
}