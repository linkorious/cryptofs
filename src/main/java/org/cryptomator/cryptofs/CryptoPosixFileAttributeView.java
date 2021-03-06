/*******************************************************************************
 * Copyright (c) 2016 Sebastian Stenzel and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the accompanying LICENSE.txt.
 *
 * Contributors:
 *     Sebastian Stenzel - initial API and implementation
 *******************************************************************************/
package org.cryptomator.cryptofs;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;

class CryptoPosixFileAttributeView extends AbstractCryptoFileAttributeView<PosixFileAttributes, PosixFileAttributeView> implements PosixFileAttributeView {

	public CryptoPosixFileAttributeView(Path ciphertextPath, CryptoFileAttributeProvider fileAttributeProvider) throws UnsupportedFileAttributeViewException {
		super(ciphertextPath, fileAttributeProvider, PosixFileAttributes.class, PosixFileAttributeView.class);
	}

	@Override
	public String name() {
		return "posix";
	}

	@Override
	public UserPrincipal getOwner() throws IOException {
		return delegate.getOwner();
	}

	@Override
	public void setOwner(UserPrincipal owner) throws IOException {
		delegate.setOwner(owner);
	}

	@Override
	public void setPermissions(Set<PosixFilePermission> perms) throws IOException {
		delegate.setPermissions(perms);
	}

	@Override
	public void setGroup(GroupPrincipal group) throws IOException {
		delegate.setGroup(group);
	}

}
