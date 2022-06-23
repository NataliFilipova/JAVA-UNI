package com.company.Main;

import java.util.ArrayList;

public class ClimbingHall {
    private ArrayList<ClimbingWall> climbingWalls;
    private ArrayList<Climber> climbers;

    public ClimbingHall() {
        this.climbingWalls = new ArrayList<>();
        this.climbers = new ArrayList<>();
    }

   public void addClimbingWall(ClimbingWall wall){
        this.climbingWalls.add(wall);
   }


    public void removeClimbingWall(ClimbingWall wall){
        this.climbingWalls.remove(wall);
    }

    public void addClimber(Climber climber){
        this.climbers.add(climber);
    }
    public void removeClimber(Climber climber){
        this.climbers.remove(climber);
    }



    public void startClimbingSession() throws  ClimbersLimitException {
        if(this.climbers.size() > this.climbingWalls.size()) {
            throw new ClimbersLimitException(this.climbingWalls.size());
        }

        for(int i = 0; i < this.climbingWalls.size(); ++i){
            ClimbingWall wall = this.climbingWalls.get(i);
            int finalI = i;
            Runnable runnable = () -> wall.startClimbing(this.climbers.get(finalI));

            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
