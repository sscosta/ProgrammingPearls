	
	/**
	*	Given a File with phone numbers, sort phone numbers and write to a new file.
	* 	Time Complexity : O(2n)
	*	Space Complexity: O(n)
	**/
	
	int TOTAL_PHONE_NUMBER_COMBINATIONS = 1000000000;
	boolean [] bitmap = new boolean [TOTAL_PHONE_NUMBER_COMBINATIONS];
	String INPUT_FILE_NAME = "PhoneDirectory.txt";
	String OUTPUT_FILE_NAME = "SortedPhoneDirectory.txt";
	
public static void sortPhoneNumbers(){
	markBitmapAsFalse();
	openFileAndMarkExistingNumbers();
	writeSortedNumbersInFile();
}

private void markBitmapAsFalse(){
	for(int i = 0;i<TOTAL_PHONE_NUMBER_COMBINATIONS;++i){
		bitmap[i] = false;
	}
}

private void openFileAndMarkExistingNumbers(){
	try(BufferedReader reader = new BufferedReader(new FileReader(INTPUTFILENAME))){
		markExistingNumbers(reader);
	}
	catch (Exception e){
		System.err.format("Exception occurred trying to read '%s'.", INTPUTFILENAME);
		e.printStackTrace();
	}
}	

private void markExistingNumbers(BufferedReader br){
	String phoneNumber;
	while ((phoneNumber = br.readLine()) != null){
		bitmap[Integer.parseInt(phoneNumber)] = true;
	}
}

private void writeSortedNumbersInFile(){
	BufferedWriter writer;
	try(writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))){
		writeToFileUsingWriter(writer);
	catch (Exception e){
		System.err.format("Exception occurred trying to write to  '%s'.", OUTPUT_FILE_NAME);
		e.printStackTrace();
	}
}

private void writeToFileUsingWriter(BufferedWriter theWriter){
	for(int i = 0; i<TOTAL_PHONE_NUMBER_COMBINATIONS;++i){
			if(bitmap[i]==true)
				theWriter.write(i);
		}
}