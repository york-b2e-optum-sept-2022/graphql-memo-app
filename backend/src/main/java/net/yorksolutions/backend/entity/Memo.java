package net.yorksolutions.backend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String text;

    private Integer prop1;
    private Integer prop2;
    private Integer prop3;
    private Integer prop4;
    private Integer prop5;
    private Integer prop6;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Foo> fooList;

    public Memo() {
    }

    public Memo(String text) {
        Random rand = new Random();

        this.text = text;
        this.fooList = new HashSet<Foo>();

        this.prop1 = rand.nextInt();
        this.prop2 = rand.nextInt();
        this.prop3 = rand.nextInt();
        this.prop4 = rand.nextInt();
        this.prop5 = rand.nextInt();
        this.prop6 = rand.nextInt();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getProp1() {
        return prop1;
    }

    public void setProp1(Integer prop1) {
        this.prop1 = prop1;
    }

    public Integer getProp2() {
        return prop2;
    }

    public void setProp2(Integer prop2) {
        this.prop2 = prop2;
    }

    public Integer getProp3() {
        return prop3;
    }

    public void setProp3(Integer prop3) {
        this.prop3 = prop3;
    }

    public Integer getProp4() {
        return prop4;
    }

    public void setProp4(Integer prop4) {
        this.prop4 = prop4;
    }

    public Integer getProp5() {
        return prop5;
    }

    public void setProp5(Integer prop5) {
        this.prop5 = prop5;
    }

    public Integer getProp6() {
        return prop6;
    }

    public void setProp6(Integer prop6) {
        this.prop6 = prop6;
    }

    public Set<Foo> getFooList() {
        return fooList;
    }

    public void setFooList(Set<Foo> fooList) {
        this.fooList = fooList;
    }
}
