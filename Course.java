class Course  {
	private String courseNumber; 
	private String courseTitle;
	
	void setCourseNumber(String inputCourseNumber){
		courseNumber = inputCourseNumber;
	}
	
	void setCourseTitle(String inputCourseTitle){
		courseTitle = inputCourseTitle;
	}

	String getCourseNumber(){
		return courseNumber;
	}

	String getCourseTitle(){
		return courseTitle;
	}
	void printCourseInfo(){
		System.out.println("courseNumber:" + courseNumber);
		System.out.println("courseTitle:" + courseTitle);
	}

}

class OfferedCourse extends Course{
	private String instructorName; 
	private String location ;
	private String classTime; 

	void setInstructorName(String inputInstructorName){
		instructorName = inputInstructorName;
	}
	
	void setLocation(String inputLocation){
		location = inputLocation;
	}

	void setClassTime(String inputClassTime){
		classTime = inputClassTime;
	}

	String getInstructorName(){
		return instructorName;
	}

	String getLocation(){
		return location;
	}

	String getClassTime(){
		return classTime;
	}
	
	void printCourseInfo(){
		System.out.println("courseNumber:\t" + getCourseNumber());	
		System.out.println("courseTitle:\t" + getCourseTitle());
		System.out.println("instructorName:\t" + instructorName);
		System.out.println("location:\t" + location);
		System.out.println("classTime:\t" + classTime);		
	}
}

class MainClass{

	public static void main(String[] args) {
		OfferedCourse courseObj = new OfferedCourse();
		
		courseObj.setCourseNumber("IT211");
		courseObj.setCourseTitle("Object Oriented...");
		courseObj.setInstructorName("Byungcheon Ko");
		courseObj.setLocation("Online");
		courseObj.setClassTime("01/01/2023");

		courseObj.printCourseInfo();
	
	}
}


