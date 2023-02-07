package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party.ivs;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStatsType;
import org.bukkit.entity.Player;

public class PartyIvSPAttackParser extends PartyParser {

    private final BattleStatsType stat;

    public PartyIvSPAttackParser() {
        super(0);
        this.stat = BattleStatsType.NONE;

    }

    protected PartyIvSPAttackParser(final int slot, final BattleStatsType stat) {
        super(slot);
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_iv_spa";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
                SkyExpansion.registerParser(new PartyIvSPAttackParser(i, stat));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getIVs().getStat(BattleStatsType.SPECIAL_ATTACK);
    }
}
