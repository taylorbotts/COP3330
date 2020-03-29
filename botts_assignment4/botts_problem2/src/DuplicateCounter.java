import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
import java.util.Formatter;
import java.util.Map;
import java.util.HashMap;

public class DuplicateCounter {

    private HashMap<String, Integer> wordCount = new HashMap<>();

    public void count (String dataFile) throws IOException {
        try (Scanner input = new Scanner(Paths.get(dataFile))) {
            System.out.println("Reading from '" + dataFile + "'...");

            while (input.hasNext()) {
                String currentWord = input.next().toLowerCase();
                if (wordCount.containsKey(currentWord)) {
                    int count = wordCount.get(currentWord);
                    wordCount.put(currentWord, count + 1);
                } else {
                    wordCount.put(currentWord, 1);
                }
            }
        } catch (SecurityException e) {
            System.out.println("Security Exception: You don't have permission to read this file!");
        } catch (FileNotFoundException | NoSuchFileException e) {
            System.out.println(("Error: Input File Not Found!"));
        }
    }

    public void write (String outputFile) throws FileNotFoundException {
        try (Formatter output = new Formatter(outputFile)) {

            for (Map.Entry word : wordCount.entrySet()) {
                output.format("'%s': %d%n", word.getKey(), word.getValue());
            }
            System.out.println("Duplicate word count written to '" + outputFile + "'.");
        } catch (SecurityException e) {
            System.out.println("Security Exception: You don't have permission to write to this file!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Output File Not Found!");
        }
    }
}
