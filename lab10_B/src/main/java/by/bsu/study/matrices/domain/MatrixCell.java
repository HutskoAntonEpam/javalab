package by.bsu.study.matrices.domain;

public class MatrixCell {
    public int i; // line num
    public int j; // column num
    public int value;
    public MatrixCell next;

    public MatrixCell(int i, int j, int value, MatrixCell next){
        this.i = i;
        this.j = j;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "(" + i + ", " + j + ") " + value;
    }
}
