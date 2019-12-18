package socket_demo_2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        while (true) {
            System.out.println("服务器已开启，请上传文件...");
            Socket accept = ss.accept();
            new Thread(() -> {
                try {
                    //获取输入流对象
                    BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                    //获取输出流对象
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\out\\" + System.currentTimeMillis() + ".txt"));

                    //读写数据
                    byte[] bytes = new byte[1024*8];
                    int len;
                    while ((len = bis.read(bytes)) != -1) {
                        bos.write(bytes, 0, len);
                    }

                    bos.close();
                    bis.close();
                    accept.close();
                    System.out.println("文件已上传保存！");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
