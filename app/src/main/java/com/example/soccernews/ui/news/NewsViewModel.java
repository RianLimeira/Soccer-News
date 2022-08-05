package com.example.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soccernews.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        //TODO Remover Mock de Notícias
        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviaria tem Tem Desfalque Importante","Ferroviaria teve seu desfalque que pode mudar a situação do time"));
        news.add(new News("Ferrinha Joga no Sábado","Jogo acontecera no periodo da manha, e será bem importante"));
        news.add(new News("Copa do Mundo Feminina Está Terminando","Acompanhe os grandes momentos finais, Brasil está chegando e detonando"));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}