package com.github.unchama.seichiassist.listener;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;

import com.github.unchama.seichiassist.SeichiAssist;
import com.github.unchama.seichiassist.data.PlayerData;

public class EntityShootBowListener {
	HashMap<UUID,PlayerData> playermap = SeichiAssist.playermap;
	private SeichiAssist plugin = SeichiAssist.plugin;

	@EventHandler
	public void EntityShootBowEvent(EntityShootBowEvent event){
		//矢を発射したのがプレイヤーじゃなければ終了
		if(!event.getEntityType().equals(EntityType.PLAYER)){
			return;
		}
		UUID uuid = event.getEntity().getUniqueId();
		//uuidが見つからなければ終了
		if(!playermap.containsKey(uuid)){
			return;
		}
		PlayerData playerdata = playermap.get(uuid);
		Player player = plugin.getServer().getPlayer(playerdata.uuid);
	}
}
