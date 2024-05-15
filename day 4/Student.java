public class Student {
  private String name;
  private int rollNumber;
  private Subject[] subjects;

  public Student(String name, int rollNumber, Subject[] subjects) {
      this.name = name;
      this.rollNumber = rollNumber;
      this.subjects = subjects;
  }

  // Method to calculate total marks
  public int calculateTotalMarks() {
      int totalMarks = 0;
      for (Subject subject : subjects) {
          totalMarks += subject.getMarks();
      }
      return totalMarks;
  }

  // Method to display result
  public void displayResult() {
      System.out.println("Student Name: " + name);
      System.out.println("Roll Number: " + rollNumber);
      System.out.println("Subject-wise Marks:");
      for (Subject subject : subjects) {
          System.out.println(subject.getName() + ": " + subject.getMarks());
      }
      System.out.println("Total Marks: " + calculateTotalMarks());
  }

  // Getters and setters
}
