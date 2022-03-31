package com.liferay.react.game.setup.v1_0_0;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.react.game.core.service.model.Ability;
import com.liferay.react.game.core.service.model.Enemy;
import com.liferay.react.game.core.service.model.Player;
import com.liferay.react.game.setup.DependencyProvider;
import com.liferay.react.game.setup.common.BaseUpgradeProcess;
import com.liferay.react.game.setup.constants.AbilityConstants;
import com.liferay.react.game.setup.constants.EnemyConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddGameContentUpgradeProcess extends BaseUpgradeProcess {

	public AddGameContentUpgradeProcess(DependencyProvider provider) {
		super(provider);
	}

	@Override
	protected void doUpgrade() throws Exception {
		Group group = groupLocalService.getGroup(
			portal.getDefaultCompanyId(), "Guest");

		_setupMainPage(group.getCreatorUserId(), group.getGroupId());
		_addDefaultContent();
	}

	private void _addDefaultContent() {
		Ability basicAttack = abilityLocalService.addAbility(AbilityConstants.ABILITY_NAME_BASIC_ATTACK, false, 10);
		Ability basicHeal = abilityLocalService.addAbility(AbilityConstants.ABILITY_NAME_BASIC_HEAL, true, 10);
		Ability basicMagic = abilityLocalService.addAbility(AbilityConstants.ABILITY_NAME_BASIC_MAGIC, false, 10);
		Ability unstableAttack = abilityLocalService.addAbility(AbilityConstants.ABILITY_NAME_ENEMY_UNSTABLE_ATTACK, false, 20);
		Ability unstableHeal = abilityLocalService.addAbility(AbilityConstants.ABILITY_NAME_ENEMY_UNSTABLE_HEAL, true, 20);
		Ability unstableMagic = abilityLocalService.addAbility(AbilityConstants.ABILITY_NAME_ENEMY_UNSTABLE_MAGIC, false, 20);

		_logger.info("Added default abilities");

		Enemy octopus = enemyLocalService.addEnemy(EnemyConstants.ENEMY_NAME_OCTOPUS, EnemyConstants.LEVEL_1_HP, EnemyConstants.LEVEL_1,
			EnemyConstants.LEVEL_1_HP, EnemyConstants.ENEMY_NAME_OCTOPUS_IMAGE_URL);

		Enemy gremlin = enemyLocalService.addEnemy(EnemyConstants.ENEMY_NAME_GREMLIN, EnemyConstants.LEVEL_2_HP, EnemyConstants.LEVEL_2,
			EnemyConstants.LEVEL_2_HP, EnemyConstants.ENEMY_NAME_GREMLIN_IMAGE_URL);

		_logger.info("Added default enemies");

		Player player = playerLocalService.addNewPlayer("Default Player", 0);

		_logger.info("Added default player");

		playerEnemyAbilityLocalService.addPlayerEnemyAbility(true, octopus.getEnemyId(), basicAttack.getAbilityId());
		playerEnemyAbilityLocalService.addPlayerEnemyAbility(true, octopus.getEnemyId(), unstableHeal.getAbilityId());
		playerEnemyAbilityLocalService.addPlayerEnemyAbility(true, octopus.getEnemyId(), basicMagic.getAbilityId());

		playerEnemyAbilityLocalService.addPlayerEnemyAbility(true, gremlin.getEnemyId(), unstableAttack.getAbilityId());
		playerEnemyAbilityLocalService.addPlayerEnemyAbility(true, gremlin.getEnemyId(), basicHeal.getAbilityId());
		playerEnemyAbilityLocalService.addPlayerEnemyAbility(true, gremlin.getEnemyId(), unstableMagic.getAbilityId());

		playerEnemyAbilityLocalService.addPlayerEnemyAbility(false, player.getPlayerId(), basicAttack.getAbilityId());
		playerEnemyAbilityLocalService.addPlayerEnemyAbility(false, player.getPlayerId(), basicHeal.getAbilityId());
		playerEnemyAbilityLocalService.addPlayerEnemyAbility(false, player.getPlayerId(), basicMagic.getAbilityId());

		_logger.info("Added default player and enemy abilities");

	}

	private void _setupMainPage(long userId, long groupId)
		throws PortalException {

		Layout layout = layoutLocalService.addLayout(
			userId, groupId, false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
			_MAIN_PAGE_TITLE, _MAIN_PAGE_TITLE, StringPool.BLANK,
			LayoutConstants.TYPE_PORTLET, false, _MAIN_PAGE_TITLE_FRIENDLY_URL,
			new ServiceContext());

		LayoutTypePortlet layoutTypePortlet =
			(LayoutTypePortlet)layout.getLayoutType();

		layoutTypePortlet.setLayoutTemplateId(userId, "1_column");
		layoutTypePortlet.addPortletId(userId, reactGamePortlet.getPortletId());

		layoutLocalService.updateLayout(
			layout.getGroupId(), layout.isPrivateLayout(), layout.getLayoutId(),
			layout.getTypeSettings());
	}

	private static final String _MAIN_PAGE_TITLE = "Main Game Page";

	private static final String _MAIN_PAGE_TITLE_FRIENDLY_URL = "/play-game";

	private static Logger _logger = LoggerFactory.getLogger(AddGameContentUpgradeProcess.class);
}