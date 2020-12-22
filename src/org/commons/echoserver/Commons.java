package org.commons.echoserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Commons
{
    public static void call(Class<?> klass, final String namespace, final String grouping, final String subgrouping, final String reference, final String handler, final Object...objects)
    {
        if(namespace.equals("{org.bank.echoserver.Bank003}"))
        {
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

                        try
                        {
                            internals.echoserver.queue.add(internals.message);
                        }
                        catch(Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }

        if(namespace.equals("{org.bank.echoserver.Bank003}"))
        {
            if (klass.isAssignableFrom(Echoserver.Thread002.class))
            {
                if (grouping.equals("{grp.003}"))
                {

                }
            }
        }

        if(klass.isAssignableFrom(Echoserver.class))
        {
            if(grouping.equals("{grp.001}"))
            {
                if(reference.equals("{ref.001}"))
                {
                    Echoserver echoserver = new Echoserver();
                }
            }
        }

        if(klass.isAssignableFrom(Echoclient.class))
        {
            if(grouping.equals("{grp.001}"))
            {
                if(reference.equals("{ref.001}"))
                {
                    Echoclient echoclient = new Echoclient();
                }
            }
        }
    }
}
