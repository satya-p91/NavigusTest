package com.satya.BLB.projectBLB;

import javax.persistence.*;


@Entity
@Table(name = "Beer")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String img;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String descr;
    private Boolean isfav;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Boolean getIsfav() {
        return isfav;
    }

    public void setIsfav(Boolean isfav) {
        this.isfav = isfav;
    }
}
