import java.io.IOException;

public class Application {
    public static void main (String[] args) throws IOException {
        DuplicateRemover dr = new DuplicateRemover();

        dr.remove("problem1.txt");

        dr.write("uniqueWords.txt");
    }
}
