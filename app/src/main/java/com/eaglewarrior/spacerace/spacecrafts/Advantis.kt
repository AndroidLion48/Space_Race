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
open class Advantis(universe: MainActivity) : Spacecraft(universe) {

    init {
        name = "Advantis"
        imageId = R.drawable.advantis
        fuelQuantity = 15000.0F
    }

}
