package entity;

import java.util.Date;

public class MessageBean {
    private int id;
    private String mcontent;
    private Date publish;

    public MessageBean() {
    }

    public MessageBean(int id, String mcontent, Date publish) {
        this.id = id;
        this.mcontent = mcontent;
        this.publish = publish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }
}
