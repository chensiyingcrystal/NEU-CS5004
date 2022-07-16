public class SeniorSDE extends AbstractEngineer{
    private double numberOfReports;

    public SeniorSDE(String name, double baseSalary, double numberOfReports) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = 0;
        this.numberOfReports = numberOfReports;
    }

    @Override
    public void setBonus(Rating rating) {
        double bonusRatio = numberOfReports / 5.0;
        this.bonus = this.baseSalary * bonusRatio;
        return;
    }

}
