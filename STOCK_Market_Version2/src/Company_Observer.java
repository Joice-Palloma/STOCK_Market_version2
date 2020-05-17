public interface Company_Observer {

	//interface methods
    public void setPrice(double price);

    public void setNumOfShares(int num);

    public void updateShares(int change);

    public int getSharesSold();

    public double getSharePrice();

    public int getSharesRemaining();

    public long getId();


}
