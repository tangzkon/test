package chatting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread1 implements Runnable {

    public Socket socket;

    public SocketThread1(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            while(true){
                String str = br.readLine();
                pw.println(str);
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

