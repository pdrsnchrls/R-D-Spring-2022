package com.liferay.react.game.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;
import com.liferay.react.game.rest.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.react.game.rest.internal.graphql.query.v1_0.Query;
import com.liferay.react.game.rest.resource.v1_0.AbilityResource;
import com.liferay.react.game.rest.resource.v1_0.EnemyResource;
import com.liferay.react.game.rest.resource.v1_0.PlayerResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Charles Pederson
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setEnemyResourceComponentServiceObjects(
			_enemyResourceComponentServiceObjects);
		Mutation.setPlayerResourceComponentServiceObjects(
			_playerResourceComponentServiceObjects);

		Query.setAbilityResourceComponentServiceObjects(
			_abilityResourceComponentServiceObjects);
		Query.setEnemyResourceComponentServiceObjects(
			_enemyResourceComponentServiceObjects);
		Query.setPlayerResourceComponentServiceObjects(
			_playerResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/game-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<EnemyResource>
		_enemyResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<PlayerResource>
		_playerResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<AbilityResource>
		_abilityResourceComponentServiceObjects;

}