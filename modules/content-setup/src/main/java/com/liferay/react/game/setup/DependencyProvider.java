package com.liferay.react.game.setup;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = DependencyProvider.class)
public class DependencyProvider {

	public CompanyLocalService getCompanyLocalService() {
		return _companyLocalService;
	}

	public GroupLocalService getGroupLocalService() {
		return _groupLocalService;
	}

	public LayoutLocalService getLayoutLocalService() {
		return _layoutLocalService;
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
	private CompanyLocalService _companyLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private Portal _portal;

	@Reference(
		target = "(javax.portlet.name=com_liferay_react_game_portlet_ReactGame)"
	)
	private Portlet _reactGamePortlet;

	@Reference
	private UserLocalService _userLocalService;

}