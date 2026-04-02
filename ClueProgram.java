/********************************************************
 Programming Assignment 2
 JavaProgramFinalProgrammingAssignment.java                
 4/22/2023          
 Purpose:  Clue
*********************************************************/
import java.io.*;
import java.util.*;
import java.io.PrintWriter;

public class ClueProgram {
   // static String[] players = { "ProfessorPlum", "MrsWhite", "MrGreen", "MrsPeacock", "MissScarlett", "ColMustard" };
   // static String[] CardHolders = { "ProfessorPlum", "MrsWhite", "MrGreen", "MrsPeacock", "MissScarlett", "Colonel Mustard", "Casefile" };
   // static String[] Rooms = { "Library", "Conservatory", "Kitchen", "DiningRoom", "Hall", "Ballroom", "BilliardRoom", "Lounge", "Study" };
   // static String[] Weapons = { "Knife", "Candlestick", "Revolver", "Rope", "LeadPipe", "Wrench" };

   //make circular list
   static String[] players = { "ProfessorPlum", "MrsWhite", "MrGreen", "MrsPeacock", "MissScarlett", "ColMustard","ProfessorPlum", "MrsWhite", "MrGreen", "MrsPeacock", "MissScarlett", "ColMustard" };

   public static void main(String[] args) throws IOException {
      PrintStream o = new PrintStream(new File("inputmurder3.txt"));
      PrintStream console = System.out;
      System.setOut(o);
      //murder1();
      //murder2();
      murder3();
      //murder4();
      o.close();
   }

