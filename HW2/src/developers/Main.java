package developers;

public class Main {
    public static void main(String[] args) {
        Backender backender = new Backender("John", 33);
        Frontender fronender = new Frontender("Bob", 22);
        Fullstack fullstackDeveloper = new Fullstack("Mike", 44);
        Backendable fullstack2 = new Fullstack("Nick", 55);

        System.out.println("Backender try work!");
        backender.doBackendWork();
        backender.doFrontendWork();
        System.out.println("");

        System.out.println("Frontender try work!");
        fronender.doBackendWork();
        fronender.doFrontendWork();
        System.out.println("");

        System.out.println("Fullstack-developer try work!");
        fullstackDeveloper.doBackendWork();
        fullstackDeveloper.doFrontendWork();
        System.out.println("");

        fullstack2.doBackendWork();
        System.out.println("");

        // HW
        Developer backender2 = new Backender("Mary", 33);
        Developer fronender2 = new Frontender("Lily", 22);
        Developer fullstackDeveloper2 = new Fullstack("Yumy", 44);

        System.out.println("Developer2 try work!");
        backender2.doFrontendWork();
        System.out.println("");

        System.out.println("Fronender2 try work!");
        fronender2.doFrontendWork();
        System.out.println("");

        System.out.println("FullstackDeveloper2 try work!");
        fullstackDeveloper2.doFrontendWork();

    }
}
