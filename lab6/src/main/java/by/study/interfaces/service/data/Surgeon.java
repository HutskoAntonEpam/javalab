package by.study.interfaces.service.data;

import java.util.Random;

public class Surgeon implements Doctor {
    private String name;
    private int experience;

    public Surgeon(){
        name = "SurgeonName";
        experience = 10;
    }
    public Surgeon(String name, int experience){
        this.name = name;
        this.experience = (experience > 100 || experience < 0 ) ? 10 : experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDoctorType() {
        return Surgeon.class.getSimpleName();
    }
    @Override
    public String getSurgeryResult() {
        Random rand = new Random();
        if (rand.nextInt(experience) == 1)
            return "Usual surgery failed!";
        return "Usual surgery was successful";
    }
}
