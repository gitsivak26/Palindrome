$("#palindrome-submit").click(function () {
	var swapValue = '';
	var givenValue = $("#palindromeValue").val().toLowerCase();
	
	alert("Paly called" + givenValue);
	
	for (var i = givenValue.length - 1; i >= 0; i--) {
		swapValue += givenValue[i]; 
	}
	
	if (givenValue != swapValue) {
		alert("Not equal");
		$("#error-paly").show();
	}
});

/*function checkPalindrome(userValue) {
var swapValue = '';
var givenValue = userValue.toLowerCase();

for (var i = givenValue.length - 1; i >= 0; i--) {
	swapValue += givenValue[i]; 
}

if (givenValue != swapValue) {
	
}
}*/