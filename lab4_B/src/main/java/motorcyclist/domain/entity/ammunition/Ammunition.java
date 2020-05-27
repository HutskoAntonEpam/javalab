package motorcyclist.domain.entity.ammunition;

import java.io.Serializable;

//structure of every ammunition
public class Ammunition implements Serializable {
    public String name;
    public AmmunitionType type;
    public double price;
    public double weight;

    public Ammunition(){
        name = "";
        type = AmmunitionType.NONE;
        price = 0;
        weight = 0;
    }
    public Ammunition(String name, AmmunitionType type, double price, double weight){
        this.name = name;
        this.type = type;
        this.price = price;
        if (weight < 0){
            throw new IllegalArgumentException("Weight must be more or equals 0");
        }
        this.weight = weight;
    }
    public Ammunition(Ammunition old){
        this.name = old.name;
        this.type = old.type;
        this.price = old.price;
        this.weight = old.weight;
    }

    @Override
    public String toString() {
        return name + " (" + weight + "kg)" + " - " + price + "$";
    }
}
