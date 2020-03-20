var apiclient=(function(){

    function getAirportsByName(){
        axios({
            method:'get',
            url: "/airports/" + $("#airportName").val(),

        })
        .then(response => app.createTable(response.data))
        .catch(error => console.log(error));
    }


    return{
        getAirportsByName:getAirportsByName

    }
})();
