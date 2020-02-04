package MScIT_TeamProject_TemplateProject.src;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

public class DatabaseAccess{
    

    
    public static void uploadData(GameData gd){
        int noOfDraws = gd.getNoOfDraws();
        int noOfRounds = gd.getNoOfRounds();
        int overallWinner = 1;
        int userRoundWins = gd.getUserRoundWins();
        int ai1RoundWins = gd.getAi1RoundWins();
        int ai2RoundWins = gd.getAi2RoundWins();
        int ai3RoundWins = gd.getAi3RoundWins();
        int ai4RoundWins = gd.getAi4RoundWins();
        Connection c = null;

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("dbc:postgresql://localhost/postgres","postgres", "postgres");

        } catch (Exception e) {

            e.printStackTrace();

            System.err.println(e.getClass().getName() + ": " + e.getMessage());

            System.exit(0);
        }

        try{
            String query = "INSERT INTO game_data \n" +
            /*
            * Adds the values stored in the GameData object when passed
            * The first value is an sql sequence whihc will increse
            * each time a new set is added and can be used to identify each game
            *
            * The value for overall winner has to be 1-5
            */
                "VALUES " +
                "(nextval('one'), " +
                noOfDraws + ", " +
                noOfRounds + ", " +
                overallWinner + ", " +
                userRoundWins + ", " +
                ai1RoundWins + ", " +
                ai2RoundWins + ", " +
                ai3RoundWins + ", " +
                ai4RoundWins + ");";
                
            java.sql.Statement stmt = c.createStatement();
            stmt.executeUpdate(query);
            System.out.print("Done");

            c.close();


        }catch(Exception e){
            e.printStackTrace();
        }


       

    }

    public static void retrieveGameData(){
        int totalGames = -1;
        int computerWins = -1;
        int userWins = -1;
        int avgNoDraws = -1;
        int maxRounds = -1;
        Connection c = null;

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("dbc:postgresql://localhost/postgres","postgres", "postgres");

        } catch (Exception e) {

            e.printStackTrace();

            System.err.println(e.getClass().getName() + ": " + e.getMessage());

            System.exit(0);
        }
        try{
            //Number of games played overall:
            String query = "SELECT COUNT(*)\n" +
            "FROM game_data";
           
                
            java.sql.Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            totalGames = rs.getInt("count");
            System.out.print("Done");
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            //How many times has the computer won:
            String query = "SELECT COUNT(*)\n" +
            "FROM game_data\n" +
            "WHERE overall_winner != 1";
           
                
            java.sql.Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            computerWins = rs.getInt("count");
            System.out.print("Done");

        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            //How many times has the user won:
            String query = "SELECT COUNT(*)\n" +
            "FROM game_data\n" +
            "WHERE overall_winner = 1";
           
                
            java.sql.Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            userWins = rs.getInt("count");
            System.out.print("Done");
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            //The average number of draws:
            String query = "SELECT AVG(no_of_draws)\n" +
            "FROM game_data\n";
           
                
            java.sql.Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            avgNoDraws = rs.getInt("avg");
            System.out.print("Done");

        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            //The largest number of rounds played:
            String query = "SELECT MAX(no_of_rounds)\n" +
            "FROM game_data\n";
           
                
            java.sql.Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            maxRounds = rs.getInt("max");
            System.out.print("Done");

            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
       System.out.println("" + totalGames + computerWins + userWins + avgNoDraws + maxRounds);

        


    }


}