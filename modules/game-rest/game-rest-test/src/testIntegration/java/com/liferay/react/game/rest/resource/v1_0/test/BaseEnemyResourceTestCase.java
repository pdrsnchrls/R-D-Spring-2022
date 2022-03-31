package com.liferay.react.game.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.react.game.rest.client.dto.v1_0.Enemy;
import com.liferay.react.game.rest.client.http.HttpInvoker;
import com.liferay.react.game.rest.client.pagination.Page;
import com.liferay.react.game.rest.client.resource.v1_0.EnemyResource;
import com.liferay.react.game.rest.client.serdes.v1_0.EnemySerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Charles Pederson
 * @generated
 */
@Generated("")
public abstract class BaseEnemyResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_enemyResource.setContextCompany(testCompany);

		EnemyResource.Builder builder = EnemyResource.builder();

		enemyResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Enemy enemy1 = randomEnemy();

		String json = objectMapper.writeValueAsString(enemy1);

		Enemy enemy2 = EnemySerDes.toDTO(json);

		Assert.assertTrue(equals(enemy1, enemy2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Enemy enemy = randomEnemy();

		String json1 = objectMapper.writeValueAsString(enemy);
		String json2 = EnemySerDes.toJSON(enemy);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Enemy enemy = randomEnemy();

		enemy.setImage(regex);
		enemy.setName(regex);

		String json = EnemySerDes.toJSON(enemy);

		Assert.assertFalse(json.contains(regex));

		enemy = EnemySerDes.toDTO(json);

		Assert.assertEquals(regex, enemy.getImage());
		Assert.assertEquals(regex, enemy.getName());
	}

	@Test
	public void testGetEnemy() throws Exception {
		Enemy postEnemy = testGetEnemy_addEnemy();

		Enemy getEnemy = enemyResource.getEnemy(postEnemy.getId());

		assertEquals(postEnemy, getEnemy);
		assertValid(getEnemy);
	}

	protected Enemy testGetEnemy_addEnemy() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetEnemy() throws Exception {
		Enemy enemy = testGraphQLEnemy_addEnemy();

		Assert.assertTrue(
			equals(
				enemy,
				EnemySerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"enemy",
								new HashMap<String, Object>() {
									{
										put("enemyId", enemy.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/enemy"))));
	}

	@Test
	public void testGraphQLGetEnemyNotFound() throws Exception {
		Long irrelevantEnemyId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"enemy",
						new HashMap<String, Object>() {
							{
								put("enemyId", irrelevantEnemyId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPatchEnemy() throws Exception {
		Enemy postEnemy = testPatchEnemy_addEnemy();

		Enemy randomPatchEnemy = randomPatchEnemy();

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Enemy patchEnemy = enemyResource.patchEnemy(
			postEnemy.getId(), randomPatchEnemy);

		Enemy expectedPatchEnemy = postEnemy.clone();

		_beanUtilsBean.copyProperties(expectedPatchEnemy, randomPatchEnemy);

		Enemy getEnemy = enemyResource.getEnemy(patchEnemy.getId());

		assertEquals(expectedPatchEnemy, getEnemy);
		assertValid(getEnemy);
	}

	protected Enemy testPatchEnemy_addEnemy() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Enemy testGraphQLEnemy_addEnemy() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Enemy enemy, List<Enemy> enemies) {
		boolean contains = false;

		for (Enemy item : enemies) {
			if (equals(enemy, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(enemies + " does not contain " + enemy, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Enemy enemy1, Enemy enemy2) {
		Assert.assertTrue(
			enemy1 + " does not equal " + enemy2, equals(enemy1, enemy2));
	}

	protected void assertEquals(List<Enemy> enemies1, List<Enemy> enemies2) {
		Assert.assertEquals(enemies1.size(), enemies2.size());

		for (int i = 0; i < enemies1.size(); i++) {
			Enemy enemy1 = enemies1.get(i);
			Enemy enemy2 = enemies2.get(i);

			assertEquals(enemy1, enemy2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Enemy> enemies1, List<Enemy> enemies2) {

		Assert.assertEquals(enemies1.size(), enemies2.size());

		for (Enemy enemy1 : enemies1) {
			boolean contains = false;

			for (Enemy enemy2 : enemies2) {
				if (equals(enemy1, enemy2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				enemies2 + " does not contain " + enemy1, contains);
		}
	}

	protected void assertValid(Enemy enemy) throws Exception {
		boolean valid = true;

		if (enemy.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("abilities", additionalAssertFieldName)) {
				if (enemy.getAbilities() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("hitPoints", additionalAssertFieldName)) {
				if (enemy.getHitPoints() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("image", additionalAssertFieldName)) {
				if (enemy.getImage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("level", additionalAssertFieldName)) {
				if (enemy.getLevel() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (enemy.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("xpDrop", additionalAssertFieldName)) {
				if (enemy.getXpDrop() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Enemy> page) {
		boolean valid = false;

		java.util.Collection<Enemy> enemies = page.getItems();

		int size = enemies.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.liferay.react.game.rest.dto.v1_0.Enemy.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Enemy enemy1, Enemy enemy2) {
		if (enemy1 == enemy2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("abilities", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						enemy1.getAbilities(), enemy2.getAbilities())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("hitPoints", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						enemy1.getHitPoints(), enemy2.getHitPoints())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(enemy1.getId(), enemy2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("image", additionalAssertFieldName)) {
				if (!Objects.deepEquals(enemy1.getImage(), enemy2.getImage())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("level", additionalAssertFieldName)) {
				if (!Objects.deepEquals(enemy1.getLevel(), enemy2.getLevel())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(enemy1.getName(), enemy2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("xpDrop", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						enemy1.getXpDrop(), enemy2.getXpDrop())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_enemyResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_enemyResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Enemy enemy) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("abilities")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("hitPoints")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("image")) {
			sb.append("'");
			sb.append(String.valueOf(enemy.getImage()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("level")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(enemy.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("xpDrop")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Enemy randomEnemy() throws Exception {
		return new Enemy() {
			{
				hitPoints = RandomTestUtil.randomInt();
				id = RandomTestUtil.randomLong();
				image = StringUtil.toLowerCase(RandomTestUtil.randomString());
				level = RandomTestUtil.randomInt();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				xpDrop = RandomTestUtil.randomInt();
			}
		};
	}

	protected Enemy randomIrrelevantEnemy() throws Exception {
		Enemy randomIrrelevantEnemy = randomEnemy();

		return randomIrrelevantEnemy;
	}

	protected Enemy randomPatchEnemy() throws Exception {
		return randomEnemy();
	}

	protected EnemyResource enemyResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseEnemyResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.react.game.rest.resource.v1_0.EnemyResource
		_enemyResource;

}