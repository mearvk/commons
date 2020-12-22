package org.commons.echoserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Message
{
    public InputStream is;

    public OutputStream os;

    public Socket socket;

    public String value;

    public Message(final String value, final Socket socket, final InputStream is, final OutputStream os)
    {
        this.value = value;

        this.socket = socket;

        this.is = is;

        this.os = os;
    }
}
