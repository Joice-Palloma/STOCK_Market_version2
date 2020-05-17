
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradingDay implements TradingDay_Subject{

	// List to store the companies
    List<Company_Observer> companies;

    private Date date;

    public TradingDay(){
    	
    	// We are creating the object
        this.companies = new ArrayList<>();
    }

    
    //Registering the new company
    @Override
    public void register(Company_Observer company) {
        if(company == null){
            throw new NullPointerException("Null Company cannot be added");
        }

        if(!companies.contains(company)){
            companies.add(company);
        }
    }

    @Override
    public void unregister(Company_Observer company) {

        companies.remove(company);

    }

    @Override
    public void notifyObservers() {

    }
}