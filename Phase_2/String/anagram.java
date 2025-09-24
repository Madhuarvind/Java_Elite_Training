package String;
import java.util.*;
public class anagram {
    public static void main(String[] args) {
        String str = "listen";
        String str2 = "silent";
        System.out.println(isAnagram(str, str2));
        }
        public static boolean isAnagram(String str, String str2) {
            if (str.length() != str2.length()) {
                return false;
                }
                char[] charArray = str.toCharArray();
                char[] charArray2 = str2.toCharArray();
                Arrays.sort(charArray);
                Arrays.sort(charArray2);
                return Arrays.equals(charArray, charArray2);
                

    }
}