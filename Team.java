import java.util.ArrayList;
import java.util.List;
record Affiliation(String name, String type, String countryCode){
    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}
public class Team <T extends Player, S>{
    private String teamName;
    private List<T> teamMembers = new ArrayList<>();// good practice
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalDraws = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t){
        if(!teamMembers.contains(t)){
            teamMembers.add(t);
        }
    }
    public void listTeamMembers(){
        System.out.print(teamName + "Roster: ");
        System.out.println(affiliation == null ? "" : " Affiliation: "+affiliation);
        for(T t : teamMembers){
            System.out.println(t.name());
        }
    }
    public int ranking(){
        return (totalLosses*2)+ totalDraws +1;
    }

    public String setScore(int ourScore, int theirScore){
        String message ;
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
