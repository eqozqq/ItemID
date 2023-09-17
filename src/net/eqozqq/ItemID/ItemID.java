package net.eqozqq.ItemID;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;

public class ItemID extends PluginBase {
   public ItemID() {
   }

   public void onEnable() {
      this.getLogger().info("ItemID plugin is enabled!");
   }

   public void onDisable() {
      this.getLogger().info("ItemID plugin is disabled!");
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player) {
         Player player = (Player)sender;
         if (command.getName().equalsIgnoreCase("id")) {
            Item itemInHand = player.getInventory().getItemInHand();
            int itemId = itemInHand.getId();
            String itemName = itemInHand.getName();
            player.sendMessage("Your current item: " + itemName + " (ID: " + itemId + ")");
            return true;
         }
      } else {
         sender.sendMessage("This command can only be used in game!");
      }

      return false;
   }
}
