package TrieImplementation;
import java.util.*;
public class TrieSolution {
	private void generateTrie(Trie cur, String word) {
		int wordLength=word.length();
		Trie holder=cur;
		for (int i=0;i<wordLength;i++) {
			//Get ASCII value of character
			int index=word.charAt(i);
			//Check if the character have already existed ? Create new one : Increase its frequency
			if (holder.child[index]==null) {
				holder.child[index]= new Trie();
			} else {
				holder.child[index].frequency++;
			}
			//Go to next character
			holder=holder.child[index];
		}
		//System.out.println();
	}
	private void getPrefix(Trie cur,StringBuilder prefix,ArrayList<String> res) {
		//The prefix is unique
		if (cur.frequency==1) {
			res.add(prefix.toString());
			return;
		}
		Trie[] child=cur.child;
		for (int i=0;i<Trie.MAX;i++) {
			if (child[i]!=null) {
				prefix.append((char)i);
				getPrefix(child[i],prefix,res);
				prefix.deleteCharAt(prefix.length()-1);
			}
		}
	}
	public ArrayList<String> shortestUniquePrefix(ArrayList<String> words) {
		ArrayList<String> result= new ArrayList<String>();
		//If collection of words is empty
		if (words==null || words.size()==0) {
			return result;
		}
		//If collection only contains 1 words
		if (words.size()==1) {
			result.add(words.get(0).substring(0,1));
			return result;
		}
		//Create root as empty char
		Trie root= new Trie();
		//Prevent getPrefix to check for frequency==1 --> Exit;
		root.frequency=2;
		//Create Trie for all words
		for (int i=0;i<words.size();i++) {
			generateTrie(root,words.get(i));
		}
		getPrefix(root,new StringBuilder(),result);
		return result;
	}
}
