import java.util.List;

public interface InvestorCollectionInterface {
	//interface methods
	
	 public void addInvestor(Investor i);

	    public void removeInvestor(Investor i);

	    public InvestorIteratorInterface iterator();

	    public Investor getInvestorWithId(int id);

	    public List<Investor> getInvestorList();
	
}
