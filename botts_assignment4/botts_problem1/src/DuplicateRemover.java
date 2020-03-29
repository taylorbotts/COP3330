import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Formatter;

public class DuplicateRemover {

    private Set<String> uniqueWords = new HashSet<>();

    public void remove (String dataFile) throws IOException {
        try (Scanner input = new Scanner(Paths.get(dataFile))) {
            System.out.println("Reading from '" + dataFile + "'...");
            while (input.hasNext()) {
                uniqueWords.add(input.next().toLowerCase());
            }
        } catch (SecurityException e) {
            System.out.println("Security Exception: You don't have permission to read this file!");
        } catch (FileNotFoundException | NoSuchFileException e) {
            System.out.println(("Error: Input File Not Found!"));
        }
    }

    public void write (String outputFile) {
        try (Formatter output = new Formatter(outputFile)) {
            for (String word : uniqueWords) {
                output.format("%s ", word);
            }
            System.out.println("Unique words written to '" + outputFile + "'.");
        } catch (SecurityException e) {
            System.out.println("Security Exception: You don't have permission to write to this file!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Output File Not Found!");
        }
}
}
