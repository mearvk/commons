package org.commons.echoserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Commons
{
    public static void call(Class<?> klass, final String namespace, final String grouping, final String subgrouping, final String reference, final String handler, final Object...objects)
    {
        if(namespace.equals("{org.commons.echoserver}"))
        {
            if(klass.isAssignableFrom(Threading.Sleep.class))
            {
                Long millis = (Long)objects[0];

                try
                {
                    if(millis==null) return;

                    Thread.sleep(millis);
                }
                catch(Exception exception)
                {
                    exception.printStackTrace();
                }
            }

            if(klass.isAssignableFrom(Echoserver.Thread001.class))
            {
                if(grouping.equals("{grp.002}"))
                {
                    if(reference.equals("{ref.001}"))
                    {
                        Echoserver.Thread001.Internals internals = (Echoserver.Thread001.Internals) objects[0];

                        try
                        {
                            internals.serversocket = new ServerSocket(internals.port);
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }

                    if(reference.equals("{ref.002}"))
                    {
                        Echoserver.Thread001.Internals internals = (Echoserver.Thread001.Internals) objects[0];

                        try
                        {
                            internals.socket = internals.serversocket.accept();
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }

                    if(reference.equals("{ref.003}"))
                    {
                        Echoserver.Thread001.Internals internals = (Echoserver.Thread001.Internals) objects[0];

                        try
                        {
                            internals.inputstream = internals.socket.getInputStream();

                            internals.outputstream = internals.socket.getOutputStream();
                        }
                        catch(Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }

                    if(reference.equals("{ref.004}"))
                    {
                        Echoserver.Thread001.Internals internals = (Echoserver.Thread001.Internals) objects[0];

                        try
                        {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(internals.inputstream));

                            StringBuffer buffer = new StringBuffer();

                            String line=null;

                            while((line= reader.readLine())!=null)
                            {
                                buffer.append(line);
                            }

                            internals.message = new Message(buffer.toString(), internals.socket, internals.inputstream, internals.outputstream);
                        }
                        catch(Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }

                    if(reference.equals("{ref.005}"))
                    {
                        Echoserver.Thread001.Internals internals = (Echoserver.Thread001.Internals) objects[0];

                        System.err.println("Received: "+internals.message.value);

                        internals.echoserver.queue.enqueue(internals.message);
                    }
                }
            }
        }

        if(namespace.equals("{org.commons.echoserver}"))
        {
            if (klass.isAssignableFrom(Echoserver.Thread002.class))
            {
                if (grouping.equals("{grp.003}"))
                {
                    if(reference.equals("{ref.001}"))
                    {
                        Echoserver.Thread002.Internals internals = (Echoserver.Thread002.Internals) objects[0];

                        internals.message = internals.echoserver.queue.dequeue();
                    }

                    if(reference.equals("{ref.002}"))
                    {
                        Echoserver.Thread002.Internals internals = (Echoserver.Thread002.Internals) objects[0];

                        if(internals.message==null) return;

                        try
                        {
                            System.err.println("Returned: "+internals.message.value+"\n");

                            internals.message.os.write(internals.message.value.getBytes());

                            internals.message.os.flush();

                            internals.message.os.close();
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }

        if(klass.isAssignableFrom(Echoserver.class))
        {
            Echoserver echoserver = new Echoserver();
        }

        if(klass.isAssignableFrom(Echoclient.class))
        {
            Echoclient echoclient = new Echoclient();
        }
    }
}
