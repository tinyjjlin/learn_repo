package com.tiny.java.event;


import java.util.EventObject;

/**
 * @author tiny lin
 * @date 2019/8/2
 */
public class TaskEvent extends EventObject {

    private TaskEventType taskEventType;

    public TaskEventType getType() {
        return taskEventType;
    }

    public TaskEvent(Object source) {
        super(source);
    }

    public TaskEvent(Object source,TaskEventType taskEventType){
        super(source);
        this.taskEventType = taskEventType;
    }
    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
