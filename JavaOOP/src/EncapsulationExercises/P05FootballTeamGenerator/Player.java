package EncapsulationExercises.P05FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.name = name;
        this.endurance = endurance;
        this.sprint = sprint;
        this.dribble = dribble;
        this.passing = passing;
        this.shooting = shooting;
    }

    private void setName(String name){
        //TODO
    }
    public String getName(){
        return name;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setSprint(int sprint) {
        this.sprint = sprint;
    }

    public void setDribble(int dribble) {
        this.dribble = dribble;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }
}
