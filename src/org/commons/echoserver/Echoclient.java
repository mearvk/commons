package org.commons.echoserver;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Echoclient
{
    public Echoclient.Thread001 thread_001 = new Echoclient.Thread001(this);

    public Echoclient()
    {
        Constructors.call(Echoclient.class, "{org.commons.echoserver}","{grp.001}","{n/a}", "{ref.001}", "{exc.001}", this);
    }

    public static class Thread001 extends Thread
    {
        public Echoclient echoclient;

        public Thread001(Echoclient echoclient)
        {
            this.echoclient = echoclient;
        }

        @Override
        public void run()
        {
            while(true)
            {
                try
                {
                    Socket socket = new Socket("localhost",8888);

                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    writer.write("An Apple; ");

                    writer.write("An Apple Tree; ");

                    writer.write("An Apple Tree Orchard.");

                    writer.flush();

                    writer.close();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }

                Commons.call(Threading.Sleep.class,"","","","","", 10L);
            }
        }

        public static class Internals
        {
            public Echoserver echoserver;

            public ServerSocket serversocket;

            public InputStream inputstream;

            public OutputStream outputstream;

            public Message message;

            public Socket socket;

            public Integer port = 8888;
        }
    }
}
