package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.*;
import org.bukkit.entity.Player;


public class LegendaryAmountParser implements Parser {

    @Override
    public String getID() {
        return "party_legendary_amount";
    }

    @Override
    public void register() {
            SkyExpansion.registerParser(new LegendaryAmountParser());
    }

    @Override
    public Object parse(Player p0, String[] p2) {
        final PlayerPartyStorage storage = StorageProxy.getParty(p0.getUniqueId());
        final PCStorage pc = StorageProxy.getPCForPlayer(p0.getUniqueId());

        int leg = 0;

        for (Pokemon pokemon : storage.getAll()) {
            if (pokemon != null && pokemon.isLegendary()){
                leg += 1;
            }

        }

        for (Pokemon pokemon : pc.getAll()) {
            if (pokemon != null && pokemon.isLegendary()) {
                leg += 1;
            }
        }

        return leg;
    }
}
