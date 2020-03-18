document.addEventListener('DOMContentLoaded', function () {
  if (document.querySelectorAll('#map').length > 0)
  {
    if (document.querySelector('html').lang)
      lang = document.querySelector('html').lang;
    else
      lang = 'en';

    var js_file = document.createElement('script');
    js_file.type = 'text/javascript';
    js_file.src = 'https://maps.googleapis.com/maps/api/js?key=AIzaSyDklz_vypQM1veXLWkmvUjEu8NIRtDZ9kM&callback=initMap&language=' + lang;
    document.getElementsByTagName('head')[0].appendChild(js_file);
  }
});
    var map;
    function initMap(){
      map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -34.397, lng: 150.644},
        zoom: 8
      });
    }

    var markers;
    var bounds;

    function plotMarkers(m){
        initMap();
        markers = [];
        bounds = new google.maps.LatLngBounds();
        m.forEach(function (marker) {
            var position = new google.maps.LatLng(marker.location.latitude, marker.location.longitude);
            markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
            );
            bounds.extend(position);
        });
        map.fitBounds(bounds);
    }

var app = (function(){

    function getAirportsByName(){
        $('#MyTable tbody').empty();
        var autor = $("#airportName").val();
            if(autor=="" || autor==null){
                alert("El parámetro del nombre es obligatorio");
            }else{
                apiclient.getAirportsByName();
            }
    }

    function createTable(airports){
        console.log(airports);
        airports.map(function(element){
            var markup = "<tr> <td>"+ element.airportId +"</td> <td>"+element.name+"</td> <td>"+element.city+"</td> <td>"+element.countryCode+"</td> </tr>";
            $("#filasAirports").append(markup)
        })
        plotMarkers(airports);


    }




    return{
        getAirportsByName:getAirportsByName,
        createTable:createTable
    }

})();
