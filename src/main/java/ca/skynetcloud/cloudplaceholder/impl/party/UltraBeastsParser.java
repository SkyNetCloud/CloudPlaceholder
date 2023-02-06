

package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class UltraBeastsParser extends PartyParser
{
    public UltraBeastsParser() {
        super(0);
    }

    protected UltraBeastsParser(final int slot) {
        super(slot);
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_ultrabeast";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new UltraBeastsParser(i));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.isUltraBeast() ? "Yes" : "No";
    }
}
