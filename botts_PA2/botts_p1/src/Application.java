import java.util.Scanner;

public class Application {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter digits to be encrypted:");

        // Read a four digit integer from the user

        int userDigits = scan.nextInt();

        String withLeadingZeroes = String.format("%04d", userDigits);
        System.out.println("You entered: " + withLeadingZeroes);

        Encrypter e = new Encrypter(userDigits);

        // encrypt it
        String encryptedDigits = e.encrypt();
        // print it
        System.out.println("Your encrypted digits: " + encryptedDigits);

        // decrypt it
        Decrypter d = new Decrypter(encryptedDigits);

        String decryptedDigits = d.decrypt();
        // print decrypted
        System.out.println("And your decrypted digits: " + decryptedDigits);
    }
}


