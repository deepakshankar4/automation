

package org.drait.source.util.uuid;

import java.io.Serializable;

import org.hibernate.usertype.UserType;


public abstract class HibernateUserType implements UserType
{
    @Override
    public Object assemble(final Serializable arg0, final Object arg1)
    {
        // hibernate 3.x optional method, implement default behavior.
        return null;
    }

    @Override
    public Serializable disassemble(final Object arg0)
    {
        // hibernate 3.x optional method, implement default behavior.
        return null;
    }

    @Override
    public int hashCode(final Object x)
    {
        // hibernate 3.x method, implement default behavior.
        return null == x ? 0 : x.hashCode();
    }

    @Override
    public Object replace(final Object original, final Object target,
            final Object owner)
    {
        // hibernate 3.x method, implement default behavior.
        Object replaceObject;
        if (original == null || !isMutable())
        {
            replaceObject = original;
        }
        else
        {
            replaceObject = deepCopy(original);
        }
        return replaceObject;

    }

    @Override
    public Object deepCopy(final Object value)
    {
        return value;
    }

    @Override
    public boolean isMutable()
    {
        return false;
    }

}
