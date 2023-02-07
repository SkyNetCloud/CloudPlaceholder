package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PCStorage;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import org.bukkit.entity.Player;

public class ShinyAmountParser implements Parser {

    @Override
    public String getID() {
        return "party_shiny_amount";
    }

    @Override
    public void register() {
            SkyExpansion.registerParser(new ShinyAmountParser());
    }

    @Override
    public Object parse(Player player, String[] p2) {
        final PlayerPartyStorage storage = StorageProxy.getParty(player.getUniqueId());
        final PCStorage pc = StorageProxy.getPCForPlayer(player.getUniqueId());

        int shiny = 0;

        for (Pokemon pokemon : storage.getAll()) {
            if (pokemon != null && pokemon.isShiny()) {
                shiny += 1;
            }
        }
        for (Pokemon pokemon : pc.getAll()) {
            if (pokemon != null && pokemon.isShiny()){
                shiny += 1;
            }

        }

        return shiny;
    }
}
