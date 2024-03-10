public class App 
{
    public static void main( String[] args )
    {
        if (args.length > 0) {
            String numberString = args[0].trim();
            System.out.println("Validating ID-number: " + numberString);

            ValidityChecker checker = new ValidityChecker(numberString);
            checker.validate();
        }
        else{
            System.out.println("No command line arguments found.");
        }
    }
}