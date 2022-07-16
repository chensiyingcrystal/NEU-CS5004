public class SDE extends AbstractEngineer{
    private double numberOfDesignedDoc;
    private double linesOfCode;

    public SDE(String name, double baseSalary, double numberOfDesignedDoc, double linesOfCode) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = 0;
        this.numberOfDesignedDoc = numberOfDesignedDoc;
        this.linesOfCode = linesOfCode;
    }

    @Override
    public void setBonus(Rating rating) {
        double bonusRatio = linesOfCode / 80.0 + numberOfDesignedDoc / 5.0;
        if (rating == Rating.EXCEED_EXPECTATION) {
            bonusRatio *= 1.2;
        }
        else if (rating == Rating.SUPERB) {
            bonusRatio *= 1.7;
        }
        this.bonus = this.baseSalary * bonusRatio;
        return;
    }
}
