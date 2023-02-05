

package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class NatureParser extends PartyParser
{
    private final boolean isMint;
    
    public NatureParser() {
        super(0);
        this.isMint = false;
    }
    
    protected NatureParser(final int slot, final boolean isMint) {
        super(slot);
        this.isMint = isMint;
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_" + (this.isMint ? "mint" : "nature");
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new NatureParser(i, true));
            SkyExpansion.registerParser(new NatureParser(i, false));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        if (this.isMint) {
            return (pokemon.getMintNature() == null) ? "None" : pokemon.getMintNature().getLocalizedName();
        }
        return pokemon.getBaseNature().getLocalizedName();
    }
}
