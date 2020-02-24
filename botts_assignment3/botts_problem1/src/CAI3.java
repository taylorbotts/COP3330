import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {

    private SecureRandom random = new SecureRandom();
    private Scanner response = new Scanner(System.in);

    private int result;
    private int answer;
    private int whichResponse;
    private int correctAns = 0;

    public void quiz(){
        int answered = 0;
        
        while(answered < 10){
            askQuestion();
            answered++;
        }

        displayCompletionMessage();
    }

    private void askQuestion(){
        int value1 = random.nextInt(10);
        int value2 = random.nextInt(10);
        result = value1 * value2;
        System.out.printf("How much is %d times %d?\n", value1, value2);
        readResponse();
    }

    private void readResponse(){
        answer = response.nextInt();
        isAnswerCorrect();
    }

    private void isAnswerCorrect(){
        if(answer==result){
            correctAns++;
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

    private void displayCompletionMessage(){
        double score = correctAns / 10.0 * 100;
        System.out.printf("\nScore: %.0f%%\n", score);
        if (score >= 75){
            System.out.println("Congratulations, you are ready to go to the next level!");
        } else {
            System.out.println("Please ask your teacher for extra help.");
        }
    }
}
class main3 {
    public static void main(String[] args) {
        CAI3 app = new CAI3();
        app.quiz();
    }
}