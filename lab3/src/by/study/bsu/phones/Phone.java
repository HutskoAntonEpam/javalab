package by.study.bsu.phones;

import java.math.BigDecimal;
import java.util.Date;

class Phone {
    private int id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String address;
    private long cardID;
    private BigDecimal debit;
    private BigDecimal credit;
    private double townCallsTime;
    private double distanceCallsTime;

    //constructors
    Phone(){
        townCallsTime = 0;
        distanceCallsTime = 0;
    }
    Phone(int idN, String firstNameN, String secondNameN){
        this(); //call of empty constructor
        id = idN;
        firstName = firstNameN;
        secondName = secondNameN;
    }
    Phone(int idN, String firstNameN, String secondNameN, String patronymicN, String addressN, long cardIDN){
        this(idN, firstNameN, secondNameN);
        patronymic = patronymicN;
        address = addressN;
        cardID = cardIDN;
    }

    //getters
    int getId(){
        return id;
    }
    String getFirstName(){
        return firstName;
    }
    String getSecondName(){
        return secondName;
    }
    String getPatronymic(){
        return patronymic;
    }
    String getAddress(){
        return address;
    }
    long getCardID(){
        return cardID;
    }
    BigDecimal getDebit(){
        return debit;
    }
    BigDecimal getCredit(){
        return credit;
    }
    double getTownCallsTime(){
        return townCallsTime;
    }
    double getDistanceCallsTime(){
        return distanceCallsTime;
    }

    //setters
    void setId(int idN){
        id = idN;
    }
    void setFirstName(String firstNameN){
        firstName = firstNameN;
    }
    void setSecondName(String secondNameN){
        secondName = secondNameN;
    }
    void setPatronymic(String patronymicN){
        patronymic = patronymicN;
    }
    void setAddress(String addressN){
        address = addressN;
    }
    void setCardID(long cardIDN){
        cardID = cardIDN;
    }
    void setDebit(BigDecimal debitN){
        debit = new BigDecimal(debitN.toString());//для полной точности
    } //new object with same value
    void setCredit(BigDecimal creditN){
        credit = new BigDecimal(creditN.toString());
    }
    void setTownCallsTime(double townCallsTimeN){
        townCallsTime = townCallsTimeN;
    }
    void setDistanceCallsTime(double distanceCallsTimeN){
        distanceCallsTime = distanceCallsTimeN;
    }

    public String toString(){
        String str = "N" + id + " " + firstName + " " + secondName + " " + patronymic
                + ":\n<--\naddress - " + address + ";\ncardID - " + cardID
                + ";\ndebit - " + debit.floatValue() + "$;\ncredit - " + credit.floatValue()
                + "$;\nTown calls - " + townCallsTime
                + " mins;\nDistance calls - " + distanceCallsTime + " mins;\n";
        str+="-->";
        return str;
    }
}
