public class Driver {
    private String name;
    private int age;
    private int raceHours;
    private int takenDrivenTime;

    public Driver(String name, int age, int raceHours) {
        this.name = name;
        this.age = age;
        this.raceHours = raceHours;
    }

    public int getRaceHours() {
        return raceHours;
    }
}
