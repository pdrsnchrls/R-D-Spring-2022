package com.liferay.react.game.rest.client.serdes.v1_0;

import com.liferay.react.game.rest.client.dto.v1_0.Ability;
import com.liferay.react.game.rest.client.dto.v1_0.Enemy;
import com.liferay.react.game.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author Charles Pederson
 * @generated
 */
@Generated("")
public class EnemySerDes {

	public static Enemy toDTO(String json) {
		EnemyJSONParser enemyJSONParser = new EnemyJSONParser();

		return enemyJSONParser.parseToDTO(json);
	}

	public static Enemy[] toDTOs(String json) {
		EnemyJSONParser enemyJSONParser = new EnemyJSONParser();

		return enemyJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Enemy enemy) {
		if (enemy == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (enemy.getAbilities() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"abilities\": ");

			sb.append("[");

			for (int i = 0; i < enemy.getAbilities().length; i++) {
				sb.append(String.valueOf(enemy.getAbilities()[i]));

				if ((i + 1) < enemy.getAbilities().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (enemy.getHitPoints() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hitPoints\": ");

			sb.append(enemy.getHitPoints());
		}

		if (enemy.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(enemy.getId());
		}

		if (enemy.getImage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"image\": ");

			sb.append("\"");

			sb.append(_escape(enemy.getImage()));

			sb.append("\"");
		}

		if (enemy.getLevel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"level\": ");

			sb.append(enemy.getLevel());
		}

		if (enemy.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(enemy.getName()));

			sb.append("\"");
		}

		if (enemy.getXpDrop() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"xpDrop\": ");

			sb.append(enemy.getXpDrop());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EnemyJSONParser enemyJSONParser = new EnemyJSONParser();

		return enemyJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Enemy enemy) {
		if (enemy == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (enemy.getAbilities() == null) {
			map.put("abilities", null);
		}
		else {
			map.put("abilities", String.valueOf(enemy.getAbilities()));
		}

		if (enemy.getHitPoints() == null) {
			map.put("hitPoints", null);
		}
		else {
			map.put("hitPoints", String.valueOf(enemy.getHitPoints()));
		}

		if (enemy.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(enemy.getId()));
		}

		if (enemy.getImage() == null) {
			map.put("image", null);
		}
		else {
			map.put("image", String.valueOf(enemy.getImage()));
		}

		if (enemy.getLevel() == null) {
			map.put("level", null);
		}
		else {
			map.put("level", String.valueOf(enemy.getLevel()));
		}

		if (enemy.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(enemy.getName()));
		}

		if (enemy.getXpDrop() == null) {
			map.put("xpDrop", null);
		}
		else {
			map.put("xpDrop", String.valueOf(enemy.getXpDrop()));
		}

		return map;
	}

	public static class EnemyJSONParser extends BaseJSONParser<Enemy> {

		@Override
		protected Enemy createDTO() {
			return new Enemy();
		}

		@Override
		protected Enemy[] createDTOArray(int size) {
			return new Enemy[size];
		}

		@Override
		protected void setField(
			Enemy enemy, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "abilities")) {
				if (jsonParserFieldValue != null) {
					enemy.setAbilities(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> AbilitySerDes.toDTO((String)object)
						).toArray(
							size -> new Ability[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "hitPoints")) {
				if (jsonParserFieldValue != null) {
					enemy.setHitPoints(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					enemy.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "image")) {
				if (jsonParserFieldValue != null) {
					enemy.setImage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "level")) {
				if (jsonParserFieldValue != null) {
					enemy.setLevel(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					enemy.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "xpDrop")) {
				if (jsonParserFieldValue != null) {
					enemy.setXpDrop(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}