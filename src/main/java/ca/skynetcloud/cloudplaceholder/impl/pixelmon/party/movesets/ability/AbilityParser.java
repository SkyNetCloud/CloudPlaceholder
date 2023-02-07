

package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party.movesets.ability;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;


public class AbilityParser extends PartyParser
{
    public AbilityParser() {
        super(0);
    }
    
    protected AbilityParser(final int slot) {
        super(slot);
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_ability";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new AbilityParser(i));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getAbility().getLocalizedName();
    }
}
