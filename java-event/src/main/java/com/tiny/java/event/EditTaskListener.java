package com.tiny.java.event;

/**
 * @author tiny lin
 * @date 2019/8/2
 */
public class EditTaskListener implements  TaskListener {
    public void doEvent(TaskEvent event) {
        if(event.getSource() != null && event.getType() == TaskEventType.CREATE){
            System.out.println("task already create.....");
        }else if(event.getSource() != null && event.getType() == TaskEventType.COMPELETE){
            System.out.println("task already complete .............");
        }
    }
}
