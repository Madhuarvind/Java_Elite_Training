package String;

public class string_mutable {
    public static void main(String[] args) {
        String dept = "AIML";
        System.out.println(dept);
        System.out.println("Identity hash code: " + System.identityHashCode(dept));
        dept = "AIDS";
        System.out.println(dept);
        System.out.println("Identity hash code: " + System.identityHashCode(dept));
    }
}