import java.util.ArrayList;
import java.util.HashMap;

public class savedNotes {
    static private HashMap<String,String> newNotes = new HashMap<>();
    static private int count=0;
    savedNotes(String n){
        if(!n.isEmpty()){
            count++;
            newNotes.put(ordinal(count),n);
        }
        else{
            return;
        }

    }
    public HashMap<String,String> getHashMap(){
        return newNotes;
    }
    private String ordinal(int number){
        if(number==1){
            return count+"st note";
        } else if (number ==2) {
            return count+"nd note";
        } else if (number==3) {
            return count+"rd note";
        }
        else return count+"th note";
    }

}
