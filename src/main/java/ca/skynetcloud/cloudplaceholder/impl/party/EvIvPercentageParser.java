

package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class EvIvPercentageParser extends PartyParser
{
    private final boolean isEv;
    
    public EvIvPercentageParser() {
        super(0);
        this.isEv = false;
    }
    
    protected EvIvPercentageParser(final int slot, final boolean isEv) {
        super(slot);
        this.isEv = isEv;
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_" + (this.isEv ? "ev" : "iv") + "_percentage";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new EvIvPercentageParser(i, false));
            SkyExpansion.registerParser(new EvIvPercentageParser(i, true));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        if (this.isEv) {
            return Arrays.stream(pokemon.getEVs().getArray()).sum() / 510 * 100;
        }
        return Arrays.stream(pokemon.getIVs().getArray()).sum() / 186 * 100;
    }
}
