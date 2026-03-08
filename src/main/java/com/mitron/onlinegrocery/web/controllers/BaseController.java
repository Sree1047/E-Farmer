package com.mitron.onlinegrocery.web.controllers;

import static com.mitron.onlinegrocery.util.constants.AppConstants.*;

import org.springframework.web.servlet.ModelAndView;


public abstract class BaseController {
    protected ModelAndView view(String view, ModelAndView modelAndView) {
        modelAndView.setViewName(view);

        return modelAndView;
    }

    protected ModelAndView view(String view) {
        return this.view(view, new ModelAndView());
    }

    protected ModelAndView redirect(String url){
        return this.view(REDIRECT_BASE_CONTROLLER + url);
    }
}
