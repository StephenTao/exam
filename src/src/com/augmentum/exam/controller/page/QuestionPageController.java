package com.augmentum.exam.controller.page;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.Constants;
import com.augmentum.exam.base.BaseController;
import com.augmentum.exam.base.JsonMessage;
import com.augmentum.exam.base.JsonMessage.MessageEntry;
import com.augmentum.exam.dto.QuestionDTO;
import com.augmentum.exam.service.QuestionService;

@Controller("questionController")
@RequestMapping("/page/question")
public class QuestionPageController extends BaseController {

    @Resource
    private QuestionService questionService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody QuestionDTO questionDTO) throws ValidationException {
        try {
            questionService.add(questionDTO);
            return JsonMessage.ok(Constants.SUCCESSFUL);
        } catch (ValidationException e) {
            return JsonMessage.error(500, e.getFieldErrors());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = questionService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody QuestionDTO questionDTO) throws ValidationException {
        boolean result = questionService.update(questionDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        QuestionDTO result = questionService.getById(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/create-question", method = RequestMethod.GET)
    public ModelAndView createQuestion() {
        ModelAndView view = new ModelAndView();
        view.setViewName(Constants.CREATE_QUESTION_PAGE);
        return view;
    }

    @RequestMapping(value = "/myquestion", method = RequestMethod.GET)
    public ModelAndView myQuestion() {
        ModelAndView view = new ModelAndView();
        view.setViewName(Constants.MY_QUESTION_PAGE);
        return view;
    }

    @RequestMapping(value = "/question-list", method = RequestMethod.GET)
    public ModelAndView questionList() {
        ModelAndView view = new ModelAndView();
        view.setViewName(Constants.QUESTION_LIST_PAGE);
        return view;
    }
}
