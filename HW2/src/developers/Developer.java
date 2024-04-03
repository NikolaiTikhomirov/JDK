package developers;

abstract class Developer implements Frontendable {
    String name;
    int age;

    public Developer (String name, int age) {
        this.name = name;
        this.age = age;
    }
}
