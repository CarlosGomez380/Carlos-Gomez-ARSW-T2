package edu.eci.AirportFinder.cache;

import org.javatuples.Triplet;
import org.springframework.stereotype.Service;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class AirportsFinderCache {

    private final CopyOnWriteArrayList<Triplet<String,Timer,String>> airports= new CopyOnWriteArrayList<>();
    /**
     *
     * @param name airport's name
     * @param data all the airports
     * @return all the airports of the given author if the airports are  on  cache
     * @throws AirportsFinderException if the given name doesn't exist
     */
    public String  getAirportByName(String name,String data) throws AirportsFinderException {
        String objeto="";
        for (int i=0; i< airports.size();i++){
            if(airports.get(i).getValue0().equals(name)){
                objeto=airports.get(i).getValue2();
                break;
            }
        }
        if (objeto.equals("")){
            tiempo(name,data);
        }

        return objeto;
    }

    /**
     *
     * @param name airport's name
     * @return all the airports of the given author if the airports are not on cache
     * @throws AirportsFinderException if the given author doesn't exist
     */
    public String getAirportByName(String name) throws AirportsFinderException{
        String objeto=null;
        for (int i=0; i< airports.size();i++){
            if(airports.get(i).getValue0().equals(name)){
                objeto=airports.get(i).getValue2();
                break;
            }
        }
        return objeto;
    }

    /**
     *
     * Remove the airport from cache when the time has passed 5 minutes
     * @param name airport's name
     * @param data all the airports
     * @throws AirportsFinderException if the given name doesn't exist
     */
    public void tiempo(String name, String data){
        Timer timer = new Timer();
        final Triplet airpot=new Triplet<>(name,timer,data);
        airports.add(airpot);
        TimerTask timerTask = new TimerTask() {
            public void run() {
                airports.remove(airpot);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 300000, 300000);
    }
}
