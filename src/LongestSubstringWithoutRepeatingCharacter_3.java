import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter_3 {

//  Problem Description:
//	Given a string, find the length of the longest substring without repeating characters.
//	Examples:
//	Given "abcabcbb", the answer is "abc", which the length is 3.
//	Given "bbbbb", the answer is "b", with the length of 1.
//	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
//	                "pwke" is a subsequence and not a substring.

	
	//O(n^2)从首字符开始两个指针i,j遍历字符串
	static public int lengthOfLongestSubstring(String s) {
		int lengthest =0 ;
		for( int i=0; i< s.length(); ++i){
			int length =0 ;
			Set<Character> substring = new HashSet<>();
			for(int j=i; j<s.length();++j){
				//使用Set的特性，若有重复的字符，则Set.add()会返回false
				if( substring.add(s.charAt(j)) ){
					++length ;
				}else{
					break;
				}
			}
			if(lengthest < length){
				lengthest = length;
			}
		}
		
		return lengthest;
    }

	
	//O(n)，i,j两个指针只需遍历一次字符串
	 static public int lengthOfLongestSubstring2(String s) {
		 if (s.length()==0) return 0;
         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
         int max=0;
         for (int i=0, j=0; i<s.length(); ++i){
             if (map.containsKey(s.charAt(i))){
                 j = Math.max(j,map.get(s.charAt(i))+1);
             }
             map.put(s.charAt(i),i);
             max = Math.max(max,i-j+1);
         }
         return max;
	 }
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String test = "abcabcbb";
		String test2 = "bbbbb";
		String test3 = "pwwkew";
		System.out.println( lengthOfLongestSubstring2(test) );
		System.out.println( lengthOfLongestSubstring2(test2) );
		System.out.println( lengthOfLongestSubstring2(test3) );

	}

}
