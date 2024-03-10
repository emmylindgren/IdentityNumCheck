import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IdentityNum {
    
    protected String id; 
    protected List<String> errors;
    protected List<String> idListOfNumbers;

    public IdentityNum(String id){
        this.id = id;
        this.errors = new ArrayList<>();
        this.idListOfNumbers = Arrays.stream(
            id
            .replaceAll("[^0-9]", "")
            .split(""))
            .collect(Collectors.toList());
    }

    public List<String> validityCheck(){
        validFormatCheck();
        validControlNumberCheck();
        return errors;
    }
    /**
     * Checks that the identitynumber is of valid format. 
     * Valid formats are (Å,M,D,X = all numbers):
     */
    private void validFormatCheck(){ 
        boolean hasValidFormat = id.matches("^\\d{12}$|^\\d{10}$|^\\d{6}[-|+]\\d{4}$|^\\d{8}[-|+]\\d{4}$");
        if(!hasValidFormat){
            errors.add("The id is of unvalid format.");
        }
    }

    private void validControlNumberCheck(){
        if(idListOfNumbers.size() != 12 && idListOfNumbers.size() !=10) return;

        List<String> subList = idListOfNumbers;
        int controlNum;
        if(idListOfNumbers.size() == 12){
            subList = idListOfNumbers.subList(2, 12);
            controlNum = Integer.parseInt(idListOfNumbers.get(11));
        }else{
            controlNum = Integer.parseInt(idListOfNumbers.get(9));
        }

        int totalSum = 0;
        for (int i = 0; i < subList.size() -1 ; i++){
            int number;
            if(i % 2 == 0){
                number = Integer.parseInt(subList.get(i))*2;
            }else{
                number = Integer.parseInt(subList.get(i));
            }
            totalSum += String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
        }
        if(!((totalSum%10)==0 && controlNum == 0)){
            int proposedSum = ((10-(totalSum%10))%10);
            if(!(proposedSum==controlNum)){
                errors.add("Invalid control number");
            }
        }
    }
}
