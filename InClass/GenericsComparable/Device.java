package com.company;

public class Device extends Goods {
    private int guaranteePeriod;

    public Device() {
    }

    public Device(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public Device(String name, double price, double weight, int guaranteePeriod) {
        super(name, price, weight);
        this.guaranteePeriod = guaranteePeriod;
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    @Override
    public String toString() {
        return "Device{" +
                "guaranteePeriod=" + guaranteePeriod +
                '}';
    }
}
