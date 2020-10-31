package com.pawelsmagala.songlistapp.songListActivity;

import com.pawelsmagala.domain.song.SongDataSource;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SongListViewModel_AssistedFactory_Factory implements Factory<SongListViewModel_AssistedFactory> {
  private final Provider<SongDataSource> songDataSourceProvider;

  public SongListViewModel_AssistedFactory_Factory(
      Provider<SongDataSource> songDataSourceProvider) {
    this.songDataSourceProvider = songDataSourceProvider;
  }

  @Override
  public SongListViewModel_AssistedFactory get() {
    return newInstance(songDataSourceProvider);
  }

  public static SongListViewModel_AssistedFactory_Factory create(
      Provider<SongDataSource> songDataSourceProvider) {
    return new SongListViewModel_AssistedFactory_Factory(songDataSourceProvider);
  }

  public static SongListViewModel_AssistedFactory newInstance(
      Provider<SongDataSource> songDataSource) {
    return new SongListViewModel_AssistedFactory(songDataSource);
  }
}
