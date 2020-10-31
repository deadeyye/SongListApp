package com.pawelsmagala.songlistapp.songListActivity;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.pawelsmagala.domain.song.SongDataSource;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class SongListViewModel_AssistedFactory implements ViewModelAssistedFactory<SongListViewModel> {
  private final Provider<SongDataSource> songDataSource;

  @Inject
  SongListViewModel_AssistedFactory(Provider<SongDataSource> songDataSource) {
    this.songDataSource = songDataSource;
  }

  @Override
  @NonNull
  public SongListViewModel create(SavedStateHandle arg0) {
    return new SongListViewModel(songDataSource.get(), arg0);
  }
}
