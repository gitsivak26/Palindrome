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
					paly.push(item.palindromValue);
					$("#palindromes").append($('<tr/>').append($('<td/>').text(item.palindromValue)));
				});
				//console.dir("Array Values GET = " + array);
			});
		},
		error: function (error) {
			console.log(error.status);
		}
	});
}