package com.liferay.react.game.rest.internal.resource.v1_0;

import com.liferay.react.game.core.service.service.EnemyLocalService;
import com.liferay.react.game.core.service.service.PlayerEnemyAbilityLocalService;
import com.liferay.react.game.rest.dto.v1_0.Enemy;
import com.liferay.react.game.rest.dto.v1_0.Ability;
import com.liferay.react.game.rest.resource.v1_0.AbilityResource;
import com.liferay.react.game.rest.resource.v1_0.EnemyResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Charles Pederson
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/enemy.properties",
	scope = ServiceScope.PROTOTYPE, service = EnemyResource.class
)
public class EnemyResourceImpl extends BaseEnemyResourceImpl {

	@Override
	public Enemy getEnemy(Long enemyId) throws Exception {
		return _toRESTEnemy(_enemyLocalService.getEnemy(enemyId));
	}

	@Override
	public Enemy patchEnemy(Long enemyId, Enemy enemy) throws Exception {
		return super.patchEnemy(enemyId, enemy);
	}

	protected Enemy _toRESTEnemy(com.liferay.react.game.core.service.model.Enemy enemy) {
		long enemyId = enemy.getEnemyId();

		List<com.liferay.react.game.core.service.model.Ability> enemyAbilities = _playerEnemyAbilityLocalService.getPlayerEnemyAbilities(enemyId);

		List<Ability> abilitiesList = new ArrayList<>();

		if (Objects.nonNull(enemyAbilities)) {
			for (com.liferay.react.game.core.service.model.Ability ability : enemyAbilities) {
				try {
					abilitiesList.add(abilityResource.getAbility(ability.getAbilityId()));
				} catch (Exception e) {
					e.printStackTrace();

					continue;
				}
			}
		}

		abilitiesList.toArray(new com.liferay.react.game.rest.dto.v1_0.Ability[abilitiesList.size()]);

		return new Enemy() {{
			abilities = abilitiesList.toArray(new com.liferay.react.game.rest.dto.v1_0.Ability[abilitiesList.size()]);
			hitPoints = enemy.getHitPoints();
			id = enemyId;
			image = enemy.getImageURL();
			level = enemy.getLevel();
			name = enemy.getEnemyName();
			xpDrop = enemy.getXpDrop();
		}};
	}

	@Reference
	private AbilityResource abilityResource;

	@Reference
	private EnemyLocalService _enemyLocalService;

	@Reference
	private PlayerEnemyAbilityLocalService _playerEnemyAbilityLocalService;
}