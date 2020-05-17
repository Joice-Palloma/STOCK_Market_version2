
import java.util.List;

public class InvestorIterator implements InvestorIteratorInterface{

	// List of investors for the day
    List<Investor> investorList;
    
    //Current position in iterator
    int position;

    public InvestorIterator(List<Investor> investors){
        this.investorList = investors;
        this.position = 0;
    }

    //Overridden methods
    @Override
    public boolean hasNext() {

        Investor investor = null;

        while(position < investorList.size()){
            investor = investorList.get(position);
            position++ ;
        }

        return !(investor == null);
    }

    @Override
    public Investor next() {
        Investor investor = investorList.get(position);
        position++;
        return investor;
    }

}