package bank_balance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToptalSolution2 {

	public static void main(final String[] args) {
		new ToptalSolution2().solution(new int[]{1, -1, 0, -105, 1},
				new String[]{"2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12"});
	}

	private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public int solution(final int[] A, final String[] D) {
		final int totalIncome = calcTotalIncome(A);

		// calc card payment per month
		final int[] monthCardPayments = new int[12];
		final int[] monthCardFrequency = new int[12];
		for (int i = 0; i < A.length; i++) {
			final int payment = A[i];
			final int month  = LocalDate.parse(D[i], DTF).getMonthValue();        // 1-index
			if (payment < 0) {
				monthCardPayments[month - 1] += -payment;
				monthCardFrequency[month - 1]++;
			}
		}

		// count number of +100 months
		int billableMonths = 12;
		for (int i = 0; i < monthCardPayments.length; i++) {
			final int monthCardPayment = monthCardPayments[i];
			final int monthCardFrequence = monthCardFrequency[i];
			if (monthCardPayment >= 100 && monthCardFrequence >= 3) {
				billableMonths--;
			}
		}

		return totalIncome - billableMonths * 5;
	}


	private int calcTotalIncome(final int[] A) {
		int totalIncome = 0;
		for (final int i : A) {
			totalIncome += i;
		}
		return totalIncome;
	}
}
