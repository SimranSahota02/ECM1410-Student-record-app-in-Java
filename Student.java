public class Student {
	//Attributes for student class
	private int id;
	
	private String name;
	
	private char gender;
	
	private double gpa;
	
	private StudentRecord[] records;
	//temp number for summation
	private double tempGpa;
	//array of used ids for validation
	private static int[] usedIds;

	//Student class constructor
	public Student(int newId, String newName, char newGender, 
	double newGpa) {

		setId(newId);
		setName(newName);
		setGender(newGender);
		setGpa(newGpa);
	}
	
	//Student class setters

	public void setId(int newId) {

		//validation that student id is not null and unique
		if (idCheck(newId) == true){
			this.id = newId;
		}
		else{
			System.out.println("Student id not unique");
		}
		
	}

	public void setName(String newName) {

		//validation that student name is not null
		if (newName == null) {
			System.out.println("Student name null");
		}
		else {
			this.name = newName;
		}
	}

	public void setGender(char newGender) {
		
		//Validation that gender is F M X
		if (newGender == 'F') {
			this.gender = newGender;
		}
		else if (newGender == 'M') {
			this.gender = newGender;
		}
		else if (newGender == 'X') {
			this.gender = newGender;
		}
		else {
			System.out.println("Student gender invalid");
		}
	}

	public void setGpa(double newGpa) {
		
		this.gpa = newGpa;
	}

	public void setRecord(StudentRecord[] newRecords) {
		
		this.records = newRecords;
	}

	//Student class getters

	public int getId() {
		
		return this.id;
	}

	public String getName() {
		
		return this.name;
	}

	public char getGender() {
		
		return this.gender;
	}

	public double getGpa() {
		
		return this.gpa;
	}

	public StudentRecord[] getRecord() {
		
		return this.records;
	}

	//Student class other methods

	/**
	 * @param id id to check
	 * @return True if id has not been used previously
	 */
	public static boolean idCheck(int id) {
		
		//if no usedIds create the array
		if (usedIds == null) {
			int newIds[] = new int[1]; 
        	newIds[0] = id; 
        	usedIds = newIds;
			return true;
		}
		//else search existing array for id
		else {
			int usedLength = usedIds.length;
			
			for (int i = 0; i < usedLength; i++) {
				
				if (usedIds[i] == id) {
					return false;
				}
			}
			//If id is not found append it to array
			int newIds[] = new int[usedLength + 1]; 
        	
			for (int i = 0; i < usedLength; i++) {
            	newIds[i] = usedIds[i];
        	}
        	newIds[usedLength] = id; 
        	usedIds = newIds;
			return true;
		}
	}

	/**
	 * @param j index of current record 
	 * @param individualRecords array of studentrecords for student
	 */
	public void calculateGpa(int j, StudentRecord[] individualRecords) {
		
		//if j is final record for student calculate and set the gpa
		if ( j == individualRecords.length - 1) {
			this.tempGpa += individualRecords[j].getFinalScore();
			double moduleCount = individualRecords.length;
			double newGpa = this.tempGpa / moduleCount;
			setGpa(newGpa);
		}
		//if j is 0 then new student so set temp to 0
		else if (j == 0) {
			this.tempGpa = 0;
		}
		//add final scores to temp gpa total
		this.tempGpa += individualRecords[j].getFinalScore();
		
	}

	/**
	 * @param oldArray old record array
	 * @param allRecords array of all student records
	 * @param oldLength length of old record array
	 * @param recordIndex location record is to be appended to array
	 * @return updated records array
	 */
	public StudentRecord[] addRecordElement(StudentRecord[] oldArray, 
	StudentRecord[] allRecords, int oldLength, int recordIndex) {

		//create a new array of one size larger and append all old array records
		StudentRecord newArray[] = new StudentRecord[oldLength + 1]; 
						
		for (int i = 0; i < oldLength; i++) {
			newArray[i] = oldArray[i];
		}
		newArray[oldLength] = allRecords[recordIndex]; 
		return newArray;
	}

	/**
	 * @return string transcript 
	 */
	public String printTranscript() {
		//create first part of transcript using values from student object
		String transcriptIntro = ("\n" + "\n" + "\n" + "ID: " + this.id + "\n" 
		+ "Name: " + this.name + "\n" + "GPA: " + this.gpa + "\n" + "\n");
		String transcriptRecords = "";

		//iterate through records adding necessary information to string
		for (int i=0; i < records.length; i++){
			transcriptRecords += ("| " + records[i].getModule().getYear() 
			+ " | " + records[i].getModule().getTerm() + " | " 
			+ records[i].getModule().getModuleDescriptor().getCode() + " | " 
			+ records[i].getFinalScore() +" |" + "\n");
		}
		//concatenate the transcript string print and return it
		String transcript = transcriptIntro + transcriptRecords;
		System.out.println(transcript);
		return transcript;
	}
}
