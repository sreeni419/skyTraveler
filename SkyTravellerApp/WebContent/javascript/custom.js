$(document).ready(function(){
	$(document).on("click", '.flightinfo', function(event)  {
	event.preventDefault();
	var id = $(this).attr('id'); 
	var departcode = $('#departure_code'+id).val();
	var arrivalcode = $('#arrival_code'+id).val();console.log(arrivalcode)
	if(arrivalcode === ""){
		$('.close.flightinfo').click();
		alert("Please Enter the Arrival code");
		return false;
	}
	$.ajax({
		type : "GET",
		url : "flight",
		data : {
			"departure_code" : departcode,
			"arrival_code" : arrivalcode
		},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var json = JSON.parse(data['data']);
			
			$('#flight-data'+id).children().remove();
			if(json.scheduledFlights.length == 0){
				$('#flight-data'+id).append('<tr><td>Sorry No Flights Today to '+arrivalcode+' From '+departcode+'</td></tr>');
				return;
			}
			$('#flight-data'+id)
					.append(
							'<thead><tr><th>S.No.</th><th>Flight#</th><th>Departure Time</th><th>Arrival Time</th><th>Departure Terminal</th><th>Stops</th></tr></thead><tbody>');
			var count = 1;
			if(json.scheduledFlights.length>0){
				for (var item in json.scheduledFlights) {
					var oFlight =json.scheduledFlights[item];
					$('#flight-data'+id).append(	
							'<tr><td>' + count + '</td><td>'
									+ oFlight.carrierFsCode+" "+oFlight.flightNumber + '</td><td>'
									+ oFlight.departureTime + '</td><td>'
									+ oFlight.arrivalTime + '</td><td>'
									+ oFlight.departureTerminal + '</td><td>'
									+ oFlight.stops	+ '</td></tr>');
					count++;
				}
			}
			
			$('#flight-data'+id).append('</tbody>');
		},
		error : function(e) {
			console.log(e);
			alert("Internal Server Error");
		}
	});
});

});
function stopLoader() {
	$('#loading').hide();
}

function getData() {

	$('#mainDiv').show();
	$('#loading').show();
	var search = $('#search-data').val();
	var from = $('#date-picker-from').val();
	var to = $('#date-picker-to').val();
	var geoLocation = $('#geoLocation').val();
	var country = $('#selectCountry').val();
	var page = $('#numberResult').val();
	var domains = $('#domains').val();
	var excludeDomains = $('#excludeDomains').val();
	var sortBy = $('#sortBy').val();

	if ($('#search-data').val() != '') {
		$
				.ajax({
					type : "GET",
					url : "searchController",
					data : {
						"search" : search,
						"from" : from,
						"to" : to,
						"geoLocation" : geoLocation,
						"country" : country,
						"page" : page,
						"domains" : domains,
						"excludeDomains" : excludeDomains,
						"sortBy" : sortBy
					},
					dataType : 'json',
					cache : false,
					timeout : 600000,
					success : function(data) {
						$('#download-div').show();
						$('#download-div').css({
							"visibility" : "visible"
						});
						var accessData = data['data'];
						var tmp = JSON.parse(accessData);
						var createDiv = '';
						$("#mainDiv").html('');
						var jsonData = '';
						for ( var item in tmp['articles']) {
							var newsTitle = tmp['articles'][item]['title'];
							var image = tmp['articles'][item]['urlToImage'];
							var description = tmp['articles'][item]['description'];
							var author = tmp['articles'][item]['author'];
							var content = tmp['articles'][item]['content'];
							var published = tmp['articles'][item]['publishedAt'];
							var url = tmp['articles'][item]['url'];

							createDiv += "<div class='second-keyword'><div class='row'><div class='col-sm-5'><img id='image' src="
									+ image
									+ " style='max-width: 463px'></div><div class='col-sm-7' style='word-spacing: 0px; text-align: left;'><span class='news-title'>"
									+ newsTitle
									+ "</span><br> <span class='news-desc'>"
									+ description
									+ "</span> <br> <span>Author: <span class='author'>"
									+ author
									+ "</span></span><br><span class='news-content'>"
									+ content
									+ "</span></div></div><div class='row'><div class='col-sm-5'><b>Publish Date:</b><span id='date'>"
									+ published
									+ "</span></div><div class='col-sm-7'><b>Source link:</b><span id='url'>"
									+ url + "</span></div></div></div>";

							// ('.news-title').append(newsTitle);

							// $('#image').attr('src', imageUrl);
						}
						$("#mainDiv").append(createDiv);

					},
					complete : function() {
						$('#loading').hide();
					}

				});
	} else {
		alert('Please input field');
		$("textarea:empty,input:text[value='']").first().focus();
		$('#loading').hide();
	}
}

