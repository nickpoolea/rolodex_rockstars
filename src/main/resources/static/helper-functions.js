
//--------------------------------------------------
//Send an AJAX delete request
function sendAjaxDelete(thisItem, closestElement) {
	$.ajax(thisItem.action, {type: 'DELETE'})
		.done(() =>{
			$(thisItem)
				.closest(closestElement)
				.remove();
		})
		.fail(error => console.log(error));
}

//--------------------------------------------------
//Create HTML to display phone form and info
function createPhoneHTML(data, html) {

	for (let phone of data.phoneNumbers) {
		html += `
			<div>
				<b>${phone.type}</b>
				<div>${phone.number}</div>
				<form class="delete-phone-form" method="post" action="/cards/${data.id}/phone/${phone.id}">
					<button>Delete Phone</button>
				</form>
			</div>
		`;
	}
		
	html += `
		<form id="create-phone-form" method="post" action="/cards/${data.id}/phone">
			<input name="type" id="type" placeholder="Type">
			<br>
			<input name="number" id="number" placeholder="Phone Number">
			<br>
			<button>Add Phone Number</button>
		</form>
	`;
	return html;
}

//--------------------------------------------------
//Create HTML to display address form and info
function createAddressHTML(data, html) {
	
	for (let address of data.addresses) {
		html += `
			<div>
				<b>${address.type}</b>
				<div>${address.street}</div>
				<div>${address.city}</div>
				<div>${address.state}</div>
				<div>${address.zipCode}</div>
				<form class="delete-address-form" method="post" action="/cards/${data.id}/address/${address.id}">
					<button>Delete Address</button>
				</form>
			</div>
		`;
	}
		
	html += `
		<form id="create-address-form" method="post" action="/cards/${data.id}/address">
			<input name="type" id="type" placeholder="Type">
			<br>
			<input name="street" id="street" placeholder="Street">
			<br>
			<input name="city" id="city" placeholder="City">
			<br>
			<input name="state" id="state" placeholder="State">
			<br>
			<input name="zipCode" id="zipCode" placeholder="Zip Code">
			<br>
			<button>Add Address</button>
		</form>
	`;
	return html;
}


//--------------------------------------------------
//Fill in the details for the one card view
function fillInDetails(data) {
	let html = `
		<h1>${data.firstName} ${data.lastName}</h1>
		<h2>${data.company}</h2>
		<div>Title: ${data.title}</div>
	`;
	
	html = createPhoneHTML(data, html);
	html = createAddressHTML(data, html)
	
	$('#card-detail').html(html);
}

//--------------------------------------------------
//Create card list elements
function createListElement(card) {
	$('<li></li>')
	.html(`
			<a href="#" data-card-id="${card.id}">
				${card.lastName}, ${card.firstName} 
			</a>
			<form class="delete-card-form" method="post" action="/cards/${card.id}">
				<button>Delete</button>
			</form>
		`)
	.appendTo($('#card-list'));
}

