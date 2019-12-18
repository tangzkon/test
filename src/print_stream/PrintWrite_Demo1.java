package print_stream;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWrite_Demo1 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("PrintWriter.txt");
        pw.println("Hello,Java!");
        pw.flush();
    }
}
