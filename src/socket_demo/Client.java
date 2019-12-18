package socket_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 6666);
        OutputStream outputStream = client.getOutputStream();
        FileInputStream fis = new FileInputStream("cc.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {

            outputStream.write(bytes);
        }

        fis.close();
        outputStream.close();
        client.close();

    }
}
