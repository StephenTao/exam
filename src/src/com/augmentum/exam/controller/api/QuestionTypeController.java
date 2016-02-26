package com.augmentum.exam.controller.api;

import java.util.List;

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
import com.augmentum.exam.dto.QuestionTypeDTO;
import com.augmentum.exam.service.QuestionTypeService;

@Controller("apiQuestionTypeController")
@RequestMapping("/api/question/type")
public class QuestionTypeController extends BaseController {

    @Resource
    private QuestionTypeService questionTypeService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody QuestionTypeDTO questionTypeDTO) throws ValidationException {
        int questionTypeId = questionTypeService.add(questionTypeDTO);
        return JsonMessage.ok(questionTypeId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = questionTypeService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody QuestionTypeDTO questionTypeDTO) throws ValidationException {
        boolean result = questionTypeService.update(questionTypeDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        QuestionTypeDTO result = questionTypeService.getById(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry findTypes() {
        List<QuestionTypeDTO> result = questionTypeService.findAll();
        return JsonMessage.ok(result);
    }

}
