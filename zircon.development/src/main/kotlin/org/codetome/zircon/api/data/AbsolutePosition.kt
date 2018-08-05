package org.codetome.zircon.api.data

import org.codetome.zircon.api.tileset.Tileset

data class AbsolutePosition(override val x: Int,
                            override val y: Int) : Position {

    override fun toAbsolutePosition(tileset: Tileset<out Tile, out Any>) = this

    companion object {

        fun create(x: Int, y: Int): Position = AbsolutePosition(x, y)
    }
}