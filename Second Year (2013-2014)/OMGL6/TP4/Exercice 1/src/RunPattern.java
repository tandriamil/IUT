public class RunPattern{
    public static void main(String [] arguments){
        System.out.println("Example for the AbstractFactory pattern");
        System.out.println();
        System.out.println(" (take a look in the RunPattern code. Notice that you can");
        System.out.println("  use the Address and PhoneNumber classes when writing");
        System.out.println("  almost all of the code. This allows you to write a very");
        System.out.println("  generic framework, and plug in Concrete Factories");
        System.out.println("  and Products to specialize the behavior of your code)");
        System.out.println();
        
        System.out.println("Creating U.S. Address and Phone Number:");
        AddressFactory usAddressFactory = new USAddressFactory();
        Address usAddress = usAddressFactory.createAddress();
        PhoneNumber usPhone = usAddressFactory.createPhoneNumber();
        
        usAddress.setStreet("142 Lois Lane");
        usAddress.setCity("Metropolis");
        usAddress.setRegion("WY");
        usAddress.setPostalCode("54321");
        usPhone.setPhoneNumber("7039214722");
        
        System.out.println("U.S. address:");
        System.out.println(usAddress.getFullAddress());
        System.out.println("U.S. phone number:");
        System.out.println(usPhone.getPhoneNumber());
        System.out.println();
        System.out.println();
        
        System.out.println("Creating French Address and Phone Number:");
        AddressFactory frenchAddressFactory = new FrenchAddressFactory();
        Address frenchAddress = frenchAddressFactory.createAddress();
        PhoneNumber frenchPhone = frenchAddressFactory.createPhoneNumber();
        
        frenchAddress.setStreet("21 Rue Victor Hugo");
        frenchAddress.setCity("Courbevoie");
        frenchAddress.setPostalCode("40792");
        frenchPhone.setPhoneNumber("011324290");
        
        System.out.println("French address:");
        System.out.println(frenchAddress.getFullAddress());
        System.out.println("French phone number:");
        System.out.println(frenchPhone.getPhoneNumber());
        System.out.println();
        System.out.println();


        //For the MlgAddress
        System.out.println("Creating Madagascarian Address and Phone Number:");
        AddressFactory mlgAddressFactory = new MlgAddressFactory();
        Address mlgAddress = mlgAddressFactory.createAddress();
        PhoneNumber mlgPhone = mlgAddressFactory.createPhoneNumber();
        
        mlgAddress.setStreet("02 B 67");
        mlgAddress.setCity("Antsirabe");
        mlgAddress.setPostalCode("15 575");
        mlgAddress.setRegion("Toamasina");
        mlgPhone.setPhoneNumber("101324290");
        
        System.out.println("Madagascarian address:");
        System.out.println(mlgAddress.getFullAddress());
        System.out.println("Madagascarian phone number:");
        System.out.println(mlgPhone.getPhoneNumber());
    }
}