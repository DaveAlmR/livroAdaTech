package com.projetinho.livrinho.controller;

import com.projetinho.livrinho.services.IBaseService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class GenericController<T, S extends IBaseService> {
    @Autowired
    S service;
    protected Logger logger;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            var objects = service.getAll();

            return ResponseEntity
                    .ok()
                    .body(objects);
        } catch (Exception e) {
            if (logger != null) {
                var stackTrace = ExceptionUtils.getStackTrace(e);
                logger.warn(stackTrace);
            }

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getAll(@PathVariable Long id) {
        try {
            var object = service.find(id);

            return ResponseEntity
                    .ok()
                    .body(object);
        } catch (Exception e) {
            if (logger != null) {
                var stackTrace = ExceptionUtils.getStackTrace(e);
                logger.warn(stackTrace);
            }

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody T object) {
        try {
            service.create(object);

            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e) {
            if (logger != null) {
                var stackTrace = ExceptionUtils.getStackTrace(e);
                logger.warn(stackTrace);
            }

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody T object) {
        try {
            service.update(id, object);

            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e) {
            if (logger != null) {
                var stackTrace = ExceptionUtils.getStackTrace(e);
                logger.warn(stackTrace);
            }

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            service.delete(id);

            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e) {
            if (logger != null) {
                var stackTrace = ExceptionUtils.getStackTrace(e);
                logger.warn(stackTrace);
            }

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
