package com.spring.project.model;

import javax.persistence.*;

@Entity
@Table(name = "memes")
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "meme_title")
    private String memeTitle;

    @Column(name = "meme_author")
    private String memeAuthor;

    @Column(name = "meme_description")
    private String memeDescription;

    @Column(name = "meme_img_link")
    private String memeImgLink;

    @Column(name = "meme_price")
    private double memePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMemeTitle() {
        return memeTitle;
    }

    public void setMemeTitle(String memeTitle) {
        this.memeTitle = memeTitle;
    }

    public String getMemeAuthor() {
        return memeAuthor;
    }

    public void setMemeAuthor(String memeAuthor) {
        this.memeAuthor = memeAuthor;
    }

    public String getMemeDescription() {
        return memeDescription;
    }

    public void setMemeDescription(String memeDescription) {
        this.memeDescription = memeDescription;
    }

    public String getMemeImgLink() {
        return memeImgLink;
    }

    public void setMemeImgLink(String memeImgLink) {
        this.memeImgLink = memeImgLink;
    }

    public double getMemePrice() {
        return memePrice;
    }

    public void setMemePrice(double memePrice) {
        this.memePrice = memePrice;
    }

    public Meme() {
    }

    @Override
    public String toString() {
        return "Meme{" +
                "id=" + id +
                ", memeTitle='" + memeTitle + '\'' +
                ", memeAuthor='" + memeAuthor + '\'' +
                ", memeDescription='" + memeDescription + '\'' +
                ", memeImgLink='" + memeImgLink + '\'' +
                ", memePrice=" + memePrice +
                '}';
    }
}
