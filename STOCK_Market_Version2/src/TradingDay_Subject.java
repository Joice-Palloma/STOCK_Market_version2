public interface TradingDay_Subject {
	
	//interface methods with its parameter
    public void register(Company_Observer company);

    public void unregister(Company_Observer company);


    public void notifyObservers();
}
