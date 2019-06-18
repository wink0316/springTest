package org.com.wink.IO.socketX.client.sender;


import org.com.wink.IO.socketX.SocketWrapper;

import java.io.IOException;

import static org.com.wink.IO.socketX.Commons.*;


public class DefaultSender implements Sendable {
	
	public DefaultSender(String []tokens) {
		String firstToken = tokens[0];
		if(HELP_STR.equalsIgnoreCase(firstToken)) {//帮助
			println(HELP_SHOW);
		}else if(EXIT_STR.equalsIgnoreCase(firstToken)) {//退出
			//System.exit(0);该方法直接关闭进程，也可以使用，自定义的ExitException外部会做socket回收处理
			/*try {
				throw new ExitException(null,null);
			} catch (ExitException e) {
				e.printStackTrace();
			}*/
		}else {
			throw new RuntimeException(ERROR_MESSAGE_FORMAT);
		}
	}

	@Override
	public byte getSendType() {
		return 0;
	}

	@Override
	public void sendContent(SocketWrapper socketWrapper) throws IOException {
		/*不发送任何信息*/
	}

}
