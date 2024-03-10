import java.time.YearMonth;

public class CoordinationNum extends SwedishPersonalNum {

    public CoordinationNum(String id) {
        super(id);
    }
    
    /**
     * Validates a date. Checks if months are within range of 1-12 and days
     * within the specific month (of that years) range of days + 60, as this is the 
     * format of coordination numbers. 
     * @return boolean to say if the date is valid or not. 
     */
    @Override
    protected boolean validDateChecker(int year, int month, int day){
        boolean validMonth = 1 <= month && month <= 12;
        return validMonth && (61 <= day && day <= (YearMonth.of(year, month).lengthOfMonth())+60);
    }
}
