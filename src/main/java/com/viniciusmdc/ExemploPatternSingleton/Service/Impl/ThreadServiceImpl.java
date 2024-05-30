package com.viniciusmdc.ExemploPatternSingleton.Service.Impl;

import com.viniciusmdc.ExemploPatternSingleton.Enum.ThreadEnum;
import com.viniciusmdc.ExemploPatternSingleton.Service.ThreadService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ThreadServiceImpl implements ThreadService {

    @Override
    public void start(String id) {
        try {
            Thread t = ThreadEnum.fromId(id).getBaseThread();
            if (t.isAlive()) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Thread já está em execução!");
            }
            t.start();
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Thread não encontrada.");
        }
    }

    @Override
    public void stop(String id) {
        try {
            Thread t = ThreadEnum.fromId(id).getBaseThread();
            if (isRunning(t)) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Thread não está em execução no momento!");
            }
            t.interrupt();
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Thread não encontrada.");
        }
    }

    private boolean isRunning(Thread t) {
        return !t.isAlive() || t.getState() == Thread.State.TERMINATED;
    }
}
