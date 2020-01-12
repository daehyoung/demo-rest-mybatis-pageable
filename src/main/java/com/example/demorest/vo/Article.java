package com.example.demorest.vo;

public class Article {
    private Long id;
    private String title;
    private String author;
 
    // constructor, standard getters and setters
    public Article(){}

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}
}