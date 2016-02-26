package com.augmentum.exam.controller.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseController;
import com.augmentum.exam.base.JsonMessage;
import com.augmentum.exam.base.JsonMessage.MessageEntry;
import com.augmentum.exam.dto.QuestionCopyDTO;
import com.augmentum.exam.service.QuestionCopyService;

@Controller("apiQuestionCopyController")
@RequestMapping("/api/questioncopy")
public class QuestionCopyController extends BaseController {

    @Resource
    private QuestionCopyService questionCopyService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody QuestionCopyDTO questionCopyDTO) throws ValidationException {
        int questionCopyId = questionCopyService.add(questionCopyDTO);
        return JsonMessage.ok(questionCopyId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = questionCopyService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody QuestionCopyDTO questionCopyDTO) throws ValidationException {
        boolean result = questionCopyService.update(questionCopyDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        QuestionCopyDTO result = questionCopyService.getById(id);
        return JsonMessage.ok(result);
    }
}
