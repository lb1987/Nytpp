package com.firsteconomy.nytapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.firsteconomy.nytapp.model.AllStoryDataCombined;
import com.firsteconomy.nytapp.model.Multimedium;
import com.firsteconomy.nytapp.model.StoryWithMedia;
import com.firsteconomy.nytapp.model.TopStory;
import com.firsteconomy.nytapp.network_responses.TopStoriesResponse;

import java.util.List;

@SuppressWarnings("ALL")
@Dao
public interface StoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopStoriesResponse(TopStoriesResponse... topStoriesResponses);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopStory(TopStory topStory);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopStories(List<TopStory> topStory);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultimedium(List<Multimedium> multimedium);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultimedium(Multimedium... multimedia);

    @Query("SELECT * FROM TopStoriesResponse where section = :section")
    LiveData<List<AllStoryDataCombined>> getTopStories(String section);

    //@Query("SELECT * FROM Multimedium")
    //LiveData<ArrayList<Multimedium>> getMultiMedia();

    @Query("SELECT * FROM TopStory where global_section = :section")
    LiveData<List<StoryWithMedia>> getStoryWithMedia(String section);

}