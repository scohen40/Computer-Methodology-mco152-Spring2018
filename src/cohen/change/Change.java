package cohen.change;

public class Change {
	int quarters;
	int dimes;
	int nickles;
	int pennies;

	// empty constructor
	public Change() {

	}

	// constructor that takes total money and makes coins
	public Change(double amount) {
		makeChange(amount);
	}

	// constructor that takes every amount of each coin
	public Change(int quarters, int dimes, int nickles, int pennies) {
		this.quarters = quarters;
		this.dimes = dimes;
		this.nickles = nickles;
		this.pennies = pennies;
	}

	// getters
	public int getQuarters() {
		return quarters;
	}

	public int getDimes() {
		return dimes;
	}

	public int getNickles() {
		return nickles;
	}

	public int getPennies() {
		return pennies;
	}

	// setters
	public void setQuarters(int quarters) {
		this.quarters = quarters;
	}

	public void setDimes(int dimes) {
		this.dimes = dimes;
	}

	public void setNickles(int nickles) {
		this.nickles = nickles;
	}

	public void setPennies(int pennies) {
		this.pennies = pennies;
	}

	// make change from total
	public void makeChange(double amount)

	{
		int totalCents = (int) Math.round(amount * 100);
		int quarterHold = totalCents % 25;
		setQuarters((totalCents - quarterHold) / 25);
		int dimeHold = quarterHold % 10;
		setDimes((quarterHold - dimeHold) / 10);
		int nickleHold = dimeHold % 5;
		setNickles((dimeHold - nickleHold) / 5);
		setPennies(nickleHold);
	}

	public String toString() {
		String contents;
		contents = "Here is your change: \nQuarters = " + quarters + "\nDimes = " + dimes + "\nNickles = " + nickles
				+ "\nPennies = " + pennies;

		return contents;
	}
}
