package me.liwk.karhu.api.event;

import me.liwk.karhu.api.exception.EventNotCancellableException;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public abstract class KarhuEvent {

    private boolean cancelled = false;

    private Player bukkitPlayer;

    /**
     * Attempts to cancel the current fired event
     * throws {@link EventNotCancellableException} if the event cannot be cancelled
     */
    public final void cancel() {
        if (!this.isCancellable())
            throw new EventNotCancellableException(this);
        else {
            this.cancelled = true;
        }
    }

    public boolean hasSpeedEffect() {
        for (PotionEffect effect : bukkitPlayer.getActivePotionEffects()) {
            if (effect.getType().equals(PotionEffectType.SPEED)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Checks if the event is cancellable
     *
     * @return cancellable
     */
    public boolean isCancellable() {
        return true;
    }

    /**
     * Returns if the current event is cancelled
     *
     * @return cancelled
     */
    public final boolean isCancelled() {
        return isCancellable() && this.cancelled;
    }

}
