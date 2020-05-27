package motorcyclist.domain.repository;

import motorcyclist.domain.entity.ammunition.Ammunition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class AmmunitionRepository {
    static Logger log = LogManager.getLogger(AmmunitionRepository.class.getName());

    private ArrayList<Ammunition> ammunition;
    String datPath = "./src/main/resources/ammunition.dat";

    public AmmunitionRepository(){
        try {
            ammunition = deserializeFromFile();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private ArrayList<Ammunition> deserializeFromFile() throws Exception {
        FileInputStream inputStream = new FileInputStream(datPath);
        ObjectInputStream deserializeStream = new ObjectInputStream(inputStream);

        try {
            return (ArrayList<Ammunition>)deserializeStream.readObject();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return new ArrayList<Ammunition>();
    }

    public void write() throws IOException {
        FileOutputStream fileStream = new FileOutputStream(datPath);
        ObjectOutputStream serialStream = new ObjectOutputStream(fileStream);

        serialStream.writeObject(ammunition);
    }

    public void add(Ammunition ammunitionItem){
        ammunition.add(ammunitionItem);
    }

    public void remove(int index) {
        ammunition.remove(index);
    }

    public ArrayList<Ammunition> getArrayList() {
        return new ArrayList<>(ammunition);
    }
}
