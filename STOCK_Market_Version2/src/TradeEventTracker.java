import java.util.List;

public class TradeEventTracker {

	// Number of shares already sold
    private int numOfTradesToday;

    
    // Total number of shares available at the start of simulation
    private int totalSharesInMarketToSell;

    
    //Total budget (amount with investors) available at the start of simulation
    private double totalBudgetFloating;




    private static TradeEventTracker tradeEventTracker;

  //make the constructor private so that this class cannot be
    //instantiated
    private TradeEventTracker(){
        numOfTradesToday = 0;
        totalSharesInMarketToSell = 0;
        totalBudgetFloating = 0;

    }

  //Get the only object available
    public int getNumOfTradesToday() {
        return numOfTradesToday;
    }

    public void addToNumOfTradesToday() {
        this.numOfTradesToday += 1;
    }

    public int getTotalSharesInMarketToSell() {
        return totalSharesInMarketToSell;
    }

    public void addToTotalSharesInMarketToSell(int totalSharesInMarketToSell) {
        this.totalSharesInMarketToSell += totalSharesInMarketToSell;
    }

    public void subtractToTotalSharesInMarketToSell(int totalSharesInMarketToSell) {
        this.totalSharesInMarketToSell -= totalSharesInMarketToSell;
    }

    public double getTotalBudgetFloating() {
        return totalBudgetFloating;
    }

    public void addToTotalBudgetFloating(int totalBudgetFloating) {
        this.totalBudgetFloating += totalBudgetFloating;
    }

    public void subtractToTotalBudgetFloating(double totalBudgetFloating) {
        this.totalBudgetFloating -= totalBudgetFloating;
    }

    public static TradeEventTracker getInstance(){

        if(tradeEventTracker == null){
            tradeEventTracker = new TradeEventTracker();
        }

        return tradeEventTracker;

    }


}