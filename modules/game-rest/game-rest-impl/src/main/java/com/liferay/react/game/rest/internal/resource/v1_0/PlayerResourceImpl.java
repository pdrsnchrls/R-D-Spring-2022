package com.liferay.react.game.rest.internal.resource.v1_0;

import com.liferay.react.game.core.service.service.PlayerEnemyAbilityLocalService;
import com.liferay.react.game.core.service.service.PlayerLocalService;
import com.liferay.react.game.rest.dto.v1_0.Player;
import com.liferay.react.game.rest.dto.v1_0.Ability;
import com.liferay.react.game.rest.resource.v1_0.AbilityResource;
import com.liferay.react.game.rest.resource.v1_0.PlayerResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charles Pederson
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/player.properties",
	scope = ServiceScope.PROTOTYPE, service = PlayerResource.class
)
public class PlayerResourceImpl extends BasePlayerResourceImpl {
	@Override
	public Player getPlayer(Long playerId) throws Exception {
		com.liferay.react.game.core.service.model.Player player = _playerLocalService.getPlayer(playerId);

		return _toRESTPlayer(player);
	}

	@Override
	public Player patchPlayer(Long playerId, Player player) throws Exception {
		return super.patchPlayer(playerId, player);
	}

	protected Player _toRESTPlayer(com.liferay.react.game.core.service.model.Player player) {
		long playerId = player.getPlayerId();

		List<com.liferay.react.game.core.service.model.Ability> playerAbilities = _playerEnemyAbilityLocalService.getPlayerEnemyAbilities(playerId);

		List<Ability> abilitiesList = new ArrayList<>();

		for (com.liferay.react.game.core.service.model.Ability ability : playerAbilities) {
			try {
				abilitiesList.add(abilityResource.getAbility(ability.getAbilityId()));
			} catch (Exception e) {
				e.printStackTrace();

				continue;
			}
		}

		abilitiesList.toArray(new Ability[abilitiesList.size()]);

		return new Player() {{
			abilities = abilitiesList.toArray(new Ability[abilitiesList.size()]);
			name = player.getPlayerName();
			id = playerId;
			xp = player.getXpPoints();
			level = player.getLevel();
			hitPoints = player.getHitPoints();
		}};
	}

	@Reference
	private AbilityResource abilityResource;

	@Reference
	private PlayerLocalService _playerLocalService;

	@Reference
	private PlayerEnemyAbilityLocalService _playerEnemyAbilityLocalService;
}