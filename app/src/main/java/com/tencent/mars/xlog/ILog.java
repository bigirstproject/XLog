package com.tencent.mars.xlog;

/**
 * Created by lidexian on 2017/4/28.
 */

public interface ILog {
    void logV(String tag, String filename, String funcname, int line, int pid, long tid, long maintid, String log);

    void logI(String tag, String filename, String funcname, int line, int pid, long tid, long maintid, String log);

    void logD(String tag, String filename, String funcname, int line, int pid, long tid, long maintid, String log);

    void logW(String tag, String filename, String funcname, int line, int pid, long tid, long maintid, String log);

    void logE(String tag, String filename, String funcname, int line, int pid, long tid, long maintid, String log);

    void logF(String tag, String filename, String funcname, int line, int pid, long tid, long maintid, String log);

    int getLogLevel();

    void appenderClose();

    void appenderFlush(boolean isSync);
}
