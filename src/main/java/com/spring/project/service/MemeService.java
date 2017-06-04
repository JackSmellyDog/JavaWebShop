package com.spring.project.service;

import com.spring.project.model.Meme;

import java.util.List;

public interface MemeService {
    void addMeme(Meme meme);
    void updateMeme(Meme meme);
    void removeMeme(long id);
    void getMemeById(long id);
    List<Meme> listMemes();
}
