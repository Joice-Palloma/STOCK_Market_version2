public class Company implements Company_Observer {

    private long id;

    private int numOfShares;

    private double sharePrice;

    private int sharesSold;


    public Company(int id) {

        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public int getSharesSold() {
        return sharesSold;
    }

    @Override
    public double getSharePrice() {
        return sharePrice;
    }

    @Override
    public int getSharesRemaining() {
        return numOfShares;
    }

    @Override
    public void setPrice(double price) {

        this.sharePrice = price;
    }

    @Override
    public void setNumOfShares(int num) {

        this.numOfShares = num;

    }

    @Override
    public void updateShares(int change) {
        this.numOfShares -= change;
        this.sharesSold += change;
    }
}
