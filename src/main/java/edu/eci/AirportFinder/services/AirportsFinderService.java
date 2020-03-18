package edu.eci.AirportFinder.services;

import edu.eci.AirportFinder.cache.AirportsFinderCache;
import edu.eci.AirportFinder.cache.AirportsFinderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AirportsFinderService {

    @Autowired
    AirportsFinderCache airport = null;

    @Autowired
    HttpConnectionService connection=null;

    /**
     *
     * @param name airport's name
     * @return all the airports of the given author
     * @throws AirportsFinderException if the given author doesn't exist
     */
    public String getAirportByName(String name) throws AirportsFinderException {
        System.out.println("Metodo");
        String data;
        if(airport.getAirportByName(name)!= null){
            System.out.println("chao");
            return airport.getAirportByName(name);
        }else{
            System.out.println("Hola");
            airport.getAirportByName(name,connection.getConnection(name));
            return airport.getAirportByName(name);
        }
    }

}
