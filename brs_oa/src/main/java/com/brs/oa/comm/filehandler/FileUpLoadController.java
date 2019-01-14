package com.brs.oa.comm.filehandler;

import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.staff.service.IStaffService;
import com.brs.oa.util.CommonUtil;
import com.brs.oa.util.FileUtil;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tiny lin
 * @date 2019/1/7
 */
@CrossOrigin
@RestController
@Api
public class FileUpLoadController {
    @Value("${fileservice.upload-file-dir}")
    private String uploadFileDir;

    @Autowired
    private IStaffService staffService;

    @PostMapping("/api/uploadImage")
    public RestfulResult uploadImage(@RequestHeader("Authorization") String token, @RequestParam("file")MultipartFile file, HttpServletRequest request){
        int empNo = JwtSupport.getEmployeeNo(token);
        String contentType = file.getContentType();
        String  fileName = file.getOriginalFilename();
        System.out.println("upload dir ===============>"+uploadFileDir);
        try {
            FileUtil.uploadFile(file.getBytes(), uploadFileDir, fileName);
            staffService.updateStaffHeaderImg(empNo,uploadFileDir );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  new RestfulResult(200,"上传图片成功","" );
    }
}
