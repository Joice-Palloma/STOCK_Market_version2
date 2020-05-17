import java.util.ArrayList;
import java.util.List;

public class InvestorCollection implements InvestorCollectionInterface {

	//List of investors trading
	private List<Investor> investorList;

    public InvestorCollection(){
        investorList = new ArrayList<>();
      
        
}
    //Overridden methods
    
    // Adding after dynamic creation
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

    // Getting the investor with investor id
    @Override
    public Investor getInvestorWithId(int id) {
        for(Investor investor : investorList){
            if(investor.getId() == id){
                return investor;
            }
        }

        return null;
    } 
    
    
    
    
    
    
    // Sending the list of investors 
    @Override
	public List<Investor> getInvestorList() {
		return investorList;
	}

	
}