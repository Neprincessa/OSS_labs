import com.Process;
import com.interactive.Interactive;
import com.manual.Manual;

public class HashFunc {

    public static Process session;

    public static void main(String[] args){
        if (args.length == 1 && args[0].equals("-i")) {
            session = new Interactive();
            session.start();
        }
        else
            if (args.length > 2
                    && (args[0].equals("-md5") || args[0].equals("-sha256"))
                    && args[1].equals("-f")) {
                session = new Manual(args);
                session.start();
            }
            else
                System.out.println("Invalid arguments");
    }
}
