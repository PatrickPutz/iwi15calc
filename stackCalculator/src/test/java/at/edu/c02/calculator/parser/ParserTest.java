package at.edu.c02.calculator.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.mockito.Mockito.*;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.parser.Parser;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNullParser() {
		new Parser(null);
	}

	@Test(expected = FileNotFoundException.class)
	public void testParserInvalidFile() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("invalid"));
	}

	@Test
	public void testParserTest01Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test01.xml"));
		
		verify(cal).push(1.0);
		verify(cal).push(2.0);
		verify(cal).perform(Operation.add);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest08Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test08.xml"));

		verify(cal).push(90);
		verify(cal).perform(Operation.sin);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest09Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test09.xml"));

		verify(cal).push(180);
		verify(cal).perform(Operation.cos);

		verifyNoMoreInteractions(cal);
	}
}
