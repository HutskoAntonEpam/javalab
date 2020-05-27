package motorcyclist.service;

import motorcyclist.domain.entity.ammunition.AmmunitionType;
import motorcyclist.domain.exception.WrongAmmunitionException;
import motorcyclist.domain.repository.AmmunitionRepository;
import motorcyclist.domain.entity.Motorcyclist;
import motorcyclist.domain.entity.ammunition.Ammunition;
import motorcyclist.domain.entity.ammunition.types.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MotorcyclistService {
    static Logger log = LogManager.getLogger(MotorcyclistService.class.getName());

    private final Motorcyclist equipment;
    private final AmmunitionRepository ammunition; //reading json here

    public MotorcyclistService(){
        ammunition = new AmmunitionRepository();
        equipment = new Motorcyclist();
    }

    public ArrayList<String> getAmmunitionStrings(){
        ArrayList<String> list = new ArrayList<>();
        log.debug(ammunition.getArrayList().size());
        ammunition.getArrayList()
                .forEach((am)->list.add(am.toString()));

        return list;
    }
    public ArrayList<String> getWeightSortedAmmunitionStrings(){
        ArrayList<String> list = new ArrayList<>();
        ammunition.getArrayList()
                .stream()
                .sorted(Comparator.comparingDouble(am -> am.weight))
                .forEach((am)->list.add(am.toString()));
        return list;
    }
    public ArrayList<String> getPriceFilteredAmmunitionStrings(double downBorder, double topBorder){
        ArrayList<String> list = new ArrayList<>();
        ammunition.getArrayList()
                .stream()
                .filter((am) -> am.price >= downBorder && am.price <= topBorder)
                .forEach((am) -> list.add(am.toString()));
        return list;
    }

    public String getEquipmentString(){
        return equipment.toString() + "\nFinal price: " + equipment.getFinalPrice() +  "$.";
    }

    public boolean setNewAmmunition(int index, int outputType, double downBorder, double topBorder){
        if(index < 0) throw new IllegalArgumentException("Index less than 0");
        Ammunition am;
        if (outputType == 1) {
            am = ammunition.getArrayList()
                    .stream()
                    .sorted(Comparator.comparingDouble(amun -> amun.weight))
                    .collect(Collectors.toList())
                    .get(index);
        }
        else if (outputType == 2){
            am = ammunition.getArrayList()
                    .stream()
                    .filter((amun) -> amun.price >= downBorder && amun.price <= topBorder)
                    .collect(Collectors.toList())
                    .get(index);
        }
        else {
            am = ammunition.getArrayList().get(index);
        }
        try{
            switch (am.type) {
                case HELMET:
                    equipment.setHelmet(new Helmet(am));
                    break;
                case JACKET:
                    equipment.setJacket(new Jacket(am));
                    break;
                case GLOVES:
                    equipment.setGloves(new Gloves(am));
                    break;
                case PANTS:
                    equipment.setPants(new Pants(am));
                    break;
                case BOOTS:
                    equipment.setBoots(new Boots(am));
                    break;
                case NONE:
                    throw new WrongAmmunitionException("Ammunition have no type!", AmmunitionType.NONE);
            }
        } catch (WrongAmmunitionException e){
            log.error(e.getMessage() + " Wrong type - " + e.getWrongType());
            return false;
        }
        return true;
    }
}
