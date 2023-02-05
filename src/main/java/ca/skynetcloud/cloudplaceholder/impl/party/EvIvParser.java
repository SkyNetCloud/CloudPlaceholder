

package ca.skynetcloud.cloudplaceholder.impl.party;


import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStatsType;
import org.bukkit.entity.Player;




public class EvIvParser extends PartyParser
{
    private final boolean isEv;
    private final String suffix;
    private final BattleStatsType stat;
    
    public EvIvParser() {
        super(0);
        this.isEv = false;
        this.suffix = "";
        this.stat = BattleStatsType.NONE;
    }
    
    protected EvIvParser(final int slot, final boolean isEv, final String suffix, final BattleStatsType stat) {
        super(slot);
        this.isEv = isEv;
        this.suffix = suffix;
        this.stat = stat;
    }
    
    @Override
    public String getID() {
        return "party_" + this.slot + "_" + (this.isEv ? "ev" : "iv") + "_" + this.suffix;
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            for (final BattleStatsType stat : BattleStatsType.getAllBattleStatValues()) {
                SkyExpansion.registerParser(new EvIvParser(i, true, stat.name().toLowerCase(), stat));
                SkyExpansion.registerParser(new EvIvParser(i, true, this.resolveSuffix(stat), stat));
                SkyExpansion.registerParser(new EvIvParser(i, false, stat.name().toLowerCase(), stat));
                SkyExpansion.registerParser(new EvIvParser(i, false, this.resolveSuffix(stat), stat));
            }
        }
    }
    
    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        if (this.isEv) {
            return pokemon.getEVs().getStat(this.stat);
        }
        return pokemon.getIVs().getStat(this.stat);
    }
    
    private String resolveSuffix(final BattleStatsType stat) {
        switch (stat) {
            case HP: {
                return "hp";
            }
            case ATTACK: {
                return "atk";
            }
            case DEFENSE: {
                return "def";
            }
            case SPECIAL_ATTACK: {
                return "spa";
            }
            case SPECIAL_DEFENSE: {
                return "spd";
            }
            case SPEED: {
                return "spe";
            }
            default: {
                return "";
            }
        }
    }
}
