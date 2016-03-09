package networks;

import java.io.*;
import java.net.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dance2die on 3/5/2016.
 */
public class NetworkMain {
    public static void main(final String[] args){

//        testEcho();
//        testListResource();
//        testNetworkInterfaces();
//        testNetworkInterfaces2();
        testCookies();
    }

    private static void testCookies() {
        CookieManager cm = new CookieManager();
        cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cm);
        String url = "http://www.google.com";
        url = "http://www.microsoft.com";
        try {
            new URL(url).openConnection().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<HttpCookie> cookies = cm.getCookieStore().getCookies();
        for (HttpCookie cookie: cookies)
        {
            System.out.println("Name = " + cookie.getName());
            System.out.println("Value = " + cookie.getValue());
            System.out.println("Lifetime (seconds) = " + cookie.getMaxAge());
            System.out.println("Path = " + cookie.getPath());
            System.out.println();
        }
    }

    private static void testNetworkInterfaces2() {
        Enumeration<NetworkInterface> eni;
        try {
            eni = NetworkInterface.getNetworkInterfaces();

            for (NetworkInterface ni: Collections.list(eni))
            {
                System.out.println("Name = " + ni.getName());
                List<InterfaceAddress> ias = ni.getInterfaceAddresses();
                Iterator<InterfaceAddress> iter = ias.iterator();
                while (iter.hasNext())
                    System.out.println(iter.next());
                System.out.println();
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private static void testNetworkInterfaces() {
        Enumeration<NetworkInterface> eni;
        try {
            eni = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface ni: Collections.list(eni))
            {
                System.out.println("Name = " + ni.getName());
                System.out.println("Display Name = " + ni.getDisplayName());
                System.out.println("Loopback = " + ni.isLoopback());
                System.out.println("Up and running = " + ni.isUp());
                System.out.println("MTU = " + ni.getMTU());
                System.out.println("Supports multicast = " + ni.supportsMulticast());
                System.out.println("Sub-interfaces");
                Enumeration<NetworkInterface> eni2;
                eni2 = ni.getSubInterfaces();
                for (NetworkInterface ni2: Collections.list(eni2))
                    System.out.println("   " + ni2);
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
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
