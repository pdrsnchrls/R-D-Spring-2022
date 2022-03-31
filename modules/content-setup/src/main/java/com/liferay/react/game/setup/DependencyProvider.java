package com.liferay.react.game.setup;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;

import com.liferay.react.game.core.service.service.AbilityLocalService;
import com.liferay.react.game.core.service.service.EnemyLocalService;
import com.liferay.react.game.core.service.service.PlayerEnemyAbilityLocalService;
import com.liferay.react.game.core.service.service.PlayerLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = DependencyProvider.class)
public class DependencyProvider {

	public AbilityLocalService getAbilityLocalService() {
		return _abilityLocalService;
	}

	public CompanyLocalService getCompanyLocalService() {
		return _companyLocalService;
	}

	public EnemyLocalService getEnemyLocalService() {
		return _enemyLocalService;
	}

	public GroupLocalService getGroupLocalService() {
		return _groupLocalService;
	}

	public LayoutLocalService getLayoutLocalService() {
		return _layoutLocalService;
	}

	public PlayerEnemyAbilityLocalService getPlayerEnemyAbilityLocalService() {
		return _playerEnemyAbilityLocalService;
	}

	public PlayerLocalService getPlayerLocalService() {
		return _playerLocalService;
	}

	public Portal getPortal() {
		return _portal;
	}

	public Portlet getReactGamePortlet() {
		return _reactGamePortlet;
	}

	public UserLocalService getUserLocalService() {
		return _userLocalService;
	}

	@Reference
	private AbilityLocalService _abilityLocalService;

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private EnemyLocalService _enemyLocalService;

	@Reference
	private PlayerEnemyAbilityLocalService _playerEnemyAbilityLocalService;

	@Reference
	private PlayerLocalService _playerLocalService;

	@Reference
	private Portal _portal;

	@Reference(
		target = "(javax.portlet.name=com_liferay_react_game_portlet_ReactGame)"
	)
	private Portlet _reactGamePortlet;

	@Reference
	private UserLocalService _userLocalService;

}