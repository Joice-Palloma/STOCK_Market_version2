import java.util.HashMap;

public class Investor {

	//attributes
    private long id;

    // Total amount of money with the investor
    private double budget;

    //hashmap to  store the company id and number of shares the investor bought
    HashMap<Integer, Integer> companyStockMap;

    public Investor(int id) {
        this.id = id;
        companyStockMap = new HashMap<>();
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
