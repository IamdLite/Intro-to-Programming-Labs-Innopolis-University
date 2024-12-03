import java.util.ArrayList;
import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {

        /*  Task 1 */
        ArrayList<Integer> generatedNumbers = generateRandomInt(10, -100, 100);
        generatedNumbers
            .stream()
            .filter((n) -> (n%3==0))
            .map(n -> Math.abs(n))
            .forEach(n -> System.out.println(n));
        
        System.out.println("-----");
        generatedNumbers.forEach(n -> System.out.println(n));


        /* Task 2 */
        ArrayList<String> randStrings = generateStrings(5);
            randStrings
            .stream()
            .filter(n -> n != "")
            .distinct()
            .forEach(n -> System.out.println(n));
        

    }       

    public static ArrayList<Integer> generateRandomInt(int number, int origin, int bound){
        ArrayList<Integer> generatedNumbers = new ArrayList<>();
        Random randomInt = new Random();

        while(number != 0){
            generatedNumbers.add(randomInt.nextInt(origin, bound));
            number--;
        }

        return generatedNumbers;
    }

    public static ArrayList<String> generateStrings(int size){
        ArrayList<String> randStrings = new ArrayList<>();
        
        
        while(size != 0){
            String fullString = getWordPart() + 
            getWordPart() +
            getWordPart() + 
            getWordPart() + 
            getWordPart() + 
            getWordPart() +
            getIntPart();
            
            randStrings.add(fullString);
            randStrings.add(fullString);
            size--;
        }
        return randStrings;
    }

    private static String getWordPart(){
        Random random = new Random();
        return random.nextInt(-1,2) == 1 ?  String.valueOf((char)(random.nextInt(1, 27) + 'a' - 1)) : "" ;
    }

    private static String getIntPart(){
        Random random = new Random();
        return random.nextInt(-1,2) == 1 ? Integer.toString(random.nextInt(0, 1000)) : "";
    }
}



