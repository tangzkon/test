package socket_demo_2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket localhost = new Socket("localhost", 9999);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("cc.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(localhost.getOutputStream());

            byte[] bytes = new byte[8*1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

            bos.close();
            bis.close();
            localhost.close();

            System.out.println("文件已上传完毕！");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
