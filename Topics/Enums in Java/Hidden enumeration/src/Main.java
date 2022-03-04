public class Main {

    public static void main(String[] args) {
        // write your program here
        int count = 0;
        String stringToSearch = "STAR";
        for (Secret secret : Secret.values()) {
            if (secret.name().startsWith(stringToSearch)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
// enum Secret {
//    STAR, CRASH, START, // ...
//}
