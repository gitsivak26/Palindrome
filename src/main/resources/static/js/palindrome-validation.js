var responseData = [];

$(document).ready(function () {

	getPalindromes();
	
	$("#palindromeValue").val('');
	$("#duplicate").hide();
	$("#success").hide();
	
	// Does not allow special characters and numerics
	$.validator.addMethod("checkSpecialCharacters", function (value, element) {
		var postData = element.value;
		var regex = /^[0-9-+()]*$/;
		
		if(postData == regex)
			return false;
		else
			return true;
	});
	
	// Value must be palindrom
	$.validator.addMethod("checkPalindrome", function (value, element)
		{
			var postData = element.value;
			
			var swapValue = '';
			var givenValue = postData.toLowerCase();
			
			for (var i = givenValue.length - 1; i >= 0; i--) {
				swapValue += givenValue[i]; 
			}
			
			if (givenValue == swapValue)
				return true;
			else
				return false;
		},
		"Enter palindrome value."
	);
	
	$("#palindromeform").validate({
		rules: {
			palindromeValue: {
				required: true,
				maxlength: 100,
				checkPalindrome: true,
				checkSpecialCharacters: true
			}
		},
		
		messages: {
			palindromeValue: {
				required: "Please enter the value.",
				maxlength: "The maximum length is 100.",
				checkPalindrome: "It is not a palindrome value",
				checkSpecialCharacters: "Does not allow special characters and numbers."
			}
		},
		submitHandler: function(form) {
			$("#duplicate").hide();
			var postData = $('#palindromeValue').val();
			
			$.ajax({
				type: "POST",
				url: "/api/v1/palindromes/",
				data: "palindromeValue=" + postData,
				dataType: 'json',
				success: function (response) {
					$("#success").show();
					$("#duplicate").hide();
					response = JSON.stringify(response);
					
					// convert string to JSON
					response = $.parseJSON(response);
					
					$(function() {
						$("#palindromes").empty();
						$("#palindromes").append($('<tr/>').append($('<th/>').text("Palindrome Values")));
						$.each(response, function(i, item) {
							responseData.push(item.palindromValue);
							$("#palindromes").append($('<tr/>').append($('<td/>').text(item.palindromValue)));
						});
					});
				},
				error: function (error) {
					if (error.status == 400)
						$("#success").hide();
						$("#duplicate").show();
				}
			});
		}
	});
	
	$(function() {
	    $( "#palindromeValue" ).autocomplete({
	      source: responseData
	    });
	 });
});

function getPalindromes() {
	$.ajax({
		type: "GET",
		url: "/api/v1/palindromes/",
		dataType: 'json',
		success: function (response) {
			var response = JSON.stringify(response);
			
			// convert string to JSON
			response = $.parseJSON(response);
			
			$(function() {
				$("#palindromes").empty();
				$("#palindromes").append($('<tr/>').append($('<th/>').text("Palindrome Values")));
				$.each(response, function(i, item) {
					responseData.push(item.palindromValue);
					$("#palindromes").append($('<tr/>').append($('<td/>').text(item.palindromValue)));
				});
			});
		},
		error: function (error) {
			console.log(error.status);
		}
	});
}