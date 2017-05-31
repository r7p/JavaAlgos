package Spotify;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: s = “Roll”, doc = “Lorem ipsum”

 Output: False

 Input: s = “mRole”, doc = “Lorem ipsum”

 Output: True


 */
public class DocHasWord {

    boolean hasWord(String doc, String s) {



        char[] arS = s.toLowerCase().toCharArray();
        Map<Character, Integer> wordOccurrence = new HashMap<>();
        for (char aChar : arS) {
            Integer thisOccurrence = 1;
            if (wordOccurrence.containsKey(aChar)) {
                thisOccurrence = wordOccurrence.get(aChar);
                thisOccurrence++;
            }
            wordOccurrence.put(aChar, thisOccurrence);
        }

        char[] arDoc = doc.toLowerCase().toCharArray();
        int wordCharCount = wordOccurrence.size();

        for (char aChar : arDoc) {
            Integer thisOccurrence = wordOccurrence.get(aChar);
            if (thisOccurrence != null) {
                thisOccurrence--;
                if (thisOccurrence >= 0) {
                    wordOccurrence.put(aChar, thisOccurrence);
                }
                if (thisOccurrence == 0) {
                    wordCharCount--;
                    if (wordCharCount == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DocHasWord x = new DocHasWord();
        System.out.println(x.hasWord("Lorem ipsum", "Roll"));
        System.out.println(x.hasWord("Lorem ipsum", "Role"));
        System.out.println(x.hasWord("Lorem ipsum", "mRole"));
    }
}
