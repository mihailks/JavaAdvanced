package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT;
import static robotService.common.ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseService implements Service {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    protected BaseService(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        supplements = new ArrayList<>();
        robots = new ArrayList<>();
    }


    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if (capacity > robots.size()) {
            this.robots.add(robot);
        } else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : robots) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        return this.supplements.stream().mapToInt(Supplement::getHardness).sum();
    }

    @Override
    public String getStatistics() {
        String robotsNamesStr = this.robots.isEmpty() ? "none"
                : this.robots.stream()
                .map(Robot::getName).collect(Collectors.joining(" "));
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s %s:", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("Robots: %s", robotsNamesStr))
                .append(System.lineSeparator())
                .append(String.format("Supplements: %d Hardness: %d", this.supplements.size(), sumHardness()))
                .append(System.lineSeparator());

        return stringBuilder.toString().trim();
    }
}












