import java.util.ArrayList;

public class Study {

	public static void main(String[] args) {
		
		String type1 = "E";
		String type2 = "M";
		
		int distance1 = 5;
		int distance2 = 15;
		int distance3 = 50;
		
		ArrayList<Integer> costs = new ArrayList<Integer>();
		costs.add(2);
		costs.add(4);
		costs.add(6);
        ArrayList<Integer> pogosticks = new ArrayList<Integer>();
        pogosticks.add(1);
        pogosticks.add(5);
        pogosticks.add(10);
        
        
        
        long startTime = System.currentTimeMillis();
    	new JJ(type1, distance1, pogosticks, costs);
    	long stopTime = System.currentTimeMillis();
    	long runtime1 = stopTime-startTime;
    	
    	startTime = System.currentTimeMillis();
    	new JJ(type2, distance1, pogosticks, costs);
    	stopTime = System.currentTimeMillis();
    	long runtime2 = stopTime-startTime;
    	
    	startTime = System.currentTimeMillis();
    	new JJ(type1, distance2, pogosticks, costs);
    	stopTime = System.currentTimeMillis();
    	long runtime3 = stopTime-startTime;
    	
    	startTime = System.currentTimeMillis();
    	new JJ(type2, distance2, pogosticks, costs);
    	stopTime = System.currentTimeMillis();
    	long runtime4 = stopTime-startTime;
    	
    	startTime = System.currentTimeMillis();
    	new JJ(type1, distance3, pogosticks, costs);
    	stopTime = System.currentTimeMillis();
    	long runtime5 = stopTime-startTime;
    	
    	startTime = System.currentTimeMillis();
    	new JJ(type2, distance3, pogosticks, costs);
    	stopTime = System.currentTimeMillis();
    	long runtime6 = stopTime-startTime;
    	
    	System.out.println("Test 1 runtime: " + runtime1);
    	System.out.println("Test 2 runtime: " + runtime2);
    	System.out.println("Test 3 runtime: " + runtime3);
    	System.out.println("Test 4 runtime: " + runtime4);
    	System.out.println("Test 5 runtime: " + runtime5);
    	System.out.println("Test 6 runtime: " + runtime6);

	}
	
}
