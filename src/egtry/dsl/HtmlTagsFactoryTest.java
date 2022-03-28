package egtry.dsl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HtmlTagsFactoryTest {

    @Test
    void testCase1() {
        HtmlTagsFactory htmlTagsFactory = new HtmlTagsFactory("img", "https://www.w3schools.com/html/pic_trulli.jpg"
                , "", "", "", "");
        String expectedOutput = "<img src=\"https://www.w3schools.com/html/pic_trulli.jpg\"/>";
        String actualOutput = htmlTagsFactory.createTag();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void testCase2() {
        HtmlTagsFactory htmlTagsFactory = new HtmlTagsFactory("h1", "", "", "Hello", "", "");
        String expectedOutput = "<h1 >Hello</h1>";
        String actualOutput = htmlTagsFactory.createTag();
        assertEquals(expectedOutput,actualOutput);

    }

    @Test
    void testCase3() {
        HtmlTagsFactory htmlTagsFactory = new HtmlTagsFactory("p", "", "TIMENEWROMAN", "DIEDEUTSCHEMANSCHAFT", "", "");
        String expectedOutput = "<p style=\"font-family:TIMENEWROMAN;\">DIEDEUTSCHEMANSCHAFT</p>";
        String actualOutput = htmlTagsFactory.createTag();
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void testCase4() {
        HtmlTagsFactory htmlTagsFactory = new HtmlTagsFactory("a", "", "Arial", "GOOGLE"
                , "ORANGE", "http://google.com");
        String expectedOutput = "<a href=\"http://google.com\" style=\"font-family:Arial;color:\"ORANGE\";\">GOOGLE</a>";
        String actualOutput = htmlTagsFactory.createTag();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testCase5() {
        HtmlTagsFactory htmlTagsFactory = new HtmlTagsFactory("a", "", "Arial", "Good bye"
                , "", "");
        String expectedOutput = "<p style=\"font-family=Arial\">Good bye</p>\n";
        String actualOutput = htmlTagsFactory.createTag();
        assertNotEquals(expectedOutput, actualOutput);
    }

}