   public static void initialize(String p1, String p2, String p3, String p4, String p5, String p6) {
      System.out.println("%AUTHORS: (Kevin, Caitlin, Jacob).");
      System.out.println("clear(print_given).");
      System.out.println("set(binary_res).");
      System.out.println("set(detailed_history).");
      System.out.println("clear(print_kept).");
      System.out.println("clear(print_back_sub).");
      System.out.println("assign(max_seconds,10).");
      System.out.println("assign(stats_level,0).");
        
      System.out.println("formula_list(usable).");
      
      //redundant with suspects list?
      //System.out.println("Player(MissScarlet) & Player(ColMustard) & Player(MrsWhite) & Player(MrGreen) & Player(MrsPeacock) & Player(ProfessorPlum).");
      System.out.println("Cardholder(MissScarlet) & Cardholder(ColMustard) & Cardholder(MrsWhite) & Cardholder(MrGreen) & Cardholder(MrsPeacock) & Cardholder(ProfessorPlum) & Cardholder(Casefile).");
      System.out.println("Suspect(MissScarlet) & Suspect(ColMustard) & Suspect(MrsWhite) & Suspect(MrGreen) & Suspect(MrsPeacock) & Suspect(ProfessorPlum).");
      System.out.println("Weapon(Knife) & Weapon(Candlestick) & Weapon(Revolver) & Weapon(Pipe) & Weapon(Rope) & Weapon(Wrench).");
      System.out.println("Room(Library) & Room(Conservatory) & Room(Kitchen) & Room(DiningRoom) & Room(Hall) & Room(BallRoom) & Room(BilliardRoom) & Room(Lounge) & Room(Study).");

        
      /* Equals statements for Characters: */
      //Equals methods for MissScarlet
      System.out.println("Equals(MissScarlet,MissScarlet) & -Equals(MissScarlet,ColMustard) & -Equals(MissScarlet,MrsWhite) & -Equals(MissScarlet,MrGreen) & -Equals(MissScarlet,MrsPeacock) & -Equals(MissScarlet,ProfessorPlum).");
      System.out.println("-Equals(MissScarlet,Knife) & -Equals(MissScarlet,Candlestick) & -Equals(MissScarlet,Revolver) & -Equals(MissScarlet,Pipe) & -Equals(MissScarlet,Rope) & -Equals(MissScarlet,Wrench).");
      System.out.println("-Equals(MissScarlet,Library) & -Equals(MissScarlet,Conservatory) & -Equals(MissScarlet,Kitchen) & -Equals(MissScarlet,DiningRoom) & -Equals(MissScarlet,Hall) & -Equals(MissScarlet,BallRoom) & -Equals(MissScarlet,BilliardRoomRoom) & -Equals(MissScarlet,Lounge) & -Equals(MissScarlet,Study).");

      //Equals methods for ColMustard
      System.out.println("Equals(ColMustard,ColMustard) & -Equals(ColMustard,MissScarlet) & -Equals(ColMustard,MrsWhite) & -Equals(ColMustard,MrGreen) & -Equals(ColMustard,MrsPeacock) & -Equals(ColMustard,ProfessorPlum).");
      System.out.println("-Equals(ColMustard,Knife) & -Equals(ColMustard,Candlestick) & -Equals(ColMustard,Revolver) & -Equals(ColMustard,Pipe) & -Equals(ColMustard,Rope) & -Equals(ColMustard,Wrench).");
      System.out.println("-Equals(ColMustard,Library) & -Equals(ColMustard,Conservatory) & -Equals(ColMustard,Kitchen) & -Equals(ColMustard,DiningRoom) & -Equals(ColMustard,Hall) & -Equals(ColMustard,BallRoom) & -Equals(ColMustard,BilliardRoomRoom) & -Equals(ColMustard,Lounge) & -Equals(ColMustard,Study).");
    
      //Equals methods for MrsWhite
      System.out.println("Equals(MrsWhite,MrsWhite) & -Equals(MrsWhite,MissScarlet) & -Equals(MrsWhite,ColMustard) & -Equals(MrsWhite,MrGreen) & -Equals(MrsWhite,MrsPeacock) & -Equals(MrsWhite,ProfessorPlum).");
      System.out.println("-Equals(MrsWhite,Knife) & -Equals(MrsWhite,Candlestick) & -Equals(MrsWhite,Revolver) & -Equals(MrsWhite,Pipe) & -Equals(MrsWhite,Rope) & -Equals(MrsWhite,Wrench).");
      System.out.println("-Equals(MrsWhite,Library) & -Equals(MrsWhite,Conservatory) & -Equals(MrsWhite,Kitchen) & -Equals(MrsWhite,DiningRoom) & -Equals(MrsWhite,Hall) & -Equals(MrsWhite,BallRoom) & -Equals(MrsWhite,BilliardRoomRoom) & -Equals(MrsWhite,Lounge) & -Equals(MrsWhite,Study).");
    
      //Equals methods for MrGreen
      System.out.println("Equals(MrGreen,MrGreen) & -Equals(MrGreen,MissScarlet) & -Equals(MrGreen,ColMustard) & -Equals(MrGreen,MrsWhite) & -Equals(MrGreen,MrsPeacock) & -Equals(MrGreen,ProfessorPlum).");
      System.out.println("-Equals(MrGreen,Knife) & -Equals(MrGreen,Candlestick) & -Equals(MrGreen,Revolver) & -Equals(MrGreen,Pipe) & -Equals(MrGreen,Rope) & -Equals(MrGreen,Wrench).");
      System.out.println("-Equals(MrGreen,Library) & -Equals(MrGreen,Conservatory) & -Equals(MrGreen,Kitchen) & -Equals(MrGreen,DiningRoom) & -Equals(MrGreen,Hall) & -Equals(MrGreen,BallRoom) & -Equals(MrGreen,BilliardRoomRoom) & -Equals(MrGreen,Lounge) & -Equals(MrGreen,Study).");

      //Equals methods for MrsPeacock
      System.out.println("Equals(MrsPeacock,MrsPeacock) & -Equals(MrsPeacock,MissScarlet) & -Equals(MrsPeacock,ColMustard) & -Equals(MrsPeacock,MrsWhite) & -Equals(MrsPeacock,MrGreen) & -Equals(MrsPeacock,ProfessorPlum).");
      System.out.println("-Equals(MrsPeacock,Knife) & -Equals(MrsPeacock,Candlestick) & -Equals(MrsPeacock,Revolver) & -Equals(MrsPeacock,Pipe) & -Equals(MrsPeacock,Rope) & -Equals(MrsPeacock,Wrench).");
      System.out.println("-Equals(MrsPeacock,Library) & -Equals(MrsPeacock,Conservatory) & -Equals(MrsPeacock,Kitchen) & -Equals(MrsPeacock,DiningRoom) & -Equals(MrsPeacock,Hall) & -Equals(MrsPeacock,BallRoom) & -Equals(MrsPeacock,BilliardRoomRoom) & -Equals(MrsPeacock,Lounge) & -Equals(MrsPeacock,Study).");
      
      //Equals methods for ProfessorPlum
      System.out.println("Equals(ProfessorPlum,ProfessorPlum) & -Equals(ProfessorPlum,MissScarlet) & -Equals(ProfessorPlum,ColMustard) & -Equals(ProfessorPlum,MrsWhite) & -Equals(ProfessorPlum,MrGreen) & -Equals(ProfessorPlum,MrsPeacock).");
      System.out.println("-Equals(ProfessorPlum,Knife) & -Equals(ProfessorPlum,Candlestick) & -Equals(ProfessorPlum,Revolver) & -Equals(ProfessorPlum,Pipe) & -Equals(ProfessorPlum,Rope) & -Equals(ProfessorPlum,Wrench).");
      System.out.println("-Equals(ProfessorPlum,Library) & -Equals(ProfessorPlum,Conservatory) & -Equals(ProfessorPlum,Kitchen) & -Equals(ProfessorPlum,DiningRoom) & -Equals(ProfessorPlum,Hall) & -Equals(ProfessorPlum,BallRoom) & -Equals(ProfessorPlum,BilliardRoomRoom) & -Equals(ProfessorPlum,Lounge) & -Equals(ProfessorPlum,Study).");
      /* End of equals statements for Characters: */


      /* Equals statements for Weapons: */
      //Equals methods for Knife
      System.out.println("-Equals(Knife,ProfessorPlum) & -Equals(Knife,MissScarlet) & -Equals(Knife,ColMustard) & -Equals(Knife,MrsWhite) & -Equals(Knife,MrGreen) & -Equals(Knife,MrsPeacock).");
      System.out.println("Equals(Knife,Knife) & -Equals(Knife,Candlestick) & -Equals(Knife,Revolver) & -Equals(Knife,Pipe) & -Equals(Knife,Rope) & -Equals(Knife,Wrench).");
      System.out.println("-Equals(Knife,Library) & -Equals(Knife,Conservatory) & -Equals(Knife,Kitchen) & -Equals(Knife,DiningRoom) & -Equals(Knife,Hall) & -Equals(Knife,BallRoom) & -Equals(Knife,BilliardRoomRoom) & -Equals(Knife,Lounge) & -Equals(Knife,Study).");
   
      //Equals methods for CandleStick
      System.out.println("-Equals(CandleStick,ProfessorPlum) & -Equals(CandleStick,MissScarlet) & -Equals(CandleStick,ColMustard) & -Equals(CandleStick,MrsWhite) & -Equals(CandleStick,MrGreen) & -Equals(CandleStick,MrsPeacock).");
      System.out.println("Equals(CandleStick,CandleStick) & -Equals(CandleStick,Knife) & -Equals(CandleStick,Revolver) & -Equals(CandleStick,Pipe) & -Equals(CandleStick,Rope) & -Equals(CandleStick,Wrench).");
      System.out.println("-Equals(CandleStick,Library) & -Equals(CandleStick,Conservatory) & -Equals(CandleStick,Kitchen) & -Equals(CandleStick,DiningRoom) & -Equals(CandleStick,Hall) & -Equals(CandleStick,BallRoom) & -Equals(CandleStick,BilliardRoomRoom) & -Equals(CandleStick,Lounge) & -Equals(CandleStick,Study).");
   
      //Equals methods for Revolver
      System.out.println("-Equals(Revolver,ProfessorPlum) & -Equals(Revolver,MissScarlet) & -Equals(Revolver,ColMustard) & -Equals(Revolver,MrsWhite) & -Equals(Revolver,MrGreen) & -Equals(Revolver,MrsPeacock).");
      System.out.println("Equals(Revolver,Revolver) & -Equals(Revolver,Knife) & -Equals(Revolver,CandleStick) & -Equals(Revolver,Pipe) & -Equals(Revolver,Rope) & -Equals(Revolver,Wrench).");
      System.out.println("-Equals(Revolver,Library) & -Equals(Revolver,Conservatory) & -Equals(Revolver,Kitchen) & -Equals(Revolver,DiningRoom) & -Equals(Revolver,Hall) & -Equals(Revolver,BallRoom) & -Equals(Revolver,BilliardRoomRoom) & -Equals(Revolver,Lounge) & -Equals(Revolver,Study).");

      //Equals methods for Pipe
      System.out.println("-Equals(Pipe,ProfessorPlum) & -Equals(Pipe,MissScarlet) & -Equals(Pipe,ColMustard) & -Equals(Pipe,MrsWhite) & -Equals(Pipe,MrGreen) & -Equals(Pipe,MrsPeacock).");
      System.out.println("Equals(Pipe,Pipe) & -Equals(Pipe,Knife) & -Equals(Pipe,CandleStick) & -Equals(Pipe,Revolver) & -Equals(Pipe,Rope) & -Equals(Pipe,Wrench).");
      System.out.println("-Equals(Pipe,Library) & -Equals(Pipe,Conservatory) & -Equals(Pipe,Kitchen) & -Equals(Pipe,DiningRoom) & -Equals(Pipe,Hall) & -Equals(Pipe,BallRoom) & -Equals(Pipe,BilliardRoomRoom) & -Equals(Pipe,Lounge) & -Equals(Pipe,Study).");
      
      //Equals methods for Rope
      System.out.println("-Equals(Rope,ProfessorPlum) & -Equals(Rope,MissScarlet) & -Equals(Rope,ColMustard) & -Equals(Rope,MrsWhite) & -Equals(Rope,MrGreen) & -Equals(Rope,MrsPeacock).");
      System.out.println("Equals(Rope,Rope) & -Equals(Rope,Knife) & -Equals(Rope,CandleStick) & -Equals(Rope,Revolver) & -Equals(Rope,Pipe) & -Equals(Rope,Wrench).");
      System.out.println("-Equals(Rope,Library) & -Equals(Rope,Conservatory) & -Equals(Rope,Kitchen) & -Equals(Rope,DiningRoom) & -Equals(Rope,Hall) & -Equals(Rope,BallRoom) & -Equals(Rope,BilliardRoomRoom) & -Equals(Rope,Lounge) & -Equals(Rope,Study).");
   
      //Equals methods for Wrench
      System.out.println("-Equals(Wrench,ProfessorPlum) & -Equals(Wrench,MissScarlet) & -Equals(Wrench,ColMustard) & -Equals(Wrench,MrsWhite) & -Equals(Wrench,MrGreen) & -Equals(Wrench,MrsPeacock).");
      System.out.println("Equals(Wrench,Wrench) & -Equals(Wrench,Knife) & -Equals(Wrench,CandleStick) & -Equals(Wrench,Revolver) & -Equals(Wrench,Pipe) & -Equals(Wrench,Rope).");
      System.out.println("-Equals(Wrench,Library) & -Equals(Wrench,Conservatory) & -Equals(Wrench,Kitchen) & -Equals(Wrench,DiningRoom) & -Equals(Wrench,Hall) & -Equals(Wrench,BallRoom) & -Equals(Wrench,BilliardRoomRoom) & -Equals(Wrench,Lounge) & -Equals(Wrench,Study).");
      /* End of equals statements for Weapons: */


      /* Equals statements for Rooms: */
      //Equals statements for Library (Line1: rooms, Line2: weapons, Line3: characters)
      System.out.println("Equals(Library,Library) & -Equals(Library,Conservatory) & -Equals(Library,Kitchen) & -Equals(Library,DiningRoom) & -Equals(Library,Hall) & -Equals(Library,BallRoom) & -Equals(Library,BilliardRoomRoom) & -Equals(Library,Lounge) & -Equals(Library,Study).");
      System.out.println("-Equals(Library,Knife) & -Equals(Library,Candlestick) & -Equals(Library,Revolver) & -Equals(Library,Pipe) & -Equals(Library,Rope) & -Equals(Library,Wrench).");
      System.out.println("-Equals(Library,MissScarlet) & -Equals(Library,ColMustard) & -Equals(Library,MrsWhite) & -Equals(Library,MrGreen) & -Equals(Library,MrsPeacock) & -Equals(Library,ProfessorPlum).");

      //Equals statements for Conservatory (Line1: rooms, Line2: weapons, Line3: characters)
      System.out.println("Equals(Conservatory,Conservatory) & -Equals(Conservatory,Library) & -Equals(Conservatory,Kitchen) & -Equals(Conservatory,DiningRoom) & -Equals(Conservatory,Hall) & -Equals(Conservatory,BallRoom) & -Equals(Conservatory,BilliardRoomRoom) & -Equals(Conservatory,Lounge) & -Equals(Conservatory,Study).");
      System.out.println("-Equals(Conservatory,Knife) & -Equals(Conservatory,Candlestick) & -Equals(Conservatory,Revolver) & -Equals(Conservatory,Pipe) & -Equals(Conservatory,Rope) & -Equals(Conservatory,Wrench).");
      System.out.println("-Equals(Conservatory,MissScarlet) & -Equals(Conservatory,ColMustard) & -Equals(Conservatory,MrsWhite) & -Equals(Conservatory,MrGreen) & -Equals(Conservatory,MrsPeacock) & -Equals(Conservatory,ProfessorPlum).");

      //Equals statements for DiningRoom (Line1: rooms, Line2: weapons, Line3: characters)
      System.out.println("Equals(DiningRoom,DiningRoom) & -Equals(DiningRoom,Conservatory) & -Equals(DiningRoom,Kitchen) & -Equals(DiningRoom,Library) & -Equals(DiningRoom,Hall) & -Equals(DiningRoom,BallRoom) & -Equals(DiningRoom,BilliardRoomRoom) & -Equals(DiningRoom,Lounge) & -Equals(DiningRoom,Study).");
      System.out.println("-Equals(DiningRoom,Knife) & -Equals(DiningRoom,Candlestick) & -Equals(DiningRoom,Revolver) & -Equals(DiningRoom,Pipe) & -Equals(DiningRoom,Rope) & -Equals(DiningRoom,Wrench).");
      System.out.println("-Equals(DiningRoom,MissScarlet) & -Equals(DiningRoom,ColMustard) & -Equals(DiningRoom,MrsWhite) & -Equals(DiningRoom,MrGreen) & -Equals(DiningRoom,MrsPeacock) & -Equals(DiningRoom,ProfessorPlum)."); 
      
      //Equals statements for Hall (Line1: rooms, Line2: weapons, Line3: characters)
      System.out.println("Equals(Hall,Hall) & -Equals(Hall,Conservatory) & -Equals(Hall,Kitchen) & -Equals(Hall,DiningRoom) & -Equals(Hall,Library) & -Equals(Hall,BallRoom) & -Equals(Hall,BilliardRoomRoom) & -Equals(Hall,Lounge) & -Equals(Hall,Study).");
      System.out.println("-Equals(Hall,Knife) & -Equals(Hall,Candlestick) & -Equals(Hall,Revolver) & -Equals(Hall,Pipe) & -Equals(Hall,Rope) & -Equals(Hall,Wrench).");
      System.out.println("-Equals(Hall,MissScarlet) & -Equals(Hall,ColMustard) & -Equals(Hall,MrsWhite) & -Equals(Hall,MrGreen) & -Equals(Hall,MrsPeacock) & -Equals(Hall,ProfessorPlum).");

      //Equals statements for BallRoom (Line1: rooms, Line2: weapons, Line3: characters)
      System.out.println("Equals(BallRoom,BallRoom) & -Equals(BallRoom,Conservatory) & -Equals(BallRoom,Kitchen) & -Equals(BallRoom,DiningRoom) & -Equals(BallRoom,Hall) & -Equals(BallRoom,Library) & -Equals(BallRoom,BilliardRoomRoom) & -Equals(BallRoom,Lounge) & -Equals(BallRoom,Study).");
      System.out.println("-Equals(BallRoom,Knife) & -Equals(BallRoom,Candlestick) & -Equals(BallRoom,Revolver) & -Equals(BallRoom,Pipe) & -Equals(BallRoom,Rope) & -Equals(BallRoom,Wrench).");
      System.out.println("-Equals(BallRoom,MissScarlet) & -Equals(BallRoom,ColMustard) & -Equals(BallRoom,MrsWhite) & -Equals(BallRoom,MrGreen) & -Equals(BallRoom,MrsPeacock) & -Equals(BallRoom,ProfessorPlum).");
      
      //Equals statements for BilliardRoomRooms (Line1: rooms, Line2: weapons, Line3: characters)
      System.out.println("Equals(BilliardRoomRooms,BilliardRoomRooms) & -Equals(BilliardRoomRooms,Conservatory) & -Equals(BilliardRoomRooms,Kitchen) & -Equals(BilliardRoomRooms,DiningRoom) & -Equals(BilliardRoomRooms,Hall) & -Equals(BilliardRoomRooms,BallRoom) & -Equals(BilliardRoomRooms,Library) & -Equals(BilliardRoomRooms,Lounge) & -Equals(BilliardRoomRooms,Study).");
      System.out.println("-Equals(BilliardRoomRooms,Knife) & -Equals(BilliardRoomRooms,Candlestick) & -Equals(BilliardRoomRooms,Revolver) & -Equals(BilliardRoomRooms,Pipe) & -Equals(BilliardRoomRooms,Rope) & -Equals(BilliardRoomRooms,Wrench).");
      System.out.println("-Equals(BilliardRoomRooms,MissScarlet) & -Equals(BilliardRoomRooms,ColMustard) & -Equals(BilliardRoomRooms,MrsWhite) & -Equals(BilliardRoomRooms,MrGreen) & -Equals(BilliardRoomRooms,MrsPeacock) & -Equals(BilliardRoomRooms,ProfessorPlum).");
      
      //Equals statements for Lounge (Line1: rooms, Line2: weapons, Line3: characters)
      System.out.println("Equals(Lounge,Lounge) & -Equals(Lounge,Conservatory) & -Equals(Lounge,Kitchen) & -Equals(Lounge,DiningRoom) & -Equals(Lounge,Hall) & -Equals(Lounge,BallRoom) & -Equals(Lounge,BilliardRoomRoom) & -Equals(Lounge,Library) & -Equals(Lounge,Study).");
      System.out.println("-Equals(Lounge,Knife) & -Equals(Lounge,Candlestick) & -Equals(Lounge,Revolver) & -Equals(Lounge,Pipe) & -Equals(Lounge,Rope) & -Equals(Lounge,Wrench).");
      System.out.println("-Equals(Lounge,MissScarlet) & -Equals(Lounge,ColMustard) & -Equals(Lounge,MrsWhite) & -Equals(Lounge,MrGreen) & -Equals(Lounge,MrsPeacock) & -Equals(Lounge,ProfessorPlum).");
      
      //Equals statements for Study (Line1: rooms, Line2: weapons, Line3: characters)
      System.out.println("Equals(Study,Study) & -Equals(Study,Conservatory) & -Equals(Study,Kitchen) & -Equals(Study,DiningRoom) & -Equals(Study,Hall) & -Equals(Study,BallRoom) & -Equals(Study,BilliardRoomRoom) & -Equals(Study,Lounge) & -Equals(Study,Library).");
      System.out.println("-Equals(Study,Knife) & -Equals(Study,Candlestick) & -Equals(Study,Revolver) & -Equals(Study,Pipe) & -Equals(Study,Rope) & -Equals(Study,Wrench).");
      System.out.println("-Equals(Study,MissScarlet) & -Equals(Study,ColMustard) & -Equals(Study,MrsWhite) & -Equals(Study,MrGreen) & -Equals(Study,MrsPeacock) & -Equals(Study,ProfessorPlum).");
      /* End of equals statements for Rooms: */

      //Rules about the game
     
      // System.out.println("all w (Weapon(w)).");
      // System.out.println("all r (Room(r)).");
      // System.out.println("all s (Suspect(s)).");
      // System.out.println("all x (Cardholder(x)).");
      // System.out.println("all p (Player(p)).");
      // System.out.println("all c (Card(c)).");

      //every weapon is a card
      System.out.println("all w (Weapon(w) -> Card(w)).");
      
      //every room is a card
      System.out.println("all r (Room(r) -> Card(r)).");

      //every suspect is a card
      System.out.println("all s (Suspect(s) -> Card(s)).");

      //HasCard requires a cardholder and a card
      System.out.println("all p c (HasCard(p,c) -> (Cardholder(p) & Card(c))).");
      
      //the same card cant be held by the same person
      System.out.println("all p1 p2 c ((HasCard(p1,c) & -Equals(p1,p2) & Card(c) & Cardholder(p1) & Cardholder(p2)) -> -HasCard(p2,c)).");
      //System.out.println("all p1 p2 c ((-HasCard(p1,c) & -Equals(p1,p2) & Card(c) & Cardholder(p1) & Cardholder(p2)) -> HasCard(p2,c)).");

      //if 2 diff players have cards then cards are not the same
      System.out.println("all x1 x2 c1 c2 ((Cardholder(x1) & Cardholder(x2)& Card(c1) & Card(c2) & -Equals(x1,x2)) -> -Equals(c1,c2)).");
      
      //System.out.println("all w1 w2 (Weapon(w1) & Weapon(w2) & -Equals(w1,w2)).");
      //System.out.println("all r1 r2 (Room(r1) & Room(r2) & -Equals(r1,r2)).");
      //System.out.println("all p1 p2 (Player(p1) & Player(p2) & -Equals(p1,p2)).");
      //System.out.println("all c1 c2 c3 (Cardholder(Casefile) -> HasCard(Casefile, c1) & HasCard(Casefile, c2) & HasCard(Casefile, c3))."); //Casefile must hold three cards, and each must be from a different category (suspect, room, or weapon).
      //System.out.println("all x c z (Cardholder(x) & Card(c) & Cardholder(z) & HasCard(x,c) & -Equals(x,z) -> -HasCard(z,c))."); same as 178

      System.out.println("all k w r (Murder(k,w,r) <-> (Suspect(k) & Weapon(w) & Room(r) & HasCard(Casefile, k) & HasCard(Casefile, w) & HasCard(Casefile, r))).");
      //no need System.out.println("all p c1 c2 c3 r c (Suggest(p,c1,c2,c3,r,c) -> (Cardholder(p) & Cardholder(r) & -Equals(p,r) & Card(c1) & Card(c2) & Card(c3) & -Equals(c1,c2) & -Equals(c2,c3) & -Equals(c1,c3) & (Equals(c1,c) | Equals(c2,c) | Equals(c3,c)))).");
      
      //If cardholder1 has a card1 and cardholder2 has card2 and cardholder1 != cardholder2 - > card1 != card2 
      System.out.println("all p1 p2 c1 c2 ((Cardholder(p1) & Cardholder(p2) & Card(c1) & Card(c2) & HasCard(p1,c1) & HasCard(p2,c2) & -Equals(p1,p2)) -> -Equals(c1,c2)).");
      System.out.println("all p1 p2 c1 c2 ((Cardholder(p1) & Cardholder(p2) & Card(c1) & Card(c2) & HasCard(p1,c1) & HasCard(p2,c2) & -Equals(c1,c2)) -> -Equals(p1,p2)).");
      

      //If there are multiple cards of the same type in the Casefile they must be the same card
      System.out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Weapon(k) & Weapon(w) & Weapon(r)) -> (Equals(k,w) & Equals(k,r) & Equals(w,r))).");
      System.out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Room(k) & Room(w) & Room(r)) -> (Equals(k,w) & Equals(k,r) & Equals(w,r))).");
      System.out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Suspect(k) & Suspect(w) & Suspect(r)) -> (Equals(k,w) & Equals(k,r) & Equals(w,r))).");
      
      
      //if the casefile has weapon,room cards then it has a suspect card and vv
      // System.out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Weapon(k) & Room(r)) -> Suspect(w)).");
