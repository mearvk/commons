package org.commons.echoserver;

import java.util.LinkedList;

public class Queue extends LinkedList<Message>
{
    public void enqueue(Message message)
    {
        this.add(message);
    }

    public Message dequeue()
    {
        return this.poll();
    }
}
