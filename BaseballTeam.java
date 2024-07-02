import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {
    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();// good practice
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalDraws = 0;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }
    public void addTeamMember(BaseballPlayer player){
        if(!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }
    public void listTeamMembers(){
        System.out.println(teamName + "Roster: ");
        System.out.println(teamMembers);
    }
    public int ranking(){
        return (totalLosses*2)+ totalDraws +1;
    }

    public String setScore(int ourScore, int theirScore){
        String message = "lost to";
        if(ourScore> theirScore){
            totalWins++;
            message = "win";
        } else if(ourScore==theirScore){
            totalDraws++;
            message="tied";
        } else{
            totalLosses++;
            message="loss";
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
