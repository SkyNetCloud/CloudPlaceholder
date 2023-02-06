package ca.skynetcloud.cloudplaceholder;

import ca.skynetcloud.cloudplaceholder.api.Parser;
import ca.skynetcloud.cloudplaceholder.impl.global.SpawnerTimer;
import ca.skynetcloud.cloudplaceholder.impl.party.*;
import ca.skynetcloud.cloudplaceholder.impl.trainer.*;
import com.google.common.collect.Sets;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Set;
public class SkyExpansion extends PlaceholderExpansion {
    private static final Set<Parser> defaultParsers;
    private static final HashMap<String, Parser> parsers;

    public static void registerParser(final Parser parser) {
        SkyExpansion.parsers.put(parser.getID(), parser);
    }

    public boolean canRegister() {
        return true;
    }

    public String getIdentifier() {
        return "cloud";
    }

    public String getAuthor() {
        return "SkyNetCloud";
    }

    public String getVersion() {
        return "0.1.5";
    }

    public boolean register() {
        SkyExpansion.defaultParsers.forEach(Parser::register);
        return super.register();
    }

    public String onRequest(final OfflinePlayer player, final String identifier) {
        if (player != null && player.isOnline()) {
            return this.onPlaceholderRequest(player.getPlayer(), identifier);
        }
        return null;
    }

    public String onPlaceholderRequest(final Player p, final String identifier) {
        if (p == null || !p.isOnline()) {
            return "INVALID_PLAYER";
        }
        final String formattedInput = identifier.replace("\\s+", "_").toLowerCase();
        final Player player = p.getPlayer();
        final Parser parser = SkyExpansion.parsers.get(formattedInput);
        if (parser != null) {
            final String[] args = formattedInput.split("_");
            return parser.parse(player, args).toString();
        }
        return "Could not parse request check syntax please";
    }

    static {
        defaultParsers = Sets.newHashSet(new HpParser(),new HyperTrainedParser(),new PartyNbtParser(),new OTNameParser(), new OTUuidParser(),new HiddenAbilityParser(),new SpeciesEvoParser(), new CaughtCountParser(), new DexPercentageParser(), new SeenCountParser(), new WinLossParser(false), new WinLossParser(true), new WinRateParser(), new BalanceParser(), new AbilityParser(), new CustomTextureParser(), new DexNumberParser(), new EvIvParser(), new EvIvPercentageParser(), new ExperienceParser(), new FormParser(), new GenderParser(), new GmaxParser(), new LevelParser(), new MaxLevelParser(), new NatureParser(), new NicknameParser(), new PokeballParser(), new ShinyParser(), new SpeciesParser(), new SpawnerTimer(true), new SpawnerTimer(false));
        parsers = new HashMap<String, Parser>();
    }
}
