public class Decrypter {

    private int encryptedDigits;

    public Decrypter(String ed){
        encryptedDigits = Integer.parseInt(ed);
    }

    public String decrypt(){
        int firstDigit, secondDigit, thirdDigit, fourthDigit, currentDigits;

        fourthDigit = encryptedDigits % 10;
        currentDigits = encryptedDigits / 10;
        thirdDigit = currentDigits % 10;
        currentDigits = currentDigits / 10;
        secondDigit = currentDigits % 10;
        currentDigits = currentDigits / 10;
        firstDigit = currentDigits;

        if (firstDigit < 7){
            firstDigit = firstDigit + 3;
        } else {
            firstDigit = firstDigit - 7;
        }

        if (secondDigit < 7){
            secondDigit = secondDigit + 3;
        } else {
            secondDigit = secondDigit - 7;
        }

        if (thirdDigit < 7) {
            thirdDigit = thirdDigit + 3;
        } else {
            thirdDigit = thirdDigit - 7;
        }

        if (fourthDigit < 7){
            fourthDigit = fourthDigit + 3;
        } else {
            fourthDigit = fourthDigit - 7;
        }

        return "" + thirdDigit + fourthDigit + firstDigit + secondDigit;
    }

}
