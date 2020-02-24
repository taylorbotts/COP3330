import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {

    private SecureRandom random = new SecureRandom();
    private Scanner response = new Scanner(System.in);

    private int value1 = random.nextInt(10);
    private int value2 = random.nextInt(10);
    private int result = value1 * value2;
    private int answer;
    private int whichResponse;
    private boolean done = false;

    public void quiz(){
        while(!done){
            askQuestion();
        }
    }

    private void askQuestion(){
        System.out.printf("How much is %d times %d?\n", value1, value2);
        readResponse();
    }

    private void readResponse(){
        answer = response.nextInt();
        isAnswerCorrect();
    }

    private void isAnswerCorrect(){
        if(answer==result){
            displayCorrectResponse();
        } else {
            displayIncorrectResponse();
        }
    }

    private void displayCorrectResponse(){
        whichResponse = 1 + random.nextInt(4);
        switch (whichResponse){
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("It's big brain time!");
                break;
            case 3:
                System.out.println("You know math!");
                break;
            case 4:
                System.out.println("Excellent!");
                break;
        }
        done = true;
    }

    private void displayIncorrectResponse(){
        whichResponse = 1 + random.nextInt(4);
        switch (whichResponse) {
            case 1:
                System.out.println("Did you even try?");
                break;
            case 2:
                System.out.println("You can do better than that...");
                break;
            case 3:
                System.out.println("Sorry, try again.");
                break;
            case 4:
                System.out.println("Do it again, but like, for real this time.");
                break;
        }
    }
}
class main2 {
    public static void main(String[] args) {
        CAI2 app = new CAI2();
        app.quiz();
    }
}