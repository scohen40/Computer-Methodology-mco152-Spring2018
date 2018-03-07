package cohen.change;

public class VendingMachine {

	public static Change pay(double price, double paid) {
		Change change = new Change();
		Change priceAmount = new Change(price);
		Change paidAmount = new Change(paid);
		change.setQuarters(paidAmount.getQuarters() - priceAmount.getQuarters());
		change.setDimes(paidAmount.getDimes() - priceAmount.getDimes());
		change.setNickles(paidAmount.getNickles() - priceAmount.getNickles());
		change.setPennies(paidAmount.getPennies() - priceAmount.getPennies());
		return change;
	}
}
