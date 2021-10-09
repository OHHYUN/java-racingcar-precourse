package racinggame;

public class Car {

	public static final int MOVE_FORWARD = 1;
	public static final int STOP = 0;

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
		if(ranNo > 3){
			return MOVE_FORWARD;
		}
		return STOP;
	}
}
