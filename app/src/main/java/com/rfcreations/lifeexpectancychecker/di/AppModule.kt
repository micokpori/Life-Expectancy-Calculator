package com.rfcreations.lifeexpectancychecker.di

import android.content.Context
import android.content.SharedPreferences
import com.rfcreations.lifeexpectancychecker.reposiitory.UserPreferenceRepository
import com.rfcreations.lifeexpectancychecker.reposiitory.UserPreferenceRepositoryImpl
import com.rfcreations.lifeexpectancychecker.util.ThemeUiState
import com.rfcreations.lifeexpectancychecker.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * A Dagger Hilt module that provides application-wide dependencies.
 * It is installed in the SingletonComponent, ensuring these dependencies are singletons.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Provides a [SharedPreferences] instance for managing app preferences.
     * It uses the PREF_NAME constant from Constants.PrefKeys and operates in private mode.
     *
     * @param context The application context, required to access shared preferences.
     * @return The shared preferences instance.
     */
    @Provides
    @Singleton
    fun providesSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        val prefName = Constants.PrefKeys.PREF_NAME
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    /**
     * Provides an instance of the UserPreferenceRepository, which is responsible for
     * interacting with user preferences stored in shared preferences.
     *
     * @param sharedPreferences The shared preferences instance, injected as a dependency.
     * @return An instance of the UserPreferenceRepositoryImpl.
     */
    @Provides
    @Singleton
    fun providesUserPreferenceRepository(sharedPreferences: SharedPreferences): UserPreferenceRepository {
        return UserPreferenceRepositoryImpl(sharedPreferences)
    }

    /**
     * Provides an instance of the ThemeUiState, which manages the state of the application's theme.
     * It depends on the UserPreferenceRepository to retrieve and update theme preferences.
     *
     * @param userPreferenceRepository The injected UserPreferenceRepository instance.
     * @return An instance of the ThemeUiState.
     */
    @Singleton
    @Provides
    fun providesThemeUiState(userPreferenceRepository: UserPreferenceRepository): ThemeUiState =
        ThemeUiState(userPreferenceRepository)
}
