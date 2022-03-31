package com.liferay.react.game.rest.client.serdes.v1_0;

import com.liferay.react.game.rest.client.dto.v1_0.Ability;
import com.liferay.react.game.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Charles Pederson
 * @generated
 */
@Generated("")
public class AbilitySerDes {

	public static Ability toDTO(String json) {
		AbilityJSONParser abilityJSONParser = new AbilityJSONParser();

		return abilityJSONParser.parseToDTO(json);
	}

	public static Ability[] toDTOs(String json) {
		AbilityJSONParser abilityJSONParser = new AbilityJSONParser();

		return abilityJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Ability ability) {
		if (ability == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (ability.getHealing() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"healing\": ");

			sb.append(ability.getHealing());
		}

		if (ability.getHitPoints() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hitPoints\": ");

			sb.append(ability.getHitPoints());
		}

		if (ability.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(ability.getId());
		}

		if (ability.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(ability.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AbilityJSONParser abilityJSONParser = new AbilityJSONParser();

		return abilityJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Ability ability) {
		if (ability == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (ability.getHealing() == null) {
			map.put("healing", null);
		}
		else {
			map.put("healing", String.valueOf(ability.getHealing()));
		}

		if (ability.getHitPoints() == null) {
			map.put("hitPoints", null);
		}
		else {
			map.put("hitPoints", String.valueOf(ability.getHitPoints()));
		}

		if (ability.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(ability.getId()));
		}

		if (ability.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(ability.getName()));
		}

		return map;
	}

	public static class AbilityJSONParser extends BaseJSONParser<Ability> {

		@Override
		protected Ability createDTO() {
			return new Ability();
		}

		@Override
		protected Ability[] createDTOArray(int size) {
			return new Ability[size];
		}

		@Override
		protected void setField(
			Ability ability, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "healing")) {
				if (jsonParserFieldValue != null) {
					ability.setHealing((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "hitPoints")) {
				if (jsonParserFieldValue != null) {
					ability.setHitPoints(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					ability.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					ability.setName((String)jsonParserFieldValue);
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