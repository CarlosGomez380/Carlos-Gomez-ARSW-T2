package edu.eci.AirportFinder.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.AirportFinder.cache.AirportsFinderException;
import edu.eci.AirportFinder.services.AirportsFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/airports")
public class AirpotsFinderController {

    @Autowired
    AirportsFinderService airport = null;

    /**
     *
     * @param name airport's name
     * @return all the airports of the given author as a HTTP response.
     */
    @RequestMapping(path ="/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> GetAirpotFilterByName(@PathVariable  String name) {
        try {
            return new ResponseEntity<>(airport.getAirportByName(name), HttpStatus.ACCEPTED);
        } catch (AirportsFinderException e) {
            Logger.getLogger(AirpotsFinderController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
