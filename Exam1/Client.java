package Nbu.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private LocalDate birthdate;
    private List<Belonging> belongings;
    private TypeOfBusiness typeOfBusiness;

    //Constructors

    public Client(String name, LocalDate birthdate, TypeOfBusiness typeOfBusiness) {
        this.name = name;
        this.birthdate = birthdate;
        this.belongings = new ArrayList<>();
        this.typeOfBusiness = typeOfBusiness;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Belonging> getBelongings() {
        return belongings;
    }

    public void setBelongings(List<Belonging> belongings) {
        this.belongings = belongings;
    }

    public TypeOfBusiness getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public void setTypeOfBusiness(TypeOfBusiness typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }


    //Changes the type of Client

    public void changeTypeOfClient(){
        if(this.getTypeOfBusiness().toString() == "INDIVIDUAL"){
            this.setTypeOfBusiness(typeOfBusiness.BUSINESS);
        }
        else{
            this.setTypeOfBusiness(typeOfBusiness.INDIVIDUAL);
        }
    }

    //Checks if the type of Client is Business

    public boolean isBusiness(){
        if(this.getTypeOfBusiness().toString() =="BUSINESS"){
            return true;
        }
        else{
            return false;
        }
    }

    //Checks who have more belongings.
    public boolean haveMoreBelongings(Client client){
        if(this.belongings.size() > client.belongings.size()){
            return true;
        }
        else{
            return false;
        }
    }

    //Adds belonging
    public void addBelonging(Belonging belonging){
        belongings.add(belonging);
    }

    //Remove belonging
    public void removeBelonging(Belonging belonging){
        belongings.remove(belonging);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", belongings=" + belongings +
                ", typeOfBusiness=" + typeOfBusiness +
                '}';
    }
}
