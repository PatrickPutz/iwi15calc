package at.edu.c02.calculator.logic;

import java.util.Stack;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;


public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();
	private double stored;

	@Override
	public double perform(Operation op) throws CalculatorException {

		double b = 0.0;
		double a = 0.0;

		// Exclude b in case of sinus/cosinus
		// Don't pop values in case of dotproduct
		if(op != Operation.sin && op != Operation.cos && op != Operation.dotproduct)
			b = pop();
		if(op != Operation.dotproduct)
			a = pop();

		switch (op) {
		case add:
			return a + b;
		case sub:
			return a - b;
		case div:
			double c = a / b;
			if (Double.isInfinite(c))
				throw new CalculatorException("Division by zero");
			return c;
		case mul:
			return a * b;
		case mod:
			if (b == 0)
				throw new CalculatorException("Division by zero");
			return a % b;
		case sin:
			return Math.sin(Math.toRadians(a));
		case cos:
			return Math.cos(Math.toRadians(a));
		case dotproduct:
			return dotProduct();
		}
		return 0;
	}

	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException();
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}

	@Override
	public void clear() {
		stack_.clear();
	}

	@Override
	public void store(double value){
		this.stored = value;
	}

	@Override
	public double load(){
		return this.stored;
	}


	public double dotProduct() throws CalculatorException {
		double lastStackItem = stack_.pop();
		int elementsPerVector = (int) lastStackItem;

		if(stack_.size() != elementsPerVector * 2)
			throw new CalculatorException("Incorrect Stack Size!");

		double[] vectorB = populateVector(elementsPerVector);
		double[] vectorA = populateVector(elementsPerVector);

		return calculateDotProduct(vectorA, vectorB, elementsPerVector);
	}

	private double[] populateVector(int elementsPerVector){
		double[] result = new double[elementsPerVector];

		for(int i = 1; i <= elementsPerVector; i++){
			double value = stack_.pop();
			result[elementsPerVector - i] = value;
		}

		return result;
	}

	private double calculateDotProduct(double[] vectorA, double[] vectorB, int elementsPerVector){
		double result = 0.0;

		for(int i = 0; i < elementsPerVector; i++){
			double multiplicationResult = vectorA[i] * vectorB[i];
			result += multiplicationResult;
		}

		return result;
	}
}
