import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    private static ServerSocket ss;
    private static Socket s;
    private static BufferedReader br;
    private static InputStreamReader isr;
    private static String mess = "";
    private static int counts;
    
    public static void main(String[] args) throws SocketException  {
        try {
            while (true) {
                ss = new ServerSocket(8888);
                if (counts != 0) {
                    s = ss.accept();
                    isr = new InputStreamReader(s.getInputStream());
                    br = new BufferedReader(isr);
                    mess = br.readLine();
    
                    System.out.println(mess);
    
                    isr.close();
                    br.close();
                    ss.close();
                    s.close();
                } else {
                System.out.println("Waiting for client connections");
                s = ss.accept();
                System.out.println("Client Connet");
                counts++;
                isr = new InputStreamReader(s.getInputStream());
                br = new BufferedReader(isr);
                mess = br.readLine();

                System.out.println(mess);

                isr.close();
                br.close();
                ss.close();
                s.close();
                }
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
