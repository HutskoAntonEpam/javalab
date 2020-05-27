package motorcyclist.domain.entity.ammunition.types;

import motorcyclist.domain.entity.ammunition.Ammunition;
import motorcyclist.domain.entity.ammunition.AmmunitionType;

public class Boots extends Ammunition {

    public Boots(){
        name = "";
        type = AmmunitionType.BOOTS;
        price = 0;
        weight = 0;
    }
    public Boots(String name, double price, double weight){
        this.name = name;
        this.type = AmmunitionType.BOOTS;
        this.price = price;
        if (weight < 0){
            throw new IllegalArgumentException("Weight must be more or equals 0");
        }
        this.weight = weight;
    }
    public Boots(Ammunition old){
        this.name = old.name;
        this.type = AmmunitionType.BOOTS;
        this.price = old.price;
        this.weight = old.weight;
    }
}
