# CloudPlaceholder
A simple utility to link your PAPI with Pixelmon!

## Party Placeholders

**The following entries that contain "slot" are replaced by the party slot number you wish to target (1 to 6)**

```%cloud_party_slot_name%``` - returns the species name of the specified Pixelmon

```%cloud_party_slot_nickname%``` - returns the nickname of the specified Pixelmon

```%cloud_party_slot_exp%``` - returns the current exp on the current level of the specified Pixelmon

```%cloud_party_slot_level%``` - returns the current level of the specified Pixelmon

```%cloud_party_slot_ability%``` - returns the current ability of the specified Pixelmon

```%cloud_party_slot_gender%``` - returns the gender of the specified Pixelmon

```%cloud_party_slot_nature%``` - returns the current nature of the specified Pixelmon

```%cloud_party_slot_form%``` - returns the current form of the specified Pixelmon

```%cloud_party_slot_shiny%``` - returns a "Yes" / "No"

```%cloud_party_slot_customtexture%``` - returns "None" or the name of the custom texture

```%cloud_party_slot_dex%``` - returns the Dex number of the specified Pixelmon

```%cloud_party_slot_gmax%``` - returns a "Yes" / "No"

```%cloud_party_slot_hidden_ability%``` - returns the hidden ability of the specified Pixelmon (If pokemon doesn't have one it will return N/A)

```%cloud_party_slot_moveset%``` - return moveset of pokemon

```%cloud_party_slot_dynamaxlevel%``` - returns the Dynamax Level of the specified Pixelmon

```%cloud_party_ot_slot_name%``` - returns the Original Trainer's name of the specified Pixelmon

```%cloud_party_ot_slot_uuid%``` - returns the Original Trainer's UUID of the specified Pixelmon

```%cloud_ultrabeast``` - returns a "Yes" / "No"

```%cloud_party_legendary_amount%``` - returns amount of legendary Player has in total

```%cloud_party_legendary_amount%``` - returns amount of shiny Player has in total

```%cloud_party_legendary_amount%``` - returns amount of ultrabeast Player has in total





**The following "stat" can be replaced with any of the 6 stats ("hp", "atk", "def", "spa", "spd", "spe")**

```%cloud_party_slot_iv_stat%``` - returns the IV value from 0 to 31"

```%cloud_party_slot_ev_stat%``` - returns the EV value from 0 to 252"

```%cloud_party_slot_hypertrained_iv_stat%``` - returns the ture or false if a bottle cap was used on a stats

```%cloud_party_slot_iv_percentage%``` - returns the total IV percentage

```%cloud_party_slot_ev_percentage%``` - returns the total EV percentage


## Trainer Placeholders

```%cloud_trainer_dexcount%``` - returns the number of Pixelmon caught

```%cloud_trainer_dexpercentage%``` - returns the percentage of Dex completion

```%cloud_trainer_dexseen%``` - returns the number of Pixelmon seen

```%cloud_trainer_wins%``` - returns the number of PvP wins

```%cloud_trainer_losses%``` - returns the number of PvP losses

```%cloud_trainer_wlratio%``` - returns the number of W/L ratio in percentage

```%cloud_trainer_balance%``` - returns the current pokedollar balance (broken)


## Spawn Timer Placeholders

```%cloud_spawn_timer_legendary%``` - returns the time until the next legendary pokemon spawn (HH,MM,SS)

```%cloud_spawn_timer_mega_boss%``` - returns the time until the next mega-boss pokemon spawn (HH,MM,SS)
