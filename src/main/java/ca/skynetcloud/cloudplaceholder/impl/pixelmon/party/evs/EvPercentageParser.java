package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party.evs;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class EvPercentageParser extends PartyParser
{

    public EvPercentageParser() {
        super(0);

    }

    protected EvPercentageParser(final int slot, final boolean isEv) {
        super(slot);
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_ev" + "_percentage";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new EvPercentageParser(i, false));
            SkyExpansion.registerParser(new EvPercentageParser(i, true));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
            return String.format("%.2f", pokemon.getEVs().getTotal() * 100.0D / 510.0D);

    }
}
