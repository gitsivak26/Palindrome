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
				$.each(response, function(i, item) {
					$("#palindromes").append($('<tr/>').append($('<td/>').text(item.palindromValue)));
				});
			});
		},
		error: function (error) {
			console.log(error.status);
		}
	});
}