package org.commons.echoserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Echoserver
{
    public Thread001 thread_001 = new Thread001(this);

    public Thread002 thread_002 = new Thread002(this);

    public Queue queue = new Queue();

    public Echoserver()
    {
        Constructors.call(Echoserver.class, "{org.commons.echoserver}","{grp.001}","{n/a}", "{ref.001}", "{exc.001}", this);
    }

    public static class Thread001 extends Thread
    {
        public Internals internals = new Internals();

        public Thread001(Echoserver echoserver)
        {
            this.internals.echoserver = echoserver;
        }

        @Override
        public void run()
        {
            Commons.call(Echoserver.Thread001.class, "{org.commons.echoserver}","{grp.002}","{n/a}", "{ref.001}", "{exc.001}", this.internals);

            while(true)
            {
                Commons.call(Echoserver.Thread001.class, "{org.commons.echoserver}","{grp.002}","{n/a}", "{ref.002}", "{exc.001}", this.internals);

                Commons.call(Echoserver.Thread001.class, "{org.commons.echoserver}","{grp.002}","{n/a}", "{ref.003}", "{exc.001}", this.internals);

                Commons.call(Echoserver.Thread001.class, "{org.commons.echoserver}","{grp.002}","{n/a}", "{ref.004}", "{exc.001}", this.internals);

                Commons.call(Echoserver.Thread001.class, "{org.commons.echoserver}","{grp.002}","{n/a}", "{ref.005}", "{exc.001}", this.internals);

                Commons.call(Threading.Sleep.class, "{org.commons.threading}","{}","{}", "{}", "{exc.001}", 10L);
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

    public static class Thread002 extends Thread
    {
        public Internals internals = new Internals();

        public Thread002(Echoserver echoserver)
        {
            this.internals.echoserver = echoserver;
        }

        @Override
        public void run()
        {
            while(true)
            {
                Commons.call(Echoserver.Thread002.class, "{org.commons.echoserver}","{grp.003}","{n/a}", "{ref.001}", "{exc.001}", this.internals);

                Commons.call(Echoserver.Thread002.class, "{org.commons.echoserver}","{grp.003}","{n/a}", "{ref.002}", "{exc.001}", this.internals);

                Commons.call(Threading.Sleep.class, "{org.commons.threading}","{}","{}", "{}", "{exc.001}", 10L);
            }
        }

        public static class Internals
        {
            public Echoserver echoserver;

            public Message message;
        }
    }
}