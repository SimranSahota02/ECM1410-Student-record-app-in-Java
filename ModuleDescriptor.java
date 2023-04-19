public class ModuleDescriptor {
	//Attributes for ModuleDescriptor class
	private String code;
	
	private String name;
	
	private double[] continuousAssignmentWeights;
	//array of used module codes
	private static String[] usedCodes;
	//temp number for checkweight validation
	private double checkWeightSum;

	//ModuleDescriptor class constructor
	public ModuleDescriptor(String newCode, String newName, 
	double[] newContinuousAssignmentWeights) {

		//if code and name pass validation checks set attributes
		if (CodeCheck(newCode) == true) {

			if (nullCheck(newCode, newName) == false) {

				setCode(newCode);
				setName(newName);
				setContinuousAssignmentWeights(newContinuousAssignmentWeights);
			}
		}
		else {
			System.out.println("Module Descriptor code not unique");
		}
	}

	//ModuleDescriptor class setters

	public void setCode(String newCode) {
		
		this.code = newCode;
	}

	public void setName(String newName) {
		
		this.name = newName;
	}

	public void setContinuousAssignmentWeights(double [] newContinuousAssignmentWeights) {
		
		//if the weights sum to 1 set them
		this.checkWeightSum = 0;

		for (int i=0; i < newContinuousAssignmentWeights.length; i++) {
			this.checkWeightSum += newContinuousAssignmentWeights[i];
		}

		if (this.checkWeightSum == 1) {
			this.continuousAssignmentWeights = newContinuousAssignmentWeights;
		}
		else {
			System.out.println("Module descriptor weights do not sum to 1");
		}
	}

	//ModuleDescriptor class getters

	public String getCode() {
		
		return this.code;
	}

	public String getName() {
		
		return this.name;
	}

	public double[] getContinousAssignmentWeights() {
		
		return this.continuousAssignmentWeights;
	}
	
	//ModuleDescriptor other methods

	/**
	 * @param code code to check
	 * @return true if module code has not been used already
	 */
	public static boolean CodeCheck(String code) {

		//initialise usedCodes array and append code to it if no usedCodes
		if (usedCodes == null) {
			String newCodes[] = new String[1]; 
        	newCodes[0] = code; 
        	usedCodes = newCodes;
			return true;
		}
		//else iterate through array to find code
		else {
			int usedLength = usedCodes.length;
			
			for (int i = 0; i < usedLength; i++) {
				
				if (usedCodes[i] == code) {
					return false;
				}
			}
			//given code not found recreate array with new code
			String newCodes[] = new String[usedLength + 1]; 
        	
			for (int i = 0; i < usedLength; i++) {
            	newCodes[i] = usedCodes[i];
        	}
        	newCodes[usedLength] = code; 
        	usedCodes = newCodes;
			return true;
		}
	}

	/**
	 * @param newCode code to check if null
	 * @param newName name to check if null
	 * @return false if new code and name are not null
	 */
	public boolean nullCheck(String newCode, String newName) {

		if (newCode == null) {
			System.out.println("Module Descriptor code null");
			return true;
		}
		else {
			if (newName == null) {

				System.out.println("Module Descriptor Name null");
				return true;
			}
		}
		return false;
		
	}

	
}
