import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {

    private SecureRandom random = new SecureRandom();
    private Scanner response = new Scanner(System.in);

    private int value1 = random.nextInt(10);
    private int value2 = random.nextInt(10);
    private int result = value1 * value2;
    private int answer;
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
        System.out.println("Very good!");
        done = true;
    }

    private void displayIncorrectResponse(){
        System.out.println("No. Please try again.");
    }
}
class main {
    public static void main(String[] args) {
        CAI1 app = new CAI1();
        app.quiz();
    }
}