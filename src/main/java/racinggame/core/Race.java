package racinggame.core;

import nextstep.utils.Console;
import racinggame.exception.InputException;
import racinggame.model.MessageType;
import racinggame.model.Racing;
import racinggame.utils.InputValidUtils;

public class Race {

    public static final String COMMA = ",";

    public void play(){
        Racing racing = inputCarNames();
        int runningTime = inputRunningTime();
        for(int i=0; i<runningTime; i++){
            racing.moveAll();
        }
        racing.printWinner();
    }

    public Racing inputCarNames(){
        MessageType.INPUT_CAR_NAME.printMsg();
        try{
            String carNames = Console.readLine();
            InputValidUtils.validationAll(carNames);
            String [] carArr = carNames.split(COMMA);
            Racing racing = new Racing(carArr);
            return racing;
        }catch (InputException inputException){
            return inputCarNames();
        }
    }

    public int inputRunningTime(){
        MessageType.INPUT_RUNNING_TIME.printMsg();
        try{
            String runningTime = Console.readLine();
            InputValidUtils.validationNumber(runningTime);
            return Integer.parseInt(runningTime);
        }catch (InputException inputException){
            return inputRunningTime();
        }
    }
}
