package networks;

import java.io.*;
import java.net.*;

/**
 * Created by dance2die on 3/5/2016.
 */
public class NetworkMain {
    public static void main(final String[] args){

//        testEcho();
        testListResource();
    }

    private static void testListResource() {
        try
        {
            URL url = new URL("http://www.google.com");
            InputStream is = url.openStream();
            try
            {
                int ch;
                while ((ch = is.read()) != -1)
                    System.out.print((char) ch);
            }
            catch (IOException ioe)
            {
                is.close();
            }
        }
        catch (MalformedURLException murle)
        {
            System.err.println("invalid URL");
        }
        catch (IOException ioe)
        {
            System.err.println("I/O error: " + ioe.getMessage());
        }
    }

    private static void testEcho() {
        try
        {
            runServerSocket();

            Socket socket = new Socket("localhost", 9999);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
            String message = "Hello Cruel World!";
            pw.println(message);
            pw.flush();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            System.out.println(br.readLine());
        }
        catch (UnknownHostException uhe)
        {
            System.err.println("unknown host: " + uhe.getMessage());
        }
        catch (IOException ioe)
        {
            System.err.println("I/O error: " + ioe.getMessage());
        }
    }

    private static void runServerSocket() throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        while (true)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    // obtain socket input/output streams and communicate with socket
                    try {
                        final Socket s = ss.accept();
                        OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
                        PrintWriter pw = new PrintWriter(osw);
                        String message = "Hello Cruel World!";
                        pw.println(message);
                        pw.flush();


                        s.close();
                    } catch (IOException ioe) {}
                }
            }).start();
        }
    }
}
