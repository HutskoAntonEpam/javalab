package motorcyclist.domain.entity.ammunition.types;

import motorcyclist.domain.entity.ammunition.Ammunition;
import motorcyclist.domain.entity.ammunition.AmmunitionType;

public class Gloves extends Ammunition {

    public Gloves(){
        name = "";
        type = AmmunitionType.GLOVES;
        price = 0;
        weight = 0;
    }
    public Gloves(String name, double price, double weight){
        this.name = name;
        this.type = AmmunitionType.GLOVES;
        this.price = price;
        if (weight < 0){
            throw new IllegalArgumentException("Weight must be more or equals 0");
        }
        this.weight = weight;
    }
    public Gloves(Ammunition old){
        this.name = old.name;
        this.type = AmmunitionType.GLOVES;
        this.price = old.price;
        this.weight = old.weight;
    }
}
