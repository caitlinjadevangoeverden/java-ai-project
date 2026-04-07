import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class ClueProgram {
   static List<String> players = Arrays.asList("MissScarlett", "ColMustard", "MrsWhite", "MrGreen", "MrsPeacock", "ProfPlum");
   static Set<String> suspects = new LinkedHashSet<>(Arrays.asList("MissScarlett","ColMustard","MrsWhite","MrGreen","MrsPeacock","ProfPlum"));
   static Set<String> weapons = new LinkedHashSet<>(Arrays.asList("Knife","Candlestick","Revolver","Pipe","Rope","Wrench"));
   static Set<String> rooms = new LinkedHashSet<>(Arrays.asList("Library","Conservatory","Kitchen","DiningRoom","Hall","Ballroom","BilliardRoom","Lounge","Study"));
   static Map<String, Integer> suspectScore = new HashMap<>();
   static Map<String, Integer> weaponScore = new HashMap<>();
   static Map<String, Integer> roomScore = new HashMap<>();
   static final int IMPOSSIBLE = -999;
   static int currentRound = 0;
   static int lastPrintedRound = -1;

   public static void main(String[] args) {
      try {
         murder1();
         resetAll();
         murder3();
         resetAll();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void section(PrintStream out, String title) {
      out.println();
      out.println("======================================");
      out.println(" " + title.toUpperCase());
      out.println("======================================");
   }

   public static void reset() {
    suspects = new LinkedHashSet<>(Arrays.asList("MissScarlett","ColMustard","MrsWhite","MrGreen","MrsPeacock","ProfPlum"));
    weapons = new LinkedHashSet<>(Arrays.asList("Knife","Candlestick","Revolver","Pipe","Rope","Wrench"));
    rooms = new LinkedHashSet<>(Arrays.asList("Library","Conservatory","Kitchen","DiningRoom","Hall","Ballroom","BilliardRoom","Lounge","Study"));
   }

   public static void resetScores() {
      suspectScore.clear();
      weaponScore.clear();
      roomScore.clear();

      for (String s : suspects) suspectScore.put(s, 0);
      for (String w : weapons) weaponScore.put(w, 0);
      for (String r : rooms) roomScore.put(r, 0);
   }
   
   public static void resetAll() {
      reset();
      resetScores();
   }

   public static PrintStream createOut(String fileName) throws Exception {
    File dir = new File("output");
    dir.mkdirs(); // ensure folder exists
    return new PrintStream(new File(dir, fileName));
   }

   public static PrintStream createInputFile(String filename) throws FileNotFoundException {
      new File("output").mkdirs(); // ensure folder exists
      return new PrintStream(new File("output/" + filename));
   }

   public static void initializeOutput(PrintStream out) {
      section(out, "Clue Game Results");
   }

   public static void printEquals(PrintStream out, Set<String> group1, Set<String> group2) {
      for (String a : group1) {
         StringBuilder line = new StringBuilder();
         for (String b : group2) {
            if (a.equals(b)) {
               line.append("Equals(").append(a).append(",").append(b).append(") & ");
            } else {
               line.append("-Equals(").append(a).append(",").append(b).append(") & ");
            }
        }
        if (line.length() > 3) {
         out.println(line.substring(0, line.length() - 3) + ".");
         }
      }
   }

   public static void printAllEquals(PrintStream out) {
      List<Set<String>> groups = Arrays.asList(suspects, weapons, rooms);
      for (Set<String> g1 : groups) {
         for (Set<String> g2 : groups) {
            printEquals(out, g1, g2);
         }
      }
   }

   public static void printPredicate(PrintStream out, String predicate, Set<String> items) {
      StringBuilder line = new StringBuilder();
      for (String item : items) {
         line.append(predicate).append("(").append(item).append(") & ");
      }
      out.println(line.substring(0, line.length() - 3) + ".");
   }

   public static void printCardholders(PrintStream out) {
      Set<String> cardholders = new LinkedHashSet<>(suspects);
      cardholders.add("Casefile");
      printPredicate(out, "Cardholder", cardholders);
   }

   public static void printCardDistributionRule(PrintStream out) {
      Set<String> cardholders = new LinkedHashSet<>(suspects);
      cardholders.add("Casefile");
      
      StringBuilder line = new StringBuilder("all c (Card(c) <-> (");
      
      for (String p : cardholders) {
         line.append("HasCard(").append(p).append(", c) | ");
      }
      out.println(line.substring(0, line.length() - 3) + ")).");
   }


   public static void initialize(PrintStream out){
      
      section(out, "Information");
      out.println("%AUTHOR: Caitlin van Goeverden");
      out.println("clear(print_given).");
      out.println("set(binary_res).");
      out.println("set(detailed_history).");
      out.println("clear(print_kept).");
      out.println("clear(print_back_sub).");
      out.println("assign(max_seconds,10).");
      out.println("assign(stats_level,0).");
      out.println("formula_list(usable).");

      section(out, "Entities");
      printPredicate(out, "Player", suspects);
      printPredicate(out, "Suspect", suspects);
      printPredicate(out, "Weapon", weapons);
      printPredicate(out, "Room", rooms);
      printCardholders(out);

      section(out, "Equality Rules");
      printAllEquals(out);

      section(out, "Game Rules");
      //Rules about the game
      // 1. Every weapon is a card
      out.println("all w (Weapon(w) -> Card(w)).");
      
      // 2. Every room is a card
      out.println("all r (Room(r) -> Card(r)).");

      // 3. Every suspect is a card
      out.println("all s (Suspect(s) -> Card(s)).");

      // 4. HasCard() requires a cardholder and a card
      out.println("all p c (HasCard(p,c) -> (Cardholder(p) & Card(c))).");
      
      //5. The same card cant be held by the same person
      out.println("all p1 p2 c ((HasCard(p1,c) & -Equals(p1,p2) & Card(c) & Cardholder(p1) & Cardholder(p2)) -> -HasCard(p2,c)).");

      //6. If 2 different players have cards then cards are not the same
      out.println("all x1 x2 c1 c2 ((Cardholder(x1) & Cardholder(x2)& Card(c1) & Card(c2) & -Equals(x1,x2)) -> -Equals(c1,c2)).");
      
      //7. Declaring a murder
      out.println("all k w r (Murder(k,w,r) <-> (Suspect(k) & Weapon(w) & Room(r) & HasCard(Casefile, k) & HasCard(Casefile, w) & HasCard(Casefile, r))).");
      //no need out.println("all p c1 c2 c3 r c (Suggest(p,c1,c2,c3,r,c) -> (Cardholder(p) & Cardholder(r) & -Equals(p,r) & Card(c1) & Card(c2) & Card(c3) & -Equals(c1,c2) & -Equals(c2,c3) & -Equals(c1,c3) & (Equals(c1,c) | Equals(c2,c) | Equals(c3,c)))).");
      
      //8. If cardholder1 has a card1 and cardholder2 has card2 and cardholder1 != cardholder2 - > card1 != card2 
      out.println("all p1 p2 c1 c2 ((Cardholder(p1) & Cardholder(p2) & Card(c1) & Card(c2) & HasCard(p1,c1) & HasCard(p2,c2) & -Equals(p1,p2)) -> -Equals(c1,c2)).");
      out.println("all p1 p2 c1 c2 ((Cardholder(p1) & Cardholder(p2) & Card(c1) & Card(c2) & HasCard(p1,c1) & HasCard(p2,c2) & -Equals(c1,c2)) -> -Equals(p1,p2)).");
      
      //9. If there are multiple cards of the same type in the Casefile they must be the same card
      out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Weapon(k) & Weapon(w) & Weapon(r)) -> (Equals(k,w) & Equals(k,r) & Equals(w,r))).");
      out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Room(k) & Room(w) & Room(r)) -> (Equals(k,w) & Equals(k,r) & Equals(w,r))).");
      out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Suspect(k) & Suspect(w) & Suspect(r)) -> (Equals(k,w) & Equals(k,r) & Equals(w,r))).");
      
      //10. every card is held by 1 card holder
      printCardDistributionRule(out);
   }

   public static void setPlayer(PrintStream out, String p, String c1, String c2, String c3) {
      section(out, "Player Setup");
      out.println(p + " holds:");
      out.printf("  • %s%n", c1);
      out.printf("  • %s%n", c2);
      out.printf("  • %s%n", c3);
   }

   /*GAME RULES:
    * When a suggestion of three cards is made, the player to the left of the suggester
    * (clockwise) checks their private cards to see if any of the cards are part of the suggestion.
    * If so, the player must refute the suggestion by privately showing one of these refuting
    * cards to the suggester. If not, the player states that they cannot refute the suggestion, and
    * attention then turns to the next player clockwise. The next player does the same, either
    * refuting or not, and this continues clockwise until the first possible refutation, or until all
    * other players have stated that they cannot refute the suggestion.
    * If the refuter shows a card then call HasCard for one of the three cards
    * If a player is unable to refute than they do not have any of the three cards*/

   
   public static void suggest(PrintStream out, int round, String suggester, Map<String, String> guess, String refuter, String cardShown) {
      round(out, round);
      out.println("\n--------------------------------------------------");
      out.println("SUGGESTION REPORT");
      out.println("--------------------------------------------------");

      out.printf("Detective : %s%n", suggester);

      String suspect = guess.get("Suspect");
      String weapon  = guess.get("Weapon");
      String room    = guess.get("Room");

      out.println("\n[THEORY]");
      out.printf("  Suspect : %s%n", suspect);
      out.printf("  Weapon  : %s%n", weapon);
      out.printf("  Room    : %s%n", room);

      suggestEvidence(suspect, weapon, room, out);

      out.println("\n[REFUTATION]");

      if (refuter != null && !refuter.isEmpty()) {
         out.printf("Refuted by : %s%n", refuter);
         if (cardShown != null && !cardShown.isEmpty()) {
            out.printf("Card shown : %s%n", cardShown);
            out.println("\n[DEDUCTION]");
            eliminate(cardShown, out);
         } else {
            out.println("Card shown : (unknown)");
            out.println("\n[DEDUCTION]");
            out.println("Refutation occurred but no card information gained.");
         }
      } else {
         out.println("No refutation possible.");
         out.println("\n[DEDUCTION]\nAll elements gain suspicion weighting.");
      }
      checkInferences(out);
   
      if (isSolved()) {
         printSolution(out);
      }
      out.println("--------------------------------------------------\n");
      nextRound();
   }

   public static void checkInferences(PrintStream out) {

    if (suspects.size() == 1) {
        out.println("Inference: Murderer is " + suspects.iterator().next());
    }

    if (weapons.size() == 1) {
        out.println("Inference: Weapon is " + weapons.iterator().next());
    }

    if (rooms.size() == 1) {
        out.println("Inference: Room is " + rooms.iterator().next());
    }
   }

   public static void eliminate(String card, PrintStream out) {
      boolean eliminated = false;
      
      if (suspects.contains(card)) {
         suspects.remove(card);
         suspectScore.put(card, IMPOSSIBLE); // impossible now
         out.println("Eliminated suspect: " + card);
         eliminated = true;
      }

      if (weapons.contains(card)) {
         weapons.remove(card);
         weaponScore.put(card, IMPOSSIBLE);
         out.println("Eliminated weapon: " + card);
         eliminated = true;
      }

      if (rooms.contains(card)) {
        rooms.remove(card);
        roomScore.put(card, IMPOSSIBLE);
        out.println("Eliminated room: " + card);
        eliminated = true;
      }

      if (!eliminated) {
         out.println("No new eliminations.");
      }
   }

   public static void suggestEvidence(String suspect, String weapon, String room, PrintStream out) {
      
      suspectScore.put(suspect, suspectScore.getOrDefault(suspect, 0) + 2);
      weaponScore.put(weapon, weaponScore.getOrDefault(weapon, 0) + 2);
      roomScore.put(room, roomScore.getOrDefault(room, 0) + 2);

      out.println("Evidence added:");
      out.println(" + suspect: " + suspect);
      out.println(" + weapon: " + weapon);
      out.println(" + room: " + room);
   }

   public static void inferSolution(PrintStream out) {
      
      String bestSuspect = getBest(suspectScore);
      String bestWeapon = getBest(weaponScore);
      String bestRoom = getBest(roomScore);

      out.println("\nAI INFERENCE RESULT");
      out.println("--------------------------------");

      out.printf("%-20s : %s%n", "Most Likely Murderer", bestSuspect);
      out.printf("%-20s : %s%n", "Most Likely Weapon", bestWeapon);
      out.printf("%-20s : %s%n", "Most Likely Room", bestRoom);

      out.println("\nConfidence Scores:");
      out.println("Suspect score: " + suspectScore);
      out.println("Weapon score : " + weaponScore);
      out.println("Room score   : " + roomScore);
   }

   public static boolean isSolvedAI() {
      return getBest(suspectScore) != null && getBest(weaponScore) != null && getBest(roomScore) != null;
   }

   public static String getBest(Map<String, Integer> map) {
      return map.entrySet()
      .stream()
      .max(Map.Entry.comparingByValue())
      .map(Map.Entry::getKey)
      .orElse("UNKNOWN");
   }

   public static void printSolution(PrintStream out) {
      String murderer = getBest(suspectScore);
      String weapon = getBest(weaponScore);
      String room = getBest(roomScore);

      section(out, "AI Final Deduction");
      out.println("Murderer : " + murderer);
      out.println("Weapon   : " + weapon);
      out.println("Room     : " + room);

      out.println("\nConfidence:");
      out.printf("%-20s : %d%n", "Suspects", suspectScore.getOrDefault(murderer, 0));
      out.printf("%-20s : %d%n", "Weapons", weaponScore.getOrDefault(weapon, 0));
      out.printf("%-20s : %d%n", "Rooms", roomScore.getOrDefault(room, 0));
    }

   public static void accuse(PrintStream out, String accuserName, String murderer, String weapon, String room, boolean isCorrect){
      section(out, "Accusation");
      out.println("Accuser: " + accuserName);
      out.println("Suspected Murderer: " + murderer);
      out.println("Weapon Used       : " + weapon);
      out.println("Crime Scene       : " + room);
      out.println("--------------------------------------");

      if (isCorrect) {
        out.println("CASE SOLVED");
        out.println();
        out.println("The murderer is " + murderer + ", who used the " + weapon + " in the " + room + ".");
        out.println();
      } else {
        out.println("INCORRECT ACCUSATION");
        out.println("Case still under investigation...");
      }

    out.println("======================================");
    out.println();
   }

   public static boolean isSolved() {
    return suspects.size() == 1 &&
           weapons.size() == 1 &&
           rooms.size() == 1;
   }

   public static void runMurder(String name,String player, String c1, String c2, String c3,Consumer<PrintStream> actions) throws Exception {
      File dir = new File("output");
      dir.mkdirs();
      PrintStream result = createOut(name + "_results.txt");
      initializeOutput(result); 
      PrintStream input = createInputFile(name + "_input.txt");
      initialize(input);
      input.close();

      setPlayer(result, player, c1, c2, c3);

      actions.accept(result);

      result.close();
   }

   public static void divider(PrintStream out) {
      out.println("\n--------------------------------------------------\n");
   }

   public static void round(PrintStream out, int roundNum) {
      if (roundNum != lastPrintedRound) {
         out.println();
         out.println("*************** ROUND " + roundNum + " ***************");
         lastPrintedRound = roundNum;
      }
   }

   public static void nextRound() {
      currentRound++;
   }

   public static void murder1() throws Exception {
      //Murder 1 involves hard coded guesses as humans would play
      runMurder("murder1", "MissScarlett", "MrsWhite", "Library", "Study",result -> { //You are MissScarlett, and you have the MrsWhite, Library, and Study cards.
         divider(result);
         section(result, "MURDER 1");
         
        // ROUND 1: GUESSES
         Map<String, String> guess1 = Map.of("Suspect", "MissScarlett","Weapon", "Rope","Room", "Lounge");
         suggest(result, currentRound,"MissScarlett",guess1,"ColMustard","MissScarlett");
         Map<String, String> guess2 = Map.of("Suspect", "MrsPeacock","Weapon", "Pipe","Room", "DiningRoom");
         suggest(result, currentRound,"ColMustard",guess2,"MrsPeacock","");

         // ROUND 2 — INVESTIGATION
         suggest(result, currentRound, "MrsWhite", Map.of("Suspect", "ColMustard", "Weapon", "Revolver", "Room", "Ballroom"), "MrsPeacock", "");
         suggest(result, currentRound, "MrGreen",Map.of("Suspect", "MrsWhite", "Weapon", "Knife", "Room", "Ballroom"),"ProfPlum","");
         suggest(result, currentRound, "MrsPeacock",Map.of("Suspect", "MrGreen", "Weapon", "Candlestick", "Room", "DiningRoom"),"MrsWhite","");
         suggest(result, currentRound, "ProfPlum",Map.of("Suspect", "MrsWhite", "Weapon", "Wrench", "Room", "Study"),"MissScarlett","MrsWhite" );

         // ROUND 3 — HIGH SIGNAL ELIMINATION PHASE
         suggest(result, currentRound, "MissScarlett", Map.of("Suspect", "ProfPlum", "Weapon", "Rope", "Room", "Conservatory"),"ColMustard","ProfPlum");
         suggest(result, currentRound, "ColMustard", Map.of("Suspect", "MrsPeacock", "Weapon", "Rope", "Room", "Ballroom"), "MrsWhite", "");
         suggest(result, currentRound, "MrsWhite", Map.of("Suspect", "ColMustard", "Weapon", "Candlestick", "Room", "Study"), "MrGreen", "" );
         suggest(result, currentRound, "MrGreen", Map.of("Suspect", "MrsPeacock", "Weapon", "Knife", "Room", "DiningRoom"), "MrsPeacock","");
         suggest(result, currentRound, "MrsPeacock", Map.of("Suspect", "ColMustard", "Weapon", "Pipe", "Room", "DiningRoom"), "ProfPlum", "");
         suggest(result, currentRound, "ProfPlum", Map.of("Suspect", "MrsWhite", "Weapon", "Knife", "Room", "Conservatory"), "MrsWhite","");

         // FINAL EXPLORATION LOOP 
         suggest(result, currentRound, "MissScarlett", Map.of("Suspect", "MrsPeacock", "Weapon", "Knife", "Room", "Lounge"), "ColMustard", "Lounge");
         suggest(result, currentRound, "ColMustard", Map.of("Suspect", "MrsPeacock", "Weapon", "Knife", "Room", "DiningRoom"), "MrsWhite", "");
         suggest(result, currentRound, "MrsWhite", Map.of("Suspect", "MrsPeacock", "Weapon", "Wrench", "Room", "Hall"), "MrGreen", "");
         suggest(result, currentRound, "MrGreen", Map.of("Suspect", "MrsWhite", "Weapon", "Pipe", "Room", "Conservatory"), "ProfPlum", "");
         suggest(result, currentRound, "MrsPeacock", Map.of("Suspect", "MissScarlett", "Weapon", "Pipe", "Room", "Hall"), "ColMustard", "");
         suggest(result, currentRound, "ProfPlum", Map.of("Suspect", "MrsPeacock", "Weapon", "Pipe", "Room", "Ballroom"), "", "");
         suggest(result, currentRound, "MrsWhite", Map.of("Suspect", "MrsPeacock", "Weapon", "Pipe", "Room", "Study"), "MissScarlett", "Study");
         suggest(result, currentRound, "MrGreen", Map.of("Suspect", "MrsWhite", "Weapon", "Pipe", "Room", "Study"), "MissScarlett", "MrsWhite");
         suggest(result, currentRound, "MrsPeacock", Map.of("Suspect", "MrsWhite", "Weapon", "Pipe", "Room", "Study"), "MissScarlett", "MrsWhite");
         suggest(result, currentRound, "ProfPlum", Map.of("Suspect", "MrsPeacock", "Weapon", "Pipe", "Room", "Kitchen"), "MrGreen", "");

         // ACCUSATION
         accuse(result, "MissScarlett", "MrsPeacock", "Pipe", "BilliardRoom", true);

         printSolution(result);
      });
   }

   public static void murder3() throws Exception {
      
      runMurder("murder3", "MrsPeacock", "ProfPlum", "Conservatory", "Kitchen", result -> {   
         
         GameState state = new GameState();
         divider(result);  
         section(result, "MURDER 3 - DYNAMIC AI ENGINE");
         int round = 1; 
         for (int i = 1; i <= 8; i++) {

            Map<String, String> guess = buildBestGuess(state);
            String suggester = getNextPlayer(i);

            String refuter = simulateRefuter(guess);
            String cardShown = simulateCardShown(guess, refuter);

            boolean wasRefuted = suggestAndTrack(result, state, round, suggester, guess, refuter, cardShown);

            if (!wasRefuted) {
               result.println(">> Strong inference: possible case file cards.");
            }

            round++;
         }
         
         String murderer = pickBest(state.suspectScore);
         String weapon = pickBest(state.weaponScore);
         String room = pickBest(state.roomScore);

         accuse(result, "AI", murderer, weapon, room, true);

         printSolution(result);
      });
   }

   public static Map<String, String> buildBestGuess(GameState state) {
    return Map.of("Suspect", pickBest(state.suspectScore), "Weapon", pickBest(state.weaponScore), "Room", pickBest(state.roomScore));
   }

   public static String pickBest(Map<String, Integer> map) {
      return map.entrySet()
      .stream()
      .max(Map.Entry.comparingByValue())
      .map(Map.Entry::getKey)
      .orElse("UNKNOWN");
   }

   public static boolean suggestAndTrack(PrintStream out, GameState state, int round, String suggester, Map<String, String> guess, String refuter, String cardShown) {
      
      suggest(out, round, suggester, guess, refuter, cardShown);
    
      // update scores
      state.suspectScore.put(guess.get("Suspect"), state.suspectScore.getOrDefault(guess.get("Suspect"), 0) + 2);
      state.weaponScore.put( guess.get("Weapon"), state.weaponScore.getOrDefault(guess.get("Weapon"), 0) + 2);
      state.roomScore.put(guess.get("Room"), state.roomScore.getOrDefault(guess.get("Room"), 0) + 2);

      return refuter != null && !refuter.isEmpty();
   }

   public static String getNextPlayer(int i) {
      return players.get(i % players.size());
   }

   public static String simulateRefuter(Map<String, String> guess) {
      if (Math.random() < 0.4) return "";
      return players.get((int)(Math.random() * players.size()));
   }

   public static String simulateCardShown(Map<String, String> guess, String refuter) {
      if (refuter == null || refuter.isEmpty()) return "";
      
      List<String> cards = Arrays.asList( guess.get("Suspect"), guess.get("Weapon"), guess.get("Room"));
      return cards.get((int)(Math.random() * cards.size()));
   }



}//end of class