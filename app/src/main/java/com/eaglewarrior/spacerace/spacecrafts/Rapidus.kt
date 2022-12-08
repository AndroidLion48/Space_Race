package com.eaglewarrior.spacerace.spacecrafts

import com.eaglewarrior.spacerace.MainActivity
import com.eaglewarrior.spacerace.R

/**
 * Created by Clarence E Moore on 2022-11-28.
 *
 * Description:
 *
 *
 */
class Rapidus(universe: MainActivity) : Advantis(universe) {

    init {
        name = "Rapidus"
        imageId = R.drawable.rapidus
        speed = 1.0
    }
}
