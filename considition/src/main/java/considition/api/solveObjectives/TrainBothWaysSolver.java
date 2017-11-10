package considition.api.solveObjectives;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import considition.api.models.City;
import considition.api.models.GameState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oscar on 2017-11-10.
 */
public class TrainBothWaysSolver {

    List<City> cityWithTrains = new ArrayList<>();
    String startCity;
    String endCity;
    int tempDistance;

    public TrainBothWaysSolver(GameState state){

        for(City c : state.cities){

            if(!c.hasTrainTo.isEmpty()){

                if(startCity.isEmpty() || endCity.isEmpty()){
                    startCity = c.name;
                    endCity = c.hasTrainTo.get(0);

                    tempDistance = Math.abs( (c.x - state.cities.get(getIndexOf(state, endCity)).x) +
                            (c.y - state.cities.get(getIndexOf(state, endCity)).y));
                }

                for (String s : c.hasTrainTo){

                    if (tempDistance > Math.abs( (c.x - state.cities.get(getIndexOf(state, s)).x) +
                            (c.y - state.cities.get(getIndexOf(state, s)).y))){

                        startCity = c.name;
                        endCity = s;
                    }
                }
            }
        }


    }

    private int getIndexOf(GameState state, String cityName){
        int index = 0;
        for(City c : state.cities){
            if(c.name.equalsIgnoreCase(cityName)){
                return index;
            }
            index++;
        }

        return -1;
    }
}
