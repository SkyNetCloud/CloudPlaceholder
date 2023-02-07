package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party.ivs;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class IvPercentageParser extends PartyParser
{


    public IvPercentageParser() {
        super(0);

    }

    protected IvPercentageParser(final int slot, final boolean isEv) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_iv" + "_percentage";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new IvPercentageParser(i, false));
            SkyExpansion.registerParser(new IvPercentageParser(i, true));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {

        return pokemon.getIVs().getPercentageString(2);
    }
}
