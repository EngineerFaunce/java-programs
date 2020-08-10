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

	// accessors and mutators
	public String getfName() {	return fName;	}
	public void setfName(String fName) {this.fName = fName;	}
	public String getlName() {	return lName;	}
	public void setlName(String lName) { this.lName = lName;	}
	public String getStudentID() {	return studentID;	}
	public void setStudentID(String studentID) { this.studentID = studentID;	}
	public ArrayList<Course> getCourseList() {	return courseList;	}
	public void setCourseList(ArrayList<Course> courseList) {	this.courseList = courseList;	}
	public int getCurrentCreditHours() { return currentCreditHours;	}
	public void setCurrentCreditHours(int currentCreditHours) {	this.currentCreditHours = currentCreditHours;	}
	public double getCurrentQualityPoints() { return currentQualityPoints;	}
	public void setCurrentQualityPoints(double currentQualityPoints) {	this.currentQualityPoints = currentQualityPoints;	}
	
	public String toString ( )								// POST: return string of data
	{	return fName + " " + lName + " " + studentID + "\nCourses: " + courseList.toString();   
	}
	
	public void addCourse (Course c)						// POST: add course list of courses
	{
															// write code
	}
		
	public double semesterGPA ( )							// POST: return semester GPA
	{
		return 0.0;											// write correct code
	}
	
	
	public double cumulativeGPA ( )							// POST: return new cumulative GPA factoring in this semester
	{
		return 0.0;											// write correct code					
	}
}

