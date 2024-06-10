public class Person {

    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
        this(0, "Ivan");
    }

    public static void sayHello() {
        System.out.println("Hey, my name is...");
    }

    public void sayHello(String str) {
        System.out.println("Hey, my name is..." + str);
    }

    public void sayHello(int str) {
        System.out.println("Hey, my name is..." + str);
    }

    public void sayHello(int str, String str2) {
        System.out.println("Hey, my name is..." + str);
    }

    public void sayHello(String str, int str2) {
        System.out.println("Hey, my name is..." + str);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int meet(Person person, Person person12) {
        return person.getAge() + person12.getAge();
    }
}