package com.tiny.java.event;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author tiny lin
 * @date 2019/8/2
 */
public class TaskEventDispatcher {
    private Set<TaskListener> listeners;

    public void addTaskListener(TaskListener taskListener){
        if(listeners == null){
            listeners= new HashSet<TaskListener>();
        }
        listeners.add(taskListener);
    }

    public void removeTaskListener(TaskListener taskListener){
        if(listeners == null){
            return;
        }
        listeners.remove(taskListener);
    }

    public void fireTaskCreate(){
        if(listeners == null){
            return ;
        }
        TaskEvent event = new TaskEvent(this,TaskEventType.CREATE);
        notifyListeners(event);

    }
    public void fireTaskComplete(){
        if(listeners == null){
            return ;
        }
        TaskEvent event = new TaskEvent(this,TaskEventType.COMPELETE);
        notifyListeners(event);

    }

    public void fireTaskCancel(){
        if(listeners == null){
            return ;
        }
        TaskEvent event = new TaskEvent(this,TaskEventType.CANCEL);
        notifyListeners(event);

    }

    public void notifyListeners(TaskEvent event){
        Iterator iterator = listeners.iterator();
        while(iterator.hasNext()){
            TaskListener taskListener = (TaskListener) iterator.next();

            //TODO
            //监听者处理耗时任务（异步处理）
            taskListener.doEvent(event);
        }
    }



}
