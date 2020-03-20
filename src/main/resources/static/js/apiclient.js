var apiclient=(function(){

    function getAirportsByName(){
        axios({
            method:'get',
            url: "http://carlos-gomez-arsw-t2.herokuapp.com/airports/" + $("#airportName").val(),

        })
        .then(response => app.createTable(response.data))
        .catch(error => console.log(error));
    }


    return{
        getAirportsByName:getAirportsByName

    }
})();
