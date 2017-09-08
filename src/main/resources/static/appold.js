console.log("I am Here");

const baseurl = "http://localhost:8080/cards";

$(document).on('click', 'a[data-card-id]', function (e) {
	e.preventDefault();
	const cardId = $(this).data('cardId');
	
	$.getJSON(baseurl, + '/' + cardId, function (data) {
		console.log(data.firstName);
		$('#card-detail')
			.html(`
					<h1>${data.firstName} ${data.lastName}</h1>
					<h2>${data.company}</h2>
					<div>Title: ${data.title}</div>
			`);
	})
	
})

$.getJSON(baseurl, function (data) {
	if (data.length) {
		
		for (let card of data) {
			$('<li></li>')
			.html('<a href="#" data-card-id="' + card.id + '">' + card.lastName + ", " + card.firstName + '</a>')
			.appendTo($('#card-list'));
		}
		
	} else {
		
		$('<li></li>')
			.css('color', 'red')
			.html('You have no data')
			.appendTo($('#card-list'));
	}
});