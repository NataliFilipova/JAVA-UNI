/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class MovieTheatre extends TradeCenter {

    public static final long serialVersionUID = 123456789L;

    private int numberOfTicketsSold;
    private double pricePerTicket;

    public MovieTheatre() {
    }

    public MovieTheatre(int numberOfTicketsSold, double pricePerTicket, String name, String address) {
        super(name, address);
        this.numberOfTicketsSold = numberOfTicketsSold;
        this.pricePerTicket = pricePerTicket;
    }

    @Override
    public String toString() {
        return super.toString() + "MovieTheater{" +
                "numberOfTicketsSold=" + numberOfTicketsSold +
                ", pricePerTicket=" + pricePerTicket +
                '}';
    }

}

