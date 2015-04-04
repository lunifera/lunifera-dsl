/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */

package org.lunifera.dsl.entity.xtext.extensions

class Constants {
	public static final String PROP__VALID_UNTIL = "validUntil";
	public static final String PROP__VALID_FROM = "validFrom";
	// object id
	public static final String PROP__OID = "objId";
	// object version
	public static final String PROP__VERSION = "objVersion";
	// current record of historized records
	public static final String PROP__ISCURRENT = "objCurrent";
	public static final String DT_INTERNAL_VALID_FROM = "$internal_validFrom";
	public static final String DT_INTERNAL_VALID_UNTIL = "$internal_validUntil";
	public static final String DT_INTERNAL_OBJECT_ID = "$internal_objectId";
	public static final String DT_INTERNAL_OBJECT_VERSION = "$internal_objectVersion";
	public static final String DT_INTERNAL_IS_CURRENT_VERSION = "$internal_isCurrentVersion";
}