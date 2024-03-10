import java.util.List;

public class CompanyNum extends IdentityNum{

    public CompanyNum(String id) {
        super(id);
    }

    @Override
    public List<String> validityCheck(){
        super.validityCheck();
        if(errors.isEmpty()){
            middleNumberCheck();
        }
        if(idListOfNumbers.size() == 12){
            startOfNumberCheck();
        }
        return errors;
    }

    /**
     * Validates middle number of a company number should be at least 20. 
     */
    private void middleNumberCheck(){
        int middleNum;
        if(idListOfNumbers.size() == 12){
            middleNum= Integer.parseInt(idListOfNumbers.get(4) + idListOfNumbers.get(5));
        }else{
            middleNum= Integer.parseInt(idListOfNumbers.get(2) + idListOfNumbers.get(3));
        }

        if(!(middleNum > 19)){
            errors.add("The middle number needs to be 20 or bigger.");
        }
    }

    /**
     * Validates that the company number starts with 16. 
     * (Only to be used when the company number is of 12 digits)
     */
    private void startOfNumberCheck(){
        int start = Integer.parseInt(idListOfNumbers.get(0) + idListOfNumbers.get(1));
        if(start != 16){
            errors.add("The start of a 12-digit company number needs to be 16.");
        }
    }
}
