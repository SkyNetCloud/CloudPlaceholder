

package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;


public class HiddenAbilityParser extends PartyParser
{
    public HiddenAbilityParser() {
        super(0);
    }

    protected HiddenAbilityParser(final int slot) {
        super(slot);
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_hidden_ability";
    }
    
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new HiddenAbilityParser(i));
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        if (pokemon.isUltraBeast() && pokemon.getSpecies().getDefaultForm().getAbilities().getHiddenAbilities() == null){
            return "N/A";
        }
        return pokemon.getSpecies().getDefaultForm().getAbilities().getHiddenAbilities()[0].getLocalizedName();
    }
}
