package com.liferay.react.game.setup.v1_0_0;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.react.game.setup.DependencyProvider;
import com.liferay.react.game.setup.common.BaseUpgradeProcess;

public class AddGameContentUpgradeProcess extends BaseUpgradeProcess {

	public AddGameContentUpgradeProcess(DependencyProvider provider) {
		super(provider);
	}

	@Override
	protected void doUpgrade() throws Exception {
		System.out.println("Hello! We are upgrading the thing.");

		Group group = groupLocalService.getGroup(
			portal.getDefaultCompanyId(), "Guest");

		_setupMainPage(group.getCreatorUserId(), group.getGroupId());
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

}