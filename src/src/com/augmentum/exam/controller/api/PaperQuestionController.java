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
import com.augmentum.exam.dto.PaperQuestionDTO;
import com.augmentum.exam.service.PaperQuestionService;

@Controller("apiPaperQuestionController")
@RequestMapping("/api/paper/question")
public class PaperQuestionController extends BaseController {

    @Resource
    private PaperQuestionService paperQuestionService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody PaperQuestionDTO paperQuestionDTO) throws ValidationException {
        int paperQuestionId = paperQuestionService.add(paperQuestionDTO);
        return JsonMessage.ok(paperQuestionId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = paperQuestionService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody PaperQuestionDTO paperQuestionDTO) throws ValidationException {
        boolean result = paperQuestionService.update(paperQuestionDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        PaperQuestionDTO result = paperQuestionService.getById(id);
        return JsonMessage.ok(result);
    }

}
