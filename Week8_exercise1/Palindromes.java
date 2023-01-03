
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Palindromes {
    public static void main(String args[]) throws IOException {

        String filename="Dictionary.txt";
        File text = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(text));
        String line;
        while ((line = reader.readLine()) != null) {

            String reverse = "";

            // Initializing a new boolean variable for the answer

            boolean answer = false;

            for (int i = line.length() - 1; i >= 0; i--) {
                reverse = reverse + line.charAt(i);
            }

            // Checking if both the strings are equal
            if (line.equals(reverse)) {
                answer = true;

                System.out.println(line);
            }


        }
        reader.close();
    }

}