/*
 * function downloadCSV() { $.ajax({ type : "POST", url : "createDataFile",
 * dataType : 'json', cache : false, timeout : 600000, success : function(data) { },
 * error : function(e) { alert("error"); } }); }
 */

function getTravelWarningData(countryCode) {
	$.ajax({
				type : "GET",
				url : "travelWarningData",
				data : {
					"countryCode" : countryCode
				},
				dataType : 'json',
				cache : false,
				timeout : 6000000,
				success : function(data) {
					var json = JSON.parse(data['data'])['data'];
					var lang = json['lang']['en'];
					var situation = json['situation'];
					
					$('#rating').html(situation['rating']);
					$('#updated-date').html(situation['updated']);
					$('#advice').html(lang['advice']);
				},
				error : function(e) {console.log(e);
					alert("Internal Server Error");
				}
			});
}

function getAirportData(city) { 
	$.ajax({
				type : "GET",
				url : "airportFinderResponse",
				data : {
					"cityName" : city
				},
				dataType : 'json',
				cache : false,
				timeout : 600000,
				success : function(data) {
					var json = JSON.parse(data['data']);
					$('#airport-data').children().remove();
					$('#airport-data')
							.append(
									'<thead><tr><th>S.No.</th><th>Airport Name</th><th>Location</th><th>Country</th><th>View Flight details</th></tr></thead><tbody>');
					var count = 1;
					for ( var item in json) {
						$('#airport-data').append(
								'<tr><td>' + count + '</td><td>'
										+ json[item]['name'] + '</td><td>'
										+ json[item]['location']['latitude']
										+ " , "
										+ json[item]['location']['longitude']
										+ '</td><td>'
										+ json[item]['countryCode']
										+ '</td><td>'
										+'<form method="post" name="flightform" class="flightform'+item+'">'
											+'<input type="text" placeholder="Arrival Airport Code eg:DTW,BOS" id="arrival_code'+item+'" size="25">'
											+'<input type="hidden" id="departure_code'+item+'" value='+json[item]['code']+'>'
											+'<button type="button" id='+item+' class="flightinfo btn btn-primary btn-md" data-toggle="modal" data-target="#myModal'+item+'">'
											+'View Flights</button>'
											+'<div class="modal fade" id="myModal'+item+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">'
												+'<div class="modal-dialog" role="document">'
													+'<div class="modal-content">'
														+'<div class="modal-header">'
															+'<button type="button" class="close flightinfo" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'
															+'<h4 class="modal-title" id="myModalLabel">Flight Details</h4>'
														+'</div>'
														+'<div class="modal-body flightbody"><table class="table table-bordered" id="flight-data'+item+'"></table></div>'
														+'<div class="modal-footer">'
															+'<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'
														+'</div>'
													+'</div>'
												+'</div>'
											+'</div>'
										+'</form></td></tr>');
						count++;
					}

					$('#airport-data').append('</tbody>');
				},
				error : function(e) {
					alert("Internal Server Error");
				}
			});
}