		

function GoogleApiManagerOwner(mapId ,latitude, longitude, serverUrl)
{
	// Server
	this.serverUrl = serverUrl;
		
	// DOM elements
	this.mapDOM = document.getElementById(mapId);
	this.stopListDOM;
	this.abusiveErrorDOM;
	this.refreshDOM;
	
	// icons vars
	this.iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
	this.icons = [];
	
	// markers vars
    this.markers = [];
    this.currentSelectedMarker;
    
    // google map
    this.map;
    
    // InfoWindow
    this.infoWindow = new google.maps.InfoWindow(),	
	
	// Geocoding API objects
	this.geocoder = new google.maps.Geocoder();

    // init icons
    this.Initicons();
    
    // init google map
    this.map = this.InitMap(latitude,longitude);
    
    // init google map events
    this.InitGoogleMapsEvents();
    
    
    this.tariffaOraria;
    
    this.markerMap = new Map();
    
    this.currentLatitude;
    this.currentLongitude;
    
    this.loadOwnerSlots();
};
  

GoogleApiManagerOwner.prototype.Initicons = function()
{
	this.iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
	this.icons = {
			parking : {
				icon : this.iconBase + 'parking_lot_maps.png'
			},
			parkingGreen : {
				icon : '/css/green.png'
			},
			parkingRed : {
				icon : '/css/red.png'
			},
			parkingYellow : {
				icon : '/css/yellow.png'
			},
			library : {
				icon : this.iconBase + 'library_maps.png'
			},
			info : {
				icon : this.iconBase + 'info-i_maps.png'
			},
			start : {
				url : this.iconBase + 'cabs.png',
				scaledSize : new google.maps.Size(25,25)
			}
		};
};

GoogleApiManagerOwner.prototype.InitMap = function(latitude,longitude)
{
	var mapOptions = {
			center : new google.maps.LatLng(latitude, longitude),
			zoom : 12,
			mapTypeId : google.maps.MapTypeId.ROADMAP,
			disableDefaultUI : true,
			zoomControl : true
		}
	return map = new google.maps.Map(this.mapDOM,
			mapOptions);
};

// pass params in map
GoogleApiManagerOwner.prototype.doAjax = function(url,mapParams,success,fail,method)
{
	var self = this;
	var http = new XMLHttpRequest();
	var myurl = url; 
	
	var params = "";
	for (const [key, value] of mapParams.entries()) {
		  console.log(key, value);
		  params = params + (key + "=" + value + "&");
		}
	if(params.length > 0) params.slice(0, -1);
	
	console.log("params:  " + params);
	
	http.open(method, myurl, true);
	// Send the proper header information along with the request
	http.setRequestHeader('Content-type',
			'application/x-www-form-urlencoded');
	http.send(params);
	http.onreadystatechange = function() 
	{
		if (http.readyState == 4 && http.status == 200) 
		{
			success(http);
		}
		else
		{
			fail(http);
		}
	}
};

GoogleApiManagerOwner.prototype.selectStopList = function(stopListID,abusiveErrorId){
	this.stopListDOM = document.getElementById(stopListID);
	this.abusiveErrorDOM = document.getElementById(abusiveErrorId);
	console.log("quii");
}

GoogleApiManagerOwner.prototype.selectRefresh = function(refreshID){
	var self = this;
	self.refreshDOM = document.getElementById(refreshID);
	
	self.refreshDOM.addEventListener('click', function(){
		self.deleteMarkers();
		self.loadOwnerSlots();
	});
};




