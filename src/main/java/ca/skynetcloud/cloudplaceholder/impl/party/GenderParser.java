

package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class GenderParser extends PartyParser
{
    public GenderParser() {
        super(0);
    }
    
    protected GenderParser(final int slot) {
        super(slot);
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_gender";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new GenderParser(i));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getGender().getLocalizedName();
    }
}
