package org.commons.echoserver;

public class Main
{
    public static void main(String[] args)
    {
        Commons.call(Echoserver.class, "{org.commons.echoserver}","{}","{}", "{}", "{}");

        Commons.call(Echoclient.class, "{org.commons.echoserver}","{}","{}", "{}", "{}");
    }
}
