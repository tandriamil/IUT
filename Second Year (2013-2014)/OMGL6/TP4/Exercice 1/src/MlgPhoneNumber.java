/**
 * The class for madagascarian phone number
 */
public class MlgPhoneNumber extends PhoneNumber {
	//Constant var for the country code
    private static final String COUNTRY_CODE = "00 261";

    //And the one for the length of the phone number (A tab of 9 have 10 chars!!!)
    private static final int NUMBER_LENGTH = 9;


    /**
     * Gets the country code
     * @return The country code
     */
    public String getCountryCode() {
    	return COUNTRY_CODE;
    }
    

    /**
     * Set the phone number
     * @param newNumber The new phone number
     */
    public void setPhoneNumber(String newNumber) {
        if (newNumber.length() == NUMBER_LENGTH) {
            super.setPhoneNumber(newNumber);
        }
    }
}
