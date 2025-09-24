package String.basic;

public class string {
    public static void main(String[] args){
        String original="Hello World";
        int len=original.length();
        char fc=original.charAt(0);
        String substr=original.substring(0,5);
        String concat=original.concat("!!");

        System.out.println(original);
        System.out.println(len);
        System.out.println(fc);
        System.out.println(original.toUpperCase());
        System.out.println(substr);
        System.out.println(concat);
        System.out.println(original.contains("World"));
        
    }
}
