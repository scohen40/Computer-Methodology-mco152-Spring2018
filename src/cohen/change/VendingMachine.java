package cohen.change;

public class VendingMachine {

	public static Change pay(double price, double paid) {
		Change change = new Change();
		Change priceAmount = new Change(price);
		Change paidAmount = new Change(paid);
		change.setQuarters(priceAmount.getQuarters() - paidAmount.getQuarters());
		change.setDimes(priceAmount.getDimes() - paidAmount.getDimes());
		change.setNickles(priceAmount.getNickles() - paidAmount.getNickles());
		change.setPennies(priceAmount.getPennies() - paidAmount.getPennies());
		return change;
	}
}
