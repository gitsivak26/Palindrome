package nexware.interview.palindrome.Services;

import nexware.interview.palindrome.model.Palindrome;

public interface PalindromeService {
	
	Iterable<Palindrome> getPalindromeValues();
	
	boolean verifyPalindromOrNot(String formValue);
	
	Iterable<Palindrome> savePalindrome(Palindrome palindrome);

}
