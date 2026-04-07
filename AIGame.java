import java.io.PrintStream;
import java.util.*;

public class AIGame {
    public static void run() throws Exception {
        ClueGame.resetAll();
        ClueGame.runMurder("murder3", "MrsPeacock", "ProfPlum", "Conservatory", "Kitchen", result -> {
            GameState state = new GameState();

            ClueGame.divider(result);
            ClueGame.section(result, "MURDER 3 - DYNAMIC AI ENGINE");

            for (int i = 1; i <= 8; i++) {

                Map<String, String> guess = buildBestGuess(state);

                String refuter = simulateRefuter(guess);
                String cardShown = simulateCardShown(guess, refuter);

                suggestAI(result, state, i, getNextPlayer(i), guess, refuter, cardShown);
            }
        });
    }

    public static Map<String, String> buildBestGuess(GameState state) {
        return Map.of("Suspect", getBest(state.suspectScore), "Weapon", getBest(state.weaponScore), "Room", getBest(state.roomScore));
    }

    public static boolean suggestAndTrack(PrintStream out, GameState state, int round, String suggester, Map<String, String> guess, String refuter, String cardShown) {
        
        ClueGame.AIsuggest(out, round, suggester, guess, refuter, cardShown);
    
        // update scores
        state.suspectScore.put(guess.get("Suspect"), state.suspectScore.getOrDefault(guess.get("Suspect"), 0) + 2);
        state.weaponScore.put( guess.get("Weapon"), state.weaponScore.getOrDefault(guess.get("Weapon"), 0) + 2);
        state.roomScore.put(guess.get("Room"), state.roomScore.getOrDefault(guess.get("Room"), 0) + 2);

        return refuter != null && !refuter.isEmpty();
    }

    public static String getNextPlayer(int i) {
        return ClueGame.players.get((i-1) % ClueGame.players.size());
    }

    public static String simulateRefuter(Map<String, String> guess) {
      if (Math.random() < 0.4) return "";
      return ClueGame.players.get((int)(Math.random() * ClueGame.players.size()));
    }

   public static String simulateCardShown(Map<String, String> guess, String refuter) {
      if (refuter == null || refuter.isEmpty()) return "";
      
      List<String> cards = Arrays.asList(guess.get("Suspect"), guess.get("Weapon"), guess.get("Room"));
      return cards.get((int)(Math.random() * cards.size()));
   }

    public static boolean suggestAI(PrintStream out, GameState state, int round, String suggester, Map<String, String> guess, String refuter, String cardShown){
        out.println("\n--------------------------------------------------");
        out.println("AI SUGGESTION REPORT");
        out.println("Round: " + round);
        out.println("Detective: " + suggester);

        String suspect = guess.get("Suspect");
        String weapon  = guess.get("Weapon");
        String room    = guess.get("Room");

        out.println("\n[THEORY]");
        out.printf("  Suspect : %s%n", suspect);
        out.printf("  Weapon  : %s%n", weapon);
        out.printf("  Room    : %s%n", room);

        // 2. SOFT SCORING (AI learning step)
        boostScore(state.suspectScore, suspect, 1);
        boostScore(state.weaponScore, weapon, 1);
        boostScore(state.roomScore, room, 1);

        // 3. REFUTATION HANDLING
        out.println("\n[REFUTATION]");

        boolean wasRefuted = (refuter != null && !refuter.isEmpty());

        if (wasRefuted) {
            out.println("Refuted by: " + refuter);
            if (cardShown != null && !cardShown.isEmpty()) {
                out.println("Card shown: " + cardShown);
                out.println("\n[DEDUCTION]");
                eliminateAI(state, cardShown, out);
            } else {
                out.println("Card shown: UNKNOWN");
            }   
        } else {
            out.println("No refutation possible");
        }

        // 4. OPTIONAL: inference feedback loop
        printTopCandidates(state, out);

        out.println("--------------------------------------------------");

        return wasRefuted;
    }

    private static void boostScore(Map<String, Integer> map, String key, int amount) {
        if (key == null || key.isEmpty()) return;
        map.put(key, map.getOrDefault(key, 0) + amount);
    }

    private static void eliminateAI(GameState state, String card, PrintStream out) {
        if (state.suspectScore.containsKey(card)) {
            state.suspectScore.put(card, -999);
            out.println("Eliminated suspect: " + card);
        }

        if (state.weaponScore.containsKey(card)) {
            state.weaponScore.put(card, -999);
            out.println("Eliminated weapon: " + card);
        }

        if (state.roomScore.containsKey(card)) {
            state.roomScore.put(card, -999);
            out.println("Eliminated room: " + card);
        }
    }

    private static void printTopCandidates(GameState state, PrintStream out) {
        out.println("\n[AI TOP CANDIDATES]");

        out.println("Suspect: " + pickBest(state.suspectScore));
        out.println("Weapon  : " + pickBest(state.weaponScore));
        out.println("Room    : " + pickBest(state.roomScore));
    }

    public static String pickBest(Map<String, Integer> map) {
        return map.entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse("UNKNOWN");
    }
}

