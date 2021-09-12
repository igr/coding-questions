package lemonade_stand;

public class VroomLemonade {

	private int billsOf5;
	private int billsOf10;
	private int billsOf20;

	public static void main(final String[] args) {
		new VroomLemonade().run();

	}

	public void run() {
		final int[] input = new int[] {
				5, 5, 5, 10, 20
		};

		for (final int payment : input) {
			acceptMoney(payment);
			if (calculateTheReturningMoney(payment) == false) {
				System.out.println("NOPE");
				return;
			}
		}
		System.out.println("YES");
	}

	private boolean calculateTheReturningMoney(final int payment) {
		int returnMoney = payment - 5;

		while (returnMoney > 0) {
			if (returnMoney >= 10 && billsOf10 > 0) {
				billsOf10--;
				returnMoney -= 10;
				continue;
			}
			if (returnMoney >= 5 && billsOf5 > 0) {
				billsOf5--;
				returnMoney -= 5;
				continue;
			}
			// error return false
			return false;
		}
		return true;
	}

	private void acceptMoney(final int payment) {
		switch (payment) {
			case 5:
				billsOf5++; break;
			case 10:
				billsOf10++; break;
			case 20:
				billsOf20++; break;
		}
	}
}
