public class User {
  public String passportNumber, name, contact;

  public User(String passportNumber, String name, String contact) {
      this.passportNumber = passportNumber;
      this.name = name;
      this.contact = contact;
  }

  @Override
  public String toString() {
      return "Passport: " + passportNumber + " | Name: " + name + " | Contact: " + contact;
  }
}
