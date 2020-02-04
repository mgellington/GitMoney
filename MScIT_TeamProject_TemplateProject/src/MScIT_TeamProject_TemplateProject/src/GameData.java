package MScIT_TeamProject_TemplateProject.src;
public class GameData{
    private int noOfDraws, noOfRounds, overallWinner, userRoundWins, ai1RoundWins, ai2RoundWins, ai3RoundWins, ai4RoundWins;

    public GameData(){
        /*
        * all the variables that will be required in order to store the game data
        *
        * values are initiated to 0 so if all the ai players arent used the value isnt null for when 
        * uploading to database as this might cause issues
        *
        * these can then be uploaded to the database at the end of each game and reset
        * getters and setters generated to acess and update data
        */
        noOfDraws = 0;
        noOfRounds = 0;
        overallWinner = 0;
        userRoundWins = 0;
        ai1RoundWins = 0;
        ai2RoundWins = 0;
        ai3RoundWins = 0;
        ai4RoundWins = 0;
    }
    public void resetValues(){
        this.noOfDraws = 0;
        this.noOfRounds = 0;
        this.overallWinner = 0;
        this.userRoundWins = 0;
        this.ai1RoundWins = 0;
        this.ai2RoundWins = 0;
        this.ai3RoundWins = 0;
        this.ai4RoundWins = 0;
    }
    public void setNoOfDraws(int one){
        this.noOfDraws = one;
    }

    public void setNoOfRounds(int one){
        this.noOfRounds = one;
    }
    public void setOverallWinner(int one){
        this.overallWinner = one;
    }
    public void setUserRounds(int one){
        this.userRoundWins = one;
    }
    public void setAi1RoundWins(int one){
        this.ai1RoundWins = one;
    }
    public void setAi2RoundWins(int one){
        this.ai2RoundWins = one;
    }
    public void setAi3RoundWins(int one){
        this.ai3RoundWins = one;
    }
    public void setAi4RoundWins(int one){
        this.ai4RoundWins = one;
    }
    public int getNoOfDraws(){
        return this.noOfDraws;
    }
    public int getNoOfRounds(){
        return this.noOfRounds;
    }
    public int getOverallWinner(){
        return this.overallWinner;
    }
    public int getUserRoundWins(){
        return this.userRoundWins;
    }
    public int getAi1RoundWins(){
        return this.ai1RoundWins;
    }
    public int getAi2RoundWins(){
        return this.ai2RoundWins;
    }
    public int getAi3RoundWins(){
        return this.ai3RoundWins;
    }
    public int getAi4RoundWins(){
        return this.ai4RoundWins;
    }


}