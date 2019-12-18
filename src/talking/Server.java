package talking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("服务器已开启，请上传文件...");
        while (true) {
            Socket accept = ss.accept();
            new Thread(() -> {
                try {
                    while (accept.getInputStream() != null){
                        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                        byte[] bytes = new byte[1024*8];
                        int len;
                        len = bis.read(bytes);
                        System.out.println("【" + Thread.currentThread().getName() + "】  " + accept.getPort() + "---" + new String(bytes));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            //获取输入流对象
            //获取输出流对象



            //读写数据

//                    bis.close();
//                    accept.close();
        }


    }
}
