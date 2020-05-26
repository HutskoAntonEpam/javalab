package by.bsu.tasks;

import java.util.Objects;

public class Flower extends Bud {
    private int state;
    //default constructor
    public Flower()
    {
        this.state = 0;
    }
    //set flower state in bloom
    public void Bloom()
    {
        this.state = 1;
    }
    //set flower state in wilt
    public void Wilt()
    {
        this.state = -1;
    }
    //returns flower state
    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flower{");
        sb.append("state=").append(state);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Flower flower = (Flower) o;
        return state == flower.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), state);
    }
}
