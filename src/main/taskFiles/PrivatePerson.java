private class Person {
    private int age;
    private String name;

    private Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Person() {
        this(0, "Ivan");
    }

    private static void sayHello() {
        System.out.println("Hey, my name is...");
    }

    private void sayHello(String str) {
        System.out.println("Hey, my name is..." + str);
    }

    private void sayHello(int str) {
        System.out.println("Hey, my name is..." + str);
    }

    private void sayHello(int str, String str2) {
        System.out.println("Hey, my name is..." + str);
    }

    private void sayHello(String str, int str2) {
        System.out.println("Hey, my name is..." + str);
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static int meet(Person person, Person person12) {
        return person.getAge() + person12.getAge();
    }
}
