package com.company.Main;

public class ClimbersLimitException extends Exception{
    private int climbersLimit;

    public ClimbersLimitException(int climbersLimit) {
        this.climbersLimit = climbersLimit;
    }

    @Override
    public String toString() {
        return "ClimbersLimitException{" +
                "climbersLimit=" + climbersLimit +
                '}';
    }
}
