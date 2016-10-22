package TrieImplementation;
import java.util.*;
public class Trie {
	//Representing 256 characters in ASCII table
	public static final int MAX=256;
	public Trie[] child;
	public int frequency;
	public Trie() {
		child = new Trie[MAX];
		frequency=1;
	}
}
