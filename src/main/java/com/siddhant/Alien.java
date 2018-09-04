package com.siddhant;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {

    private String name;
    private int point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
