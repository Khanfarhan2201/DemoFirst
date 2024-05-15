public class School {
  public static void main(String[] args) {
      // Create subjects
      Subject[] subjects = {
          new Subject("Maths", 85),
          new Subject("Science", 90),
          new Subject("English", 80)
      };
      
      // Create student object
      Student student = new Student("John", 101, subjects);
      
      // Display result
      student.displayResult();
  }
}
