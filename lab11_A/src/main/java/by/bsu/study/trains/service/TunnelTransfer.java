package by.bsu.study.trains.service;

import by.bsu.study.trains.domain.Train;
import by.bsu.study.trains.domain.Tunnel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TunnelTransfer extends Thread {
    private static final Logger log = LogManager.getLogger(TunnelTransfer.class.getSimpleName());

    private final Tunnel firstTunnel;
    private final Tunnel secondTunnel;
    ConcurrentLinkedQueue<Train> trainFirstQuery;
    ConcurrentLinkedQueue<Train> trainSecondQuery;
    volatile boolean working;

    public TunnelTransfer() {
        firstTunnel = new Tunnel();
        secondTunnel = new Tunnel();
        trainFirstQuery = new ConcurrentLinkedQueue<>();
        trainSecondQuery = new ConcurrentLinkedQueue<>();
        working = false;
    }

    public void addTrainToFirstTunnel(Train train) {
        train.setTunnel(firstTunnel);
        firstTunnel.getTrains().add(train);
        trainFirstQuery.add(train);
    }
    public void addTrainToSecondTunnel(Train train) {
        train.setTunnel(secondTunnel);
        secondTunnel.getTrains().add(train);
        trainSecondQuery.add(train);
    }

    // build string info
    public String getInfo() {
        StringBuilder info = new StringBuilder();

        info.append("\n-----\nAll trains:");
        ArrayList<Train> firstTrains = firstTunnel.getTrains();
        ArrayList<Train> secondTrains = secondTunnel.getTrains();
        for (int i = 0; i < firstTrains.size(); i++){
            info.append("\n").append(i+1).append(". ")
                    .append(firstTrains.get(i).toString());
        }
        for (int i = 0; i < secondTrains.size(); i++){
            info.append("\n").append(firstTrains.size()+i+1).append(". ")
                    .append(secondTrains.get(i).toString());
        }

        String currentTrainStr = (firstTunnel.getCurrentTrain() == null) ?
                "No train in queue." : firstTunnel.getCurrentTrain().toString();
        info.append("\n\nFirst tunnel:")
                .append("\nTunnel length = ").append(firstTunnel.getLength())
                .append("\nCurrent train - ").append(currentTrainStr);

        currentTrainStr = (secondTunnel.getCurrentTrain() == null) ?
                "No train in queue." : secondTunnel.getCurrentTrain().toString();
        info.append("\n\nSecond train:")
                .append("\nTunnel length = ").append(secondTunnel.getLength())
                .append("\nCurrent train - ").append(currentTrainStr);

        return info.append("\n-----\n").toString();
    }

    public void turnOff(){
        working = false;
    }

    @Override
    public void run() {
        working = true;
        for(Train train: firstTunnel.getTrains()){
            train.start();
        }
        for(Train train: secondTunnel.getTrains()){
            train.start();
        }

        while (working) {
            Thread.onSpinWait();
            // wait 1/10 of second
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }

            // if the previous train has finished moving and there are trains in the queue
            if (firstTunnel.getCurrentTrain() == null && trainFirstQuery.size() != 0) {
                // extract next train from the queue
                Train nextTrain = trainFirstQuery.poll();
                // send it to the tunnel
                firstTunnel.setCurrentTrain(nextTrain);
                // push it to the back of queue
                trainFirstQuery.add(nextTrain);
            }
            // same to the second tunnel
            if (secondTunnel.getCurrentTrain() == null && trainSecondQuery.size() != 0) {
                Train nextTrain = trainSecondQuery.poll();
                secondTunnel.setCurrentTrain(nextTrain);
                trainSecondQuery.add(nextTrain);
            }

            // if one of the trains wait too long, send it to another tunnel
            sendWaitingTrainsToAnotherTunnel(firstTunnel, trainFirstQuery, secondTunnel, trainSecondQuery);
            sendWaitingTrainsToAnotherTunnel(secondTunnel, trainSecondQuery, firstTunnel, trainFirstQuery);
        }

        // stop threads
        for (Train train: firstTunnel.getTrains()){
            train.turnOff();
        }
        for (Train train: secondTunnel.getTrains()){
            train.turnOff();
        }
    }

    private void sendWaitingTrainsToAnotherTunnel(Tunnel firstTunnel, ConcurrentLinkedQueue<Train> firstQuery
            , Tunnel secondTunnel, ConcurrentLinkedQueue<Train> secondQuery) {
        ArrayList<Train> trains = firstTunnel.getTrains();
        for (int i = 0; i < trains.size(); i++){
            Train train = trains.get(i);
            if (train.getWaitTime() > 60){
                firstQuery.remove(train);
                train.setWaitTime(0);
                trains.remove(i--);

                secondTunnel.getTrains().add(train);
                secondQuery.add(train);
            }
        }
    }
}
