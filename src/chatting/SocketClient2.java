package chatting;

import java.net.Socket;

public class SocketClient2 {
    public static void main(String args[])throws Exception{
        Socket socket = new Socket("localhost", 5208);
        System.out.println("恭喜你连接成功!");
        new Thread(new SocketThread1(socket)).start();
        new Thread(new SocketThread2(socket)).start();
    }
}
