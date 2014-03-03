package org.drait.source.util.uuid;

import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.SequenceGenerator;

public class UuidIdentifierGenerator extends SequenceGenerator {

	@Override
	public Serializable generate(final SessionImplementor session,
			final Object object) {
		final Serializable id = session.getEntityPersister(null, object)
				.getClassMetadata().getIdentifier(object, session);

		return (null == id) ? new Uuid(UuidGenerator.generateId()) : id;
	}

}
