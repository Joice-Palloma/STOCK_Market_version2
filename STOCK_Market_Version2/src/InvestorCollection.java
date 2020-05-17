import java.util.ArrayList;
import java.util.List;

public class InvestorCollection implements InvestorCollectionInterface {

	private List<Investor> investorList;

    public InvestorCollection(){
        investorList = new ArrayList<>();
      
        
}
    @Override
    public void addInvestor(Investor i) {
        this.investorList.add(i);
    }
    
    @Override
    public void removeInvestor(Investor i) {
        this.investorList.remove(i);
    }

    @Override
    public InvestorIteratorInterface iterator() {
        return new InvestorIterator(this.investorList);
    }

    @Override
    public Investor getInvestorWithId(int id) {
        for(Investor investor : investorList){
            if(investor.getId() == id){
                return investor;
            }
        }

        return null;
    }
    
    
    
    
    
    
    @Override
	public List<Investor> getInvestorList() {
		return investorList;
	}

	
}