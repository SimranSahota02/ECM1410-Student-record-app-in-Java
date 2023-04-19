public class Module {
	//Attributes for module class
	private int year;
	
	private byte term;
	
	private ModuleDescriptor module;
	
	private StudentRecord[] records;
	
	private double finalAverageGrade;
	//temp number for summation
	private double tempFinalAverageGrade;

	//Module class constructor
	public Module(int newYear, byte newTerm, ModuleDescriptor newModule) {
		
		setYear(newYear);
		setTerm(newTerm);
		setModuleDescriptor(newModule);
	} 	

	//Module class setters

	public void setYear(int newYear) {
		
		this.year = newYear;
	}

	public void setTerm(byte newTerm) {
		
		this.term = newTerm;
	}

	public void setModuleDescriptor(ModuleDescriptor newModule) {
		
		this.module = newModule;
	}

	public void setRecord(StudentRecord[] newRecords) {
		
		this.records = newRecords;
	}

	public void setFinalAverageGrade(double newFinalAverageGrade) {
		
		this.finalAverageGrade = newFinalAverageGrade;
	}

	//Module class getters 

	public int getYear() {
		
		return this.year;
	}

	public byte getTerm() {
		
		return this.term;
	}

	public ModuleDescriptor getModuleDescriptor() {
		
		return this.module;
	}

	public StudentRecord[] getRecord() {
		
		return this.records;
	}

	public double getFinalAverageGrade() {
		
		return this.finalAverageGrade;
	}
	
	//Module class other methods

	/**
	 * 
	 * @param moduleRecords array of student records that belong to the module
	 */
	public void calculateFinalAverageGrade(StudentRecord[] moduleRecords) {

		tempFinalAverageGrade = 0;

		//for each record sum to temp final grade
		for (int i = 0; i < moduleRecords.length; i++) {

			//if this record is the last one to sum calculate final grade and set it
			if (i == moduleRecords.length - 1) {
				this.tempFinalAverageGrade += moduleRecords[i].getFinalScore();
				double studentCount = moduleRecords.length;
				double newFinalAverageGrade = this.tempFinalAverageGrade / studentCount;
				setFinalAverageGrade(newFinalAverageGrade);
			}
			this.tempFinalAverageGrade += moduleRecords[i].getFinalScore();
		}
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
}
