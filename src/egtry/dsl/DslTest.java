package egtry.dsl;

import java.io.StringReader;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DslTest {

	@Test
	void testCase1() {
    	new Dsl(new StringReader("ADD PARAGRAPH WITH WITH FONT \"Arial\" AND TEXT \"Good bye\"\r\n"));
    	assertThrows(ParseException.class, () -> Dsl.parse());
	}
	
	@Test
	void testCase2() {
		Dsl.ReInit(new StringReader("ADD PARAGRAPH WITH FONT? \"Arial\" AND WITH COLOR \"ORANGE\" AND WITH TEXT \"HELLO_WORLD\""));
    	assertThrows(TokenMgrError.class, () -> Dsl.parse());
	}

	@Test
	void testCase3() {
		Dsl.ReInit(new StringReader("ADD IMAGE WITH SOURCE \"https://www.w3schools.com/html/pic_trulli.jpg\""));
		try {
			Dsl.parse();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(false, Dsl.status);
	}
	
	
	@Test
	void testCase4() {
		Dsl.ReInit(new StringReader("ADD HEADING WITH WITH TEXT \"HELLO WORLD!\""));
		assertThrows(ParseException.class, () -> Dsl.parse());
	}
	
	
	@Test
	void testCase5() {
		Dsl.ReInit(new StringReader("ADD LINK WITH FONT \"Arial\" AND WITH COLOR \"ORANGE\" AND WITH TEXT \"GOOGLE\" AND WITH LINK \"http://google.com\""));
		try {
			Dsl.parse();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(false, Dsl.status);
	}
	
	@Test
	void testCase6() {
		Dsl.ReInit(new StringReader("ADD PARAGRAPH WITH FONT \"TIME NEW ROMAN\" AND WITH TEXT \"DIE DEUTSCHE MANSCHAFT\""));
		try {
			Dsl.parse();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(false, Dsl.status);
	}
	
	@Test
	void testCase7() {
		Dsl.ReInit(new StringReader("ADD HEADING WITH"));
		assertThrows(ParseException.class, () -> Dsl.parse());
	}
	
	@Test
	void testCase8() {
		Dsl.ReInit(new StringReader("ADD PARAGRAPH WITH TEXT \"Welcome\" AND WITH FONT \"Arial\" AND WITH COLOR"));
		assertThrows(ParseException.class, () -> Dsl.parse());
	}
	
	@Test
	void testCase9() {
		Dsl.ReInit(new StringReader("ADD IMAGE WITH SOURCE ?\"https://www.w3schools.com/html/pic_trulli.jpg\""));
		assertThrows(TokenMgrError.class, () -> Dsl.parse());
	}
	
	@Test
	void testCase10() {
		Dsl.ReInit(new StringReader("ADD LINK WITH TEXT \"Email\" AND WITH AND WITH LINK \"http://gmail.com\" AND WITH COLOR \"Green\""));
		assertThrows(ParseException.class, () -> Dsl.parse());
		
	}
	
	
	
}
