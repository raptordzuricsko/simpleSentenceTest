/**
 * Created by puphouse on 9/6/18.
 */
public class ParseResult {
    private int length;
    private String longestWord;
    public ParseResult(int length, String longestWord){
        this.length = length;
        this.longestWord = longestWord;
    }
    public ParseResult(){}

    public int getLength() {
        return length;
    }

    public String getLongestWord() {
        return longestWord;
    }
}
