package by.bsy.study.textsorter.handling.domain;

public class Symbol {
    private char symbol;
    private SymbolType type;

    public Symbol(char symbol){
        setSymbol(symbol);
    }

    public char getSymbol() {
        return symbol;
    }
    public SymbolType getType() {
        return type;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
        if (String.valueOf(symbol).matches("[ауоыиэяюёАУОЫИЭЯЮЁaeiouyAEIOUY]")) {
            type = SymbolType.VOWEL;
        } else if (String.valueOf(symbol).matches("[a-zA-Zа-яА-Я]")){
            type = SymbolType.CONSONANT;
        } else {
            type = SymbolType.PUNCTUATION;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
