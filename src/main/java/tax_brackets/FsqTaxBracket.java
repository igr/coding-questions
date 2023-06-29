package tax_brackets;

public class FsqTaxBracket {

    public static void main(String[] args) {
        System.out.println(calculateTax(56000));    // 7900
        System.out.println(calculateTax(36000));    // 4600
    }

    static class TaxBoundary {
        double lowerBound;
        double upperBound;
        double taxRate;

        public TaxBoundary(double lowerBound, double upperBound, double taxRate) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.taxRate = taxRate;
        }
    }

    static TaxBoundary[] brackets = new TaxBoundary[] {
            new TaxBoundary(0, 10000, 0.1),
            new TaxBoundary(10000, 25000, 0.13),
            new TaxBoundary(25000, 50000, 0.15),
            new TaxBoundary(50000, Double.MAX_VALUE, 0.2)
    };

    private static double calculateTax(int income) {
        double tax = 0;
        for (TaxBoundary bracket : brackets) {
            if (income > bracket.upperBound) {
                tax += (bracket.upperBound - bracket.lowerBound) * bracket.taxRate;
            } else {
                tax += (income - bracket.lowerBound) * bracket.taxRate;
                break;
            }
        }
        return tax;
    }


}
