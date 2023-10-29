import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Engeener {
    private final String filePath;
    private static final int NUMBERS_WORDS = 3;


    public Engeener(String filePath) {
        this.filePath = filePath;
    }
    // Otworzenie pliku i wylosowanie słowa
    public void printWords() {
        Path path = Paths.get(filePath);
        try {
            List<String> lines = Files.readAllLines(path);
            Random random = new Random();
            int randomIndex = random.nextInt(NUMBERS_WORDS); // Losowy indeks
            String randomWord = lines.get(randomIndex); // Losowe słowo
            System.out.println(randomWord);
        } catch (IOException e) {
            System.out.println("Plik nie został znaleziony");
        }
    }

}
