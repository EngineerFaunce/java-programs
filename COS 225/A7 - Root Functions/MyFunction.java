import java.util.*;

public class MyFunction implements MathFunction {
	
	private double [ ] values;								// array of coefficients
	private int nvalues;									// number of coefficients
	
	public MyFunction (double ...coefficients)				// POST: fill array with coefficient values
	{	nvalues= coefficients.length;
		values = new double[nvalues];
		for (int k=0; k<nvalues; k++)
			values[k] = coefficients[k];
	}
	
	public MyFunction (List<Double> coefficients)			// POST: fill array with coefficient values
	{	
	}
	
	public double f (double x)								// POST: evaluate f on x
	{	double result= 0.0;
		for (int k=0; k < nvalues; k++)
			result = result + values[k] * Math.pow(x, k);
		return result;		
	}
}

