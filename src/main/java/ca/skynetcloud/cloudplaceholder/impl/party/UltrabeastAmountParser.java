package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PCStorage;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import org.bukkit.entity.Player;

public class UltrabeastAmountParser extends PartyParser {

    public UltrabeastAmountParser() {
        super(0);
    }
    protected UltrabeastAmountParser(int slot) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_ub_amount";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new UltrabeastAmountParser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon p1, String[] p2) {
        final PlayerPartyStorage storage = StorageProxy.getParty(p0.getUniqueId());
        final PCStorage pc = StorageProxy.getPCForPlayer(p0.getUniqueId());

        int ub = 0;

        for (Pokemon pokemon : storage.getAll()) {
            if (pokemon != null && pokemon.isUltraBeast())
                ub += 1;
        }

        for (Pokemon pokemon : pc.getAll()) {
            if (pokemon != null && pokemon.isUltraBeast())
                ub += 1;
        }

        return ub + "";
    }
}
