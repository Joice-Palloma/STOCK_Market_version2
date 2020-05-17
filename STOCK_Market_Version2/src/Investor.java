import java.util.HashMap;

public class Investor {

    private long id;

    private double budget;

    HashMap<Integer, Integer> companyStockMap;

    public Investor(int id) {
        this.id = id;
        companyStockMap = new HashMap<>();
    }

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
