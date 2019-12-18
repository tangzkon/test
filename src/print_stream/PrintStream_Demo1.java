package print_stream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_Demo1 {
    public static void main(String[] args) throws IOException {
        System.out.println(97);

        //创建打印流，制定文件名
        PrintStream ps = new PrintStream("PrintStream.txt");

        //改变系统的打印流向，输出到PrintStream.txt
        System.setOut(ps);

        System.out.println(97);
    }
}
