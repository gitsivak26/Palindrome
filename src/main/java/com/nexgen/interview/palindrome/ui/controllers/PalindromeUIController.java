package com.nexgen.interview.palindrome.ui.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nexgen.interview.palindrome.Services.PalindromeService;

@Controller
public class PalindromeUIController {
	
	@Autowired
	PalindromeService palindromeService;
	
	private static final String PALINDROM_PAGE = "palindrome";
	
	@RequestMapping(path = "/palindrome", method = RequestMethod.GET)
	public String storePalindrom(HttpServletRequest request, 
			HttpServletResponse response,  
			Model model) {
		
		palindromeService.getPalindromeDatas();
		
		return PALINDROM_PAGE;
		
	}

}
