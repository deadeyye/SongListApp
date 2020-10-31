package com.pawelsmagala.songlistapp.songListActivity;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = SongListViewModel.class
)
public interface SongListViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.pawelsmagala.songlistapp.SongListActivity.SongListViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(SongListViewModel_AssistedFactory factory);
}
