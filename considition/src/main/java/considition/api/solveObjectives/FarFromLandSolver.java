package considition.api.solveObjectives;

import considition.api.models.GameState;
import considition.api.models.TransportationMethod;

import java.util.List;

/**
 * Created by Oscar on 2017-11-10.
 */
public class FarFromLandSolver {

    List<String> solution;

    public FarFromLandSolver(int x, int y, List<String> solution, GameState state){

        char[][] mapClone = state.map.clone();

        for(int i=0; i<state.map.length; i++){

            for(int j=0; j<state.map.length; j++){


            }
        }

        this.solution=solution;

        while(x>1){

            x--;
            solution.add("TRAVEL WEST");
        }

        while(y>1){

            y--;
            solution.add("TRAVEL NORTH");
        }
    }

    public List<String> returnSolution(){

        return solution;
    }
}
