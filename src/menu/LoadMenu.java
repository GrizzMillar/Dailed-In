package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import actors.golfer;
import attributes.club;
import golfIreland.GameState;
import menus.input.SelectOptionMenu;
import menus.input.StringMenu;
import round.recordHole;
import round.recordShot;
import round.round;

public class LoadMenu {
	private final String filePath;
    private golfer player;

	public LoadMenu(String directory, boolean isViewOthers) {
		
		if (!isViewOthers) {
		 //looking for file in directory location
        File f = new File(directory);

        //presenting all the '.csv' files in directory filepath in a string array
        FilenameFilter filter = (f1, name) -> name.endsWith(".json");
        //FilenameFilter filter = (f1, name) -> name.startsWith("luke millar");
        String[] pathname = f.list(filter);

        //removing '.csv' from file names before presenting to user
        if (pathname != null){
            for(int i=0; i<pathname.length; i++){
                pathname[i] = pathname[i].substring(0, pathname[i].length()-5);
            }

            //presents a menu of all the valid files in the directory for the user to choose one to play on
            SelectOptionMenu boardSelect = new SelectOptionMenu("Select a player to Load", pathname, false);

            //creates new board from user selected file
            int choice = boardSelect.getUserInput()-1;
            this.filePath = pathname[choice];
        }
        //Throws error if no .csv files located in directory i.e. cannot load a save game file
        else{
            System.out.println("Error - No player files can be found.");
            filePath = null;
            return;
        }
		} else {
			StringMenu search = new StringMenu("Enter Player name", true);
			
			String player = search.getUserInput();
			this.filePath = player;
			
			
			 //looking for file in directory location
	        File f = new File("golfers");

	        //presenting all the '.csv' files in directory filepath in a string array
	        FilenameFilter filter = (f1, name) -> name.endsWith(".json");
	        
	        String[] pathname = f.list(filter);

	        //removing '.csv' from file names before presenting to user
	        if (pathname != null){
	            for(int i=0; i<pathname.length; i++){
	                pathname[i] = pathname[i].substring(0, pathname[i].length()-5);
	               
	            }
	        }
	            
	           for(int i=0; i <pathname.length; i++) {
	       
	            	if (player.contentEquals(pathname[i])) {
	            		System.out.println("Player found");
	            		
	            	} 
	            	
	            }
		}
		
	}
	
	
	
