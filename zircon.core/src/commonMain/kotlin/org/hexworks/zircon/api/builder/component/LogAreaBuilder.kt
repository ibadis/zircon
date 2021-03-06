package org.hexworks.zircon.api.builder.component

import org.hexworks.zircon.api.component.LogArea
import org.hexworks.zircon.api.component.builder.base.BaseComponentBuilder
import org.hexworks.zircon.api.component.data.ComponentMetadata
import org.hexworks.zircon.api.component.renderer.ComponentRenderer
import org.hexworks.zircon.internal.component.impl.DefaultLogArea
import org.hexworks.zircon.internal.component.renderer.DefaultComponentRenderingStrategy
import org.hexworks.zircon.internal.component.renderer.DefaultLogAreaRenderer
import kotlin.jvm.JvmStatic

@Suppress("UNCHECKED_CAST")
class LogAreaBuilder(
        private var logRowHistorySize: Int = 100)
    : BaseComponentBuilder<LogArea, LogAreaBuilder>(DefaultLogAreaRenderer()) {

    fun withLogRowHistorySize(numberOfRows: Int) = also {
        logRowHistorySize = numberOfRows
    }

    override fun build(): LogArea {
        return DefaultLogArea(
                componentMetadata = ComponentMetadata(
                        relativePosition = position,
                        size = size,
                        tileset = tileset,
                        componentStyleSet = componentStyleSet),
                renderingStrategy = DefaultComponentRenderingStrategy(
                        decorationRenderers = decorationRenderers,
                        componentRenderer = props.componentRenderer as ComponentRenderer<LogArea>)).apply {
            colorTheme.map {
                theme = it
            }
        }
    }

    override fun createCopy() = newBuilder().withProps(props.copy())
            .withLogRowHistorySize(logRowHistorySize)

    companion object {

        @JvmStatic
        fun newBuilder() = LogAreaBuilder()
    }
}
