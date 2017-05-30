
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * 
 */

/**
 * @author imendoza
 *
 */
public class TopPhrases {

	private static final Logger logger = Logger.getLogger(TopPhrases.class.getName());

    /**
     * The maximum number of phrases to be utilised.
     */
    private static final int DefaultLimit = 100000;
    
    private static final String Filename = "phrases.txt";

    public static void main(String... args) {

        InputStream inputStream = TopPhrases.class.getResourceAsStream(Filename);
        System.out.println("Top phrases from the file: " + getTopPhrases(inputStream, DefaultLimit));

    }

    
    private static Map<String, Integer> getTopPhrases(InputStream IS, int limite) {

        Map<String, Integer> topPhrases = new LinkedHashMap<>();

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS));
            String line = null;

//            Read every line of the file.
            while( (line=bufferedReader.readLine()) != null ) {

                //Split the line to get the phrases.
                String[] linePhrases = line.split("\\|");

                //Read every phrase.
                for (String phrase : linePhrases){

                    //Check if the phrase is already in the collection.
                    //If true, then increment the value by 1. Else add the phrase
                    //as the new entry to the collection.
                    if (topPhrases.containsKey(phrase)) {
                        topPhrases.put(phrase, topPhrases.get(phrase).intValue() + 1);
                    } else {
                        topPhrases.put(phrase, 1);
                    }
                }
            }

            //Sort the collection by Map value.
            //Limit the collection to 100000.
            topPhrases = topPhrases.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limite)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2)->v1, LinkedHashMap::new));

        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, e.toString(), e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.toString(), e);
        }

        return topPhrases;
    }

}
