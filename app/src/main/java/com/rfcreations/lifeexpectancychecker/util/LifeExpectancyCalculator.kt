package com.rfcreations.lifeexpectancychecker.util

import android.content.Context
import com.rfcreations.lifeexpectancychecker.R

/**
 * Wrapper object to calculate life expectancy
 * @author Okporiaku Miracle
 * @date 3/17/2024
 */
object LifeExpectancyCalculator {
    /**
     * Calculates an estimated life expectancy based on various user inputs.
     *
     * @param context The Android context to access resources.
     * @param selectedCountry The user-selected country.
     * @param genderSelection The user-selected gender ("Male" or "Female").
     * @param smokeSelection The user's smoking habit selection.
     * @param socialClassSelection The user's social class selection.
     * @param educationSelection The user's education level selection.
     * @param relationshipSelection The user's relationship status selection.
     * @param diabeticSelection Whether the user has diabetes (Yes/No).
     * @param jobSelection The user's job type selection.
     * @param bmiSelection The user's BMI category selection.
     * @param exerciseSelection The user's exercise frequency selection.
     * @return A Pair containing the estimated life expectancy and the average life expectancy for the selected country and gender.
     */
    fun calculateLifeExpectancy(
        context: Context,
        selectedCountry: String,
        genderSelection: String,
        smokeSelection: String,
        socialClassSelection: String,
        educationSelection: String,
        relationshipSelection: String,
        diabeticSelection: String,
        jobSelection: String,
        bmiSelection: String,
        exerciseSelection: String,
    ): Pair<Int, Int> {

        val averageLifeExpectancy =
            getCountryAverageLifeExpectancy(selectedCountry, genderSelection, context)
        var lifeExpectancy = averageLifeExpectancy
        val res = context.resources
        val smokeOptions = res.getStringArray(R.array.smoking_options)
        val socialClassOptions = res.getStringArray(R.array.social_class_options)
        val educationOptions = res.getStringArray(R.array.education_options)
        val relationshipStatusOptions = res.getStringArray(R.array.social_class_options)
        val diabeticOptions = res.getStringArray(R.array.diabetic_options)
        val jobStatusOptions = res.getStringArray(R.array.job_status_options)
        val bmiOptions = res.getStringArray(R.array.bmi_options)
        val exerciseOptions = res.getStringArray(R.array.exercise_options)

        when (smokeSelection) {
            smokeOptions[0] -> lifeExpectancy += 3
            smokeOptions[1] -> lifeExpectancy -= 1
            smokeOptions[2] -> lifeExpectancy -= 3
        }
        when (socialClassSelection) {
            socialClassOptions[0] -> lifeExpectancy -= 3
            socialClassOptions[1] -> lifeExpectancy += 1
            socialClassOptions[2] -> lifeExpectancy += 3
        }
        when (educationSelection) {
            educationOptions[0] -> lifeExpectancy += 1
            educationOptions[1] -> lifeExpectancy += 2
            educationOptions[2] -> lifeExpectancy += 3
        }
        when (relationshipSelection) {
            relationshipStatusOptions[0] -> lifeExpectancy -= 3
            relationshipStatusOptions[1] -> lifeExpectancy += 3
        }
        when (diabeticSelection) {
            diabeticOptions[0] -> lifeExpectancy -= 3
            diabeticOptions[1] -> lifeExpectancy += 0
        }
        when (jobSelection) {
            jobStatusOptions[0] -> lifeExpectancy += 2
            jobStatusOptions[1] -> lifeExpectancy -= 3
            jobStatusOptions[2] -> lifeExpectancy += 3
        }
        when (exerciseSelection) {
            exerciseOptions[0] -> lifeExpectancy -= 3
            exerciseOptions[1] -> lifeExpectancy += 1
            exerciseOptions[2] -> lifeExpectancy += 3
        }
        when (bmiSelection) {
            bmiOptions[0] -> lifeExpectancy -= 3
            bmiOptions[1] -> lifeExpectancy += 3
            bmiOptions[2] -> lifeExpectancy -= 3
            bmiOptions[3] -> lifeExpectancy -= 5
        }
        return Pair(lifeExpectancy, averageLifeExpectancy)
    }

