import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWord {

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static Map<Character, List<String>> groupByFirstLetter(List<String> words) {
        Map<Character, List<String>> groups = new HashMap<>();
        for (String word : words) {
            char firstLetter = word.charAt(0);
            List<String> group = groups.get(firstLetter);
            if (group == null) {
                group = new ArrayList<>();
                groups.put(firstLetter, group);
            }
            group.add(word);
        }
        return groups;
    }

    public static void main(String[] args) throws IOException {
        String filename = "dictionary.txt";
        File text = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(text));
        String line;
        String results = "";

        List<String> words = new ArrayList<>();

        int vowelCount = 0;

        while ((line = reader.readLine()) != null) {

            words.add(line);


            char firstLetter = line.charAt(0);
            if (firstLetter >= 'b' && firstLetter <= 'm') {


                //count Vowel
                if (line.length() > results.length())
                    for (char letter : line.toCharArray()) {
                        if (isVowel(letter)) {
                            vowelCount++;
                        }
                    }


                //find the longest word

                if (line.length() > results.length()) {
                    results = line;
                }
            }
        }

        System.out.println("Total number of Vowels: "+vowelCount);
        System.out.println("\nThe longest word is : "+results);

        Map<Character, List<String>> groups = groupByFirstLetter(words);
        int maxSize = 0;
        char groupWithMostWords = ' ';
        for (Map.Entry<Character, List<String>> entry : groups.entrySet()) {
            int size = entry.getValue().size();
            if (size > maxSize) {
                maxSize = size;
                groupWithMostWords = entry.getKey();
            }
        }
        System.out.println("\nGroup with most words: " + groupWithMostWords);



        reader.close();


    }
}




