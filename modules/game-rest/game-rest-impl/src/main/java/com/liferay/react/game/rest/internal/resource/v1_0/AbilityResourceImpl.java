package com.liferay.react.game.rest.internal.resource.v1_0;

import com.liferay.react.game.rest.resource.v1_0.AbilityResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Charles Pederson
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/ability.properties",
	scope = ServiceScope.PROTOTYPE, service = AbilityResource.class
)
public class AbilityResourceImpl extends BaseAbilityResourceImpl {
}