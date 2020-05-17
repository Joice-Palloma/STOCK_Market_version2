import java.util.List;

public interface InvestorCollectionInterface {
	
	 public void addInvestor(Investor i);

	    public void removeInvestor(Investor i);

	    public InvestorIteratorInterface iterator();

	    public Investor getInvestorWithId(int id);

	    public List<Investor> getInvestorList();
	
}
