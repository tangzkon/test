package talking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Talker_2 {
    public static void main(String[] args) throws IOException {
        Socket localhost = new Socket("localhost", 8888);
        OutputStream is = localhost.getOutputStream();

        System.out.println("【Talker_2】已经连接服务器,请输入要发送的文本...");
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!"quit".equals(s=scanner.nextLine())) {
            is.write(s.getBytes());
            is.flush();
            InputStream in = localhost.getInputStream();
            // 5. 读取数据数据
            byte[] b = new byte[1024*8];
            int len = in.read(b);
            System.out.println(new String(b, 0, len));
        }
        is.close();
        localhost.close();
    }
}
