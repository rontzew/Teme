import java.util.ArrayList;
import java.util.Scanner;

public class MaxFrequency {

    //method filterSentence takes a string and eliminates all spaces or other characters that are not letters,
    // also moving all letters to lowercase, then returns an ArrayList:
    private static ArrayList<Character> filterSentence(Scanner sc){
        System.out.println("Insert sentence to count maximum occurrences of a character: ");
        StringBuilder wordsCopy = new StringBuilder(sc.nextLine());
        for(int m = 0; m < wordsCopy.length(); m++){
            if(!Character.isLetter(wordsCopy.charAt(m))){
                wordsCopy.deleteCharAt(m);
                m--;
            }
        }
        char[] chars = wordsCopy.toString().toCharArray();
        ArrayList<Character> returnArray = new ArrayList<>(chars.length);

        for(int n = 0; n < chars.length; n++){
            returnArray.add(chars[n]);
        }
        return returnArray;
    }

    //this method takes the ArrayList and find the most often encountered letter from the input of the user:
    public static void frequency(Scanner sc) {
        ArrayList<Character> sentence = filterSentence(sc);
        ArrayList<Character> mostCommonChars = new ArrayList<>();
        int maxAppearances = 0;
        while(sentence.size() > maxAppearances){
                char getLetter = sentence.get(0);
                int getSize = sentence.size();
                ArrayList<Character> oneChar = new ArrayList<>();
                oneChar.add(sentence.get(0));
                sentence.removeAll(oneChar);

                if(maxAppearances <= (getSize - sentence.size())) {
                    if(maxAppearances < (getSize - sentence.size())){
                        mostCommonChars.clear();
                        mostCommonChars.add(getLetter);
                        maxAppearances = getSize - sentence.size();
                    }else{
                        mostCommonChars.add(getLetter);
                    }
                }
        }
        System.out.println("Letters " + mostCommonChars + " have appeared the most, with " +
                  maxAppearances + " appearances each!");
    }
}
