package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PCStorage;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import org.bukkit.entity.Player;

public class UltrabeastAmountParser implements Parser {


    @Override
    public String getID() {
        return "party_ub_amount";
    }

    @Override
    public void register() {
            SkyExpansion.registerParser(new UltrabeastAmountParser());
    }

    @Override
    public Object parse(Player p0, String[] p2) {
        final PlayerPartyStorage storage = StorageProxy.getParty(p0.getUniqueId());
        final PCStorage pc = StorageProxy.getPCForPlayer(p0.getUniqueId());

        int ub = 0;

        for (Pokemon pokemon : storage.getAll()) {
            if (pokemon != null && pokemon.isUltraBeast()) {
                ub += 1;
            }
        }

        for (Pokemon pokemon : pc.getAll()) {
            if (pokemon != null && pokemon.isUltraBeast()) {
                ub += 1;
            }
        }

        return ub;
    }
}
