package EncapsulationExercises.P05FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    public String getName(){
        return name;
    }

    private void setEndurance(int endurance) {
        if (Validator.statsValidator(endurance)){
            this.endurance = endurance;
        } else {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
    }

    private void setSprint(int sprint) {
        if (Validator.statsValidator(sprint)){
            this.sprint = sprint;
        } else {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
    }

    private void setDribble(int dribble) {
        if (Validator.statsValidator(dribble)){
            this.dribble = dribble;
        } else {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
    }

    private void setPassing(int passing) {
        if (Validator.statsValidator(passing)){
            this.passing = passing;
        } else {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
    }

    private void setShooting(int shooting) {
        if (Validator.statsValidator(shooting)){
            this.shooting = shooting;
        } else {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
    }
    public double overallSkillLevel(){
        return (this.endurance+this.sprint+this.dribble+this.passing+this.shooting)/(double)5;
    }
}
