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

        char[] arDoc = doc.toLowerCase().toCharArray();
        Map<Character, Integer> docOcurrence = new HashMap<>();

        for (char aChar : arDoc) {
            Integer thisOcurrence = 1;
            if (docOcurrence.containsKey(aChar)) {
                thisOcurrence = docOcurrence.get(aChar);
                thisOcurrence++;
            }
            docOcurrence.put(aChar, thisOcurrence);
        }

        char[] arS = s.toLowerCase().toCharArray();
        for (char aChar : arS) {
            if (!docOcurrence.containsKey(aChar)) {
                return false;
            } else {
                Integer thisOcurrence = docOcurrence.get(aChar);
                thisOcurrence--;
                if (thisOcurrence <= 0) {
                    docOcurrence.remove(aChar);
                } else {
                    docOcurrence.put(aChar, thisOcurrence);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        DocHasWord x = new DocHasWord();
        System.out.println(x.hasWord("Lorem ipsum", "Roll"));
        System.out.println(x.hasWord("Lorem ipsum", "Role"));
        System.out.println(x.hasWord("Lorem ipsum", "mRole"));
    }
}
