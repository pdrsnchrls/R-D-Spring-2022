package com.liferay.react.game.setup.common;

import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.react.game.setup.DependencyProvider;

public abstract class BaseUpgradeProcess extends UpgradeProcess {
    public BaseUpgradeProcess(DependencyProvider provider) {
        userLocalService = provider.getUserLocalService();
    }

    protected UserLocalService userLocalService;
}
