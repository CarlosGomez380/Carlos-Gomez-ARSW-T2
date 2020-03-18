package edu.eci.AirportFinder.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.AirportFinder.cache.AirportsFinderException;
import org.springframework.stereotype.Service;

@Service
public class HttpConnectionService {


    /**
     *
     * Connect to rapidapi to get the API
     * @param name airport's name
     * @return all the airports of the given name
     */
    public String getConnection(String name){
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text="+ name)
                    .header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", "562ad42b0cmsh5d796280e44b680p1df165jsn6d71ed954e15")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }

}
