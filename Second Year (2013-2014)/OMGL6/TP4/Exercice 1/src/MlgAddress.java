/**
 * Class for the madagascarian adresses
 */
public class MlgAddress extends Address {
	//The constant variable for the name of the country
    private static final String COUNTRY = "MADAGASCAR";

    /**
     * Gets the name of the country
     * @return The name of this country
     */
    public String getCountry() {
    	return COUNTRY;
    }


    /**
     * Permits to get the full address
     * @return A String object of the full address
     */
    public String getFullAddress(){
        return "Lot " + getStreet() + EOL_STRING + getPostalCode() + SPACE + getCity() + EOL_STRING + getRegion() + EOL_STRING + COUNTRY + EOL_STRING;
    }
}
