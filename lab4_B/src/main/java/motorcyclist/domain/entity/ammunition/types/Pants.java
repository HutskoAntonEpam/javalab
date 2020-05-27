package motorcyclist.domain.entity.ammunition.types;

import motorcyclist.domain.entity.ammunition.Ammunition;
import motorcyclist.domain.entity.ammunition.AmmunitionType;

public class Pants extends Ammunition {

    public Pants(){
        name = "";
        type = AmmunitionType.PANTS;
        price = 0;
        weight = 0;
    }
    public Pants(String name, double price, double weight){
        this.name = name;
        this.type = AmmunitionType.PANTS;
        this.price = price;
        if (weight < 0){
            throw new IllegalArgumentException("Weight must be more or equals 0");
        }
        this.weight = weight;
    }
    public Pants(Ammunition old){
        this.name = old.name;
        this.type = AmmunitionType.PANTS;
        this.price = old.price;
        this.weight = old.weight;
    }
}
