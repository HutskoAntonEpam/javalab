package motorcyclist.domain.entity;

/*7. Мотоциклист. Определить иерархию амуниции.
Экипировать мотоциклиста. Подсчитать стоимость.
Провести сортировку амуниции на основе веса.
Найти элементы амуниции, соответствующие заданному
диапазону параметров цены*/

import motorcyclist.domain.entity.ammunition.Ammunition;
import motorcyclist.domain.entity.ammunition.types.*;
import motorcyclist.domain.exception.WrongAmmunitionException;

import static motorcyclist.domain.entity.ammunition.AmmunitionType.*;

public class Motorcyclist {
    private Helmet helmet;
    private Jacket jacket;
    private Gloves gloves;
    private Pants pants;
    private Boots boots;

    public Motorcyclist(){
        helmet = new Helmet("Standard Helmet", 1, 1);
        jacket = new Jacket("Standard Jacket", 1, 1);
        gloves = new Gloves("Standard Gloves", 1, 1);
        pants = new Pants("Standard PANTS", 1, 1);
        boots = new Boots("Standard BOOTS", 1, 1);
    }
    public Motorcyclist(Helmet helmet, Jacket jacket,
                        Gloves gloves, Pants pants, Boots boots){
        this.helmet = helmet;
        this.jacket = jacket;
        this.gloves = gloves;
        this.pants = pants;
        this.boots = boots;
    }

    public Ammunition getHelmet() {
        return new Ammunition(helmet);
    }
    public Ammunition getJacket() {
        return new Ammunition(jacket);
    }
    public Ammunition getGloves() {
        return new Ammunition(gloves);
    }
    public Ammunition getPants() {
        return new Ammunition(pants);
    }
    public Ammunition getBoots() {
        return new Ammunition(boots);
    }

    public void setHelmet(Helmet helmet) throws WrongAmmunitionException {
        if (helmet.type == HELMET) {
            this.helmet = new Helmet(helmet);
        }
        else {
            throw new WrongAmmunitionException("Invalid ammunition type", helmet.type);
        }
    }
    public void setJacket(Jacket jacket) throws WrongAmmunitionException {
        if(jacket.type == JACKET) {
            this.jacket= new Jacket(jacket);
        }
        else {
            throw new WrongAmmunitionException("Invalid ammunition type", jacket.type);
        }
    }
    public void setGloves(Gloves gloves) throws WrongAmmunitionException {
        if(gloves.type == GLOVES){
            this.gloves= new Gloves(gloves);
        }
        else {
            throw new WrongAmmunitionException("Invalid ammunition type", gloves.type);
        }
    }
    public void setPants(Pants pants) throws WrongAmmunitionException {
        if(pants.type == PANTS){
            this.pants= new Pants(pants);
        }
        else {
            throw new WrongAmmunitionException("Invalid ammunition type", pants.type);
        }
    }
    public void setBoots(Boots boots) throws WrongAmmunitionException {
        if(boots.type == BOOTS) {
            this.boots= new Boots(boots);
        }
        else {
            throw new WrongAmmunitionException("Invalid ammunition type", boots.type);
        }
    }

    public double getFinalPrice(){
        return helmet.price + jacket.price + gloves.price + pants.price + boots.price;
    }

    @Override
    public String toString() {
        return "Chosen equipment:\n" +
                "Helmet - " + helmet.name + ",\n" +
                "Jacket - " + jacket.name + ",\n" +
                "Gloves - " + gloves.name + ",\n" +
                "Pants - " + pants.name + ",\n" +
                "Boots - " + boots.name + ".";
    }
}
