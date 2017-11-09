package considition;

import java.util.*;

import considition.api.*;
import considition.api.models.*;
import considition.api.solveObjectives.NearestNeighbour;

public class Main {
	
	// TODO: Enter your API key
	static final String API_KEY = "a3732fd3-f42e-40ec-a031-d52de6c3a4a4";
	
	static List<String> solve(GameState game) {
		/*
         * --- Available commands ---
         * TRAVEL [NORTH|SOUTH|WEST|EAST]
         * [BUS|TRAIN|FLIGHT] {CityName}
         * SET_PRIMARY_TRANSPORTATION [CAR|BIKE]
         */

        // TODO: Implement your solution

        // Example solution
		List<String> solution = new ArrayList<String>();
		int x = game.start.x;
		int y = game.start.y;

		NearestNeighbour nearestNeighbour = new NearestNeighbour(game);
		nearestNeighbour.getNearestNeighbour(x, y);



        while (x < game.end.x) {
            x++;
            solution.add("TRAVEL EAST");
        }
        while (y < game.end.y) {
            y++;
            solution.add("TRAVEL SOUTH");
        }

		return solution;
	}
	
	public static void main(String[] args) {
		Api.setApiKey(API_KEY);
		Api.initGame();
		GameState game = Api.getMyLastGame();
		List<String> solution = solve(game);
		Api.submitSolution(solution, game.id);
	}

	
}
