package org.hexworks.zircon.api.uievent

import org.hexworks.cobalt.events.api.Subscription

/**
 * An [ComponentEventSource] is an object which emits [ComponentEvent]s and can be used to listen to
 * those events. Note that [ComponentEvent]s don't support [UIEventPhase]s.
 */
interface ComponentEventSource {

    /**
     * Adds the given [handler] for [ComponentEvent]s. Use this if you selectively
     * respond to events.
     */
    fun handleComponentEvents(
            eventType: ComponentEventType,
            handler: (event: ComponentEvent) -> UIEventResponse): Subscription

    /**
     * Adds the given [handler] for [ComponentEvent]s. Use this if you handle all
     * events.
     */
    fun processComponentEvents(
            eventType: ComponentEventType,
            handler: (event: ComponentEvent) -> Unit): Subscription


}
