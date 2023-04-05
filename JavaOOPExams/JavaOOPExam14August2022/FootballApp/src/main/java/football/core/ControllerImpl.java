package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplementRepository;
    private List<Field> fields;

    public ControllerImpl() {
        supplementRepository = new SupplementRepositoryImpl();
        fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field currentField;
        if (fieldType.equals("ArtificialTurf")) {
            currentField = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            currentField = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.add(currentField);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement CurrentSupplement;
        if (type.equals("Powdered")) {
            CurrentSupplement = new Powdered();
        } else if (type.equals("Liquid")) {
            CurrentSupplement = new Liquid();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplementRepository.add(CurrentSupplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        if (supplementRepository.findByType(supplementType) == null) {
            String msg = String.format(NO_SUPPLEMENT_FOUND, supplementType);
            throw new IllegalArgumentException(msg);
        }
        Supplement supplement = supplementRepository.findByType(supplementType);
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                field.addSupplement(supplement);
            }
        }
        supplementRepository.remove(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        if (playerType.equals("Men")) {
            player = new Men(playerName, nationality, strength);
        } else if (playerType.equals("Women")) {
            player = new Women(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        String msg = String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);

        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                if (field.getClass().getSimpleName().equals("ArtificialTurf")) {
                    if (player.getClass().getSimpleName().equals("Women")) {
                        field.addPlayer(player);
                        return msg;
                    } else {
                        return FIELD_NOT_SUITABLE;
                    }
                } else if (field.getClass().getSimpleName().equals("NaturalGrass")) {
                    if (player.getClass().getSimpleName().equals("Men")) {
                        field.addPlayer(player);
                        return msg;
                    } else {
                        return FIELD_NOT_SUITABLE;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String dragPlayer(String fieldName) {
        int dragCounter = -1;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                dragCounter = field.getPlayers().size();
                field.drag();
            }
        }
        return String.format(PLAYER_DRAG, dragCounter);
    }

    @Override
    public String calculateStrength(String fieldName) {
        int totalStr = -1;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                totalStr = field.getPlayers()
                        .stream()
                        .mapToInt(Player::getStrength)
                        .sum();
            }
        }
        return String.format(STRENGTH_FIELD, fieldName, totalStr);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            sb.append(field.getInfo())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
