package org.drait.source.util.uuid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;

public class UuidUserType extends HibernateUserType {
	// Indicates database type or types
	private static final int[] TYPES = { Types.CHAR };

	@Override
	public boolean equals(final Object x, final Object y) {
		boolean isequal;
		if (x == null && y == null) {
			isequal = true;
		} else if (x == null || y == null) {
			isequal = false;
		} else {
			isequal = x.equals(y);
		}

		return isequal;
	}

	@Override
	public Object nullSafeGet(final ResultSet resultSet, final String[] names,
			final SessionImplementor session, final Object owner)
			throws SQLException {
		final String value = (String) StringType.INSTANCE.get(resultSet,
				names[0], session);
		return null == value ? null : new Uuid(value);
	}
	


	@Override
	public void nullSafeSet(final PreparedStatement statement,
			final Object value, final int index,
			final SessionImplementor session) throws SQLException {
		if (value == null) {
			statement.setNull(index, Types.CHAR);
			StringType.INSTANCE.nullSafeSet(statement, null, index, session);
		} else {
			StringType.INSTANCE.nullSafeSet(statement,
					((Uuid) value).getUuid(), index, session);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return Uuid.class;
	}

	@Override
	public int[] sqlTypes() {
		return TYPES;
	}
}
