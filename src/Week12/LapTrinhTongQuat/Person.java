public class Person implements Comparable<Person> {
    protected String name;
    protected int age;
    protected String address;

    public Person() {

    }

    /**
     * Constructor with basic information.
     *
     * @param name    The name of the person.
     * @param age     The age of the person.
     * @param address The address of the person.
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Compare two `Person` objects based on their name and then age if names are the same.
     */
    public int compareTo(Person p) {
        if (this.name.compareTo(p.name) != 0) {
            return this.name.compareTo(p.name);
        } else {
            return this.age - p.age;
        }
    }
}
