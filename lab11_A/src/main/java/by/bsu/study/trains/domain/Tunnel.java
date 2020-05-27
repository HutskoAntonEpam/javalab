package by.bsu.study.trains.domain;

import java.util.ArrayList;

public class Tunnel {

    private ArrayList<Train> trains;
    private Train currentTrain;
    private int length;

    public int getLength() {
        return length;
    }
    public Train getCurrentTrain() {
        return currentTrain;
    }
    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

    public Tunnel() {
        trains = new ArrayList<>();
        currentTrain = null;
        length = 200;
    }

}
