package nexware.interview.palindrome.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palindrome_list")
public class Palindrome {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "palindrome_value")
	private String palindromeValue;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPalindromValue() {
		return palindromeValue;
	}
	public void setPalindromValue(String palindromeValue) {
		this.palindromeValue = palindromeValue;
	}
	
	

}
