package com.tiny.java.event;

/**
 * @author tiny lin
 * @date 2019/8/2
 */
public class EditorMain {
    public static void main(String[] args) {
        TaskEventDispatcher taskEventDispatcher = new TaskEventDispatcher();
        taskEventDispatcher.addTaskListener(new EditTaskListener());

        taskEventDispatcher.fireTaskCreate();
        taskEventDispatcher.fireTaskComplete();
    }
}
