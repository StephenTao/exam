package com.augmentum.exam.controller.page;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.EContext;
import com.augmentum.exam.base.BaseController;
import com.augmentum.exam.base.JsonMessage;
import com.augmentum.exam.base.JsonMessage.MessageEntry;
import com.augmentum.exam.dto.ResourceDTO;
import com.augmentum.exam.service.QuestionService;
import com.augmentum.exam.service.ResourceService;

@Controller("uploadController")
@RequestMapping("page/upload")
public class UploadPageController extends BaseController {
    @Autowired
    private HttpServletRequest request;
    @Resource
    private QuestionService questionService;
    @Resource
    private ResourceService resourceService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry upload(@RequestParam("file") MultipartFile file) {
        String basePath = request.getSession().getServletContext().getRealPath("/resource") + File.separator;
        String fileName = getResourceFileName(basePath, file.getOriginalFilename());
        try {
            uploadFile(file, basePath + fileName);
            int userId = EContext.getContext().getUserId();
            ResourceDTO resourceDTO = new ResourceDTO();
            resourceDTO.setUserId(userId);
            resourceDTO.setUrl(fileName);
            resourceService.add(resourceDTO);
            return JsonMessage.ok(fileName);
        } catch (ValidationException e) {
            return JsonMessage.error(e.toString());
        } catch (IllegalStateException | IOException e) {
            return JsonMessage.error(e.toString());
        }
    }
}
