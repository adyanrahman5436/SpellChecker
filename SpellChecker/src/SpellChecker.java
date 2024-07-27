import java.util.*;

public class SpellChecker {
    private Set<String> dictionary;

    // Constructor
    public SpellChecker(Set<String> words) {
        this.dictionary = new HashSet<>(words);
    }

    // Spell check function
    public List<String> spellCheck(String s) {
        List<String> suggestions = new ArrayList<>();
        
        // If the word is correctly spelled
        if (dictionary.contains(s)) {
            suggestions.add(s);
            return suggestions;
        }

        // Check for possible corrections
        for (String word : dictionary) {
            if (isPossibleCorrection(s, word)) {
                suggestions.add(word);
            }
        }
        return suggestions;
    }

    // Check if a word is a possible correction for the misspelled word
    private boolean isPossibleCorrection(String s, String word) {
        return checkSwappedCharacters(s, word) || checkInsertedCharacter(s, word)
            || checkDeletedCharacter(s, word) || checkReplacedCharacter(s, word);
    }

    // Check if swapping adjacent characters makes the words equal
    private boolean checkSwappedCharacters(String s, String word) {
        if (s.length() != word.length()) return false;
        for (int i = 0; i < s.length() - 1; i++) {
            char[] chars = s.toCharArray();
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
            if (new String(chars).equals(word)) return true;
        }
        return false;
    }

    // Check if inserting a character makes the words equal
    private boolean checkInsertedCharacter(String s, String word) {
        if (s.length() + 1 != word.length()) return false;
        for (int i = 0; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.insert(i, '_'); // Placeholder character
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                if (sb.toString().equals(word)) return true;
            }
        }
        return false;
    }

    // Check if deleting a character makes the words equal
    private boolean checkDeletedCharacter(String s, String word) {
        if (s.length() - 1 != word.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            if (sb.toString().equals(word)) return true;
        }
        return false;
    }

    // Check if replacing a character makes the words equal
    private boolean checkReplacedCharacter(String s, String word) {
        if (s.length() != word.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                if (sb.toString().equals(word)) return true;
            }
        }
        return false;
    }
}
