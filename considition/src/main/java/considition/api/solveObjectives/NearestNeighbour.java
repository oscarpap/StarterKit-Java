package considition.api.solveObjectives;

import considition.api.models.City;
import considition.api.models.GameState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by papen on 2017-11-09.
 */
public class NearestNeighbour {

    List<City> visited = new ArrayList<>();
    List<City> allCities = new ArrayList<>();

    public NearestNeighbour(GameState state){

        allCities = state.cities;
    }

    public City getNearestNeighbour(int x, int y){

        City nearestCity = new City();
        int tempX = -1;
        int tempY = -1;

        for (City c: allCities){

            if(visited.contains(c)){
                continue;
            }
            else if(tempX == -1 || tempY == -1){
                tempX = Math.abs(x-c.x);
                tempY = Math.abs(y-c.y);
                nearestCity = c;
            }
            else if(tempX>Math.abs(x-c.x) || tempY>Math.abs(y-c.y)){
                tempX = Math.abs(x-c.x);
                tempY = Math.abs(y-c.y);
                nearestCity = c;
            }
        }

        return nearestCity;
    }

    public void updateVisited(City city){

        visited.add(city);
    }
}
