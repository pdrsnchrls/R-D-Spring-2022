package com.liferay.react.game.setup;

import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = DependencyProvider.class)
public class DependencyProvider {
    public UserLocalService getUserLocalService() {
        return _userLocalService;
    }

    @Reference
    private UserLocalService _userLocalService;
}
