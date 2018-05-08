package com.example.mihail.jsoncath;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chat {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("msg_id_author")
    @Expose
    private String msgIdAuthor;
    @SerializedName("msg_id_groupe")
    @Expose
    private Object msgIdGroupe;
    @SerializedName("msg_text")
    @Expose
    private String msgText;
    @SerializedName("msg_date")
    @Expose
    private String msgDate;
    @SerializedName("active_id")
    @Expose
    private String activeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgIdAuthor() {
        return msgIdAuthor;
    }

    public void setMsgIdAuthor(String msgIdAuthor) {
        this.msgIdAuthor = msgIdAuthor;
    }

    public Object getMsgIdGroupe() {
        return msgIdGroupe;
    }

    public void setMsgIdGroupe(Object msgIdGroupe) {
        this.msgIdGroupe = msgIdGroupe;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(String msgDate) {
        this.msgDate = msgDate;
    }

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

}


