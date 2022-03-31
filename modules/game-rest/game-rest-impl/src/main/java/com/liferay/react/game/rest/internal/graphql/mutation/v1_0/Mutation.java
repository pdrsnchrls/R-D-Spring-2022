package com.liferay.react.game.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.react.game.rest.dto.v1_0.Enemy;
import com.liferay.react.game.rest.dto.v1_0.Player;
import com.liferay.react.game.rest.resource.v1_0.EnemyResource;
import com.liferay.react.game.rest.resource.v1_0.PlayerResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Charles Pederson
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setEnemyResourceComponentServiceObjects(
		ComponentServiceObjects<EnemyResource>
			enemyResourceComponentServiceObjects) {

		_enemyResourceComponentServiceObjects =
			enemyResourceComponentServiceObjects;
	}

	public static void setPlayerResourceComponentServiceObjects(
		ComponentServiceObjects<PlayerResource>
			playerResourceComponentServiceObjects) {

		_playerResourceComponentServiceObjects =
			playerResourceComponentServiceObjects;
	}

	@GraphQLField(
		description = "Replaces the enemy with information sent in the request body. Ignores missing fields"
	)
	public Enemy patchEnemy(
			@GraphQLName("enemyId") Long enemyId,
			@GraphQLName("enemy") Enemy enemy)
		throws Exception {

		return _applyComponentServiceObjects(
			_enemyResourceComponentServiceObjects,
			this::_populateResourceContext,
			enemyResource -> enemyResource.patchEnemy(enemyId, enemy));
	}

	@GraphQLField(
		description = "Replaces the player with information sent in the request body. Ignores missing fields"
	)
	public Player patchPlayer(
			@GraphQLName("playerId") Long playerId,
			@GraphQLName("player") Player player)
		throws Exception {

		return _applyComponentServiceObjects(
			_playerResourceComponentServiceObjects,
			this::_populateResourceContext,
			playerResource -> playerResource.patchPlayer(playerId, player));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(EnemyResource enemyResource)
		throws Exception {

		enemyResource.setContextAcceptLanguage(_acceptLanguage);
		enemyResource.setContextCompany(_company);
		enemyResource.setContextHttpServletRequest(_httpServletRequest);
		enemyResource.setContextHttpServletResponse(_httpServletResponse);
		enemyResource.setContextUriInfo(_uriInfo);
		enemyResource.setContextUser(_user);
		enemyResource.setGroupLocalService(_groupLocalService);
		enemyResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(PlayerResource playerResource)
		throws Exception {

		playerResource.setContextAcceptLanguage(_acceptLanguage);
		playerResource.setContextCompany(_company);
		playerResource.setContextHttpServletRequest(_httpServletRequest);
		playerResource.setContextHttpServletResponse(_httpServletResponse);
		playerResource.setContextUriInfo(_uriInfo);
		playerResource.setContextUser(_user);
		playerResource.setGroupLocalService(_groupLocalService);
		playerResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<EnemyResource>
		_enemyResourceComponentServiceObjects;
	private static ComponentServiceObjects<PlayerResource>
		_playerResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}