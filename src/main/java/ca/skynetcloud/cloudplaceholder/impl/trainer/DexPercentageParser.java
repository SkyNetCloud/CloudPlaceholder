

package ca.skynetcloud.cloudplaceholder.impl.trainer;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.pokedex.PlayerPokedex;
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
        return this.FORMAT.format(pokedex.countCaught() / (double)pokedex.countSeen() * 100.0);
    }
}
