package MScIT_TeamProject_TemplateProject.src;
public class Test{

    public static void main(String args[]) {
       GameData gd = new GameData();  
       gd.addOneAi1RoundWins();
       gd.addOneNoOfDraws();
       gd.addOneAi3RoundWins();
       gd.addOneNoOfRounds();
       gd.setOverallWinner(3);

       DatabaseAccess.uploadData(gd);
       System.out.println(DatabaseAccess.getAvgNoDraws());
       System.out.println(DatabaseAccess.getTotalNumerOfGames());
        

}





}