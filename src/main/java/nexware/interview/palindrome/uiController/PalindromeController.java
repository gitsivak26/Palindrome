package nexware.interview.palindrome.uiController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nexware.interview.palindrome.Services.PalindromeService;

@Controller
public class PalindromeController {
	
	@Autowired
	PalindromeService palindromeService;
	
	private static final String PALINDROM_PAGE = "palindrome";
	
	@RequestMapping(path = "/palindrome", method = RequestMethod.GET)
	public String storePalindrom(HttpServletRequest request, 
			HttpServletResponse response,  
			Model model) {
		
		System.out.println("UI Controller Called...");
		
		palindromeService.getPalindromeValues();
		
		return PALINDROM_PAGE;
		
	}

}
