package org.com.wink.IO.socketX.client.sender;

import org.com.wink.IO.socketX.SocketWrapper;

import java.io.IOException;

public interface Sendable {

    public byte getSendType();

    public void sendContent(SocketWrapper socketWrapper) throws IOException;
}
