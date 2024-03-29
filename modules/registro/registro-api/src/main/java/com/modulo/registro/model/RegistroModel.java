/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.modulo.registro.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Registro service. Represents a row in the &quot;REG_Registro&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.modulo.registro.model.impl.RegistroModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.modulo.registro.model.impl.RegistroImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Registro
 * @generated
 */
@ProviderType
public interface RegistroModel extends BaseModel<Registro>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a registro model instance should use the {@link Registro} interface instead.
	 */

	/**
	 * Returns the primary key of this registro.
	 *
	 * @return the primary key of this registro
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this registro.
	 *
	 * @param primaryKey the primary key of this registro
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the registro ID of this registro.
	 *
	 * @return the registro ID of this registro
	 */
	public long getRegistroId();

	/**
	 * Sets the registro ID of this registro.
	 *
	 * @param registroId the registro ID of this registro
	 */
	public void setRegistroId(long registroId);

	/**
	 * Returns the company ID of this registro.
	 *
	 * @return the company ID of this registro
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this registro.
	 *
	 * @param companyId the company ID of this registro
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this registro.
	 *
	 * @return the group ID of this registro
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this registro.
	 *
	 * @param groupId the group ID of this registro
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user name of this registro.
	 *
	 * @return the user name of this registro
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this registro.
	 *
	 * @param userName the user name of this registro
	 */
	public void setUserName(String userName);

	/**
	 * Returns the lastname of this registro.
	 *
	 * @return the lastname of this registro
	 */
	@AutoEscape
	public String getLastname();

	/**
	 * Sets the lastname of this registro.
	 *
	 * @param lastname the lastname of this registro
	 */
	public void setLastname(String lastname);

	/**
	 * Returns the email of this registro.
	 *
	 * @return the email of this registro
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this registro.
	 *
	 * @param email the email of this registro
	 */
	public void setEmail(String email);

	/**
	 * Returns the birth date of this registro.
	 *
	 * @return the birth date of this registro
	 */
	public Date getBirthDate();

	/**
	 * Sets the birth date of this registro.
	 *
	 * @param birthDate the birth date of this registro
	 */
	public void setBirthDate(Date birthDate);

	/**
	 * Returns the create date of this registro.
	 *
	 * @return the create date of this registro
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this registro.
	 *
	 * @param createDate the create date of this registro
	 */
	public void setCreateDate(Date createDate);

}