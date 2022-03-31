package com.liferay.react.game.setup.common;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.react.game.core.service.service.AbilityLocalService;
import com.liferay.react.game.core.service.service.EnemyLocalService;
import com.liferay.react.game.core.service.service.PlayerEnemyAbilityLocalService;
import com.liferay.react.game.core.service.service.PlayerLocalService;
import com.liferay.react.game.setup.DependencyProvider;

public abstract class BaseUpgradeProcess extends UpgradeProcess {

	public BaseUpgradeProcess(DependencyProvider provider) {
		abilityLocalService = provider.getAbilityLocalService();
		companyLocalService = provider.getCompanyLocalService();
		groupLocalService = provider.getGroupLocalService();
		reactGamePortlet = provider.getReactGamePortlet();
		layoutLocalService = provider.getLayoutLocalService();
		enemyLocalService = provider.getEnemyLocalService();
		playerEnemyAbilityLocalService = provider.getPlayerEnemyAbilityLocalService();
		playerLocalService = provider.getPlayerLocalService();
		portal = provider.getPortal();
		userLocalService = provider.getUserLocalService();
	}

	protected AbilityLocalService abilityLocalService;
	protected CompanyLocalService companyLocalService;
	protected EnemyLocalService enemyLocalService;
	protected GroupLocalService groupLocalService;
	protected LayoutLocalService layoutLocalService;
	protected Portal portal;
	protected PlayerEnemyAbilityLocalService playerEnemyAbilityLocalService;
	protected PlayerLocalService playerLocalService;
	protected Portlet reactGamePortlet;
	protected UserLocalService userLocalService;

}