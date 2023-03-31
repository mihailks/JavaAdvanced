package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.core.commands.NamedCommand;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;
    List<Class<?>> registeredCommands = new ArrayList<>();

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerCommand(Class<?> commandClass) {
        NamedCommand annotation = commandClass.getAnnotation(NamedCommand.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Expected " + commandClass.getSimpleName() + " to have a " + NamedCommand.class.getSimpleName() + " annotation");
        }

        registeredCommands.add(commandClass);
    }

    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        Command command = buildCommand(data, commandName);

        if (command == null) {
            throw new IllegalArgumentException("Can't find command " + commandName);
        }

        String execute = command.execute();
        return execute;
    }

    private Command buildCommand(String[] data, String commandName) {
        Command command = null;
        for (Class<?> registeredCommandClass : registeredCommands) {
            NamedCommand annotation = registeredCommandClass.getDeclaredAnnotation(NamedCommand.class);
            if (annotation.commandName().equals(commandName)) {
                try {
                    command = (Command) registeredCommandClass.getConstructor(String[].class)
                            .newInstance((Object)data);

                    Optional<Field> repositoryField = Stream.of(registeredCommandClass.getDeclaredFields())
                            .filter(f -> f.getType().equals(Repository.class)).findFirst();
                    if (repositoryField.isPresent()) {
                        Field field = repositoryField.get();
                        field.setAccessible(true);
                        field.set(command, repository);
                        field.setAccessible(false);
                    }

                    Optional<Field> unitFactoryField = Stream.of(registeredCommandClass.getDeclaredFields())
                            .filter(f -> f.getType().equals(UnitFactory.class)).findFirst();
                    if (unitFactoryField.isPresent()) {
                        Field field = unitFactoryField.get();
                        field.setAccessible(true);
                        field.set(command, unitFactory);
                        field.setAccessible(false);
                    }
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
        return command;
    }
}