import java.time.LocalDate;

public class BasePlusCommissionEmployee extends Employee {
   private double grossSales; // gross weekly sales       
   private double commissionRate; // commission percentage
   private double baseSalary; // base salary per week
   private Date birthDate; // employee's birth date

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double grossSales, double commissionRate, 
      double baseSalary, Date birthDate) {
      super(firstName, lastName, socialSecurityNumber);

      if (grossSales < 0.0) {
         throw new IllegalArgumentException(
            "Gross sales must be >= 0.0");
      }

      if (commissionRate <= 0.0 || commissionRate >= 1.0) {
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      }

      if (baseSalary < 0.0) {
         throw new IllegalArgumentException(
            "Base salary must be >= 0.0");
      }

      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
      this.baseSalary = baseSalary;
      this.birthDate = birthDate;
   } 

   // set and get methods for birth date
   public void setBirthDate(Date birthDate) {
      this.birthDate = birthDate;
   }

   public Date getBirthDate() {
      return birthDate;
   }

   // calculate earnings with birthday bonus
   public double earnings() {
      double earnings = getBaseSalary() + (getCommissionRate() * getGrossSales());
      
      // Check if it's the employee's birthday
      LocalDate today = LocalDate.now();
      if (birthDate.getMonth() == today.getMonthValue() &&
          birthDate.getDay() == today.getDayOfMonth()) {
         // Add $100 bonus
         earnings += 100.0;
      }
      
      return earnings;
   } 

   // return String representation of BasePlusCommissionEmployee
   @Override
   public String toString() {
      return String.format("%s\n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %s",
         super.toString(), "Gross Sales", getGrossSales(),
         "Commission Rate", getCommissionRate(), 
         "Base Salary", getBaseSalary(),
         "Birth Date", getBirthDate());
   } 
}
