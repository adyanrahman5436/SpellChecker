import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>(Arrays.asList("hello", "world", "java", "spell", "checker"));
        SpellChecker spellChecker = new SpellChecker(words);

        System.out.println("Correctly spelled: " + spellChecker.spellCheck("hello"));
        System.out.println("Suggestions for 'hellp': " + spellChecker.spellCheck("hellp"));
        System.out.println("Suggestions for 'wold': " + spellChecker.spellCheck("wold"));
        System.out.println("Suggestions for 'spall': " + spellChecker.spellCheck("spall"));
        System.out.println("Suggestions for 'chacker': " + spellChecker.spellCheck("chacker"));
    }
}
