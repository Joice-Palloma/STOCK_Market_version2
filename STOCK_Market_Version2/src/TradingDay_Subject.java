public interface TradingDay_Subject {

    public void register(Company_Observer company);

    public void unregister(Company_Observer company);


    public void notifyObservers();
}
