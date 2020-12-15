public class Course {
	
	String courseName;									// name of course (ex. COS225)
	String letterGrade;									// letter grade (ex. A-)
	int creditHours;									// number of credit hours (ex. 4)
	
	public Course ( )									// POST: construct empty course
	{	courseName = "";
		letterGrade = "";
		creditHours = 0;	}
	
	public Course (String co, String let, int cr )		// PRE: let is A - E, 1 <= cr <= 4
	{	courseName = co;								// POST: construct course from parameters
		letterGrade = let;
		creditHours = cr;	}

	public String getCourseName() {						// POST: return course name
		return courseName;	}

	public void setCourseName(String courseName) {		// POST: set course name
		this.courseName = courseName;	}

	public String getLetterGrade() {					// POST: return letter grade
		return letterGrade;	}

	public void setLetterGrade(String let) {			// PRE: let is A - E
		letterGrade = let;	}							// POST: set letter grade
	
	public int getCreditHours() {						// POST: return credit hours
		return creditHours;	}

	public void setCreditHours(int creditHours) {		// PRE: 1 <= creditHours <= 4 
		this.creditHours = creditHours;					// POST: set credit hours
	}
	
	public String toString()							// POST: return string on course data
	{	return courseName + " " + letterGrade + " " +  creditHours; }
	
	public double qualityPoints()						// POST: return quality points 
	{
		double creditPts = 0;
		switch(this.getLetterGrade())
		{
			case "A":	creditPts = 4.00; break;
			case "A-": 	creditPts = 3.67; break;
			case "B+": 	creditPts = 3.33; break;
			case "B": 	creditPts = 3.00; break;
			case "B-": 	creditPts = 2.67; break;
			case "C+": 	creditPts = 2.33; break;
			case "C": 	creditPts = 2.00; break;
			case "C-": 	creditPts = 1.67; break;
			case "D+": 	creditPts = 1.33; break;
			case "D": 	creditPts = 1.00; break;
			case "D-": 	creditPts = 0.70; break;
			case "F": 	creditPts = 0.00; break;
			default:	creditPts = 0.00;
		}
		return creditPts * creditHours;
	}
	
	
}
