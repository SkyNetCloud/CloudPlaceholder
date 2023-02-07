

package ca.skynetcloud.cloudplaceholder.impl.pixelmon.trainer;


import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.storage.PlayerStats;
import org.bukkit.entity.Player;

public class WinRateParser implements Parser
{

    @Override
    public String getID() {
        return "trainer_wlratio";
    }
    
    @Override
    public void register() {
        SkyExpansion.registerParser(this);
    }
    
    @Override
    public Object parse(final Player player, final String[] args) {
        final PlayerStats stats = this.getParty(player).stats;
        return Math.max(stats.getWins(), 1) / Math.max(stats.getLosses(), 1) * 100;
    }
}
