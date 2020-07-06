package com.nexgen.interview.palindrome.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexgen.interview.palindrome.dao.PalindromeDAO;
import com.nexgen.interview.palindrome.model.Palindrome;

@Service
public class PalindromeService {
	
	@Autowired
	PalindromeDAO palindromDAO;
	
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
	
	public Iterable<Palindrome> savePalindrome(Palindrome palindrome) {
		
		// Checking given value is palindrome OR not
		boolean isPalindrom = verifyPalindromOrNot(palindrome.getPalindromValue());
		
		System.out.println("Service Palindrome value ====> " + palindrome.getPalindromValue());
		
		if (isPalindrom) {
			palindrome = palindromDAO.save(palindrome);
		} else {
			System.out.println("This is not a palindrome data... So the data was not added to database...");
		}
		
		return getPalindromeDatas();
	}
	
	public Iterable<Palindrome> getPalindromeDatas() {
		System.out.println("REST - Get Palindrome called...");
		
		Iterable<Palindrome> palindromes = palindromDAO.findAll();
		
		System.out.println(palindromes.toString());
		
		return palindromes;
	}

}
