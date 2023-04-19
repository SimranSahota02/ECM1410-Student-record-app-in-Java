import java.lang.reflect.Array;
import java.util.Arrays;

public class University {
	//Attributes for University class
	private ModuleDescriptor[] moduleDescriptors;
	
	private Student[] students;
	
	private Module[] modules;
	//Array of all student records
	private StudentRecord[] studentRecords;

	/**
	 * @return The number of students registered in the system.
	 */
	public int getTotalNumberStudents() {
		
		return students.length;
	}

	/**
	 * @return The student with the highest GPA.
	 */
	public Student getBestStudent() {
		
		Student bestStudent = students[0];
		
		for (int i = 0; i < students.length; i++) {
			
			if (students[i].getGpa() > bestStudent.getGpa()) {
				bestStudent = students[i];
			}
		}
		return bestStudent;
	}

	/**
	 * @return The module with the highest average score.
	 */
	public Module getBestModule() {
		
		Module bestModule = modules[0];
		
		for (int i = 0; i < modules.length; i++) {
			
			if (modules[i].getFinalAverageGrade() > 
			bestModule.getFinalAverageGrade()) {
				bestModule = modules[i];
			}
		}
		return bestModule;
	}
	
	public static void main(String[] args) {	

		//create student objects within array
		Student[] students = new Student[] {
		new Student(1000,"Ana",'F',0),
		new Student(1001,"Oliver", 'M', 0),
		new Student(1002,"Mary", 'F', 0),
		new Student(1003,"John", 'M', 0),
		new Student(1004,"Noah", 'M', 0),
		new Student(1005,"Chico", 'M', 0),
		new Student(1006,"Maria", 'F', 0),
		new Student(1007,"Mark", 'X', 0),
		new Student(1008,"Lia", 'F', 0),
		new Student(1009,"Rachel", 'F', 0)
		};

		//create module descriptor objects within array
		ModuleDescriptor[] moduleDescriptors = new ModuleDescriptor[] {
		new ModuleDescriptor("ECM0002", "Real World Mathematics", new double[]{0.1,0.3,0.6}),
		new ModuleDescriptor("ECM1400", "Programming", new double[]{0.25,0.25,0.25,0.25}),
		new ModuleDescriptor("ECM1406", "Data Structures", new double[]{0.25,0.25,0.5}),
		new ModuleDescriptor("ECM1410", "Object-Oriented Programming", new double[]{0.2,0.3,0.5}),
		new ModuleDescriptor("PHY2023", "Thermal Physics", new double[]{0.4,0.6}),
		new ModuleDescriptor("BEM2027", "Information Systems", new double[]{0.1,0.3,0.3,0.3})
		};

		//create module objects within array
		Module[] modules = new Module[] {
		new Module(2020, (byte)2, moduleDescriptors[0]),
		new Module(2019, (byte)1, moduleDescriptors[1]),
		new Module(2020, (byte)2, moduleDescriptors[1]),
		new Module(2020, (byte)1, moduleDescriptors[2]),
		new Module(2020, (byte)1, moduleDescriptors[3]),
		new Module(2019, (byte)1, moduleDescriptors[4]),
		new Module(2019, (byte)2, moduleDescriptors[5])
		};

		//create student record objects within array
		StudentRecord[] studentRecords = new StudentRecord[] {
		new StudentRecord(students[0], modules[1], new double[]{9 ,10, 10, 10}),
		new StudentRecord(students[0], modules[6], new double[]{10 ,10, 9.5, 10}),
		new StudentRecord(students[0], modules[3], new double[]{10 ,10, 10}),
		new StudentRecord(students[0], modules[4], new double[]{10 ,9, 10}),
		new StudentRecord(students[1], modules[1], new double[]{8, 8, 8, 9}),
		new StudentRecord(students[1], modules[6], new double[]{7, 8.5, 8.2, 8}),
		new StudentRecord(students[1], modules[3], new double[]{8, 7.5, 7.5}),
		new StudentRecord(students[1], modules[4], new double[]{8.5,9,7.5}),
		new StudentRecord(students[2], modules[1], new double[]{5,5,6,5}),
		new StudentRecord(students[2], modules[6], new double[]{6.5,7.0,5.5,8.5}),
		new StudentRecord(students[2], modules[3], new double[]{9,7,7}),
		new StudentRecord(students[2], modules[4], new double[]{10,10,5.5}),
		new StudentRecord(students[3], modules[1], new double[]{6,4,7,9}),
		new StudentRecord(students[3], modules[6], new double[]{5.5,5,6.5,7}),
		new StudentRecord(students[3], modules[3], new double[]{9,8,7}),
		new StudentRecord(students[3], modules[4], new double[]{7,7,7}),
		new StudentRecord(students[4], modules[1], new double[]{10,9,10,9}),
		new StudentRecord(students[4], modules[6], new double[]{7,5,8,6}),
		new StudentRecord(students[4], modules[3], new double[]{2,7,7}),
		new StudentRecord(students[4], modules[4], new double[]{5,6,10}),
		new StudentRecord(students[5], modules[5], new double[]{9,9}),
		new StudentRecord(students[5], modules[2], new double[]{9 ,10, 10, 10}),
		new StudentRecord(students[5], modules[3], new double[]{10 ,10, 10}),
		new StudentRecord(students[5], modules[0], new double[]{8 ,9, 8}),
		new StudentRecord(students[6], modules[5], new double[]{6,9}),
		new StudentRecord(students[6], modules[2], new double[]{8, 8, 8, 9}),
		new StudentRecord(students[6], modules[3], new double[]{8, 7.5, 7.5}),
		new StudentRecord(students[6], modules[0], new double[]{6.5,9,9.5}),
		new StudentRecord(students[7], modules[5], new double[]{5, 6}),
		new StudentRecord(students[7], modules[2], new double[]{5,5,6,5}),
		new StudentRecord(students[7], modules[3], new double[]{10,10,10}),
		new StudentRecord(students[7], modules[0], new double[]{8.5,10,8.5}),
		new StudentRecord(students[8], modules[5], new double[]{9, 7}),
		new StudentRecord(students[8], modules[2], new double[]{6,4,7,9}),
		new StudentRecord(students[8], modules[3], new double[]{9,8,7}),
		new StudentRecord(students[8], modules[0], new double[]{7.5,8,10}),
		new StudentRecord(students[9], modules[5], new double[]{8, 5}),
		new StudentRecord(students[9], modules[2], new double[]{10,9,8,9}),
		new StudentRecord(students[9], modules[3], new double[]{8,9,10}),
		new StudentRecord(students[9], modules[0], new double[]{10,6,10}),
		};
		
		//iterate through students array and records array creating array of records for each student
		for (int i = 0; i < students.length; i++) {
			StudentRecord[] individualRecords = new StudentRecord[] {}; 
			
			for (int j = 0; j < studentRecords.length; j++) {
				Student compareStudent = studentRecords[j].getStudent();
				
				if (compareStudent.getId() == students[i].getId()) {
						int recordsLength = individualRecords.length;
						individualRecords = students[i].addRecordElement(individualRecords, 
						studentRecords, recordsLength, j);
				}	
			}
			//then set the array as the students records array
			students[i].setRecord(individualRecords);
		}

		//iterate through the modules array and records array creating array of records for each module
		for (int i = 0; i < modules.length; i++) {
			StudentRecord[] individualRecords = new StudentRecord[] {}; 
			
			for (int j = 0; j < studentRecords.length; j++) {
				Module compareModule = studentRecords[j].getModule();
				
				if (compareModule.getTerm() == modules[i].getTerm() && 
				compareModule.getModuleDescriptor() == modules[i].getModuleDescriptor()) {
						int recordsLength = individualRecords.length;
						individualRecords = modules[i].addRecordElement(individualRecords, 
						studentRecords, recordsLength, j);
				}	
			}
			//then set the array as the modules records array
			modules[i].setRecord(individualRecords);
		}
		
		//calculate and set the gpa for each student
		for (int i = 0; i < students.length; i++) {
			StudentRecord[] individualRecords = students[i].getRecord();
			
			for (int j = 0; j < individualRecords.length; j++) {
				students[i].calculateGpa(j, individualRecords);
			}
		}

		//calculate and set the final average grade for each module
		for (int i = 0; i < modules.length; i++) {
			StudentRecord[] moduleRecords = modules[i].getRecord();
			modules[i].calculateFinalAverageGrade(moduleRecords);
		}

		//calculate if each records scores are above average
		for (int i = 0; i < studentRecords.length; i++) {
			studentRecords[i].calculateAboveAverage();
		}
	}
}

