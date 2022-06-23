package com.company.Main;

public class Main {

    public static void main(String[] args) {
	   Climber climber1 = new Climber("Pesho");
       Climber climber2 = new Climber("Viktoria");
       Climber climber3 = new Climber("Toma");
       Climber climber4 = new Climber("Gergana");




        ClimbingWall wall1 = new ClimbingWall(10);
        ClimbingWall wall2 = new ClimbingWall(20);
        ClimbingWall wall3 = new ClimbingWall(5);




       ClimbingHall hall = new ClimbingHall();

       hall.addClimber(climber1);
       hall.addClimber(climber2);
       hall.addClimber(climber3);
     //  hall.addClimber(climber4);

       hall.addClimbingWall(wall1);
       hall.addClimbingWall(wall2);
       hall.addClimbingWall(wall3);

        try {
            hall.startClimbingSession();
        }catch(ClimbersLimitException e){
            System.out.println(e);
            e.printStackTrace();
        }

        // Serializable
        ClimberUtil.serializeClimber("climber.ser", climber1);


        //Deserialize
        Climber climber  = ClimberUtil.deserializeClimber("climber.ser");
        System.out.println(climber);
    }
}
