package testing2;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordWrapTest {
	
	public static final int LINE_LENGTH = 5;

	@Test
	public void lineShouldWrapOverLineLength() {
		String result = WorldWrap.wrap("The Sleepy", LINE_LENGTH);
		assertEquals("The S\nleepy",result);
	}
	
	@Test
	public void shortLineShouldNotWrap() {
		String result = WorldWrap.wrap("The", LINE_LENGTH);
		assertEquals("The",result);
	}
	
	@Test
	public void longerLineShouldWrapTwice() {
		String result = WorldWrap.wrap("The Sleepy Brow", LINE_LENGTH);
		assertEquals("The S\nleepy\n Brow",result);
	}
	
	@Test
	public void evenlongerLinesShouldWrapThrice() {
		String result = WorldWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
		assertEquals("The S\nleepy\n Brow\nn Fox",result);
	}
	
	@Test
	public void longLinesDontHaveToBeMultipleOfLineLength() {
		String result = WorldWrap.wrap("The Sleepy Brown Fox.", LINE_LENGTH);
		assertEquals("The S\nleepy\n Brow\nn Fox\n.",result);
	}
}
