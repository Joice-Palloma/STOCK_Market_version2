
import java.util.List;

public class InvestorIterator implements InvestorIteratorInterface{

    List<Investor> investorList;
    int position;

    public InvestorIterator(List<Investor> investors){
        this.investorList = investors;
        this.position = 0;
    }

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