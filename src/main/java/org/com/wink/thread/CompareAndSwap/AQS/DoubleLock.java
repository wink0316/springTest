package org.com.wink.thread.CompareAndSwap.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class DoubleLock {

    private static class Sync extends AbstractQueuedSynchronizer{

        public Sync() {
            super();
            setState(2);//两个并发
        }

        @Override
        protected int tryAcquireShared(int arg) {
            while (true){
                int curr = getState();
                int next = curr - arg;
                if(compareAndSetState(curr,next)){
                    return next;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true){
                int curr = getState();
                int next = curr + arg;
                if(compareAndSetState(curr,next)){
                    return true;
                }
            }
        }

        private Sync sync = new Sync();

        public void lock(){
            sync.acquireShared(1);
        }

        public void unlock(){
            sync.releaseShared(1);
        }
    }
}
