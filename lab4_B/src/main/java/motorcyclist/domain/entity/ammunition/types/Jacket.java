package motorcyclist.domain.entity.ammunition.types;

import motorcyclist.domain.entity.ammunition.Ammunition;
import motorcyclist.domain.entity.ammunition.AmmunitionType;

public class Jacket extends Ammunition {

    public Jacket(){
        name = "";
        type = AmmunitionType.JACKET;
        price = 0;
        weight = 0;
    }
    public Jacket(String name, double price, double weight){
        this.name = name;
        this.type = AmmunitionType.JACKET;
        if (weight < 0){
            throw new IllegalArgumentException("Weight must be more or equals 0");
        }
        this.price = price;
        this.weight = weight;
    }
    public Jacket(Ammunition old){
        this.name = old.name;
        this.type = AmmunitionType.JACKET;
        this.price = old.price;
        this.weight = old.weight;
    }
}
