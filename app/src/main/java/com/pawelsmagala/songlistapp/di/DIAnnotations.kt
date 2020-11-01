package com.pawelsmagala.songlistapp.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalJsonFormat

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ITunesJsonFormat