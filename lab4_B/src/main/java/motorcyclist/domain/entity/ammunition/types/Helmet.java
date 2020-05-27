package motorcyclist.domain.entity.ammunition.types;

import motorcyclist.domain.entity.ammunition.Ammunition;
import motorcyclist.domain.entity.ammunition.AmmunitionType;

public class Helmet extends Ammunition {

    public Helmet(){
        name = "";
        type = AmmunitionType.HELMET;
        price = 0;
        weight = 0;
    }
    public Helmet(String name, double price, double weight){
        this.name = name;
        this.type = AmmunitionType.HELMET;
        this.price = price;
        if (weight < 0){
            throw new IllegalArgumentException("Weight must be more or equals 0");
        }
        this.weight = weight;
    }
    public Helmet(Ammunition old){
        this.name = old.name;
        this.type = AmmunitionType.HELMET;
        this.price = old.price;
        this.weight = old.weight;
    }
}
