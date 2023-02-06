package ca.skynetcloud.cloudplaceholder.api;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;


public interface Parser{

    String getID();

    void register();

    Object parse(final Player p0, final String[]p1);

    default PlayerPartyStorage getParty(final Player player) {
        return StorageProxy.getParty(player.getUniqueId());
    }

    @Nullable
    default Pokemon getPokemon(final Player player, final int slot) {
        return this.getParty(player).get(slot - 1);
    }

}
