import java.util.List;

public class ValidityChecker {
    String idString;

    public ValidityChecker(String idString){
        this.idString = idString;
    }
    /**
     * Validates the ID-number as 
     * Swedish Personal number
     * Coordination number
     * Company number
     * and logs the results.
     */
    public void validate(){
        SwedishPersonalNum swedID = new SwedishPersonalNum(idString);
        CoordinationNum cooID = new CoordinationNum(idString);
        CompanyNum compID = new CompanyNum(idString);

        displayResults(swedID.validityCheck(), "Swedish Personal");
        displayResults(cooID.validityCheck(), "Coordination");
        displayResults(compID.validityCheck(), "Company");
    }

    private void displayResults(List<String> errors, String consideredNum ){
        if(errors.size() > 0){
            System.out.println("Invalid "+ consideredNum +" number. Errors: ");
            for (String error : errors) {
                System.out.println("- " + error);
            }
        }else System.out.println("Valid "+ consideredNum +" number.");
    }
}
