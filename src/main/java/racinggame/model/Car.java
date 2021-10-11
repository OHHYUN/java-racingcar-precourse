package racinggame.model;

public class Car implements Comparable<Car>{

    public static final int MOVE_FORWARD = 1;
    public static final int STOP = 0;
    public static final int FORWARD_CONDITION = 4;

    private String carName;
    private int distance;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move(int ranNo) {
        this.distance+=isForward(ranNo);
    }

    public int getDistance() {
        return this.distance;
    }

    public int isForward(int ranNo){
        if(ranNo >= FORWARD_CONDITION){
            return MOVE_FORWARD;
        }
        return STOP;
    }

    public void printDistance() {

        StringBuilder printText = new StringBuilder();
        printText.append(this.carName + " : ");
        for(int i = 0; i<this.distance; i++){
            printText.append("-");
        }
        System.out.println(printText);
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public int compareTo(Car o) {
        return o.distance - this.distance;
    }
}