GoogleApiManagerOwner.prototype.loadOwnerSlots = function(){
    
	var self = this;
	var params = new Map();
	self.doAjax(self.serverUrl, params, slotLoadSuccess, slotLoadFailed , 'POST');
	
	function slotLoadSuccess(http)
	{
		console.log("scaricamento slot riuscito: " + http.responseText);
		
		// rimuovo i markers precedenti
		self.deleteMarkers();
		var objDTO = JSON.parse(http.responseText);
		// var infoWindow = new google.maps.InfoWindow(), marker, i;
		
		var title = [];
		for (var i = 0; i < objDTO.length; i++) {
			var obj = objDTO[i];

			var latLng = new google.maps.LatLng(
					obj.slot.latitude, obj.slot.longitude);
			var freeCarPlaces = obj.slot.number_carplace_free;
			var numberCarPlaces = obj.slot.number_carplace;
			var abusiveNumber = (obj.slot.number_carplace - obj.slot.number_carplace_free ) - obj.stop_list.length;
			var hasOneExpired = false;
			  for(var j = 0; j < obj.stop_list.length; j++)
			  {
				  if(obj.stop_list[j].expired == 1) 
				  {
					  hasOneExpired = true;
					  break;
				  }
			  }
			
			var info = "<h3>" + obj.slot.address + "</h3>"
					+ "<br> Tariffa oraria: " + obj.slot.price + "\u20AC"
					+ "<br> Numero posti: " + numberCarPlaces 
					+ "<br> Disponibli: " + freeCarPlaces
					+ "<br><a id='slotInfo'>Dettagli</a>";


			title[i] = info;
			
			// make markers
			if(abusiveNumber > 0 || hasOneExpired == true)
				var marker = self.makeMarker(latLng,self.icons["parkingRed"].icon);
			else 
				var marker = self.makeMarker(latLng,self.icons["parkingGreen"].icon);
			
			self.markerMap.set(marker, obj);
			self.AddMarkerEvent(marker,title[i], obj);
		}
		
		// se parto da lontano i marker devono essere invisibili se da vicino
		// visibili.
		// self.deleteMarkersZoom();
	}
	
	function slotLoadFailed(http)
	{
		console.log("scaricamento slot non riuscito: " + http.responseText);
	}
};

GoogleApiManagerOwner.prototype.InitGoogleMapsEvents = function()
{
	var self = this;
// google.maps.event.addListener(self.map, "dragend", function(event) {
// self.doAjaxForNearSlots(self.map.getCenter().lat(),
// self.map.getCenter().lng());
// });
	
// google.maps.event.addListener(self.map, "zoom_changed", function(event) {
// self.deleteMarkersZoom();
// });
};

GoogleApiManagerOwner.prototype.selectFindMyPosition = function(findMyPositionButtonId)
{
	this.findMyPositionButtonDOM = document.getElementById(findMyPositionButtonId);
	
	this.InitGeocodeFindMyPositionEvent();
};

// call only after selectAutoCompleteTextbox()
GoogleApiManagerOwner.prototype.geocodeAddress = function()
{
	var self = this;
	var address = this.autoCompleteTextboxDOM.value;
	this.geocoder.geocode(
					{
						'address' : address
					},
					function(results, status) 
					{
						if (status === 'OK')
						{
							this.map.setCenter(results[0].geometry.location);
							this.map.setZoom(15);
							self.doAjaxForNearSlots(this.map.getCenter().lat(), this.map.getCenter().lng());
						} else 
						{
							alert('Geocode was not successful for the following reason: '
									+ status);
						}
					});
};

GoogleApiManagerOwner.prototype.geocodeCoordinates = function(latitude,longitude)
{
	var self = this;
	var location = new google.maps.LatLng(latitude, longitude);
	this.geocoder.geocode(
					{
						'location' : location
					},
					function(results, status) 
					{
						if (status === 'OK')
						{
							this.map.setCenter(results[0].geometry.location);
							this.map.setZoom(15);
							self.doAjaxForNearSlots(this.map.getCenter().lat(), this.map.getCenter().lng());
						} else 
						{
							alert('Geocode was not successful for the following reason: '
									+ status);
						}
					});
};


GoogleApiManagerOwner.prototype.InitGeocodeFindMyPositionEvent = function()
{
	var self = this;
	this.findMyPositionButtonDOM.addEventListener('click',
			function(){
				if (navigator.geolocation) {
						navigator.geolocation.getCurrentPosition(showPosition);
				} else { 
						console.log("Geolocation is not supported by this browser.");
						}
		
	});
	
	function showPosition(position) {
		self.currentLatitude = position.coords.latitude;
		self.currentLongitude = position.coords.longitude;
		self.geocodeCoordinates(self.currentLatitude, self.currentLongitude);
	}
}

