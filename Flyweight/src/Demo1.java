import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Demo1 {
    public static void main(String[] args) {
        User user1 = new User("John smith");
        User user2 = new User("Jane smith");
    }
}

class User
{
    static List<String> strings = new ArrayList<>();
    private int [] names;
    public User(String fullName){
        Function<String,Integer> getOrAdd = (String s)->{
            int index = strings.indexOf(s);
            if(index >-1){
                return index;
            }else{
                strings.add(s);
                return strings.size()-1;
            }
        };
        names = Arrays.stream(fullName.split(" "))
                .mapToInt(s-> getOrAdd.apply(s))
                .toArray();
    }
}
