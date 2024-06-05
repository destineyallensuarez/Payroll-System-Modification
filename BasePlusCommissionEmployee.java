import java.time.LocalDate;

public class BasePlusCommissionEmployee {
   private CommissionEmployee commissionEmployee; // composition
   private double baseSalary; // base salary per week
   private Date birthDate; // employee's birth date

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary, Date birthDate) {
      if (baseSalary < 0.0) {
         throw new IllegalArgumentException(
            "Base salary must be >= 0.0");
      }

      commissionEmployee = 
         new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

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
      double earnings = getBaseSalary() + commissionEmployee.earnings();
      
      // Get today's date
      LocalDate today = LocalDate.now();
      
      // Check if it's the employee's birthday
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
      return String.format("%s %s\n%s: %.2f", "base-salaried", 
         commissionEmployee.toString(), "base salary", getBaseSalary());
   } 
}
