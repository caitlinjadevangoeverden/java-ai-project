import java.util.*;

public class GameState {

    Map<String, Integer> suspectScore = new HashMap<>();
    Map<String, Integer> weaponScore = new HashMap<>();
    Map<String, Integer> roomScore = new HashMap<>();

    public GameState() {
        // Initialize with all possible values so pickBest works immediately

        List<String> suspects = Arrays.asList(
            "MissScarlett","ColMustard","MrsWhite",
            "MrGreen","MrsPeacock","ProfPlum"
        );

        List<String> weapons = Arrays.asList(
            "Knife","Candlestick","Revolver",
            "Pipe","Rope","Wrench"
        );

        List<String> rooms = Arrays.asList(
            "Library","Conservatory","Kitchen","DiningRoom",
            "Hall","Ballroom","BilliardRoom","Lounge","Study"
        );

        for (String s : suspects) suspectScore.put(s, 0);
        for (String w : weapons) weaponScore.put(w, 0);
        for (String r : rooms) roomScore.put(r, 0);
    }
}