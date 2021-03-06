package com.nexgen.interview.palindrome.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nexgen.interview.palindrome.Services.PalindromeService;
import com.nexgen.interview.palindrome.model.Palindrome;

@Controller
public class PalindromeController {
	
	Iterable<Palindrome> palindromes;
	
	@Autowired
	PalindromeService palindromeService;
	
	@GetMapping(path = "/api/v1/palindromes")
	public @ResponseBody Iterable<Palindrome> getPalindromeDatas() {
		
		System.out.println("REST - Get Method called");
		palindromes = palindromeService.getPalindromeDatas();
		
		return palindromes; 
	}
	
	@PostMapping(path = "/api/v1/palindromes")
	public ResponseEntity<?> savePalindrome(@RequestParam String palindromeValue) {
		System.out.println("REST - Post Method called...");
		
		Palindrome palindrome = new Palindrome();
		
		// To check the field value is Empty or Null
		if (!palindromeValue.isEmpty() || !(palindromeValue == null)) {
			palindrome.setPalindromValue(palindromeValue);
		} else {
			System.out.println("The form value is Empty or Null");
		}
		
		System.out.println("user Value = " + palindrome.getPalindromValue());
		
		try {
			palindromes = palindromeService.savePalindrome(palindrome);
		} catch (Exception e) {
			System.out.println("Duplicate entries not allowed...");
			return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(palindromes, HttpStatus.OK);
	}
}