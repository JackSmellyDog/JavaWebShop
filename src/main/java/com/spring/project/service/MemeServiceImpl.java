package com.spring.project.service;

import com.spring.project.dao.MemeDao;
import com.spring.project.model.Meme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemeServiceImpl implements MemeService {
    @Autowired
    private MemeDao memeDao;

    public void setMemeDao(MemeDao memeDao) {
        this.memeDao = memeDao;
    }

    @Override
    @Transactional
    public void addMeme(Meme meme) {
        this.memeDao.save(meme);
    }

    @Override
    @Transactional
    public void updateMeme(Meme meme) {
        this.memeDao.delete(meme.getId());
        this.memeDao.save(meme);
    }

    @Override
    @Transactional
    public void removeMeme(long id) {
        this.memeDao.delete(id);
    }

    @Override
    @Transactional
    public void getMemeById(long id) {
        this.memeDao.getOne(id);
    }

    @Override
    @Transactional
    public List<Meme> listMemes() {
        return this.memeDao.findAll();
    }
}