    /**
     * Retrieves the average life expectancy for a given country and gender from a predefined set of values.
     *
     * @param selectedCountry The name of the country to retrieve the average life expectancy for.
     * @param gender The gender to retrieve the average life expectancy for (either "Male" or "Female").
     * @param context The Android context used to access string resources.
     * @return The average life expectancy for the specified country and gender, as an integer.
     */
    private fun getCountryAverageLifeExpectancy(
        selectedCountry: String,
        gender: String,
        context: Context
    ): Int {

        // Initialize a variable to hold the average life expectancy
        var averageLifeExp = 0

        // Access string resources from the context
        val res = context.resources

        // Define a lambda function to update the average life expectancy based on gender
        val updateAvgLifeExp: (Int, Int) -> Unit = { maleAvg, femaleAvg ->
            averageLifeExp = if (gender == res.getString(R.string.male)) maleAvg else femaleAvg
        }

        // Retrieve the average life expectancy based on the selected country using a when expression
        when (selectedCountry) {
            res.getString(R.string.afghanistan) -> updateAvgLifeExp(64, 67)
            res.getString(R.string.albania) -> updateAvgLifeExp(76, 80)
            res.getString(R.string.algeria) -> updateAvgLifeExp(75, 78)
            res.getString(R.string.andorra) -> updateAvgLifeExp(83, 87)
            res.getString(R.string.angola) -> updateAvgLifeExp(61, 64)
            res.getString(R.string.antigua_and_barbuda) -> updateAvgLifeExp(75, 78)
            res.getString(R.string.argentina) -> updateAvgLifeExp(77, 82)
            res.getString(R.string.armenia) -> updateAvgLifeExp(72, 78)
            res.getString(R.string.australia) -> updateAvgLifeExp(80, 84)
            res.getString(R.string.austria) -> updateAvgLifeExp(79, 84)
            res.getString(R.string.azerbaijan) -> updateAvgLifeExp(71, 76)
            res.getString(R.string.bahamas) -> updateAvgLifeExp(73, 76)
            res.getString(R.string.bahrain) -> updateAvgLifeExp(76, 78)
            res.getString(R.string.bangladesh) -> updateAvgLifeExp(71, 74)
            res.getString(R.string.barbados) -> updateAvgLifeExp(75, 79)
            res.getString(R.string.belarus) -> updateAvgLifeExp(67, 77)
            res.getString(R.string.belgium) -> updateAvgLifeExp(79, 83)
            res.getString(R.string.belize) -> updateAvgLifeExp(70, 75)
            res.getString(R.string.benin) -> updateAvgLifeExp(61, 62)
            res.getString(R.string.bhutan) -> updateAvgLifeExp(70, 72)
            res.getString(R.string.bolivia) -> updateAvgLifeExp(68, 71)
            res.getString(R.string.bosnia_and_herzegovina) -> updateAvgLifeExp(75, 78)
            res.getString(R.string.botswana) -> updateAvgLifeExp(66, 69)
            res.getString(R.string.brazil) -> updateAvgLifeExp(73, 79)
            res.getString(R.string.brunei) -> updateAvgLifeExp(75, 78)
            res.getString(R.string.bulgaria) -> updateAvgLifeExp(72, 77)
            res.getString(R.string.burkina_faso) -> updateAvgLifeExp(61, 63)
            res.getString(R.string.burundi) -> updateAvgLifeExp(59, 63)
            res.getString(R.string.cambodia) -> updateAvgLifeExp(68, 72)
            res.getString(R.string.cameroon) -> updateAvgLifeExp(58, 61)
            res.getString(R.string.canada) -> updateAvgLifeExp(80, 84)
            res.getString(R.string.cape_verde) -> updateAvgLifeExp(72, 76)
            res.getString(R.string.central_african_republic) -> updateAvgLifeExp(51, 54)
            res.getString(R.string.chad) -> updateAvgLifeExp(54, 56)
            res.getString(R.string.chile) -> updateAvgLifeExp(78, 83)
            res.getString(R.string.china) -> updateAvgLifeExp(75, 78)
            res.getString(R.string.colombia) -> updateAvgLifeExp(74, 79)
            res.getString(R.string.comoros) -> updateAvgLifeExp(63, 65)
            res.getString(R.string.congo_democratic) -> updateAvgLifeExp(60, 64)
            res.getString(R.string.congo_republic) -> updateAvgLifeExp(62, 65)
            res.getString(R.string.costa_rica) -> updateAvgLifeExp(79, 82)
            res.getString(R.string.cote_divoire) -> updateAvgLifeExp(57, 59)
            res.getString(R.string.croatia) -> updateAvgLifeExp(76, 81)
            res.getString(R.string.cuba) -> updateAvgLifeExp(77, 81)
            res.getString(R.string.cyprus) -> updateAvgLifeExp(80, 82)
            res.getString(R.string.czech_republic) -> updateAvgLifeExp(76, 81)
            res.getString(R.string.denmark) -> updateAvgLifeExp(81, 84)
            res.getString(R.string.djibouti) -> updateAvgLifeExp(62, 64)
            res.getString(R.string.dominica) -> updateAvgLifeExp(76, 79)
            res.getString(R.string.dominican_republic) -> updateAvgLifeExp(72, 76)
            res.getString(R.string.east_timor) -> updateAvgLifeExp(67, 70)
            res.getString(R.string.ecuador) -> updateAvgLifeExp(76, 80)
            res.getString(R.string.egypt) -> updateAvgLifeExp(71, 74)
            res.getString(R.string.el_salvador) -> updateAvgLifeExp(70, 74)
            res.getString(R.string.equatorial_guinea) -> updateAvgLifeExp(58, 62)
            res.getString(R.string.eritrea) -> updateAvgLifeExp(66, 68)
            res.getString(R.string.estonia) -> updateAvgLifeExp(74, 80)
            res.getString(R.string.eswatini) -> updateAvgLifeExp(55, 61)
            res.getString(R.string.ethiopia) -> updateAvgLifeExp(64, 66)
            res.getString(R.string.fiji) -> updateAvgLifeExp(67, 69)
            res.getString(R.string.finland) -> updateAvgLifeExp(82, 86)
            res.getString(R.string.france) -> updateAvgLifeExp(81, 85)
            res.getString(R.string.gabon) -> updateAvgLifeExp(65, 67)
            res.getString(R.string.gambia) -> updateAvgLifeExp(63, 66)
            res.getString(R.string.georgia) -> updateAvgLifeExp(73, 78)
            res.getString(R.string.germany) -> updateAvgLifeExp(80, 84)
            res.getString(R.string.ghana) -> updateAvgLifeExp(64, 66)
            res.getString(R.string.greece) -> updateAvgLifeExp(81, 85)
            res.getString(R.string.grenada) -> updateAvgLifeExp(75, 78)
            res.getString(R.string.guatemala) -> updateAvgLifeExp(72, 77)
            res.getString(R.string.guinea) -> updateAvgLifeExp(61, 64)
            res.getString(R.string.guinea_bissau) -> updateAvgLifeExp(58, 61)
            res.getString(R.string.guyana) -> updateAvgLifeExp(66, 69)
            res.getString(R.string.haiti) -> updateAvgLifeExp(64, 67)
            res.getString(R.string.honduras) -> updateAvgLifeExp(74, 76)
            res.getString(R.string.hungary) -> updateAvgLifeExp(74, 78)
            res.getString(R.string.iceland) -> updateAvgLifeExp(83, 86)
            res.getString(R.string.india) -> updateAvgLifeExp(69, 70)
            res.getString(R.string.indonesia) -> updateAvgLifeExp(69, 72)
            res.getString(R.string.iran) -> updateAvgLifeExp(73, 76)
            res.getString(R.string.iraq) -> updateAvgLifeExp(71, 75)
            res.getString(R.string.ireland) -> updateAvgLifeExp(82, 85)
            res.getString(R.string.israel) -> updateAvgLifeExp(82, 85)
            res.getString(R.string.italy) -> updateAvgLifeExp(83, 86)
            res.getString(R.string.jamaica) -> updateAvgLifeExp(74, 78)
            res.getString(R.string.japan) -> updateAvgLifeExp(84, 87)
            res.getString(R.string.jordan) -> updateAvgLifeExp(74, 77)
            res.getString(R.string.kazakhstan) -> updateAvgLifeExp(70, 77)
            res.getString(R.string.kenya) -> updateAvgLifeExp(66, 68)
            res.getString(R.string.kiribati) -> updateAvgLifeExp(67, 69)
            res.getString(R.string.korea_north) -> updateAvgLifeExp(67, 71)
            res.getString(R.string.korea_south) -> updateAvgLifeExp(81, 85)
            res.getString(R.string.kosovo) -> updateAvgLifeExp(72, 77)
            res.getString(R.string.kuwait) -> updateAvgLifeExp(74, 78)
            res.getString(R.string.kyrgyzstan) -> updateAvgLifeExp(69, 75)
            res.getString(R.string.laos) -> updateAvgLifeExp(68, 71)
            res.getString(R.string.latvia) -> updateAvgLifeExp(74, 80)
            res.getString(R.string.lebanon) -> updateAvgLifeExp(78, 80)
            res.getString(R.string.lesotho) -> updateAvgLifeExp(52, 54)
            res.getString(R.string.liberia) -> updateAvgLifeExp(63, 66)
            res.getString(R.string.libya) -> updateAvgLifeExp(72, 76)
            res.getString(R.string.liechtenstein) -> updateAvgLifeExp(83, 85)
            res.getString(R.string.lithuania) -> updateAvgLifeExp(74, 80)
            res.getString(R.string.luxembourg) -> updateAvgLifeExp(81, 83)
            res.getString(R.string.madagascar) -> updateAvgLifeExp(66, 68)
            res.getString(R.string.malawi) -> updateAvgLifeExp(65, 67)
            res.getString(R.string.malaysia) -> updateAvgLifeExp(74, 77)
            res.getString(R.string.maldives) -> updateAvgLifeExp(77, 80)
            res.getString(R.string.mali) -> updateAvgLifeExp(57, 59)
            res.getString(R.string.malta) -> updateAvgLifeExp(82, 84)
            res.getString(R.string.marshall_islands) -> updateAvgLifeExp(73, 76)
            res.getString(R.string.mauritania) -> updateAvgLifeExp(62, 65)
            res.getString(R.string.mauritius) -> updateAvgLifeExp(74, 79)
            res.getString(R.string.mexico) -> updateAvgLifeExp(75, 79)
            res.getString(R.string.micronesia) -> updateAvgLifeExp(68, 71)
            res.getString(R.string.moldova) -> updateAvgLifeExp(69, 76)
            res.getString(R.string.monaco) -> updateAvgLifeExp(89, 92)
            res.getString(R.string.mongolia) -> updateAvgLifeExp(67, 71)
            res.getString(R.string.montenegro) -> updateAvgLifeExp(76, 80)
            res.getString(R.string.morocco) -> updateAvgLifeExp(76, 79)
            res.getString(R.string.mozambique) -> updateAvgLifeExp(58, 60)
            res.getString(R.string.myanmar) -> updateAvgLifeExp(66, 69)
            res.getString(R.string.namibia) -> updateAvgLifeExp(64, 67)
            res.getString(R.string.nauru) -> updateAvgLifeExp(66, 68)
            res.getString(R.string.nepal) -> updateAvgLifeExp(70, 72)
            res.getString(R.string.netherlands) -> updateAvgLifeExp(81, 84)
            res.getString(R.string.new_zealand) -> updateAvgLifeExp(81, 83)
            res.getString(R.string.nicaragua) -> updateAvgLifeExp(74, 77)
            res.getString(R.string.niger) -> updateAvgLifeExp(62, 64)
            res.getString(R.string.nigeria) -> updateAvgLifeExp(54, 56)
            res.getString(R.string.north_macedonia) -> updateAvgLifeExp(75, 78)
            res.getString(R.string.norway) -> updateAvgLifeExp(83, 87)
            res.getString(R.string.oman) -> updateAvgLifeExp(76, 80)
            res.getString(R.string.pakistan) -> updateAvgLifeExp(67, 69)
            res.getString(R.string.palau) -> updateAvgLifeExp(72, 75)
            res.getString(R.string.panama) -> updateAvgLifeExp(77, 80)
            res.getString(R.string.papua_new_guinea) -> updateAvgLifeExp(65, 67)
            res.getString(R.string.paraguay) -> updateAvgLifeExp(73, 76)
            res.getString(R.string.peru) -> updateAvgLifeExp(76, 80)
            res.getString(R.string.philippines) -> updateAvgLifeExp(67, 71)
            res.getString(R.string.poland) -> updateAvgLifeExp(76, 81)
            res.getString(R.string.portugal) -> updateAvgLifeExp(81, 85)
            res.getString(R.string.qatar) -> updateAvgLifeExp(79, 82)
            res.getString(R.string.romania) -> updateAvgLifeExp(73, 77)
            res.getString(R.string.russia) -> updateAvgLifeExp(67, 77)
            res.getString(R.string.rwanda) -> updateAvgLifeExp(66, 68)
            res.getString(R.string.saint_lucia) -> updateAvgLifeExp(73, 75)
            res.getString(R.string.saint_vincent_and_the_grenadines) -> updateAvgLifeExp(71, 73)
            res.getString(R.string.samoa) -> updateAvgLifeExp(72, 76)
            res.getString(R.string.san_marino) -> updateAvgLifeExp(80, 85)
            res.getString(R.string.sao_tome_and_principe) -> updateAvgLifeExp(62, 66)
            res.getString(R.string.saudi_arabia) -> updateAvgLifeExp(75, 78)
            res.getString(R.string.senegal) -> updateAvgLifeExp(59, 62)
            res.getString(R.string.serbia) -> updateAvgLifeExp(74, 78)
            res.getString(R.string.seychelles) -> updateAvgLifeExp(79, 83)
            res.getString(R.string.sierra_leone) -> updateAvgLifeExp(48, 50)
            res.getString(R.string.singapore) -> updateAvgLifeExp(82, 85)
            res.getString(R.string.slovakia) -> updateAvgLifeExp(73, 80)
            res.getString(R.string.slovenia) -> updateAvgLifeExp(79, 84)
            res.getString(R.string.solomon_islands) -> updateAvgLifeExp(73, 77)
            res.getString(R.string.somalia) -> updateAvgLifeExp(54, 57)
            res.getString(R.string.south_africa) -> updateAvgLifeExp(61, 64)
            res.getString(R.string.south_sudan) -> updateAvgLifeExp(58, 61)
            res.getString(R.string.spain) -> updateAvgLifeExp(81, 85)
            res.getString(R.string.sri_lanka) -> updateAvgLifeExp(73, 77)
            res.getString(R.string.sudan) -> updateAvgLifeExp(65, 69)
            res.getString(R.string.suriname) -> updateAvgLifeExp(67, 72)
            res.getString(R.string.sweden) -> updateAvgLifeExp(81, 84)
            res.getString(R.string.switzerland) -> updateAvgLifeExp(81, 84)
            res.getString(R.string.syria) -> updateAvgLifeExp(76, 79)
            res.getString(R.string.taiwan) -> updateAvgLifeExp(77, 82)
            res.getString(R.string.tajikistan) -> updateAvgLifeExp(72, 75)
            res.getString(R.string.tanzania) -> updateAvgLifeExp(61, 65)
            res.getString(R.string.thailand) -> updateAvgLifeExp(73, 79)
            res.getString(R.string.togo) -> updateAvgLifeExp(56, 59)
            res.getString(R.string.tonga) -> updateAvgLifeExp(75, 79)
            res.getString(R.string.trinidad_and_tobago) -> updateAvgLifeExp(69, 73)
            res.getString(R.string.tunisia) -> updateAvgLifeExp(73, 77)
            res.getString(R.string.turkey) -> updateAvgLifeExp(70, 75)
            res.getString(R.string.turkmenistan) -> updateAvgLifeExp(68, 72)
            res.getString(R.string.tuvalu) -> updateAvgLifeExp(55, 56)
            res.getString(R.string.uganda) -> updateAvgLifeExp(62, 64)
            res.getString(R.string.ukraine) -> updateAvgLifeExp(67, 75)
            res.getString(R.string.united_arab_emirates) -> updateAvgLifeExp(73, 77)
            res.getString(R.string.united_kingdom) -> updateAvgLifeExp(79, 83)
            res.getString(R.string.united_states) -> updateAvgLifeExp(78, 82)
            res.getString(R.string.uruguay) -> updateAvgLifeExp(74, 80)
            res.getString(R.string.uzbekistan) -> updateAvgLifeExp(72, 75)
            res.getString(R.string.vanuatu) -> updateAvgLifeExp(64, 68)
            res.getString(R.string.vatican_city) -> updateAvgLifeExp(82, 83)
            res.getString(R.string.venezuela) -> updateAvgLifeExp(72, 77)
            res.getString(R.string.vietnam) -> updateAvgLifeExp(70, 73)
            res.getString(R.string.yemen) -> updateAvgLifeExp(64, 66)
            res.getString(R.string.zambia) -> updateAvgLifeExp(61, 65)
            res.getString(R.string.zimbabwe) -> updateAvgLifeExp(59, 63)
            else -> updateAvgLifeExp(50, 50)
        }
        return averageLifeExp
    }
}
