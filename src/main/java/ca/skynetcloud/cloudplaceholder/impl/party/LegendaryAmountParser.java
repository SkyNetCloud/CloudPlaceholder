package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.*;
import org.bukkit.entity.Player;

public class LegendaryAmountParser extends PartyParser {

    public LegendaryAmountParser() {
        super(0);
    }
    protected LegendaryAmountParser(int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_legendary_amount";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new LegendaryAmountParser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon p1, String[] p2) {
        final PlayerPartyStorage storage = StorageProxy.getParty(p0.getUniqueId());
        final PCStorage pc = StorageProxy.getPCForPlayer(p0.getUniqueId());

        int leg = 0;

        for (Pokemon pokemon : storage.getAll()) {
            if (pokemon != null && pokemon.isLegendary())
                leg += 1;
        }

        for (Pokemon pokemon : pc.getAll()) {
            if (pokemon != null && pokemon.isLegendary())
                leg += 1;
        }

        return leg + "";
    }
}
