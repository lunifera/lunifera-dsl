/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

/** 
 * @author Mark Christiaens - Initial contribution 
 * 
 * @since 2.3
 */
public class DefaultCacheEntry implements ICacheEntry {
	public static final int VERSION = 1;

	private BigInteger digest;
	private long origContentSize;
	private long creationTime;
	private long lastUsageTime; 
	private File relativeLocation;
	
	public DefaultCacheEntry() {
	}
	
    public DefaultCacheEntry(BigInteger digest, long origContentSize, File relativeLocation) {
		this.digest = digest;  
		this.origContentSize = origContentSize;
		this.creationTime = System.currentTimeMillis();
		this.lastUsageTime = creationTime;
		this.relativeLocation = relativeLocation; 
	}
	
	protected void readData(DataInputStream in) throws IOException {
		int digestArrayLength = in.readInt();
		byte [] digestArray = new byte [digestArrayLength]; 
		in.readFully(digestArray);
		digest = new BigInteger(1, digestArray); 
		origContentSize = in.readLong();
		creationTime = in.readLong(); 
		lastUsageTime = in.readLong ();
		relativeLocation = new File (in.readUTF());
	}
	
	public static DefaultCacheEntry read (DataInputStream in) throws IOException {
		DefaultCacheEntry entry = new DefaultCacheEntry ();
		entry.readData(in); 
		
		return entry;
	}

	public void write(DataOutputStream out) throws IOException {
		final byte[] digestArray = digest.toByteArray();
		out.writeInt(digestArray.length);
		out.write(digestArray);
		out.writeLong (origContentSize); 
		out.writeLong (creationTime);
		out.writeLong (lastUsageTime); 
		out.writeUTF(relativeLocation.toString()); 
		
		return;
	}

	public BigInteger getDigest() {
		return digest;
	}

	public long getOrigContentSize() {
		return origContentSize; 
	}

	public long getCreationTime() {
		return creationTime;
	}

	public int getVersion() {
	return VERSION; 
	}

	public File getRelativeCacheEntryDirPath() {
		return relativeLocation;
	}

	public File getRelativeEMFFilePath() {
		return new File(relativeLocation, "emf.ser"); 
	}
	
	@Override
	public File getRelativeDSFilePath() {
		return new File(relativeLocation, "ds.ser"); 
	}

	public File getRelativeNodeModelFilePath() {
		return new File(relativeLocation, "node.ser");
	}

	public long getLastUsageTime() {
		return lastUsageTime; 
	}

	public void updateUsageTime() {
		lastUsageTime = System.currentTimeMillis(); 
	}

}
