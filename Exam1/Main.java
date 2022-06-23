package Nbu.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //BELONGING CLASS

        Belonging belonging = new Belonging("Apple studio", 6.0, Type.FIXED);
        Belonging belonging2 = new Belonging("Potato", 8.0, Type.MOVABLE);

        //CHECKS IF THE SET METHOD OF TAX IS WORKING.
        //CHECKS CONSTRUCTORS.
        System.out.println(belonging);
        System.out.println(belonging2);

        //CHECKS IF THE GET METHOD OF TYPE IS WORKING.
        System.out.println(belonging.getType());

        //CHECKS IF THE GET METHOD OF PRICE IS WORKING.
        System.out.println(belonging.getPrice());

        //CHECKS IF THE GET METHOD OF TAX IS WORKING.
        System.out.println(belonging.getTax());


        //REAL ESTATE CLASS

        RealEstate realEstate = new RealEstate("Kompleks23", 9.0, Type.FIXED, "Mladost4", TypeOfRealEstate.APARTMENT);
        RealEstate realEstate2 = new RealEstate("Kusht3", 10.0, Type.MOVABLE, "Mladost3", TypeOfRealEstate.HOUSE);


        //CHECK THE METHODS IN THE CLASS
        System.out.println(realEstate.biggerPrice(realEstate2));
        System.out.println(realEstate.biggerTax(realEstate2));


        //CLIENT CLASS
        LocalDate date = LocalDate.of(1956, 6, 9);
        Client client = new Client("Dragomir", date, TypeOfBusiness.BUSINESS);


        //CHECKS ADD AND REMOVE
        client.addBelonging(belonging);
        System.out.println(client.getBelongings().size());
        client.removeBelonging(belonging);
        System.out.println(client.getBelongings().size());

        //CHECKS IF THE TYPE IS BUSINESS

        System.out.println(client.isBusiness());

        //CHANGES THE TYPE
        client.changeTypeOfClient();

        System.out.println(client);


        //CHECKS IF A CLIENT HAS MORE BELONGINGS
        client.addBelonging(belonging);
        client.addBelonging(belonging2);

        Client client2 = new Client("Stancho", date, TypeOfBusiness.BUSINESS);
        client2.addBelonging(belonging);

        System.out.println(client.haveMoreBelongings(client2));


        //TASK 4

        List<RealEstate> masiv = new ArrayList<RealEstate>();

        masiv.add(realEstate);
        masiv.add(realEstate2);

        int countOfFlats = 0;
        int countOfHouses = 0;


        //Prints the count of FLATS AND HOUSES
        for (RealEstate real : masiv) {
            if (real.getTypeOfRealEstate().toString() == "APARTMENT") {
                countOfFlats++;
            } else {
                countOfHouses++;
            }
        }
        System.out.println(countOfFlats);
        System.out.println(countOfHouses);

        //PRINTS ALL
        for (RealEstate real : masiv) {
           System.out.println(real.getTax());
        }

    }
}
