package com.meila.common.sftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * 
 ************************************************************
 * @类名 : SftpClient.java
 *
 * @DESCRIPTION : sftp工具方法
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class SftpClient {
    private ChannelSftp sftp = null;
    private Session session = null;

    public SftpClient(String ip, String username, String password, int port) throws JSchException {
        JSch jsch = new JSch();

        // 采用指定的端口连接服务器
        session = jsch.getSession(username, ip, port);
        // 设置登陆主机的密码
        session.setPassword(password);// 设置密码
        // 设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        // 设置登陆超时时间
        session.connect(30000);

        Channel channel = (Channel) session.openChannel("sftp");
        channel.connect();
        sftp = (ChannelSftp) channel;
    }

    public void close() {
        if (null != sftp) {
            sftp.disconnect();
        }
        if (null != session) {
            session.disconnect();
        }
    }

    public void upload(String localFile, String remoteFile, String remotePath) throws SftpException, IOException {
        // 以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
        sftp.cd(remotePath);
        OutputStream outstream = sftp.put(remoteFile);
        InputStream instream = new FileInputStream(new File(localFile));

        byte b[] = new byte[1024];
        int n;
        while ((n = instream.read(b)) != -1) {
            outstream.write(b, 0, n);
        }

        outstream.flush();
        outstream.close();
        instream.close();
    }

}
