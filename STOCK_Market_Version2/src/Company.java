
public class Company implements Company_Observer {

	private long id;

    private int numOfShares;

    private double sharePrice;

    private int sharesSold;


    public Company(int id) {

        this.id = id;
    }
	
	
	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
	this.sharePrice = price;	
	}

	@Override
	public void setNumOfShares(int num) {
		// TODO Auto-generated method stub
		this.numOfShares = num;
		
	}

	@Override
	public void updateShares(int change) {
		// TODO Auto-generated method stub
		
		this.numOfShares -= change;
        this.sharesSold += change;
		
	}

	@Override
	public int getSharesSold() {
		// TODO Auto-generated method stub
		return sharesSold;
	}

	@Override
	public double getSharePrice() {
		// TODO Auto-generated method stub
		return sharePrice;
	}

	@Override
	public int getSharesRemaining() {
		// TODO Auto-generated method stub
		return numOfShares;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

}