	public GameState loadGolfer() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("golfers/" + filePath + ".json"));
		JSONObject jsonObj = (JSONObject) obj;
		String forename = (String) jsonObj.get("Forename");
		String surname = (String) jsonObj.get("Surname");
		double handicap = (double) jsonObj.get("Handicap");
		String club = (String) jsonObj.get("Club");
		
		player = new golfer(forename, surname, handicap, club);
		player.setFullName();
		
		  JSONArray clubsArray = (JSONArray) jsonObj.get("Clubs");
	        for (int i = 0; i < clubsArray.size(); i++) {
	            JSONObject clubObj = (JSONObject) clubsArray.get(i);

	            
	            String series = (String) clubObj.get("Series");
	            String gclub = (String) clubObj.get("Club");
	            String manu = (String) clubObj.get("Manufacturer");
	            club clb = new club(gclub, series, manu);
	            
	   player.addClub(clb);
	        }
		 File f = new File("rounds");

	        FilenameFilter filter = (f1, name) -> name.startsWith(filePath);
	        String[] pathname = f.list(filter);

	       if (pathname != null){
	            for(int i=0; i<pathname.length; i++){
	                round rnd = loadJSONRound(player.getFullName());
	                	rnd.setName();
	                player.addPlayerRound(rnd);
	                player.getStats().initialiseStats(rnd.getRoundStats());
	               
	            
	            }
	            }
		
		GameState gamestate = new GameState(player);
		
		return gamestate;
 		
		
	}
	
	public golfer loadOtherGolfer() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("golfers/" + filePath + ".json"));
		JSONObject jsonObj = (JSONObject) obj;
		String forename = (String) jsonObj.get("Forename");
		String surname = (String) jsonObj.get("Surname");
		double handicap = (double) jsonObj.get("Handicap");
		String club = (String) jsonObj.get("Club");
		
		golfer viewGolfer = new golfer(forename, surname, handicap, club);
		viewGolfer.setFullName();
		
		  JSONArray clubsArray = (JSONArray) jsonObj.get("Clubs");
	        for (int i = 0; i < clubsArray.size(); i++) {
	            JSONObject clubObj = (JSONObject) clubsArray.get(i);

	            
	            String series = (String) clubObj.get("Series");
	            String gclub = (String) clubObj.get("Club");
	            String manu = (String) clubObj.get("Manufacturer");
	            club clb = new club(gclub, series, manu);
	            
	   viewGolfer.addClub(clb);
	        }
		 File f = new File("rounds");

	        FilenameFilter filter = (f1, name) -> name.startsWith(filePath);
	        String[] pathname = f.list(filter);

	       if (pathname != null){
	            for(int i=0; i<pathname.length; i++){
	                round rnd = loadJSONRound(player.getFullName());
	                	rnd.setName();
	                	
	                viewGolfer.addPlayerRound(rnd);
	                viewGolfer.getStats().initialiseStats(rnd.getRoundStats());
	            
	            }
	            }
		
		
		
		return viewGolfer;
 		
		
	}
	
	public static round loadJSONRound(String filepath) throws IOException, ParseException {
		 //round loadedRound = new round();
		
		String jsonStr = new String(Files.readAllBytes(Paths.get("rounds/" + filepath + ".json")));

       // Parse the JSON string into a JSONObject
       JSONParser parser = new JSONParser();
       JSONObject jsonObj = (JSONObject) parser.parse(jsonStr);

       // Extract the data from the JSONObject and use it to create a new round object
       String course = (String) jsonObj.get("Course Name");
       int par = (int) (long) jsonObj.get("Par");
       String tees = (String) jsonObj.get("Tees");
       int num = (int) (long) jsonObj.get("Number of holes");
       String date = (String) jsonObj.get("Date");
       round loadedRound = new round(course, par, tees, num, date);

		    try {
		        // Read the contents of the JSON file into a String variable
		        //String jsonStr1 = new String(Files.readAllBytes(Paths.get("rounds/" + filepath + ".json")));

		        
		        JSONArray holesArray = (JSONArray) jsonObj.get("holes");
		        for (int i = 0; i < holesArray.size(); i++) {
		            JSONObject holeObj = (JSONObject) holesArray.get(i);

		            
		            int holenum = (int) (long) holeObj.get("Hole Number");
		            int holedis = (int) (long) holeObj.get("Hole Yardage");
		            int holepar = (int) (long) holeObj.get("Par");
		            recordHole hole = new recordHole(holenum, holedis, holepar);
		            
		            JSONArray shotsArray = (JSONArray) holeObj.get("shots");
		            for (int j = 0; j < shotsArray.size(); j++) {
		                JSONObject shotObj = (JSONObject) shotsArray.get(j);

		                
		                int shotnum = (int) (long) shotObj.get("Number");
		                int shotdis = (int) (long) shotObj.get("Distance");
		                String club = (String) shotObj.get("Club");
		                int enddis = (int) (long) shotObj.get("End Distance");
		                String endpos = (String) shotObj.get("End Position");
		                recordShot shot = new recordShot(shotnum, shotdis, club,enddis, endpos);

		                hole.addShots(shot);
		            }

		            loadedRound.addHoles(hole);
		        }
		        
		        
		        loadedRound.initStats();
		        loadedRound.initPoints();
		        
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return loadedRound;
		}
	
	public static golfer loadClubs(String filepath) throws IOException, ParseException {
		 //round loadedRound = new round();
		golfer luke = new golfer("Luke", "Millar", 4, "Port");
		String jsonStr = new String(Files.readAllBytes(Paths.get("golfers/" + filepath + ".json")));

      // Parse the JSON string into a JSONObject
      JSONParser parser = new JSONParser();
      JSONObject jsonObj = (JSONObject) parser.parse(jsonStr);

		    try {
		        // Read the contents of the JSON file into a String variable
		        //String jsonStr1 = new String(Files.readAllBytes(Paths.get(filepath)));

		        
		        JSONArray holesArray = (JSONArray) jsonObj.get("Clubs");
		        for (int i = 0; i < holesArray.size(); i++) {
		            JSONObject holeObj = (JSONObject) holesArray.get(i);

		            
		            String series = (String) holeObj.get("Series");
		            String club = (String) holeObj.get("Club");
		            String manu = (String) holeObj.get("Manufacturer");
		            club clb = new club(club, series, manu);
		            
		   luke.addClub(clb);
		        }
		      
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return luke;
		}
	
}
