package com.liferay.react.game.setup.common;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.react.game.setup.DependencyProvider;

public abstract class BaseUpgradeProcess extends UpgradeProcess {

	public BaseUpgradeProcess(DependencyProvider provider) {
		companyLocalService = provider.getCompanyLocalService();
		groupLocalService = provider.getGroupLocalService();
		reactGamePortlet = provider.getReactGamePortlet();
		layoutLocalService = provider.getLayoutLocalService();
		portal = provider.getPortal();
		userLocalService = provider.getUserLocalService();
	}

	protected CompanyLocalService companyLocalService;
	protected GroupLocalService groupLocalService;
	protected LayoutLocalService layoutLocalService;
	protected Portal portal;
	protected Portlet reactGamePortlet;
	protected UserLocalService userLocalService;

}