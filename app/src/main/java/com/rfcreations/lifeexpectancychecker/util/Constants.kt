package com.rfcreations.lifeexpectancychecker.util

/**
 * This object provides constants used across the application,
 */
object Constants {

    /**
     * An inner object that holds constant keys used for shared preferences.
     */
    object PrefKeys {
        /**
         * The name of the shared preference file used by the app.
         */
        const val PREF_NAME = "MyAppPref"

        /**
         * The key used to store the user's selected theme preference.
         */
        const val SELECTED_THEME_KEY = "SelectedTheme"

        /**
         * The key used to store whether the user has enabled dynamic theming.
         */
        const val DYNAMIC_THEME_KEY = "DynamicThemeEnabled"
    }
}
