package com.eaglewarrior.spacerace.spacecrafts

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.core.animation.doOnEnd
import com.eaglewarrior.spacerace.MainActivity
import com.eaglewarrior.spacerace.R
import kotlin.math.roundToLong

/**
 * Created by Clarence E Moore on 2022-11-27.
 *
 * Description:
 *
 *
 */
open class Spacecraft(val universe: MainActivity) {

    // properties ----------------------------------------------------------------------------------------------------------------
    var name = "Basica"
    var imageId = R.drawable.basica

    var fuelQuantity = 10000.0F
    var fuelPerAU = 15000.0F
    var speed = 0.2

    // methods --------------------------------------------------------------------------------------------------------------

    open fun launch() {
        if (universe.meteorView == null || universe.spacecraftView == null) { return }

        // calculate the x and y distances between the centres of the spacecraft and the meteor

        val distanceX =
            (universe.meteorView!!.x + universe.meteorView!!.width / 2.0F) -
                    (universe.spacecraftView!!.x + universe.spacecraftView!!.width / 2.0F)
        val distanceY =
            (universe.meteorView!!.y + universe.meteorView!!.height / 2.0F) -
                    (universe.spacecraftView!!.y + universe.spacecraftView!!.height / 2.0F)

        // what portion of the total distance (1 AU) can the spacecraft travel with its fuel?

        val fractionCovered = fuelQuantity / fuelPerAU

        // animate the spacecraftView

        val deltaX = PropertyValuesHolder.ofFloat("x",
            universe.spacecraftView!!.x + distanceX * fractionCovered)

        val deltaY = PropertyValuesHolder.ofFloat("y",
            universe.spacecraftView!!.y + distanceY * fractionCovered)

        ObjectAnimator.ofPropertyValuesHolder(universe.spacecraftView, deltaX, deltaY).apply {
            duration = (1 / speed * fractionCovered).roundToLong() * 1000
            addListener(doOnEnd {
                universe.announceEndOfTravel()
            })
            start()
        }
    }
}