//       System.out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Suspect(w) & Room(r)) -> Weapon(k)).");
//       System.out.println("all k w r ((HasCard(Casefile, w) & HasCard(Casefile,k) & HasCard(Casefile, r) & Weapon(k) & Suspect(w)) -> Room(r)).");

      
      //System.out.println("all x s w r rf cs (Suggest(x,p,w,r,b) -> Cardholder(x) & Suspect(p) & Weapon(w) & Room(r) & Cardholder(rf) & Card(cs)).");
      
      
      //Accuse method
      //System.out.println("all a m w r b (Accuse(a,m,w,r,b) -> (Cardholder(a) & Suspect(m) & Weapon(w) & Room(r) & isCorrect(b) & -HasCard(a,m) & -HasCard(a,w) & -HasCard(a,r))).");
      
      //System.out.println("all p c (Cardholder(p) & Card(c) & HasCard(p,c) & -Equals(p,Casefile) -> -HasCard(Casefile,c))."); //Casefile can be a cardholder in itelf, need -same(Casefile,p)
      //System.out.println("all p c (Cardholder(Casefile) & Card(c) & HasCard(Casefile,c) & -Equals(p,Casefile) -> -HasCard(p,c)).");

      //every card is held by 1 card holder
      System.out.println("all c (Card(c) <-> (HasCard(ProfessorPlum, c) | HasCard(MrsWhite, c) | HasCard(MrGreen, c) | HasCard(MrsPeacock, c) | HasCard(MissScarlett, c) | HasCard(ColMustard, c) | HasCard(Casefile,c))).");
      
      System.out.println("end_of_list.");
      System.out.println("formula_list(sos).");
   }

   public static void setPlayer(String p, String c1, String c2, String c3){
      System.out.println("HasCard(" + p + "," + c1 + ").");
      System.out.println("HasCard(" + p + "," + c2 + ").");
      System.out.println("HasCard(" + p + "," + c3 + ").");
   }

   /*
    * When a suggestion of three cards is made, the player to the left of the suggester
    * (clockwise) checks their private cards to see if any of the cards are part of the suggestion.
    * If so, the player must refute the suggestion by privately showing one of these refuting
    * cards to the suggester. If not, the player states that they cannot refute the suggestion, and
    * attention then turns to the next player clockwise. The next player does the same, either
    * refuting or not, and this continues clockwise until the first possible refutation, or until all
    * other players have stated that they cannot refute the suggestion.
    */

    //If the refuter shows a card then call HasCard for one of the three cards
    //If a player is unable to refute than they do not have any of the three cards
    //

   public static void suggest(String suggesterName, String murderer, String weapon, String room, String refuter, String cardShown) {  
      int playerIndex=0;

      for (int i=0; i<6; i++){
         if (suggesterName.equals(players[i])) {
            playerIndex = i;
            break;
         }
         // if (refuter == players[i]) {
//             refuterIndex = i;
//          }
      }

   for (int i=playerIndex+1; i<(playerIndex+7); i++){
	   if (!refuter.equals("") && !cardShown.equals("")){
		   if (!(players[i].equals(refuter))){
            System.out.println("-HasCard(" + players[i] + "," + murderer+ ") & -HasCard(" + players[i] + "," + weapon + ") & -HasCard(" + players[i] + "," + room + ").");
         }
         else if ((players[i].equals(refuter))){
		      System.out.println("HasCard(" + refuter + "," + cardShown + ").");
            break;
         }
      }
      
      else if (refuter.equals("") && cardShown.equals("")){
         //System.out.println("(HasCard(Casefile,"+ murderer+") & (HasCard(+Casefile," + weapon+") & (HasCard(+Casefile," + room+")) | ((HasCard("+suggesterName +"," + murderer+") & (HasCard("+suggesterName +"," + weapon+") & (HasCard("+suggesterName +"," + room+")).");
         System.out.println("-HasCard(" + players[i] + "," + murderer+ ") & -HasCard(" + players[i] + "," + weapon + ") & -HasCard(" + players[i] + "," + room + ").");
      }
      
      else if (!refuter.equals("") && cardShown.equals("")){
         if (!(players[i].equals(refuter))){
            System.out.println("-HasCard(" + players[i] + "," + murderer+ ") & -HasCard(" + players[i] + "," + weapon + ") & -HasCard(" + players[i] + "," + room + ").");
         }
         else if ((players[i].equals(refuter)))
         System.out.println("HasCard(" + refuter + "," + murderer + ") | HasCard(" + refuter + "," + weapon + ") | HasCard(" + refuter + "," + room + ").");
         break;
         }
      
     }
    }




 //      if (!refuter.equals("") && !cardShown.equals("")){
