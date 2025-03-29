


import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {


    public int lengthOfLongestSubtring(String s){

        if (s == null ) return 0;

        // Get the length of the String.
        int n = s.length();

        // init a max length to be returned.
        int maxlen = 0;

        // Init left and right position trackers.
        int left  = 0, right = 0;

        // Buffer storage for read in characters.
        Set<Character> set = new HashSet<>();

        // while right cursor is less than the string size
        while( right < n ) {

            // if the set does not contain a character.
            if( !set.contains(s.charAt(right)) ) {
                //
                set.add(s.charAt(right));
                right++;
                maxlen = Math.max(maxlen, right - left );
            } else {
                set.remove(s.charAt(left));
                left++;
            }

        }


        return maxlen;
    }
    

    public static void main(String[] args) {
        String s = "abcabcbb";

        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int max = l.lengthOfLongestSubtring(s);
        System.out.println(max);
    }
}



/*
 
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();

        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("The length of the longest substring without repeating characters is: " + lengthOfLongestSubstring(input));
    }
}

  
 
 */







