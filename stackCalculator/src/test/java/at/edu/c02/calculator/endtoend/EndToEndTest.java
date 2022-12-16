package at.edu.c02.calculator.endtoend;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.logic.CalculatorImpl;
import at.edu.c02.calculator.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;


public class EndToEndTest {

    @Test
    public void testParserCalculatorTest04Xml() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        double result = parser.parse(new File("src/test/resources/test04.xml"));

        Assert.assertEquals(result, -3, 0);
    }

    @Test
    public void testParserCalculatorTest05Xml() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        double result = parser.parse(new File("src/test/resources/test05.xml"));

        Assert.assertEquals(result, 3, 0);
    }

    @Test
    public void testParserCalculatorTest06Xml() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        double result = parser.parse(new File("src/test/resources/test06.xml"));

        Assert.assertEquals(result, 14, 0);
    }

    @Test
    public void testParserCalculatorTest07Xml() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        double result = parser.parse(new File("src/test/resources/test07.xml"));

        Assert.assertEquals(result, 82040, 0);
    }

    @Test
    public void testParserCalculatorTest08Xml() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        double result = parser.parse(new File("src/test/resources/test08.xml"));

        Assert.assertEquals(result, 1, 0);
    }

    @Test
    public void testParserCalculatorTest09Xml() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        double result = parser.parse(new File("src/test/resources/test09.xml"));

        Assert.assertEquals(result, -1, 0);
    }

    @Test
    public void testParserCalculatorTest10Xml() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        double result = parser.parse(new File("src/test/resources/test10.xml"));

        Assert.assertEquals(result, 15, 0);
    }
}
