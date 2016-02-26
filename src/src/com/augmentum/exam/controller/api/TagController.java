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
import com.augmentum.exam.dto.TagDTO;
import com.augmentum.exam.service.TagService;

@Controller("apiTagController")
@RequestMapping("/api/tag")
public class TagController extends BaseController {

    @Resource
    private TagService tagService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody TagDTO tagDTO) throws ValidationException {
        int tagId = tagService.add(tagDTO);
        return JsonMessage.ok(tagId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = tagService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody TagDTO tagDTO) throws ValidationException {
        boolean result = tagService.update(tagDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        TagDTO result = tagService.getById(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry findAll() {
        List<TagDTO> result = tagService.findAll();
        return JsonMessage.ok(result);
    }
}
