package by.study.interfaces.service.data;

import java.util.Random;

public class Neurosurgeon extends Surgeon {
    public Neurosurgeon(){
        super();
    }
    public Neurosurgeon(String name, int experience){
        super(name, experience);
    }

    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public String getDoctorType() {
        return Neurosurgeon.class.getSimpleName();
    }
    @Override
    public String getSurgeryResult() {
        Random rand = new Random();
        if (rand.nextInt(getExperience())/2 == 1)
            return "Neurosurgery failed!";
        return "Neurosurgery was successful";
    }
}
