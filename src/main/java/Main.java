import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Insert url of Git repository:");
        String url = Integer.toString(System.in.read());
        String script = "/home/khermano/BackUp/MyNewScript.sh"; //do not forget change name and path to your new script
        Runtime.getRuntime().exec(script); //check checkstyle report !!!
    }
}
