package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.Repository;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {


    private Repository supplementRepository;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        if (type.equals("MainService")) {
            service = new MainService(name);
        } else if (type.equals("SecondaryService")) {
            service = new SecondaryService(name);
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        services.add(service);
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        if (type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
        } else if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplementRepository.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = supplementRepository.findFirst(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String
                    .format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        supplementRepository.removeSupplement(supplement);
        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                service.addSupplement(supplement);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE
                , supplementType, serviceName);
    }


    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName, robotKind, price);
        } else if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName, robotKind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        for (Service service : services) {
            if (service.getName().equals(serviceName)){
                if (service.getClass().getSimpleName().equals("SecondaryService") && robotType.equals("FemaleRobot")){
                    service.addRobot(robot);
                    return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE,
                            robotType, serviceName);
                } else if (service.getClass().getSimpleName().equals("MainService") && robotType.equals("MaleRobot")){
                    service.addRobot(robot);
                    return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE,
                            robotType, serviceName);
                } else {
                    return UNSUITABLE_SERVICE;
                }
            }
        }




//        if (serviceName.equals("SecondaryService")
//                && robot.getClass().getSimpleName().equals("MaleRobot")) {
//            return UNSUITABLE_SERVICE;
//        } else if (serviceName.equals("MainService")
//                && robot.getClass().getSimpleName().equals("FemaleRobot")) {
//            return UNSUITABLE_SERVICE;
//        } else {
//            for (Service service : services) {
//                service.addRobot(robot);
//            }
//            return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE,
//                    robotType, serviceName);
//        }
        return null;
    }

    @Override
    public String feedingRobot(String serviceName) {
        int counterFed = 0;
        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                service.feeding();
                counterFed = service.getRobots().size();
            }
        }
        return String.format(FEEDING_ROBOT, counterFed);
    }

    @Override
    public String sumOfAll(String serviceName) {
        double robotPrice=0;
        double supplementPrice=0;
        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                robotPrice = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
                supplementPrice = service.getSupplements().stream()
                        .mapToDouble(Supplement::getPrice).sum();
            }
        }
        return String.format(VALUE_SERVICE, serviceName, robotPrice+supplementPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Service service : services) {
            stringBuilder.append(service.getStatistics())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
