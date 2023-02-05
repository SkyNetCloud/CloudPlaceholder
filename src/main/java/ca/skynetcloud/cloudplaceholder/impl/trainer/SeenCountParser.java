

package ca.skynetcloud.cloudplaceholder.impl.trainer;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.DexCountParser;
import com.pixelmonmod.pixelmon.api.pokedex.PlayerPokedex;
import org.bukkit.entity.Player;

public class SeenCountParser extends DexCountParser
{
    private static final String ID = "trainer_dexseen";
    
    public SeenCountParser() {
    }
    
    public SeenCountParser(final Generation generation) {
        super(generation, true);
    }
    
    @Override
    public String getID() {
        return "trainer_dexseen" + this.generation.extraArgs;
    }
    
    @Override
    public void register() {
        for (final Generation generation : Generation.values()) {
            SkyExpansion.registerParser(new SeenCountParser(generation));
        }
    }
    
    @Override
    public Object parse(final Player player, final String[] args) {
        final PlayerPokedex pokedex = this.getParty(player).playerPokedex;
        if (this.generation != Generation.ALL) {
            return pokedex.countSeen(this.generation.number);
        }
        return pokedex.countSeen();
    }
}
