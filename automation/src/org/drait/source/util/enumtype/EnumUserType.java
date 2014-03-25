/*
 *  EnumUserType.java
 *
 *  Created on: Sep 8, 2013 By: U0173015
 *  Copyright 2013: Thomson Reuters Global Resources. All Rights Reserved.
 *
 *  Proprietary and Confidential information of TRGR.
 *  Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package org.drait.source.util.enumtype;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.drait.source.util.uuid.HibernateUserType;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.TypeResolver;
import org.hibernate.usertype.ParameterizedType;



/**
 * Hibernate custom user type for enum.
 * @author DEEPAK
 * 
 */
public class EnumUserType extends HibernateUserType implements
        ParameterizedType
{

    private Class<?> enumClass;

    private AbstractSingleColumnStandardBasicType<?> type;

    private int[] sqlTypes;

    private Method identifierMethod;

    @Override
    public boolean equals(final Object x, final Object y)
    {
        return x == y;
    }

    @Override
    public Class<?> returnedClass()
    {
        return this.enumClass;
    }

    @Override
    public int[] sqlTypes()
    {
        return sqlTypes;
    }

    @Override
    public Object nullSafeGet(final ResultSet resultSet, final String[] names,
            final SessionImplementor session, final Object owner)
            throws SQLException

    {
        // Get value stored from database
        Object id = type.get(resultSet, names[0], session);

        Object enumObject = null;

        for (Object enumValue : returnedClass().getEnumConstants())
        {
            try
            {
                // Get value associated with enum
                Object value = identifierMethod
                        .invoke(enumValue, new Object[0]);
                if (id.equals(value))
                {
                    enumObject = enumValue;
                    break;
                }
            }
            catch (Exception exception)
            {
                throw new HibernateException(
                        "Exception thrown while invoking identifier method",
                        exception);
            }

        }

        return enumObject;
    }

    @Override
    public void nullSafeSet(final PreparedStatement preparedStatement,
            final Object value, final int index,
            final SessionImplementor session) throws SQLException
    {
        if (null == value)
        {
            preparedStatement.setNull(index, type.sqlType());
        }
        else
        {
            try
            {
                // The id value associated with enum
                Object identifier = identifierMethod.invoke(value,
                        new Object[0]);
                preparedStatement.setObject(index, identifier);
            }
            catch (Exception exception)
            {
                throw new HibernateException(
                        "Exception thrown while invoking identifier method",
                        exception);
            }

        }
    }

    @Override
    public void setParameterValues(final Properties parameters)
    {
        // Enum class name from parameter
        String enumClassName = parameters.getProperty("enumClass");

        try
        {
            enumClass = Class.forName(enumClassName).asSubclass(Enum.class);
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            throw new HibernateException("Enum class not found",
                    classNotFoundException);
        }

        // Name of identifier method, default getId
        String identifierMethodName = parameters.getProperty(
                "identifierMethod", "getId");

        try
        {
            identifierMethod = enumClass.getMethod(identifierMethodName,
                    new Class[0]);
        }
        catch (Exception exception)
        {
            throw new HibernateException(
                    "Failed to obtain identifier method",
                    exception);
        }

        String valueType = identifierMethod.getReturnType().getName();

        TypeResolver typeResolver = new TypeResolver();

        type = (AbstractSingleColumnStandardBasicType<?>) typeResolver
                .basic(valueType);

        sqlTypes = new int[] { type.sqlType() };
    }
}
