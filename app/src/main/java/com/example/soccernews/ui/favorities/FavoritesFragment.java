package com.example.soccernews.ui.favorities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.soccernews.MainActivity;
import com.example.soccernews.databinding.FragmentFavoritesBinding;
import com.example.soccernews.domain.News;
import com.example.soccernews.ui.adapter.NewsAdapter;

import java.util.List;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);


        MainActivity activity = (MainActivity) getActivity();
        loadFavoriteNews(activity);

        return binding.getRoot();
    }

    private void loadFavoriteNews(MainActivity activity) {
        List<News> favoriteNews = null;
        if (activity != null) {
            activity.getDb().newsDao().loadFavoriteNews();

            binding.rvFavorite.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvFavorite.setAdapter(new NewsAdapter(favoriteNews, updateNews -> {
                activity.getDb().newsDao().save(updateNews);
            }));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}