//          System.out.println("HasCard(" + refuter + "," + cardShown + ").");
//       }
//       if(refuterIndex != playerIndex) {
//          while((playerIndex < 6) && (refuterIndex != playerIndex)) {
//             System.out.println("-HasCard(" + players[playerIndex] + "," + murderer+ ") & -HasCard(" + players[playerIndex] + "," + weapon + ") & -HasCard(" + players[playerIndex] + "," + room + ").");
//             playerIndex = (playerIndex + 1) % 6;
//          }
//       }
//       if(!refuter.equals("") && (refuterIndex == playerIndex)) {
//          System.out.println("HasCard(" + refuter + "," + murderer + ") | HasCard(" + refuter + "," + weapon + ") | HasCard(" + refuter + "," + room + ").");
//       }
// }

   public static void accuse(String accuserName, String murderer, String weapon, String room, boolean isCorrect){
      if (!isCorrect){
         System.out.println("-HasCard(Casefile,"+murderer+") | -HasCard(Casefile,"+weapon+") | -HasCard(Casefile,"+room+").");

       }
       else if (isCorrect){
          System.out.println("-Murder(" + murderer + "," + weapon + "," + room +").");
          System.out.println("end_of_list.");
          System.out.println("formula_list(passive).");
          System.out.println("Murder(" + murderer + "," + weapon + "," + room +").");
          System.out.println("end_of_list.");
       }
   }

   public static void murder1() {
      initialize("MissScarlet", "ColMustard", "MrsWhite", "MrGreen", "MrsPeacock", "ProfessorPlum");
      //In what order are the players sitting around the table?
      //also, print out all the background logic formulas about how the game is played

      setPlayer("MissScarlet", "MrsWhite", "Library", "Study");
      //You (Otter) are MissScarlet, and you have the MrsWhite, Library, and Study cards.

      suggest("MissScarlet", "MissScarlet", "Rope", "Lounge", "ColMustard", "MissScarlet");
      //MissScarlet suggests it was MissScarlet with a Rope in the Lounge. ColMustard refutes by showing
      //he has the MissScarlet Card --- Yes you can suggest yourself-

      suggest("ColMustard", "MrsPeacock", "Pipe", "DiningRoom", "MrsPeacock", "");
      //Next, ColMustard suggests MrsPeacock did it with a Pipe in the DiningRoom. MrsPeacock refutes it,
      //but she does not show her card to MissScarlet (who the KB is). Only ColMustard sees that card.

      suggest("MrsWhite", "ColMustard", "Revolver", "BallRoom", "MrsPeacock", "");
      //Next, MrsWhite suggests ColMustard did it with a Revolver in the BallRoom. MrsPeacock refutes
      //that, but again, she only shows her card to MrsWhite; MissScarlet does not see it.

      suggest("MrGreen", "MrsWhite", "Knife", "BallRoom", "ProfessorPlum", "");
      //Next, MrGreen suggests MrsWhite did it with a Knife in the BallRoom. ProfessorPlum refutes
      //that, but he only shows his card to MrGreen; MissScarlet does not see it.

      suggest("MrsPeacock", "MrGreen", "CandleStick", "DiningRoom", "MrsWhite", "");
      //Next, MrsPeacock suggests MrGreen did it with a CandleStick in the DiningRoom. MrsWhite
      //refutes that, but she only shows her card to MrsPeacock; MissScarlet does not see it.

      suggest("ProfessorPlum", "MrsWhite", "Wrench", "Study", "MissScarlet", "MrsWhite");
      //Next, ProfessorPlum suggests MrsWhite did it with a Wrench in the Study. MissScarlet (you) refutes
      //that, and she only shows her "MrsWhite" card to MrGreen; BUT, it is in your (MissScarletâ€™s) pile, so
      //you see the name/item/room on the card.}

      //Now a new round starts again with MissScarlet (you)
      suggest("MissScarlet", "ProfessorPlum", "Rope", "Conservatory", "ColMustard", "ProfessorPlum");
      suggest("ColMustard", "MrsPeacock", "Rope", "BallRoom", "MrsWhite", "");
      suggest("MrsWhite", "ColMustard", "CandleStick", "Study", "MrGreen", "");
      suggest("MrGreen", "MrsPeacock", "Knife", "DiningRoom", "MrsPeacock", "");
      suggest("MrsPeacock", "ColMustard", "Pipe", "DiningRoom", "ProfessorPlum", "");
      suggest("ProfessorPlum", "MrGreen", "Knife", "Conservatory", "MrsWhite", "");

      //Now another new round
      suggest("MissScarlet", "MrsPeacock", "Knife", "Lounge", "ColMustard", "Lounge");
      suggest("ColMustard", "MrsPeacock", "Knife", "DiningRoom", "MrsWhite", "");
      suggest("MrsWhite", "MrsPeacock", "Wrench", "Hall", "MrGreen", "");
      suggest("MrGreen", "MrsWhite", "Pipe", "Conservatory", "ProfessorPlum", "");
      suggest("MrsPeacock", "MissScarlet", "Pipe", "Hall", "ColMustard", "");
      suggest("ProfessorPlum", "MrsPeacock", "Pipe", "BallRoom", "", ""); // nobody refutes-

      //Now, another new round
      suggest("MissScarlet", "MrsWhite", "Pipe", "Hall", "MrsPeacock", "Hall");
      //ColMustard Passes
      suggest("MrsWhite", "MrsPeacock", "Pipe", "Hall", "MrsPeacock", "");
      //MrGreen Passes
      suggest("MrsPeacock", "MrsPeacock", "Pipe", "Hall", "", ""); //nobody refutes-
      //ProfessorPlum Passes

      //Now, another new round
      suggest("MissScarlet", "MrGreen", "Pipe", "Study", "MrsWhite", "MrGreen");
      suggest("ColMustard", "MrsPeacock", "Pipe", "BallRoom", "ProfessorPlum", "");
      suggest("MrsWhite", "MrsPeacock", "Pipe", "Study", "MissScarlet", "Study");
      suggest("MrGreen", "MrsWhite", "Pipe", "Study", "MissScarlet", "MrsWhite");
      suggest("MrsPeacock", "MrsWhite", "Pipe", "Study", "MissScarlet", "MrsWhite");
      suggest("ProfessorPlum", "MrsPeacock", "Pipe", "Kitchen", "MrGreen", "");

      accuse("MissScarlet", "MrsPeacock", "Pipe", "BilliardRoom", true);
      //And it turns out this accusation is true. End of Game-
      //Note: in the above Accusation, the true argument only means that the Casefile held those three cards.
      //It does NOT mean that the Accusationâ€™s murder charge was logically entailed by all the facts deduced
      //from the suggestions. That is what Otter is supposed to determine based on the outputs from all the
      //above method calls-
   }

   public static void murder2(){
      initialize("MrsPeacock", "MrGreen", "ProfessorPlum", "MrsWhite", "ColMustard", "MissScarlet");
      setPlayer("MrsPeacock", "ProfessorPlum", "Conservatory", "Kitchen");

      //ROUND 1
      suggest("MrsPeacock", "MrsPeacock", "Wrench", "Hall", "MrGreen", "MrsPeacock");
      suggest("MrGreen", "ColMustard", "Revolver", "DiningRoom", "ColMustard", "");
      suggest("ProfessorPlum", "MrGreen", "Pipe", "BilliardRoom", "ColMustard", "");
      suggest("MrsWhite", "ProfessorPlum", "Knife", "BilliardRoom", "MissScarlet", "");
      suggest("ColMustard", "MrsWhite", "Rope", "DiningRoom", "ProfessorPlum", "");
      suggest("MissScarlet", "ProfessorPlum", "CandleStick", "Kitchen", "MrsPeacock", "ProfessorPlum");

      //ROUND 2
      suggest("MrsPeacock", "MissScarlet", "Wrench", "Lounge", "MrGreen", "MissScarlet");
      suggest("MrGreen", "ColMustard", "Knife", "BilliardRoom", "ProfessorPlum", "");
      suggest("ProfessorPlum", "MrGreen", "Rope", "Kitchen", "MrsWhite", "");
      suggest("MrsWhite", "ColMustard", "Knife", "DiningRoom", "ColMustard", "");
      suggest("ColMustard", "MrGreen", "Revolver", "DiningRoom", "MissScarlet", "");
      suggest("MissScarlet", "MrsWhite", "Knife", "Lounge", "ProfessorPlum", "");

      //ROUND 3
      suggest("MrsPeacock", "ColMustard", "Knife", "Hall", "MrGreen", "Hall");
      suggest("MrGreen", "ColMustard", "Knife", "DiningRoom", "ProfessorPlum", "");
      suggest("ProfessorPlum", "ColMustard", "CandleStick", "Library", "MrsWhite", "");
      suggest("MrsWhite", "ProfessorPlum", "Revolver", "Lounge", "MissScarlet", "");
      suggest("ColMustard", "MrsPeacock", "Revolver", "Library", "MrGreen", "");
      suggest("MissScarlet", "ColMustard", "Revolver", "BilliardRoom", "", "");


      //ROUND 4
      suggest("MrsPeacock", "ColMustard", "Revolver", "Library", "ColMustard", "Library");

      //MrGreen passes
      suggest("ProfessorPlum", "MrGreen", "Revolver", "Library", "ColMustard", "");

      //MrsWhite passes
      suggest("ColMustard", "ColMustard", "Revolver", "Library", "", "");
      //MissScarlet passes

      //ROUND 5
      suggest("MrsPeacock", "MrsWhite", "Revolver", "Kitchen", "ProfessorPlum", "MrsWhite");
      suggest("MrGreen", "ColMustard", "Revolver", "BilliardRoom", "MissScarlet", "");
      suggest("ProfessorPlum", "ColMustard", "Revolver", "Kitchen", "MrsPeacock", "Kitchen");
      suggest("MrsWhite", "ProfessorPlum", "Revolver", "Kitchen", "MrsPeacock", "ProfessorPlum");
      suggest("ColMustard", "ProfessorPlum", "Revolver", "Kitchen", "MrsPeacock", "ProfessorPlum");
      suggest("MissScarlet", "ColMustard", "Revolver", "Ballroom", "MrsWhite", "");

      accuse("MrsPeacock", "ColMustard", "Revolver", "Study", true);
   }

   public static void murder3(){
      initialize("MrsPeacock", "MrGreen", "ProfessorPlum", "MrsWhite", "ColMustard", "MissScarlet");
		
      setPlayer("MrsPeacock", "ProfessorPlum", "Conservatory", "Kitchen");

      //ROUND 1
      suggest("MrsPeacock", "MrsPeacock", "Wrench", "Hall", "MrGreen", "MrsPeacock");
      suggest("MrGreen", "ColMustard", "Revolver", "DiningRoom", "ColMustard", "");
      suggest("ProfessorPlum", "MrGreen", "Pipe", "BilliardRoom", "ColMustard", "");
      suggest("MrsWhite", "ProfessorPlum", "Knife", "BilliardRoom", "MissScarlet", "");
      suggest("ColMustard", "MrsWhite", "Rope", "DiningRoom", "ProfessorPlum", "");
      suggest("MissScarlet", "ProfessorPlum", "CandleStick", "Kitchen", "MrsPeacock", "ProfessorPlum");

      //ROUND 2
      suggest("MrsPeacock", "MissScarlet", "Wrench", "Lounge", "MrGreen", "MissScarlet");
      suggest("MrGreen", "MrsWhite", "Wrench", "BilliardRoom", "ProfessorPlum", "");
      suggest("ProfessorPlum", "MrGreen", "Rope", "Kitchen", "MrsWhite", "");
      suggest("MrsWhite", "MissScarlet", "Knife", "DiningRoom", "ColMustard", "");
      suggest("ColMustard", "MrGreen", "Revolver", "DiningRoom", "MissScarlet", "");
      suggest("MissScarlet", "MrsWhite", "Knife", "Lounge", "ProfessorPlum", "");

      //ROUND 3
      accuse("MrsPeacock", "ColMustard", "Revolver", "Study", true);
   }

   public static void murder4(){
      initialize("MrsPeacock", "MrGreen", "ProfessorPlum", "MrsWhite", "ColMustard", "MissScarlet");
		
      setPlayer("MrsPeacock", "ProfessorPlum", "Conservatory", "Kitchen");

      //ROUND 1
      suggest("MrsPeacock", "MissScarlet", "Revolver", "BilliardRoom", "ColMustard", "MissScarlet");
      suggest("MrGreen", "MrsPeacock", "Revolver", "BilliardRoom", "MissScarlet", "");
      suggest("ProfessorPlum", "ColMustard", "Wrench", "Study", "ColMustard", "");
      suggest("MrsWhite", "MrGreen", "CandleStick", "BallRoom", "", "");
      accuse("ColMustard", "MrGreen", "CandleStick", "BallRoom", false);
      //ColMustard is now out of the game. He can only refute.
      suggest("MissScarlet", "ProfessorPlum", "Revolver", "Kitchen", "MrsPeacock", "Kitchen");

      //ROUND 2
      suggest("MrsPeacock", "ColMustard", "Wrench", "Kitchen", "ColMustard", "Wrench");
      suggest("MrGreen", "ProfessorPlum", "Revolver", "Study", "MrsPeacock", "ProfessorPlum");
      suggest("ProfessorPlum", "ColMustard", "CandleStick", "Kitchen", "MrsWhite", "");
      suggest("MrsWhite", "MissScarlet", "Knife", "DiningRoom", "ColMustard", "");
      //ColMustard is out of the game.
      suggest("MissScarlet", "ColMustard", "CandleStick", "BallRoom", "MrsWhite", "");


      //ROUND 3
      suggest("MrsPeacock", "ColMustard", "Revolver", "DiningRoom", "MissScarlet", "DiningRoom");
      suggest("MrGreen", "MrsPeacock", "Rope", "Hall", "", "");
      suggest("ProfessorPlum", "ColMustard", "Rope", "Library", "MrsWhite", "");
      suggest("MrsWhite", "MrsWhite", "Revolver", "Study", "ProfessorPlum", "");
      //ColMustard is out of the game.
      suggest("MissScarlet", "ColMustard", "Revolver", "Library", "ColMustard", "");


      //ROUND 4
      suggest("MrsPeacock", "MrsWhite", "Revolver", "Kitchen", "ProfessorPlum", "MrsWhite");
      suggest("MrGreen", "ColMustard", "Revolver", "BilliardRoom", "MissScarlet", "");
      suggest("ProfessorPlum", "MrsWhite", "Knife", "Study", "", "");
      accuse("MrsWhite", "MrsPeacock", "Rope", "Hall", false);
      //MrsWhite is now out of the game. She can only refute.
      //ColMustard is out of the game.
      suggest("MissScarlet", "ColMustard", "Revolver", "Ballroom", "MrsWhite", "");

      //Round 5
      suggest("MrsPeacock", "ColMustard", "Revolver", "Conservatory", "", "");
      accuse("MrGreen", "ColMustard", "Revolver", "Study", true);
   }
}