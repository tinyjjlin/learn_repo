package com.tiny.java.event;

import java.util.EventListener;

/**
 * @author tiny lin
 * @date 2019/8/2
 */
public interface TaskListener extends EventListener {
    public void doEvent(TaskEvent event);
}
