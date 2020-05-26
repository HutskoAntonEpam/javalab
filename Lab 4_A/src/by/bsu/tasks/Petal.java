package by.bsu.tasks;

import java.util.Objects;

public class Petal {
    //shape of petal
    private String shapePetal;
    //color of petal
    private String colorPetal;
    //default constructor
    public Petal()
    {
        this.shapePetal = "";
        this.colorPetal = "";
    }
    //constructor with parameters: shape, color
    public Petal(String shape, String color)
    {
        //empty line exception handler
        try {
            if (shape == null || color == null)
                throw new NullPointerException();
            this.shapePetal = shape;
            this.colorPetal = color;
        }
        catch(NullPointerException ex)
        {
            System.out.println("The entered data is incorrect!");
            System.exit(1);
        }

    }
    //returns shape of petal
    public String getShapePetal() {
        return this.shapePetal;
    }
    //set shape of petal
    public void setShapePetal(String shape) {
        this.shapePetal = shape;
    }
    //returns color of petal
    public String getColorPetal() {
        return this.colorPetal;
    }
    //set color of petal
    public void setColorPetal(String color) {
        this.colorPetal = color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Petal{");
        sb.append("shapePetal='").append(shapePetal).append('\'');
        sb.append(", colorPetal='").append(colorPetal).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Petal petal = (Petal) o;
        return Objects.equals(shapePetal, petal.shapePetal) &&
                Objects.equals(colorPetal, petal.colorPetal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapePetal, colorPetal);
    }
}
