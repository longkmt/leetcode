import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeStringTest {

    String str1 = "";
    String str2 = null;
    String str3 = "Anna";
    String str4 = "Race car";
    String str5 = "Not Palindrome";

    String[] S = {str1,str2,str3,str4,str5};

    @Test
    void testIsPalindrome() {
        assertTrue(PalindromeString.isPalindrome(str3));
    }

    @Test
    void testIsNotPalindrome(){
        assertFalse(PalindromeString.isPalindrome(str5));
    }
}