GoogleApiManagerOwner.prototype.AddMarkerEvent = function(marker,content)
{
	var self = this;
	google.maps.event.addListener(marker, 'click',
			(function(marker,content) {
				
				return function() {	
					self.currentSelectedMarker = marker;
					
					google.maps.event.clearListeners(self.infoWindow, 'domready');
					self.infoWindow.setContent(content);
					self.InitInfoWindowEvents(marker);
					self.infoWindow.open(self.map, marker);
				}
			})(marker,content));
};

GoogleApiManagerOwner.prototype.InitInfoWindowEvents = function(marker)
{
		var self = this;		
		google.maps.event.addListener(self.infoWindow, 'domready', function() {
					
			document.getElementById("slotInfo").addEventListener("click", function(){
				  
				  var obj = self.markerMap.get(self.currentSelectedMarker);
				  
				  var html = "";
				  for(var i = 0; i < obj.stop_list.length; i++)
					  {
					  	 html += "<tr>";
				         html += "<td>"+ obj.stop_list[i].id_stop +"</td>";
				         // html += "<td>"+ obj.stop_list[i].type +"</td>";
				         html += "<td>"+ obj.stop_list[i].car.license_plate +"</td>";
				         html += "<td>"+ obj.stop_list[i].start +"</td>";
				         html += "<td>"+ obj.stop_list[i].finish +"</td>";			       
				         
				         if(obj.stop_list[i].expired == 0)
			        	 {
			        	 	html += "<td> SI </td>";
			        	 }
				         else
			        	 {
			        	 	html += "<td> NO </td>";
			        	 }
				         
// var paymentCurrentStop = [];
// for(var j = 0; j < obj.payment_list.length; j++)
// {
// if(obj.payment_list[j].stop.id_stop == obj.stop_list[i].id_stop)
// paymentCurrentStop.push(obj.payment_list[j]);
// }
// if(paymentCurrentStop.length > 0)
// {
// html += "<td> SI </td>";
// }
// else
// {
// html += "<td> NO </td>";
// }
				         html += "</tr>";
					  }	  
				  
				  var abusiveNumber = (obj.slot.number_carplace - obj.slot.number_carplace_free ) - obj.stop_list.length;
				  if(abusiveNumber > 0)
					  self.abusiveErrorDOM.innerHTML = "<h3>Ci sono " + abusiveNumber + " parcheggi abusivi in questa area parcheggi</h3>";
				  self.stopListDOM.innerHTML = html;
			});		
			
		});
};

GoogleApiManagerOwner.prototype.makeMarker = function(position,icon)
{
	 var marker = new google.maps.Marker({
		  position: position,
		  map: this.map,
		  icon: icon,
		 });
	 this.markers.push(marker); 
	 return marker;
};


// Sets the map on all markers in the array.
GoogleApiManagerOwner.prototype.setMapOnAll = function(map)
{
	var self = this;
	for (var i = 0; i < self.markers.length; i++) {
		self.markers[i].setMap(map);
	}
};

// Removes the markers from the map, but keeps them in the array.
GoogleApiManagerOwner.prototype.clearMarkers = function()
{
	var self = this;
	self.setMapOnAll(null);
};

// Shows any markers currently in the array.
GoogleApiManagerOwner.prototype.showMarkers = function()
{
	var self = this;
	self.setMapOnAll(self.map);
};

// Hidden markers when zooming to far.
GoogleApiManagerOwner.prototype.deleteMarkersZoom = function()
{
	var self = this;
	if (self.map.getZoom() < 15) {
		console.log("zoom: " + self.map.getZoom());
		self.clearMarkers();
	} else {
		self.showMarkers();
	}
};

// Deletes all markers in the array by removing references to them.
GoogleApiManagerOwner.prototype.deleteMarkers = function()
{
	var self = this;
	self.clearMarkers();
	self.markers = [];
	self.markerMap.clear();
};




