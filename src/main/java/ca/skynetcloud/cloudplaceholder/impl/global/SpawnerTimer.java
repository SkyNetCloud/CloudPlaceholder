

package ca.skynetcloud.cloudplaceholder.impl.global;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.spawning.PixelmonSpawning;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class SpawnerTimer implements Parser
{
    private final boolean legendSpawner;
    
    public SpawnerTimer(final boolean legendSpawner) {
        this.legendSpawner = legendSpawner;
    }
    
    @Override
    public String getID() {
        return "spawn_timer_" + (this.legendSpawner ? "legendary" : "mega_boss");
    }
    
    @Override
    public void register() {
        SkyExpansion.registerParser(new SpawnerTimer(this.legendSpawner));
    }
    
    @Override
    public Object parse(final Player player, final String[] args) {
        final long baseMilliseconds = this.legendSpawner ? PixelmonSpawning.legendarySpawner.nextSpawnTime : PixelmonSpawning.megaBossSpawner.nextSpawnTime;
        final long milliseconds = baseMilliseconds - System.currentTimeMillis();
        final long totalSeconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        final long hours = totalSeconds / 3600L;
        final long minutes = totalSeconds % 3600L / 60L;
        final long seconds = totalSeconds % 60L;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
