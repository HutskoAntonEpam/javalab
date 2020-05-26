package by.bsu.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bud {
    private int countPetals;
    private String colorBud;
    private ArrayList<Petal> petals = new ArrayList<>();

    //returns most common colors
    private String CheckColor(ArrayList<Petal> colors) {
        HashMap<String, Integer> cntColors = new HashMap<>();
        for (Petal p : petals) {
            if (!cntColors.containsKey(p.getColorPetal())) {
                cntColors.put(p.getColorPetal(), 0);
            } else {
                cntColors.replace(p.getColorPetal(), cntColors.get(p.getColorPetal()) + 1);
            }
        }
        String color = "";
        int cnt = -1;
        for (Map.Entry<String, Integer> item : cntColors.entrySet()) {
            if (item.getValue() > cnt) {
                cnt = item.getValue();
                color = item.getKey();
            }
        }
        return color;
    }
    //default constructor
    public Bud() {
        this.countPetals = 0;
        this.colorBud = "";
    }
    //add petal
    public void addPetal(String shape, String color) {
        petals.add(new Petal(shape, color));
        countPetals++;
        this.colorBud = CheckColor(petals);
    }
    //returns count of petals
    public int getCountPetals() {
        return countPetals;
    }
    //returns color of bud
    public String getColorBud() {
        return colorBud;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bud{");
        sb.append("countPetals=").append(countPetals);
        sb.append(", colorBud='").append(colorBud).append('\'');
        sb.append(", petals=").append(petals);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bud bud = (Bud) o;
        return countPetals == bud.countPetals &&
                Objects.equals(colorBud, bud.colorBud) &&
                Objects.equals(petals, bud.petals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countPetals, colorBud, petals);
    }
}
