package socket_demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("服务器开启，等待客户端连接...");
            Socket server = ss.accept();
            InputStream is = server.getInputStream();
            FileOutputStream fos = new FileOutputStream("123.txt");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fos.close();
            is.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
