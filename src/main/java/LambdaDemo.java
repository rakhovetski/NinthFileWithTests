import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;


public class LambdaDemo {

    //1 - 1
    public static final Function<String, Integer> getLengthOfString = String::length;

    //2 - 1
    public static final Function<String, Character> getFirstElem = (s) ->  Optional.ofNullable(s)
            .filter(x -> !x.isEmpty()).map(y -> y.charAt(0)).orElse(null);

    //3 - 1
    public static final Function<String, Boolean> haveSpace = (s) -> (!s.contains(" "));

    //4 - 1
    public static final Function<String, Integer> countWordsInString = (s)-> {
        if (s == null || s.isEmpty()) {
            return null;
        }
        List<String> arr = new ArrayList<>();
        String[] arr1 = s.split(",");

        for(String ss : arr1){
            if((!ss.equals("") && !ss.equals(" "))){
                arr.add(ss);
            }
        }
        return arr.size();
    };

    //5 - 1
    public static final Function<? super Human, Integer> getAgeOfHuman = Human::getAge;

    //6
    public static final BiFunction<? super Human, ? super Human, Boolean> equalsLastName = (h1, h2) -> h1.getSurname().equals(h2.getSurname());

    //7 - 1
    public static final Function<? super Human, String> makeStringHuman = (h) -> String.format("%s %s %s",h.getSurname(), h.getName(), h.getPatronymic());

    //8 - 1
    public static final Function<Human, Human> getOlder = (h) -> new Human(h.getSurname(),h.getName(), h.getPatronymic(), h.getAge() + 1, h.getGender());

    //9
    public static final EqualsHumansAndMaxAge equalsAge = (h1,h2,h3,maxAge) -> (h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge);


}


