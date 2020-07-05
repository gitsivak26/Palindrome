$(document).ready(function () {
	
	var paly = [ ];
	
	$("#palindromeValue").val('');
	
	// Does not allow special characters and numerics
	$.validator.addMethod("checkSpecialCharacters", function (value, element) {
		var postData = element.value;
		var regex = /^[0-9-+()]*$/;
		
		if (postData == regex)
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
			
			var postData = $('#palindromeValue').val();
				
			$.ajax({
				type: "POST",
				url: "/api/v1/palindromes/",
				data: "palindromeValue=" + postData,
				dataType: 'json',
				success: function (response) {
					response = JSON.stringify(response);
					
					// convert string to JSON
					response = $.parseJSON(response);
					
					$(function() {
						$("#palindromes").empty();
						$.each(response, function(i, item) {
							//console.log(item.palindromValue);
							$("#palindromes").append($('<tr/>').append($('<td/>').text(item.palindromValue)));
						});
					});
				},
				error: function (error) {
					console.log(error.status);
				}
			});
		}
	});
});