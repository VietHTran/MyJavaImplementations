package BitManipulation;

import java.util.ArrayList;

public class BitManipulation {
	//Problems: Find an integer that appears only once in a list that all other elements appear twice
	//Required Time Complexity: O(n)
	//Required Space: O(1)
	public static int elementsAppearTwice(ArrayList<Integer> nums) {
		int once=0;
		for (int i=0;i<nums.size();i++) {
			//Since a==b --> (a XOR b) a^b==0 
			//--> All the elements appear twice were neutralized, leaving only the number that appears once
			once^=nums.get(i);
		}
		return once;
	}
	//Problems: Find an integer that appears only once in a list that all other elements appear thrice
	//Required Time Complexity: O(n)
	//Required Space: O(1)
	public static int elementsAppearThrice(ArrayList<Integer> nums) {
		int ones=0,twos=0;
		for (int i=0;i<nums.size();i++) {
			twos|= (ones&nums.get(i));
			ones^=nums.get(i);
			int notThree=~(ones&twos);
			ones&=notThree;
			twos&=notThree;
		}
		return ones;
	}
}
