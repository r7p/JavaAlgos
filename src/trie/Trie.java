package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an implementation of a java trie. It is a tree structure representing words.
 * Each node in the tree represents a single character, as shown below;

 Trie with the words car, cat and dog added.
 root
 /    \
 c      d
 /         \
 a           o
 /  \          \
 r    t          g

 The trie can be searched by prefix, returning a list of words which begin with the prefix.
 */
public class Trie {
    private TrieNode root;

    /**
     * Constructor
     */
    public Trie()
    {
        root = new TrieNode();
    }

    /**
     * Adds a word to the Trie
     * @param word
     */
    public void addWord(String word)
    {
        root.addWord(word.toLowerCase());
    }

    /**
     * Get the words in the Trie with the given
     * prefix
     * @param prefix
     * @return a List containing String objects containing the words in
     *         the Trie with the given prefix.
     */
    public List getWords(String prefix)
    {
        //Find the node which represents the last letter of the prefix
        TrieNode lastNode = root;
        for (int i=0; i<prefix.length(); i++)
        {
            lastNode = lastNode.getNode(prefix.charAt(i));

            //If no node matches, then no words exist, return empty list
            if (lastNode == null) return new ArrayList();
        }

        //Return the words which eminate from the last node
        return lastNode.getWords();
    }
}
