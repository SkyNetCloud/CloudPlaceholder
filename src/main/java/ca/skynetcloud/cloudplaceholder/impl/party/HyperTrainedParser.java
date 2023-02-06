

package ca.skynetcloud.cloudplaceholder.impl.party;


import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.events.pokemon.BottleCapEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStatsType;
import org.bukkit.entity.Player;




public class HyperTrainedParser extends PartyParser
{
    private final String suffix;
    private final BattleStatsType stat;

    public HyperTrainedParser() {
        super(0);
        this.suffix = "";
        this.stat = BattleStatsType.NONE;

    }

    protected HyperTrainedParser(final int slot, final String suffix, final BattleStatsType stat) {
        super(slot);
        this.suffix = suffix;
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_hypertrained_" + this.suffix;
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
        return pokemon.getIVs().isHyperTrained(this.stat);
    }

    private String resolveSuffix(final BattleStatsType stat) {
        switch (stat) {
            case HP:{
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
