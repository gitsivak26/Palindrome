package com.nexgen.interview.palindrome.dao;

import org.springframework.data.repository.CrudRepository;

import com.nexgen.interview.palindrome.model.Palindrome;

public interface PalindromeDAO extends CrudRepository<Palindrome, Integer> {

}
