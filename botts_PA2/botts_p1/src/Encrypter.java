public class Encrypter {

    private int userDigits;

    public Encrypter(int ud){
        userDigits = ud;
    }

    public String encrypt(){
        int firstDigit, secondDigit, thirdDigit, fourthDigit, currentDigits;

        // Separate each number so they can be manipulated individually

        fourthDigit = userDigits % 10;
        currentDigits = userDigits / 10;
        thirdDigit = currentDigits % 10;
        currentDigits = currentDigits / 10;
        secondDigit = currentDigits % 10;
        currentDigits = currentDigits / 10;
        firstDigit = currentDigits;

        // Replace each digit with the result of adding 7 to it
        // and get the remainder after dividing by 10 (mod 10)

        firstDigit = (firstDigit + 7) % 10;
        secondDigit = (secondDigit + 7) % 10;
        thirdDigit = (thirdDigit + 7) % 10;
        fourthDigit = (fourthDigit + 7) % 10;

        // then swap the first digit with the third, and swap the
        // second digit with the fourth

        return "" + thirdDigit + fourthDigit + firstDigit + secondDigit;

    }

}
