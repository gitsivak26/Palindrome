package nexware.interview.palindrome.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nexware.interview.palindrome.model.Palindrome;
import nexware.interview.palindrome.repositories.PalindromeDAO;

@Service
public class PalindromeServiceImpl implements PalindromeService {
	
	@Autowired
	PalindromeDAO palindromDAO;
	
	@Override
	public boolean verifyPalindromOrNot(String formValue) {
		
		String swapValue = "";
		int length = formValue.length();
		 
		for (int i = length-1; i >= 0; i--) {
			swapValue = swapValue + formValue.charAt(i);
		}
		 
		if (formValue.equals(swapValue)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Iterable<Palindrome> savePalindrome(Palindrome palindrome) {
		
		// Checking given value is palindrome OR not
		boolean isPalindrom = verifyPalindromOrNot(palindrome.getPalindromValue());
		
		System.out.println("Service Palindrome value ====> " + palindrome.getPalindromValue());
		if (isPalindrom) {
			palindrome = palindromDAO.save(palindrome);
		} else {
			System.out.println("This is not a palindrome.. So this was not added to database...");
		}
		
		return getPalindromeValues();
		
	}
	
	@Override
	public Iterable<Palindrome> getPalindromeValues() {
		System.out.println("REST - Get Palindrome called...");
		
		Iterable<Palindrome> palindromes = palindromDAO.findAll();
		
		System.out.println(palindromes.toString());
		
		return palindromes;
	}

}
