package nexware.interview.palindrome.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nexware.interview.palindrome.Services.PalindromeService;
import nexware.interview.palindrome.model.Palindrome;

@Controller
public class reterivePalindrome {
	
	Iterable<Palindrome> palindromes;
	
	@Autowired
	PalindromeService palindromeService;
	
	@GetMapping(path = "/v1/palindromes")
	public @ResponseBody Iterable<Palindrome> getAllPalindroms() {
		
		System.out.println("REST - Get Method called");
		palindromes = palindromeService.getPalindromeValues();
		
		return palindromes; 
	}
	
	@PostMapping(path = "/v1/palindromes")
	public @ResponseBody Iterable<Palindrome> storePalindrome(@RequestParam String palindromeValue) {
		
		Palindrome palindrome = new Palindrome();
		
		// To check the field value is Empty or Null
		if (!palindromeValue.isEmpty() || palindromeValue == null) {
			palindrome.setPalindromValue(palindromeValue);
		} else {
			System.out.println("The form value is Empty or Null");
		}
		
		System.out.println("user Value = " + palindrome.getPalindromValue());
		palindromes = palindromeService.savePalindrome(palindrome);
		
		return palindromes;
	}

}
