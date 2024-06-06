package menu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import actors.golfer;
import attributes.club;
import golfIreland.GameState;
import golfIreland.playerRound;
import round.recordHole;
import round.recordShot;
import round.round;

public class SaveMenu {
	private final GameState gamestate;
	private static golfer currentGolfer;

		public SaveMenu(GameState gamestate, String name) {
			this.gamestate = gamestate;
			savePlayer(name);
		}
		
		private void savePlayer(String filepath) {
			
			currentGolfer = gamestate.getCurrentGolfer();
			
			JSONObject myObj = new JSONObject();
			myObj.put("Forename", currentGolfer.getfirstName());
			myObj.put("Surname", currentGolfer.getsecondName());
			myObj.put("Handicap", currentGolfer.getHandicap());
			myObj.put("Club", currentGolfer.getClub());
			
			JSONArray clubs = new JSONArray();
			
			for(int i = 0; i < currentGolfer.displayClubs().size(); i++) {
				club clb = currentGolfer.displayClubs().get(i);
				JSONObject clbobj = new JSONObject();
				clbobj.put("Club", clb.getClub());
				clbobj.put("Series", clb.getSeries());
				clbobj.put("Manufacturer", clb.getManufacturer());
				
				clubs.add(clbobj);
			}
			
			myObj.put("Clubs", clubs);
			
			try(FileWriter file = new FileWriter("golfers/" + filepath + ".json"))
			{
				
				file.write(myObj.toString());
				
				
			}
			catch(IOException e) {
				e.printStackTrace();
		}
			System.out.println("Player Profile successfully saved");
			
	}
		
		public static void saveClubs(String filename, club clb) throws FileNotFoundException, IOException, ParseException {
			
			// Load the JSON file into a JSONObject
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("golfers/" + filename + ".json"));

			// Get the golfclubs array from the JSON object
			JSONArray clubsArray = (JSONArray) jsonObject.get("Clubs");

			// Create a new golfclub object and add it to the array
			JSONObject newGolfclub = new JSONObject();
			newGolfclub.put("Club", clb.getClub());
			newGolfclub.put("Series", clb.getSeries());
			newGolfclub.put("Manufacturer", clb.getManufacturer());
			
			clubsArray.add(newGolfclub);

			// Write the updated JSON data back to the file
			try (FileWriter file = new FileWriter("golfers/" + filename + ".json")) {
				
			    file.write(jsonObject.toJSONString());
			    System.out.println("Successfully updated JSON file.");
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
		
		
		public static void saveround(round round, String filename) {
			
	        // Create a JSON array to hold hole data
	        JSONArray holesArray = new JSONArray();
	        for (int i = 0; i < round.getHoles().size(); i++) {
	            // Create a new JSONObject for each hole
	            JSONObject holeObject = new JSONObject();
	            recordHole hole = round.getHoles().get(i);
	            holeObject.put("Hole Number",hole.getNumber());
	            holeObject.put("Hole Yardage",hole.getDistance());
	            holeObject.put("Par", hole.getPar());

	            // Create a JSON array to hold shot data for the hole
	            JSONArray shotsArray = new JSONArray();
	            for (int j = 0; j < hole.getShots().size(); j++) {
	                // Create a JSONObject for each shot and add it to the shots array
	            	recordShot shot = hole.getShots().get(j);
	            	
	                JSONObject shotObject = new JSONObject();
	                shotObject.put("Number", shot.getNumber());
	                shotObject.put("Distance", shot.getDistance());
	                shotObject.put("Club", shot.getClub());
	                shotObject.put("End Distance", shot.getEndDistance());
	                shotObject.put("End Position", shot.getEndPosition());
	                shotsArray.add(shotObject);
	            }

	            // Add the shots array to the hole object and add the hole object to the holes array
	            holeObject.put("shots", shotsArray);
	            holesArray.add(holeObject);
	        }

	        JSONObject roundObject = new JSONObject();
	        roundObject.put("Course Name", round.getCourse());
	        roundObject.put("Par", round.getPar());
	        roundObject.put("Tees", round.getTees());
	        roundObject.put("Number of holes", round.getNumberOfHoles());
	        roundObject.put("Date", round.getDate());
	        roundObject.put("holes", holesArray);

	        // Write the JSON data to a file
	        try (FileWriter file = new FileWriter("rounds/" + filename + ".json")) {
	            file.write(roundObject.toJSONString());
	            System.out.println("Successfully wrote JSON to file");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}

		
		
}
