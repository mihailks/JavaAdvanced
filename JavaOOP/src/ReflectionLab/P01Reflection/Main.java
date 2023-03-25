import ReflectionLab.P01Reflection.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);

        Class<?> superclass = clazz.getSuperclass();

        System.out.println(superclass);

        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class<?> c : interfaces) {
            System.out.println(c);
        }

        Object reflectionObject = clazz.getDeclaredConstructor().newInstance();

        System.out.println(reflectionObject);
    }
}