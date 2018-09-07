import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by puphouse on 9/6/18.
 */
public class SentenceUtil {
    public SentenceUtil(){}

    /**
     * parses a sentence. Things to consider
     * 1. is it a grammatically valid sentence?
     * 2. what sorts of punctuation are in it?
     * 3. can it be null or an empty string, and what should happen then
     * and with values
     * 1. what do in the event of a tie?
     * 2. are there any one word sentences?
     *
     * use spock instead, set up a real build file/microservice
     *
     * @param sentence
     * @return the length of the longest word and the longest word itself
     */
    public ParseResult parseSentence(String sentence){
        if(sentence == null || sentence.isEmpty()){
            return new ParseResult(0, "");
        }
        String[] words = sentence.split(" ");
        //fancy java 8 streams for
        Stream<String> wordStream = Arrays.stream(words).sorted(Comparator.comparingInt(String::length).reversed());
        String longestWord = wordStream.findFirst().get();
        //if need to expand parseResult, consider a list
        return new ParseResult(longestWord.length(), longestWord);
    }


    public ParseResult parseSentenceWithTreeSet(String sentence){
        if(sentence == null || sentence.isEmpty()){
            return new ParseResult(0, "");
        }
        String[] words = sentence.split(" ");
        Set<String> treeSet = new TreeSet<>(Comparator.comparing(String::length).reversed());
        for(String word : words){
            treeSet.add(word);
        }
        Iterator<String> iterator = treeSet.iterator();
        if(!iterator.hasNext()){
            return new ParseResult(0, "");
        }
        String firstResult = iterator.next();
        return new ParseResult(firstResult.length(), firstResult);
    }
}
