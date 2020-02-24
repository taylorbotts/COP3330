import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {

    private SecureRandom random = new SecureRandom();
    private Scanner response = new Scanner(System.in);

    private int difficulty;
    private int result;
    private int answer;
    private int whichResponse;
    private int correctAns = 0;

    public void quiz(){

        String cont;

        readDifficulty();

        do {
            int answered = 0;
            while (answered < 10) {
                askQuestion();
                answered++;
            }

            displayCompletionMessage();

            System.out.println("Would you like to try again? y/n");
            cont = response.next();
        } while (!cont.equals("n"));
    }

    private void readDifficulty(){
        System.out.println("Please enter a level of difficulty between 1 and 4:");
        difficulty = response.nextInt();
    }

    private int generateQuestionArgument(){
        switch (difficulty) {
            case 1:
                return random.nextInt(10);
            case 2:
                return random.nextInt(100);
            case 3:
                return random.nextInt(1000);
            case 4:
                return random.nextInt(10000);
            default:
                System.out.println("Please enter a number between 1 and 4");
                readDifficulty();
                return 0;
        }

    }

    private void askQuestion(){
        int value1 = generateQuestionArgument();
        int value2 = generateQuestionArgument();
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
            System.out.println("Congratulations, you are ready to go to the next level!\n");
        } else {
            System.out.println("Please ask your teacher for extra help.\n");
        }
    }
}
class main4 {
    public static void main(String[] args) {
        CAI4 app = new CAI4();
        app.quiz();
    }
}