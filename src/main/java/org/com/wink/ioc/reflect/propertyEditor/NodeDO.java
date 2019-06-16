package org.com.wink.ioc.reflect.propertyEditor;

import java.util.Date;

public class NodeDO {

    private String name;
    private String email;
    private Date dateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "NodeDO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
