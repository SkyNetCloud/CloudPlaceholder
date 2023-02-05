

package ca.skynetcloud.cloudplaceholder.impl;

import ca.skynetcloud.cloudplaceholder.api.Parser;
import org.bukkit.entity.Player;

public abstract class DexCountParser implements Parser
{
    protected final Generation generation;
    
    protected DexCountParser() {
        this.generation = Generation.ALL;
    }
    
    protected DexCountParser(final Generation generation, final boolean isSeen) {
        this.generation = generation;
    }
    
    @Override
    public abstract Object parse(final Player p0, final String[] p1);
    
    protected enum Generation
    {
        ALL("", -1), 
        KANTO("_gen_1", 1), 
        JOHTO("_gen_2", 2), 
        HOENN("_gen_3", 3), 
        SINNOH("_gen_4", 4), 
        UNOVA("_gen_5", 5), 
        KALOS("_gen_6", 6), 
        ALOLA("_gen_7", 7), 
        GALAR("_gen_8", 8),
        PALDEA("_gen_9", 9);
        
        public final String extraArgs;
        public final int number;
        
        private Generation(final String extraArgs, final int number) {
            this.extraArgs = extraArgs;
            this.number = number;
        }
    }
}
