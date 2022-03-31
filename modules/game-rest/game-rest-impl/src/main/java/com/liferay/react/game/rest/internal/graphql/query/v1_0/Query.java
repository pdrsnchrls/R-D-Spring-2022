package com.liferay.react.game.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.react.game.rest.dto.v1_0.Ability;
import com.liferay.react.game.rest.dto.v1_0.Enemy;
import com.liferay.react.game.rest.dto.v1_0.Player;
import com.liferay.react.game.rest.resource.v1_0.AbilityResource;
import com.liferay.react.game.rest.resource.v1_0.EnemyResource;
import com.liferay.react.game.rest.resource.v1_0.PlayerResource;

import java.util.Map;
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
public class Query {

	public static void setAbilityResourceComponentServiceObjects(
		ComponentServiceObjects<AbilityResource>
			abilityResourceComponentServiceObjects) {

		_abilityResourceComponentServiceObjects =
			abilityResourceComponentServiceObjects;
	}

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

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {ability(abilityId: ___){name, id, healing, hitPoints}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the ability via its ID.")
	public Ability ability(@GraphQLName("abilityId") Long abilityId)
		throws Exception {

		return _applyComponentServiceObjects(
			_abilityResourceComponentServiceObjects,
			this::_populateResourceContext,
			abilityResource -> abilityResource.getAbility(abilityId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {enemy(enemyId: ___){name, id, abilities, hitPoints, level, xpDrop, image}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the enemy via its ID.")
	public Enemy enemy(@GraphQLName("enemyId") Long enemyId) throws Exception {
		return _applyComponentServiceObjects(
			_enemyResourceComponentServiceObjects,
			this::_populateResourceContext,
			enemyResource -> enemyResource.getEnemy(enemyId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {player(playerId: ___){name, id, abilities, hitPoints, level, xp, image}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the player via its ID.")
	public Player player(@GraphQLName("playerId") Long playerId)
		throws Exception {

		return _applyComponentServiceObjects(
			_playerResourceComponentServiceObjects,
			this::_populateResourceContext,
			playerResource -> playerResource.getPlayer(playerId));
	}

	@GraphQLName("AbilityPage")
	public class AbilityPage {

		public AbilityPage(Page abilityPage) {
			actions = abilityPage.getActions();

			items = abilityPage.getItems();
			lastPage = abilityPage.getLastPage();
			page = abilityPage.getPage();
			pageSize = abilityPage.getPageSize();
			totalCount = abilityPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Ability> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("EnemyPage")
	public class EnemyPage {

		public EnemyPage(Page enemyPage) {
			actions = enemyPage.getActions();

			items = enemyPage.getItems();
			lastPage = enemyPage.getLastPage();
			page = enemyPage.getPage();
			pageSize = enemyPage.getPageSize();
			totalCount = enemyPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Enemy> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("PlayerPage")
	public class PlayerPage {

		public PlayerPage(Page playerPage) {
			actions = playerPage.getActions();

			items = playerPage.getItems();
			lastPage = playerPage.getLastPage();
			page = playerPage.getPage();
			pageSize = playerPage.getPageSize();
			totalCount = playerPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Player> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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

	private void _populateResourceContext(AbilityResource abilityResource)
		throws Exception {

		abilityResource.setContextAcceptLanguage(_acceptLanguage);
		abilityResource.setContextCompany(_company);
		abilityResource.setContextHttpServletRequest(_httpServletRequest);
		abilityResource.setContextHttpServletResponse(_httpServletResponse);
		abilityResource.setContextUriInfo(_uriInfo);
		abilityResource.setContextUser(_user);
		abilityResource.setGroupLocalService(_groupLocalService);
		abilityResource.setRoleLocalService(_roleLocalService);
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

	private static ComponentServiceObjects<AbilityResource>
		_abilityResourceComponentServiceObjects;
	private static ComponentServiceObjects<EnemyResource>
		_enemyResourceComponentServiceObjects;
	private static ComponentServiceObjects<PlayerResource>
		_playerResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}