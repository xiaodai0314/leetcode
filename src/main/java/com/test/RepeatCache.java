package com.test;

import java.io.Serializable;

public class RepeatCache implements Serializable {
    private long id;
    private String chat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "RepeatCache{" +
                "id=" + id +
                ", chat='" + chat + '\'' +
                '}';
    }
}
