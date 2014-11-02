/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import java.math.BigInteger;

/**
 * Immutable object holding digest info.
 * 
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.3
 */
public class DigestInfo {
	final private BigInteger digest;
	final private long sourceLength;

	public DigestInfo(byte[] digest, long sourceLength) {
		this(new BigInteger(1, digest), sourceLength);
	}

	public DigestInfo(BigInteger digest, long sourceLength) {
		this.digest = digest;
		this.sourceLength = sourceLength;
	}

	public long getSourceLength() {
		return sourceLength;
	}

	public BigInteger getDigest() {
		return digest;
	}

	@Override
	public String toString() {
		return digest.toString();
	}
}
