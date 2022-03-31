package com.liferay.react.game.setup;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.react.game.setup.v1_0_0.AddGameContentUpgradeProcess;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author charles
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ContentSetupUpgradeStepRegistrator
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.0", "1.0.0",
			new AddGameContentUpgradeProcess(_dependencyProvider));
	}

	@Reference
	private DependencyProvider _dependencyProvider;

}