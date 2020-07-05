package nexware.interview.palindrome.repositories;

import org.springframework.data.repository.CrudRepository;

import nexware.interview.palindrome.model.Palindrome;

public interface PalindromeDAO extends CrudRepository<Palindrome, Integer> {

}
