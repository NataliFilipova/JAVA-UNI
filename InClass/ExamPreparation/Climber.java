package com.company.Main;

import java.io.Serializable;

public class Climber implements Serializable {
    private String name;

    public Climber() {
    }

    public Climber(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "name='" + name + '\'' +
                '}';
    }
}
