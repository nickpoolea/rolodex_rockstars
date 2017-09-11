const baseurl = "http://localhost:8080/cards";

$.getScript('helper-functions.js', function() {

//--------------------------------------------------
// Create the list items to display
$.getJSON(baseurl, function (data) {
		
	if (data.length) {
		for (let card of data) {
			createListElement(card);
		}
			
	} else {
			
		$('<li></li>')
			.css('color', 'red')
			.html('You have no data')
			.appendTo($('#card-list'));
	}
});

//--------------------------------------------------
//Get details of one card
$(document).on('click', 'a[data-card-id]', function (e) {
	e.preventDefault();
	const cardId = $(this).data('cardId');
	
	$.getJSON(baseurl + '/' + cardId, function (data) {
		data.company = data.company || '<i>No company specified</i>';
		fillInDetails(data);
	});
	
});

//--------------------------------------------------
// Handle the create the card form
$('#create-card-form').on('submit', function(e) {
	e.preventDefault();
	
	let payload = {
			title: $('#title').val(),
			firstName: $('#firstName').val(),
			lastName: $('#lastName').val(),
			company: $('#company').val()	
	};
	
	let ajaxOptions = {
		type: 'POST',
		data: JSON.stringify(payload),
		contentType: 'application/json'
	};
	
	$.ajax(this.action, ajaxOptions)
		.done(function (card) {
			createListElement(card)
		})
		.fail(error => console.log(error));
		
	
});

//--------------------------------------------------
// Delete one card
$(document).on('submit', '.delete-card-form', function (e) {
	e.preventDefault();
	sendAjaxDelete(this, 'li');
});

//--------------------------------------------------
//Delete a phone number
$(document).on('submit', '.delete-phone-form', function (e) {
	e.preventDefault();
	sendAjaxDelete(this, 'div');
});

//--------------------------------------------------
//Delete an address
$(document).on('submit', '.delete-address-form', function (e) {
	e.preventDefault();
	sendAjaxDelete(this, 'div');
});


//--------------------------------------------------
//Handle create a phone number form
$(document).on('submit', '#create-phone-form', function (e) {
	e.preventDefault();
	let payload = {
			type: $('#type').val(),
			number: $('#number').val()
	};
	
	let ajaxOptions = {
			type:'POST',
			data: JSON.stringify(payload),
			contentType: 'application/json'
	};
	
	$.ajax(this.action, ajaxOptions)
		.done(function (data) {
			fillInDetails(data);
		});
});



//--------------------------------------------------
// Handle create an address form
$(document).on('submit', '#create-address-form', function (e) {
	e.preventDefault();
	let payload = {
			type: $('#type').val(),
			street: $('#street').val(),
			city: $('#city').val(),
			state: $('#state').val(),
			zipCode: $('#zipCode').val(),
	};
	
	let ajaxOptions = {
			type:'POST',
			data: JSON.stringify(payload),
			contentType: 'application/json'
	};
	
	$.ajax(this.action, ajaxOptions)
		.done(function (data) {
			fillInDetails(data);
		});
});

});




