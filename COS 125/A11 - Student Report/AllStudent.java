import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AllStudent {
	
	public static void main(String[] args) throws IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		boolean fileFound = false;
		String input;
		Scanner scanner = new Scanner(System.in);
		Scanner file = new Scanner(System.in);

		// Error checking loop for file name
		do
		{
			System.out.print("Enter a file name containing student data: ");
			input = scanner.next();
			try
			{
				file = new Scanner(new FileReader(input));
				fileFound = true;
			} catch(FileNotFoundException e)
			{
				System.out.printf("File %s not found. Try again.\n", input);
			}
		} while(!fileFound);
		scanner.close();

		// Read student and course data from file
		String student_data[];
		String course_data[];
		while(file.hasNextLine())
		{
			student_data = file.nextLine().split(" ");
			course_data = file.nextLine().split(" ");
			Student newStudent = createStudent(student_data, course_data);
			students.add(newStudent);
		}
		file.close();

		for(Student s : students)
		{
			System.out.printf("\n%s %s %s\n", s.getfName(), s.getlName(), s.getStudentID());
			System.out.printf("Current GPA: %.2f\n", (s.getCurrentQualityPoints() / s.getCurrentCreditHours()));
			System.out.printf("Semester courses: %s\n", s.getCourseList());
			System.out.printf("Semester GPA: %.2f\n", s.semesterGPA());
			System.out.printf("New GPA: %.2f\n", s.cumulativeGPA());
		}
	}

	// POST: returns a Student object
	static Student createStudent(String s_data[], String c_data[])
	{
		Student newStudent = new Student();
		newStudent.setfName(s_data[1]);
		newStudent.setlName(s_data[0]);
		newStudent.setStudentID(s_data[2]);
		newStudent.setCurrentCreditHours(Integer.parseInt(s_data[3]));
		newStudent.setCurrentQualityPoints(Double.parseDouble(s_data[4]));

		addCourseData(newStudent, c_data);

		return newStudent;
	}

	// POST: adds courses to Student object
	static void addCourseData(Student student, String c_data[])
	{
		for(int i=0; i<c_data.length; i+=3)
		{
			Course course = new Course(c_data[i], c_data[i+1], Integer.parseInt(c_data[i+2]));
			student.addCourse(course);
		}
	}

}
