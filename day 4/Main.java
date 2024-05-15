public class Main {
  public static void main(String[] args) {
      Employee emp1 = new Employee();
      Employee emp2 = new Employee();
      // Setting attributes for emp2
      emp2.empId = "Emp-01";
      emp2.empName = "Ram";
      emp2.salary = 60000.00;
      // Creating an Address object for emp2
      emp2.address = new Address();
      emp2.address.city = "Coimbator";
      emp2.address.state = "Tamilnadu";
      emp2.address.pincode = "434322";
      // Accessing and printing emp2 attributes
      System.out.println(emp2.empId); // Emp-01
      System.out.println(emp2.empName); // Ram
      System.out.println(emp2.salary); // 60000.00
      System.out.println(emp2.address.city); // Coimbator
      System.out.println(emp2.address.state); // Tamilnadu
      System.out.println(emp2.address.pincode); // 434322
  }
}
