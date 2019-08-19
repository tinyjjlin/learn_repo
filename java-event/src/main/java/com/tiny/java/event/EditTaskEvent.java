package com.tiny.java.event;

/**
 * @author tiny lin
 * @date 2019/8/2
 */
public class EditTaskEvent extends  TaskEvent {

    public EditTaskEvent(Object source, TaskEventType taskEventType) {
        super(source, taskEventType);
    }
}
