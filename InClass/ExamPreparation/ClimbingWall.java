package com.company.Main;

import java.util.ArrayList;

public class ClimbingWall {
    private int height;
    private ArrayList<Climber> climbers;

    public ClimbingWall() {
    }

    public ClimbingWall(int height) {
        this.height = height;
        this.climbers = new ArrayList<>();
    }


    public void addClimber(Climber climber){
        this.climbers.add(climber);
    }

    public void startClimbing(Climber climber){
        System.out.println(climber + "starts climbing");
        for(int currentHeight = 0 ; currentHeight <= height; currentHeight++){
            System.out.println(climber + "is on " + currentHeight + "meters from the ground.");

        }
        System.out.println(climber + "finished climbing");
    }
}
