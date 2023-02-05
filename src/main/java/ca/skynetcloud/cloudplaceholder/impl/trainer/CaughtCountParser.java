

package ca.skynetcloud.cloudplaceholder.impl.trainer;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import ca.skynetcloud.cloudplaceholder.impl.DexCountParser;
import com.pixelmonmod.pixelmon.api.pokedex.PlayerPokedex;
import org.bukkit.entity.Player;

public class CaughtCountParser extends DexCountParser implements Parser
{
    private static final String ID = "trainer_dexcount";
    
    public CaughtCountParser() {
    }
    
    public CaughtCountParser(final Generation generation) {
        super(generation, false);
    }
    
    @Override
    public String getID() {
        return "trainer_dexcount" + this.generation.extraArgs;
    }
    
    @Override
    public void register() {
        for (final Generation generation : Generation.values()) {
            SkyExpansion.registerParser(new CaughtCountParser(generation));
        }
    }
    
    @Override
    public Object parse(final Player player, final String[] args) {
        final PlayerPokedex pokedex = this.getParty(player).playerPokedex;
        if (this.generation != Generation.ALL) {
            return pokedex.countCaught(this.generation.number);
        }
        return pokedex.countCaught();
    }
}
