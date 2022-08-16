package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.exceptions.EventNotFoundException;
import com.firstownproject.FirstProject.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ResourceNotFoundAdvice {

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView onResourceNotFound(ResourceNotFoundException rnfa) {
        ModelAndView modelAndView = new ModelAndView("object-not-found");
        modelAndView.addObject("objectId", rnfa.getObjectId());

        return modelAndView;
    }
}
