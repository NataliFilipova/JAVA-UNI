package Nbu.java;

public class RealEstate extends Belonging {

    private String address;
    private TypeOfRealEstate typeOfRealEstate;

    //Constructors

    public RealEstate(String name, double price, Type type, String address, TypeOfRealEstate typeOfRealEstate) {
        super(name, price, type);
        this.address = address;
        this.typeOfRealEstate = typeOfRealEstate;
    }

    public RealEstate(String name) {
        super(name);
    }

    //Gets and Sets


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TypeOfRealEstate getTypeOfRealEstate() {
        return typeOfRealEstate;
    }

    public void setTypeOfRealEstate(TypeOfRealEstate typeOfRealEstate) {
        this.typeOfRealEstate = typeOfRealEstate;
    }



    //Methods


    public RealEstate biggerPrice(RealEstate realEstate){
        if(this.getPrice() > realEstate.getPrice()){
            return this;
        }
        else{
            return realEstate;
        }
    }

    public RealEstate biggerTax(RealEstate realEstate){
        if(this.getTax() > realEstate.getTax()){
            return this;
        }
        else{
            return realEstate;
        }
    }
}
