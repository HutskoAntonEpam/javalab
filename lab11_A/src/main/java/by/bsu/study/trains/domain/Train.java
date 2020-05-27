package by.bsu.study.trains.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Train extends Thread {
    private static final Logger log = LogManager.getLogger(Train.class.getSimpleName());

    private String trainName;
    private Tunnel tunnel;
    private int passed; // what distance train passed in the tunnel
    private int speed; // what distance train pass by one second
    private int waitTime; // how long train wait in queue
    private volatile boolean working; // is thread working

    public Train(String trainName, Tunnel tunnel, int speed) {
        this.trainName = trainName;
        this.tunnel = tunnel;
        passed = 0;
        this.speed = speed;
        working = false;
        waitTime = 0;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setTunnel(Tunnel tunnel) {
        this.tunnel = tunnel;
    }
    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public void turnOff() {
        working = false;
    }

    @Override
    public void run() {
        working = true;
        while (working) {
            Thread.onSpinWait();
            // wait one second
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }

            Train current = tunnel.getCurrentTrain();
            // if now is moving this train
            if (current == this) {
                waitTime = 0; // now train don't wait
                int newPassed = passed + speed; // move train
                // if train moved out of tunnel
                if (newPassed > tunnel.getLength() || newPassed < 0) {
                    newPassed = (newPassed < 0) ? 0 : tunnel.getLength();
                    speed = -speed;
                    tunnel.setCurrentTrain(null);
                }
                passed = newPassed;
            }
            else {
                waitTime++;
            }
        }
    }

    @Override
    public String toString() {
        return trainName + ", passed - " + passed +
                ", speed = " + speed +
                ", waiting " + waitTime + " seconds";
    }
}
