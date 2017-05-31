/**
 * Class to create a MldAddress
 */
public class MlgAddressFactory implements AddressFactory {

	/**
	 * Creates a mlg address
	 * @return A new mlg address
	 */
    public Address createAddress() {
        return new MlgAddress();
    }


    /**
	 * Creates a mlg phone number
	 * @return A  newmlg phone number
	 */
    public PhoneNumber createPhoneNumber(){
        return new MlgPhoneNumber();
    }
}
