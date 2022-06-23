/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

public abstract class TradeCenter implements Serializable {

    protected String name;
    transient protected String address;
    protected static double tax;

    public TradeCenter() {
    }

    public TradeCenter(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "name=" + name + ", address=" + address + ", ";
    }
}

