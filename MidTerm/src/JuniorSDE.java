public class JuniorSDE extends AbstractEngineer{
    private double linesOfCode;

    public JuniorSDE(String name, double baseSalary, double linesOfCode) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = 0;
        this.linesOfCode = linesOfCode;
    }

    @Override
    public void setBonus(Rating rating) {
        double bonusRatio = linesOfCode / 100.0;
        if (rating == Rating.SUPERB) {
            bonusRatio *= 2;
        }
        this.bonus = this.baseSalary * bonusRatio;
        return;
    }


}
