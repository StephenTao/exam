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
import com.augmentum.exam.dto.PaperPartDTO;
import com.augmentum.exam.service.PaperPartService;

@Controller("apiPaperPartController")
@RequestMapping("/api/paperpart")
public class PaperPartController extends BaseController {

    @Resource
    private PaperPartService paperPartService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody PaperPartDTO paperPartDTO) throws ValidationException {
        int paperPartId = paperPartService.add(paperPartDTO);
        return JsonMessage.ok(paperPartId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = paperPartService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody PaperPartDTO paperPartDTO) throws ValidationException {
        boolean result = paperPartService.update(paperPartDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        PaperPartDTO paperPartDTO = paperPartService.getById(id);
        return JsonMessage.ok(paperPartDTO);
    }
}
