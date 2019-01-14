package com.brs.oa.vofield.controller;


import com.brs.oa.comm.model.RestfulResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
@RestController
@Api("页面视图数据字段管理")
public class VoFieldController {

    /**
     * 查看指定视图数据字段
     * @param voName
     * @return
     */
    @ApiOperation(value ="查看指定视图数据字段")
    @ApiImplicitParam(paramType = "query", name = "voName", value = "视图数据模型名称", dataType = "String",required = true)
    @GetMapping("/api/voFields/{voName}")
    public RestfulResult  searchVoField(@PathVariable("voName") String voName){
        return new RestfulResult(200,"查看指定视图字段！",null );
    }
}
