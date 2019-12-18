package chatting;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread implements Runnable {

    public Socket socket;

    public ServerThread (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str = br.readLine();
                PrintStream pw2 = new PrintStream(new FileOutputStream("Day011\\src\\chatting\\log.txt", true));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                pw2.println(df.format(new Date()));
                pw2.flush();
                pw2.println("用户"+socket.getPort()+"说："+str);
                pw2.flush();
                for (Socket item : SocketService.socketList) {
                    PrintStream pw = new PrintStream(item.getOutputStream());
                    pw.println("用户"+socket.getPort()+"说："+str);
                    pw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
