import java.time.YearMonth;
import java.util.Calendar;
import java.util.List;

public class SwedishPersonalNum extends IdentityNum{

    public SwedishPersonalNum(String id) {
        super(id);
    }

    @Override
    public List<String> validityCheck(){
        super.validityCheck();
        if(errors.size() == 0){
            validMonthAndDayCheck();
        }
        return errors;
    }

    /**
     * Validates the date in the identitiynumber. A valid date has months between 1-12 and 
     * days between 1-31 depending on the month. Leap years are accounted for. 
     */
    private void validMonthAndDayCheck(){
        int year; 
        int month; 
        int day; 
        if(idListOfNumbers.size() == 12){
            year = Integer.parseInt(idListOfNumbers.get(0) + idListOfNumbers.get(1) + idListOfNumbers.get(2) + idListOfNumbers.get(3));
            month = Integer.parseInt(idListOfNumbers.get(4) + idListOfNumbers.get(5));
            day = Integer.parseInt(idListOfNumbers.get(6) + idListOfNumbers.get(7));
        }
        else{
            String yearTemp = idListOfNumbers.get(0) + idListOfNumbers.get(1);
            month = Integer.parseInt(idListOfNumbers.get(2) + idListOfNumbers.get(3));
            day = Integer.parseInt(idListOfNumbers.get(4) + idListOfNumbers.get(5));  

            year = calculateCorrectYear(month, day, yearTemp);
        }
        if(!validDateChecker(year, month, day)) errors.add("Invalid date");
    }

    /**
     * Calculates the century of the year (given in two digits) in a date of an idnumber.  
     * If the idnumber is divided by + the person has turned 100 years of age. 
     * @param month, the month of the date.
     * @param day, the day of the date.
     * @param yearTemp, the two-digit year in string format. 
     * @return the whole year including the correct century. 
     */
    private int calculateCorrectYear(int month, int day, String yearTemp) {
        int year;
        Calendar hundredYearsAgo = Calendar.getInstance(); 
        hundredYearsAgo.add(Calendar.YEAR, -100);

        Calendar nineteenHundredDate = Calendar.getInstance();
        nineteenHundredDate.set(Integer.parseInt("19" + yearTemp), month, day); 
      
        if(id.substring(6,7).matches("\\+")){
            if (nineteenHundredDate.before(hundredYearsAgo)){
                year = Integer.parseInt("19" + yearTemp);
            }else{
                year =Integer.parseInt("18" + yearTemp);
            }
        }
        else{
            if (hundredYearsAgo.before(nineteenHundredDate)){
                year =Integer.parseInt("19" + yearTemp);
            }else{
                year = Integer.parseInt("20" + yearTemp);
            }
        }
        return year;
    }

    /**
     * Validates a date. Checks if months are within range of 1-12 and days
     * within the specific month (of that years) range of days. 
     * @return boolean to say if the date is valid or not. 
     */
    protected boolean validDateChecker(int year, int month, int day){
        boolean validMonth = 1 <= month && month <= 12;
        return validMonth && (1 <= day && day <= YearMonth.of(year, month).lengthOfMonth());
    }
}
