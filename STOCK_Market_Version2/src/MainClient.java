import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainClient {

    public static void main(String[] args) throws InterruptedException {

        TradingDay tradingDay = new TradingDay();
        
        //TradeEventTracker is in singleton pattern
        TradeEventTracker tradeEventTracker = TradeEventTracker.getInstance();

        //creating companies with unique id
        for (int i = 1; i <= 100; i++) {
            Company_Observer company = new Company(i);

            tradingDay.register(company);
        }

        // Assigning shares and price
        for (Company_Observer company : tradingDay.companies) {

            Random r = new Random();
            int low = 500;
            int high = 1000;
            int share = r.nextInt(high - low) + low;
            company.setNumOfShares(share);
            tradeEventTracker.addToTotalSharesInMarketToSell(share);


            low = 10;
            high = 100;

            company.setPrice(r.nextInt(high - low) + low);
        }

        //Creating dynamic investors
        InvestorCollectionInterface investors = createInvestors();
        
        
        // Runs the final simulation 
        simulateTradingDay(tradingDay.companies, investors);
    }

    // Method for creating dynamic investors
    public static InvestorCollectionInterface createInvestors() {

    	// Storing investors in collection, which is implemented in iterator design pattern
        InvestorCollectionInterface investors = new InvestorCollection();
        
        
      //TradeEventTracker is in singleton pattern
        TradeEventTracker tradeEventTracker = TradeEventTracker.getInstance();

        
        for (int i = 1; i <= 100; i++) {
            Investor investor = new Investor(i);

            Random r = new Random();
            int low = 1000;
            int high = 10000;
            int budget = r.nextInt(high - low) + low;
            investor.setBudget(budget);

            tradeEventTracker.addToTotalBudgetFloating(budget);
            investors.addInvestor(investor);

        }

        return investors;

    }
    
    
    // Method to simulate the trading day
    public static void simulateTradingDay(List<Company_Observer> companies, InvestorCollectionInterface investors) throws InterruptedException {

        TradeEventTracker tradeEventTracker = TradeEventTracker.getInstance();

        Random random = new Random();

        int i = 0;
        
        // Run till wee have budget as well as shares in the market
        while (tradeEventTracker.getTotalBudgetFloating() > 0 && tradeEventTracker.getTotalSharesInMarketToSell() > 0) {
        	
        	// Randomly pick a company to sell a share and an investor to buy a share
            int randomCompanyId = random.nextInt(100);
            int randomInvestor = random.nextInt(100);


            //System.out.println(randomCompanyId  + 1  + " \n ");
            Company_Observer company = companies.get(randomCompanyId);

            // If we do not have any remaining share in the company, go back and choose another
            if (company.getSharesRemaining() <= 0) {
                continue;
            }

            Investor investor = investors.getInvestorWithId(randomInvestor + 1);


            
            double sellPossible = investor.getBudget() - company.getSharePrice();

            // If investor can buy the share, if he/she has enough money
            if (sellPossible < 0) {
                //System.out.println("Investor: "  +investor.getId() + " Budget ");
                i++;

                if (i > 100) break;

                continue;
            }

            // tracks the number of shares remaining and total sold shares
            company.updateShares(1);

            // Update the singleton  tracker for business logic
            tradeEventTracker.addToNumOfTradesToday();
            tradeEventTracker.subtractToTotalSharesInMarketToSell(1);
            tradeEventTracker.subtractToTotalBudgetFloating(company.getSharePrice());


            // We are updating the budget for the investor
            investor.setBudget(sellPossible);

            
            // Doubling the price after 10 shares are sold for a company
            if (company.getSharesSold() == 10) {
                company.setPrice(company.getSharePrice() * 2);
            }

            
            // Making the share price 2 % less for the companies which sold 0 shares when 10 are sold in total.
            if (tradeEventTracker.getNumOfTradesToday() == 10) {
                updatePriceOn10Sale(companies);
            }

            //System.out.println("Trading ... " + randomCompanyId + " .... " + randomInvestor);

            // Printing the top and bottoms so far
            printStats(companies, investors);

            // Controls the speed of simulation
            TimeUnit.MILLISECONDS.sleep(150);

        }

    }

    // Updating the price for company with 0 shares sold 
    public static void updatePriceOn10Sale(List<Company_Observer> companies) {

        for (Company_Observer observer : companies) {
            if (observer.getSharesSold() == 0) {
                observer.setPrice(observer.getSharePrice() * 0.98);
            }
        }
    }


    
    public static void printStats(List<Company_Observer> companies, InvestorCollectionInterface investors) {

        Company_Observer highestCapital = companies.get(0);
        Company_Observer lowestCapital = companies.get(0);

        Investor maxSharesInvestor = investors.getInvestorWithId(1);
        Investor lowestSharesInvestor = investors.getInvestorWithId(1);
        int maxSharesWithInvestor = 0;
        int minSharesWithInvestor = 0;



        // Finding the highest share and lowest shares sold 

        for (Company_Observer observer : companies) {
            double capital = observer.getSharePrice() * observer.getSharesRemaining(); // Calculating the capital as given in assignment document
            double highCap = highestCapital.getSharePrice() * observer.getSharesRemaining();
            double lowCap = lowestCapital.getSharePrice() * observer.getSharesRemaining();

            if (highCap < capital) {
                highestCapital = observer;
            }

            if (lowCap > capital) {
                lowestCapital = observer;
            }
        }
        
        // Finding all the companies with either highest or lowest shares and printing in menu
        for (Company_Observer observer : companies) {
            double capital = observer.getSharePrice() * observer.getSharesRemaining();

            double highCap = highestCapital.getSharePrice() * observer.getSharesRemaining();
            double lowCap = lowestCapital.getSharePrice() * observer.getSharesRemaining();

            if (capital == highCap) {
                System.out.println("Company id for highest capital: " + highestCapital.getId() + "  with current capital:  " + capital);
            }

            if (capital == lowCap) {
                System.out.println("Company id for lowest capital: " + lowestCapital.getId() + "  with current capital:  " + capital);
            }
        }

        
        
        // FInding the investors with the highest and lowest number of shares and 
        for (Investor investor : investors.getInvestorList()) {
            double currentShare = 0;

            for (Map.Entry<Integer, Integer> entry : investor.companyStockMap.entrySet()) {

                currentShare += entry.getValue();
            }

            int maxShares = 0;

            
            // Taking the map value for each investor as we save the shares with a invest in a map 
            for (Map.Entry<Integer, Integer> entry : maxSharesInvestor.companyStockMap.entrySet()) {
                maxShares += entry.getValue();
            }

            int minShares = 0;

            for (Map.Entry<Integer, Integer> entry : lowestSharesInvestor.companyStockMap.entrySet()) {
                minShares += entry.getValue();
            }

            if(minShares == 0){
                minShares = Integer.MAX_VALUE;
            }

            if (maxShares < currentShare) {
                maxSharesInvestor = investor;
                maxSharesWithInvestor = maxShares;
            }

            if ( minShares > 0 && minShares > currentShare ) {
                lowestSharesInvestor = investor;
                minSharesWithInvestor = minShares;
            }
        }
        
        // Printing the investors with min and max shares

        System.out.println("Investor id for most shares: " + maxSharesInvestor.getId() + "  with total shares:  " + maxSharesWithInvestor);

        System.out.println("Investor id for least shares: " + lowestSharesInvestor.getId() + "  with total shares:  " + minSharesWithInvestor);

        System.out.println("\n");
  }

}
