package TrieImplementation;
import java.util.*;
public class TrieSolution {
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
		
		return result;
	}
}
