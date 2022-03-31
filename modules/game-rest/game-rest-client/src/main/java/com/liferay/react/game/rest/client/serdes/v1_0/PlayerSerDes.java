package com.liferay.react.game.rest.client.serdes.v1_0;

import com.liferay.react.game.rest.client.dto.v1_0.Ability;
import com.liferay.react.game.rest.client.dto.v1_0.Player;
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
public class PlayerSerDes {

	public static Player toDTO(String json) {
		PlayerJSONParser playerJSONParser = new PlayerJSONParser();

		return playerJSONParser.parseToDTO(json);
	}

	public static Player[] toDTOs(String json) {
		PlayerJSONParser playerJSONParser = new PlayerJSONParser();

		return playerJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Player player) {
		if (player == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (player.getAbilities() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"abilities\": ");

			sb.append("[");

			for (int i = 0; i < player.getAbilities().length; i++) {
				sb.append(String.valueOf(player.getAbilities()[i]));

				if ((i + 1) < player.getAbilities().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (player.getHitPoints() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hitPoints\": ");

			sb.append(player.getHitPoints());
		}

		if (player.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(player.getId());
		}

		if (player.getImage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"image\": ");

			sb.append("\"");

			sb.append(_escape(player.getImage()));

			sb.append("\"");
		}

		if (player.getLevel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"level\": ");

			sb.append(player.getLevel());
		}

		if (player.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(player.getName()));

			sb.append("\"");
		}

		if (player.getXp() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"xp\": ");

			sb.append(player.getXp());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PlayerJSONParser playerJSONParser = new PlayerJSONParser();

		return playerJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Player player) {
		if (player == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (player.getAbilities() == null) {
			map.put("abilities", null);
		}
		else {
			map.put("abilities", String.valueOf(player.getAbilities()));
		}

		if (player.getHitPoints() == null) {
			map.put("hitPoints", null);
		}
		else {
			map.put("hitPoints", String.valueOf(player.getHitPoints()));
		}

		if (player.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(player.getId()));
		}

		if (player.getImage() == null) {
			map.put("image", null);
		}
		else {
			map.put("image", String.valueOf(player.getImage()));
		}

		if (player.getLevel() == null) {
			map.put("level", null);
		}
		else {
			map.put("level", String.valueOf(player.getLevel()));
		}

		if (player.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(player.getName()));
		}

		if (player.getXp() == null) {
			map.put("xp", null);
		}
		else {
			map.put("xp", String.valueOf(player.getXp()));
		}

		return map;
	}

	public static class PlayerJSONParser extends BaseJSONParser<Player> {

		@Override
		protected Player createDTO() {
			return new Player();
		}

		@Override
		protected Player[] createDTOArray(int size) {
			return new Player[size];
		}

		@Override
		protected void setField(
			Player player, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "abilities")) {
				if (jsonParserFieldValue != null) {
					player.setAbilities(
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
					player.setHitPoints(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					player.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "image")) {
				if (jsonParserFieldValue != null) {
					player.setImage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "level")) {
				if (jsonParserFieldValue != null) {
					player.setLevel(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					player.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "xp")) {
				if (jsonParserFieldValue != null) {
					player.setXp(Integer.valueOf((String)jsonParserFieldValue));
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