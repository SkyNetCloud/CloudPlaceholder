

package ca.skynetcloud.cloudplaceholder.impl.pixelmon.trainer;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.pokedex.PlayerPokedex;
import com.pixelmonmod.pixelmon.api.pokemon.species.Pokedex;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class DexPercentageParser implements Parser
{
    private final DecimalFormat FORMAT;
    private static final String ID = "trainer_dexpercentage";
    
    public DexPercentageParser() {
        this.FORMAT = new DecimalFormat("0.##");
    }
    
    @Override
    public String getID() {
        return "trainer_dexpercentage";
    }
    
    @Override
    public void register() {
        SkyExpansion.registerParser(this);
    }
    
    @Override
    public Object parse(final Player player, final String[] args) {
        final PlayerPokedex pokedex = this.getParty(player).playerPokedex;

        return String.format(
                "%.2f",
                ((pokedex.countCaught() + 0.000) / Pokedex.pokedexSize) * 100
        ) + "%";

        //return pokedex.getCaughtCompletionPercentage() * 100;
    }
}
