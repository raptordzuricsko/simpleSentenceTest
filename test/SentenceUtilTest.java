import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * run with junit by adding to classpath. If really making some sort of service, use appropriate gradle, etc
 */
public class SentenceUtilTest {

    @Test
    public void testSentenceParseApostrophe(){
        SentenceUtil sentenceUtil = new SentenceUtil();
        ParseResult parseResult = sentenceUtil.parseSentenceWithTreeSet("The super-quick darkbrown fox jumps over the lazy dog");
        assertEquals(11,parseResult.getLength());
        assertEquals("super-quick",parseResult.getLongestWord());
    }

    @Test
    public void testSentenceEmpty(){
        SentenceUtil sentenceUtil = new SentenceUtil();
        ParseResult parseResult = sentenceUtil.parseSentenceWithTreeSet(" ");
        assertEquals(0, parseResult.getLength());
    }

    @Test
    public void testSentenceNull() {
        SentenceUtil sentenceUtil = new SentenceUtil();
        ParseResult parseResult = sentenceUtil.parseSentenceWithTreeSet(null);
        assertEquals(0, parseResult.getLength());
    }
}
