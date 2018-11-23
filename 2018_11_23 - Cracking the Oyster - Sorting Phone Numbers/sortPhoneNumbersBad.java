	
	/**
	*	Given a File with a list of phone numbers, sort phone numbers and write to file.
	* 	Time Complexity : O(2n)
	*	Space Complexity: O(n)
	**/
	

public static void sortPhoneNumbers(){
	int TOTAL_PHONE_NUMBER_COMBINATIONS = 1000000000;
	boolean [] isInDocument = new boolean [TOTAL_PHONE_NUMBER_COMBINATIONS];
	String INPUT_FILE_NAME = "PhoneDirectory.txt";
	String OUTPUT_FILE_NAME = "SortedPhoneDirectory.txt";
	
	for(int i = 0;i<TOTAL_PHONE_NUMBER_COMBINATIONS;++i){
		isInDocument[i] = false;
	}
	try(BufferedReader reader = new BufferedReader(new FileReader(INTPUTFILENAME))){
		String phoneNumberStr;
		while ((phoneNumberStr = br.readLine()) != null){
			int phoneNumberInt = Integer.parseInt(phoneNumberStr);
			isInDocument[phoneNumberInt] = true;
		}
	}
	catch (Exception e){
		System.err.format("Exception occurred trying to read '%s'.", INTPUTFILENAME);
		e.printStackTrace();
	}
	
	BufferedWriter writer;
	try(writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))){
		writeToFileWith(writer);
	catch (Exception e){
		System.err.format("Exception occurred trying to write to  '%s'.", OUTPUT_FILE_NAME);
		e.printStackTrace();
	}
	for(int i = 0; i<TOTAL_PHONE_NUMBER_COMBINATIONS;++i){
			if(isInDocument[i]==true)
				writer.write(i);
		}
}