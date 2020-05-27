package by.bsy.study.textsorter.handling.domain;

/*2 — ABC, 3 — DEF, 4 — GHI,
5 — JKL, 6 — MNO, 7 — PQRS, 8 — TUV, 9 — WXYZ.*/
public enum Translation {
    l2("ABC"),
    l3("DEF"),
    l4("GHI"),
    l5("JKL"),
    l6("MNO"),
    l7("PQRS"),
    l8("TUV"),
    l9("WXYZ");

    private final String decode;

    Translation(String decode) {
        this.decode = decode;
    }

    public String getDecode() {
        return decode;
    }
}
