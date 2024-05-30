package com.viniciusmdc.ExemploPatternSingleton.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThreadManager {

    private static ThreadManager instance = new ThreadManager();

    public static ThreadManager getInstance(){
        if(instance == null){
            instance = new ThreadManager();
        }
        return instance;
    }

    private final List<BaseThread> threads = new ArrayList<>();

    public BaseThread getThread(Class<? extends BaseThread> type){
        Optional<BaseThread> t = threads.stream().filter(i -> i.getClass().getName().equals(type.getName())).findFirst();
        if(t.isPresent()){
            if(t.get().getState() == Thread.State.TERMINATED){
                threads.remove(t.get());
                return getBaseThread(type);
            } else{
                return t.get();
            }
        }else{
            return getBaseThread(type);
        }
    }

    private BaseThread getBaseThread(Class<? extends BaseThread> type) {
        try {
            BaseThread createdThread = (BaseThread) Class.forName(type.getName()).getConstructor().newInstance();
            threads.add(createdThread);
            return createdThread;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
