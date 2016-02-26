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
import com.augmentum.exam.dto.ExamDTO;
import com.augmentum.exam.service.ExamService;

@Controller("examController")
@RequestMapping("/page/exam")
public class ExamPageController extends BaseController {

    @Resource
    private ExamService examService;

    @RequestMapping(value = "create-exam", method = RequestMethod.GET)
    public ModelAndView createExam() {
        ModelAndView view = new ModelAndView();
        view.setViewName(Constants.CREATE_EXAM_PAGE);
        return view;
    }

    @RequestMapping(value = "exam-list", method = RequestMethod.GET)
    public ModelAndView examList() {
        ModelAndView view = new ModelAndView();
        view.setViewName(Constants.EXAM_LIST_PAGE);
        return view;
    }

    @RequestMapping(value = "myexam", method = RequestMethod.GET)
    public ModelAndView myExam() {
        ModelAndView view = new ModelAndView();
        view.setViewName(Constants.MY_EXAM_PAGE);
        return view;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody ExamDTO examDTO) throws ValidationException {
        int examId = examService.add(examDTO);
        return JsonMessage.ok(examId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = examService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody ExamDTO examDTO) throws ValidationException {
        boolean result = examService.update(examDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        ExamDTO result = examService.getById(id);
        return JsonMessage.ok(result);
    }
}
