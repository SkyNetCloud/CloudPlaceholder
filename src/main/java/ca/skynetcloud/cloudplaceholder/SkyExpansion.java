package ca.skynetcloud.cloudplaceholder;

import ca.skynetcloud.cloudplaceholder.api.Parser;
import ca.skynetcloud.cloudplaceholder.impl.global.SpawnerTimer;
import ca.skynetcloud.cloudplaceholder.impl.party.*;
import ca.skynetcloud.cloudplaceholder.impl.party.evs.*;
import ca.skynetcloud.cloudplaceholder.impl.party.ivs.*;
import ca.skynetcloud.cloudplaceholder.impl.party.ivs.hypertrained.*;
import ca.skynetcloud.cloudplaceholder.impl.party.movesets.PartyMoveset1Parser;
import ca.skynetcloud.cloudplaceholder.impl.party.movesets.PartyMoveset2Parser;
import ca.skynetcloud.cloudplaceholder.impl.party.movesets.PartyMoveset3Parser;
import ca.skynetcloud.cloudplaceholder.impl.party.movesets.PartyMoveset4Parser;
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
        return "0.1.6";
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
        defaultParsers = Sets.newHashSet(
                new UltraBeastsParser(),
                new PartyNbtParser(),
                new OTNameParser(),
                new OTUuidParser(),
                new HiddenAbilityParser(),
                new SpeciesEvoParser(),
                new CaughtCountParser(),
                new DexPercentageParser(),
                new SeenCountParser(),
                new WinLossParser(false),
                new WinLossParser(true),
                new WinRateParser(),
                new BalanceParser(),
                new AbilityParser(),
                new CustomTextureParser(),
                new DexNumberParser(),

                new PartyEvAttackParser(),
                new PartyEvDefenceParser(),
                new PartyEvSPAttackParser(),
                new PartyEvSPDefenceParser(),
                new PartyEvHpParser(),
                new PartyEvSpeedParser(),

                new PartyIvHyperTrainedHpParser(),
                new PartyIvHyperTrainedAttackParser(),
                new PartyIvHyperTrainedDefenceParser(),
                new PartyIvHpyerTrainedSPAttackParser(),
                new PartyIvHpyerTrainedSPDefenceParser(),
                new PartyIvHpyerTrainedSpeedParser(),

                new PartyIvHpParser(),
                new PartyIvAttackParser(),
                new PartyIvDefenceParser(),
                new PartyIvSPAttackParser(),
                new PartyIvSPDefenceParser(),
                new PartyIvSpeedParser(),

                new PartyMoveset1Parser(),
                new PartyMoveset2Parser(),
                new PartyMoveset3Parser(),
                new PartyMoveset4Parser(),

                new UltrabeastAmountParser(),
                new LegendaryAmountParser(),
                new ShinyAmountParser(),

                new EvIvPercentageParser(),
                new ExperienceParser(),
                new FormParser(),
                new GenderParser(),
                new GmaxParser(),
                new LevelParser(),
                new MaxLevelParser(),
                new NatureParser(),
                new NicknameParser(),
                new PokeballParser(),
                new ShinyParser(),
                new SpeciesParser(),
                new SpawnerTimer(true),
                new SpawnerTimer(false));
        parsers = new HashMap<>();
    }
}
