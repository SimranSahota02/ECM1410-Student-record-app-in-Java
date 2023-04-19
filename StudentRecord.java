public class StudentRecord {
	//Attributes for StudentRecord class
	private Student student;
	
	private Module module;
	
	private double[] marks;
	
	private double finalScore;
	
	private Boolean isAboveAverage;
	//temp score for summation
	private double tempScore;

	//StudentRecord class constructor
	public StudentRecord(Student newStudent, Module newModule, double[] newMarks) {

		setStudent(newStudent);
		setModule(newModule);
		setMarks(newMarks);
		//use passed in module and marks to calculate final score
		ModuleDescriptor newDescriptor = newModule.getModuleDescriptor();
		double[] newWeights = newDescriptor.getContinousAssignmentWeights();
		double[] calculatedScores = {0,0,0,0};
		this.tempScore = 0;

		for (int i = 0; i < newMarks.length; i++) {

			calculatedScores[i] = newMarks[i] * newWeights[i];
			this.tempScore += calculatedScores[i];
		}
		setFinalScore(this.tempScore);
	}

	//StudentRecord class setters

	public void setStudent(Student newStudent){
		
		this.student = newStudent;
	}

	public void setModule(Module newModule) {
		
		this.module = newModule;
	}

	public void setMarks(double[] newMarks) {
		
		this.marks = newMarks;
	}

	public void setFinalScore(double newFinalScore) {
		
		this.finalScore = newFinalScore;
	}

	public void setIsAboveAverage(boolean aboveTrue) {
		
		this.isAboveAverage = aboveTrue;
	}

	//StudentRecord class getters

	public Student getStudent() {
		
		return this.student;
	}
	
	public Module getModule() {
		
		return this.module;
	}

	public double[] getMarks() {
		
		return this.marks;
	}

	public double getFinalScore() {
		
		return this.finalScore;
	}

	public boolean getIsAboveAverage() {
		
		return this.isAboveAverage;
	}
	
	//StudentRecord class other methods

	/**
	 * use record final score and module to find if student is above average
	 */
	public void calculateAboveAverage() {

		if (this.finalScore > this.module.getFinalAverageGrade()) {
			setIsAboveAverage(true);
		}
		else {
			setIsAboveAverage(false);
		}
	}
}
