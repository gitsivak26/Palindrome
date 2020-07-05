$('#palindromeform').submit(function(e) {
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
					$("#palindromes").append($('<tr/>').append($('<td/>').text(item.palindromValue)));
				});
			});
		},
		error: function (error) {
			console.log(error.status);
		}
		e.preventDefault();
	});
});