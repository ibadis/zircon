package org.hexworks.zircon.examples.components


import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.component.ComponentAlignment.*
import org.hexworks.zircon.api.data.Position
import org.hexworks.zircon.api.data.Size
import org.hexworks.zircon.api.extensions.box
import org.hexworks.zircon.api.extensions.toScreen
import org.hexworks.zircon.api.uievent.ComponentEventType.ACTIVATED

object GroupExample {

    @JvmStatic
    fun main(args: Array<String>) {

        val screen = SwingApplications.startTileGrid(AppConfig.newBuilder()
                .withDefaultTileset(CP437TilesetResources.wanderlust16x16())
                .withSize(Size.create(60, 30))
                .build()).toScreen()

        val leftPanel = Components.panel()
                .withSize(15, 10)
                .withPosition(6, 5)
                .withDecorations(box(title = "Left Panel"))
                .withColorTheme(ColorThemes.adriftInDreams())
                .withTileset(CP437TilesetResources.aduDhabi16x16())
                .build()

        val rightPanel = Components.panel()
                .withSize(15, 10)
                .withPosition(Position.create(18, 0).relativeToRightOf(leftPanel))
                .withDecorations(box(title = "Right Panel"))
                .withColorTheme(ColorThemes.afterTheHeist())
                .withTileset(CP437TilesetResources.bisasam16x16())
                .build()

        val group = Components.group()
                .withTheme(ColorThemes.capturedByPirates())
                .withTileset(CP437TilesetResources.rexPaint16x16())
                .build()

        val groupButton = Components.button()
                .withText("Add Panels to Group")
                .withAlignmentWithin(screen, BOTTOM_CENTER)
                .withColorTheme(ColorThemes.cyberpunk())
                .build().apply {
                    processComponentEvents(ACTIVATED) {
                        group.add(leftPanel)
                        group.add(rightPanel)
                    }
                }

        screen.addComponent(leftPanel)
        screen.addComponent(rightPanel)
        screen.addComponent(groupButton)

    }

}