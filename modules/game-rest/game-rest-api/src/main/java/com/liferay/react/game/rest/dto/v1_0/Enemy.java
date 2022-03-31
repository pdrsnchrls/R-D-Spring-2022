package com.liferay.react.game.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Charles Pederson
 * @generated
 */
@Generated("")
@GraphQLName(description = "The enemy that will be fought", value = "Enemy")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Enemy")
public class Enemy implements Serializable {

	public static Enemy toDTO(String json) {
		return ObjectMapperUtil.readValue(Enemy.class, json);
	}

	public static Enemy unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Enemy.class, json);
	}

	@Schema(description = "The abilites the enemy has")
	@Valid
	public Ability[] getAbilities() {
		return abilities;
	}

	public void setAbilities(Ability[] abilities) {
		this.abilities = abilities;
	}

	@JsonIgnore
	public void setAbilities(
		UnsafeSupplier<Ability[], Exception> abilitiesUnsafeSupplier) {

		try {
			abilities = abilitiesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The abilites the enemy has")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Ability[] abilities;

	@Schema(description = "The enemy's hit points")
	public Integer getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(Integer hitPoints) {
		this.hitPoints = hitPoints;
	}

	@JsonIgnore
	public void setHitPoints(
		UnsafeSupplier<Integer, Exception> hitPointsUnsafeSupplier) {

		try {
			hitPoints = hitPointsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The enemy's hit points")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer hitPoints;

	@Schema(description = "The enemy's internal ID.")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The enemy's internal ID.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long id;

	@Schema(description = "the internal url to the enemy's image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@JsonIgnore
	public void setImage(
		UnsafeSupplier<String, Exception> imageUnsafeSupplier) {

		try {
			image = imageUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "the internal url to the enemy's image")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String image;

	@Schema(description = "The enemy's level")
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@JsonIgnore
	public void setLevel(
		UnsafeSupplier<Integer, Exception> levelUnsafeSupplier) {

		try {
			level = levelUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The enemy's level")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer level;

	@Schema(description = "The enemy's name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The enemy's name")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

	@Schema(description = "The enemy's xp it drops when killed")
	public Integer getXpDrop() {
		return xpDrop;
	}

	public void setXpDrop(Integer xpDrop) {
		this.xpDrop = xpDrop;
	}

	@JsonIgnore
	public void setXpDrop(
		UnsafeSupplier<Integer, Exception> xpDropUnsafeSupplier) {

		try {
			xpDrop = xpDropUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The enemy's xp it drops when killed")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer xpDrop;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Enemy)) {
			return false;
		}

		Enemy enemy = (Enemy)object;

		return Objects.equals(toString(), enemy.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (abilities != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"abilities\": ");

			sb.append("[");

			for (int i = 0; i < abilities.length; i++) {
				sb.append(String.valueOf(abilities[i]));

				if ((i + 1) < abilities.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (hitPoints != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hitPoints\": ");

			sb.append(hitPoints);
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (image != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"image\": ");

			sb.append("\"");

			sb.append(_escape(image));

			sb.append("\"");
		}

		if (level != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"level\": ");

			sb.append(level);
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (xpDrop != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"xpDrop\": ");

			sb.append(xpDrop);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.liferay.react.game.rest.dto.v1_0.Enemy",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}