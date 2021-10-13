package racinggame.enums;

public enum MessageType {
    INPUT_CAR_NAME("자동차 이름을 입력해주세요."),
    INPUT_RUNNING_TIME("시도할 횟수는 몇회입니까?");

    private String msg;

    MessageType(String msg){
        this.msg = msg;
    }

    public void printMsg(){
        System.out.println(this.msg);
    }
}
