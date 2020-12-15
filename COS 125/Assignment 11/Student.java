import java.util.ArrayList;

public class Student {

	String fName;											// first name
	String lName;											// last name
	String studentID;										// student identification number
	int currentCreditHours;									// current credit hours
	double currentQualityPoints;							// current quality points
	ArrayList<Course> courseList;	
	
	public Student ( )										// POST: empty student
	{	fName = "";
		lName = "";
		studentID = "";
		courseList = new ArrayList<Course> ( );
		currentCreditHours = 0;
		currentQualityPoints = 0.0;
	}

	// accessors
	public String getfName() {	return fName;	}
	public String getlName() {	return lName;	}
	public String getStudentID() {	return studentID;	}
	public ArrayList<Course> getCourseList() {	return courseList;	}
	public int getCurrentCreditHours() { return currentCreditHours;	}
	public double getCurrentQualityPoints() { return currentQualityPoints;	}
	// mutators
	public void setfName(String fName) {this.fName = fName;	}
	public void setlName(String lName) { this.lName = lName;	}
	public void setStudentID(String studentID) { this.studentID = studentID;	}
	public void setCourseList(ArrayList<Course> courseList) {	this.courseList = courseList;	}
	public void setCurrentCreditHours(int currentCreditHours) {	this.currentCreditHours = currentCreditHours;	}
	public void setCurrentQualityPoints(double currentQualityPoints) {	this.currentQualityPoints = currentQualityPoints;	}

	// POST: return string of data
	public String toString()
	{
		return fName + " " + lName + " " + studentID + "\nCourses: " + courseList.toString();   
	}
	
	// POST: add course list of courses
	public void addCourse(Course c)
	{
		courseList.add(c);
	}

	// POST: return semester GPA
	public double semesterGPA()
	{
		double totalCreditHours = 0;
		double totalQualityPoints = 0;
		Course temp;

		for(int i=0; i < courseList.size(); i++)
		{
			temp = courseList.get(i);
			totalCreditHours += temp.getCreditHours();
			totalQualityPoints += temp.qualityPoints();
		}

		if(totalQualityPoints == 0.00)
		{
			return 0.00;
		}
		else
		{
			return  totalQualityPoints / totalCreditHours;
		}
	}
	
	// POST: return new cumulative GPA factoring in this semester
	public double cumulativeGPA()
	{
		double totalCreditHours = 0;
		double totalQualityPoints = 0;
		Course temp;

		for(int i=0; i < courseList.size(); i++)
		{
			temp = courseList.get(i);
			totalCreditHours += temp.getCreditHours();
			totalQualityPoints += temp.qualityPoints();
		}

		return (this.currentQualityPoints + totalQualityPoints) / (this.currentCreditHours + totalCreditHours);				
	}
}

