package TrieImplementation;
import java.util.*;
public class Trie {
	public ArrayList<Trie> child;
	public int frequency;
	public Trie() {
		child = new ArrayList<Trie>();
		frequency=1;
	}
}
