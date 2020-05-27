package motorcyclist.domain.exception;
import motorcyclist.domain.entity.ammunition.AmmunitionType;

public class WrongAmmunitionException extends Exception {
    private final AmmunitionType wrongType;

    public AmmunitionType getWrongType(){
        return wrongType;
    }
    public WrongAmmunitionException(String message, AmmunitionType wrongType){
        super(message);
        this.wrongType = wrongType;
    }
}
