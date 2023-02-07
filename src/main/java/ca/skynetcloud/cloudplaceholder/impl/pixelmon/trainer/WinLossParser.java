

package ca.skynetcloud.cloudplaceholder.impl.pixelmon.trainer;


import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.storage.PlayerStats;
import org.bukkit.entity.Player;

public class WinLossParser implements Parser
{
    private final boolean isWin;

    public WinLossParser(final boolean isWin) {
        this.isWin = isWin;
    }
    
    @Override
    public String getID() {
        return this.isWin ? "trainer_wins" : "trainer_losses";
    }
    
    @Override
    public void register() {
        SkyExpansion.registerParser(this);
    }

    @Override
    public Object parse(final Player player, final String[] args) {
        final PlayerStats stats = this.getParty(player).stats;
        return this.isWin ? stats.getWins() : stats.getLosses();
    }
}
