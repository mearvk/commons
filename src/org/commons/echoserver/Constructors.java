package org.commons.echoserver;

public class Constructors
{
    public static void call(Class<?> klass, final String namespace, final String grouping, final String subgrouping, final String reference, final String handler, final Object...objects)
    {
        if (klass.isAssignableFrom(Echoserver.class))
        {
            Echoserver.Thread001 thread_001 = ((Echoserver) objects[0]).thread_001;

            Echoserver.Thread002 thread_002 = ((Echoserver) objects[0]).thread_002;

            thread_001.start();

            thread_002.start();
        }

        if (klass.isAssignableFrom(Echoclient.class))
        {
            Echoclient.Thread001 thread_001 = ((Echoclient) objects[0]).thread_001;

            thread_001.start();
        }
    }
}
