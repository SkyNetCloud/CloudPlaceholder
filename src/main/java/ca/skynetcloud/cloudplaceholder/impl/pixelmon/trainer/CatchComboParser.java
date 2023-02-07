package ca.skynetcloud.cloudplaceholder.impl.pixelmon.trainer;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import org.bukkit.entity.Player;

public class CatchComboParser implements Parser {

    @Override
    public String getID() {
        return "trainer_capture_combo";
    }

    @Override
    public void register() {
        SkyExpansion.registerParser(new CatchComboParser());
    }

    @Override
    public Object parse(Player p0, String[] p1) {
        final PlayerPartyStorage storage = StorageProxy.getParty(p0.getUniqueId());
        if(storage.transientData.captureCombo.getCurrentCombo() == 0){
            return "There isn't a combo going on";
        }

        return storage.transientData.captureCombo.getCurrentSpecies().getName() + " : " + storage.transientData.captureCombo.getCurrentCombo();
    }
}
