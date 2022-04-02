package com.liferay.react.game.rest.internal.resource.v1_0;

import com.liferay.react.game.core.service.service.AbilityLocalService;
import com.liferay.react.game.rest.dto.v1_0.Ability;
import com.liferay.react.game.rest.resource.v1_0.AbilityResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Charles Pederson
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/ability.properties",
	scope = ServiceScope.PROTOTYPE, service = AbilityResource.class
)
public class AbilityResourceImpl extends BaseAbilityResourceImpl {
	@Override
	public Ability getAbility(Long abilityId) throws Exception {
		return _toRESTAbility(_abilityLocalService.getAbility(abilityId));
	}

	protected Ability _toRESTAbility(com.liferay.react.game.core.service.model.Ability ability) {
		long abilityId = ability.getAbilityId();

		return new Ability() {{
			healing = ability.getHealing();
			hitPoints = ability.getHitPoints();
			id = abilityId;
			name = ability.getAbilityName();
		}};
	}

	@Reference
	private AbilityLocalService _abilityLocalService;
}