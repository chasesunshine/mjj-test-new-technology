package org.wanbang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.entity.operationcenter.*;

import javax.validation.Valid;

import java.util.List;

import static org.wanbang.constants.OperationApiConstants.*;

/**
 * 说明书管理相关接口管理Controller
 *
 * @author majiajian
 * @date 2024/7/10 10:33
 */
@Api(tags = "说明书管理-测试")
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/swaggerTest1111")
public class SpecificationManageNewController{
    /**
     * 说明书管理列表
     *
     * @param specificationManageListDTO
     * @return
     */
    @PostMapping(value = OPERATION_API_SPECIFICATION_MANAGE_LIST)
    @ResponseBody
    @ApiOperation(value = "说明书管理列表", notes = "说明书管理列表")
    public SpecificationManageListVO getSpecificationManageList(@Valid @RequestBody SpecificationManageListDTO specificationManageListDTO) {
        return null;
    }

    /**
     * 说明书新增
     *
     * @param specificationManageAddDTO
     * @return
     */
    @PostMapping(value = OPERATION_API_SPECIFICATION_MANAGE_ADD)
    @ResponseBody
    @ApiOperation(value = "说明书新增", notes = "说明书新增")
    public Integer specificationManageAdd(@RequestBody SpecificationManageAddDTO specificationManageAddDTO, @RequestParam(value = "file", required = false) MultipartFile file) {
        return null;
    }

    /**
     * 说明书编辑
     *
     * @param specificationManageEditDTO
     * @return
     */
    @PostMapping(value = OPERATION_API_SPECIFICATION_MANAGE_EDIT)
    @ResponseBody
    @ApiOperation(value = "说明书编辑", notes = "说明书编辑")
    public Integer specificationManageEdit(@RequestBody SpecificationManageEditDTO specificationManageEditDTO, @RequestParam(value = "file", required = false) MultipartFile file) {
        return null;
    }

    /**
     * 说明书删除
     *
     * @param ids
     * @return
     */
    @PostMapping(value = OPERATION_API_SPECIFICATION_MANAGE_DELETE)
    @ApiOperation(value = "说明书删除/说明书产品模块删除", notes = "说明书删除/说明书产品模块删除")
    public Integer specificationManageDelete(@PathVariable("ids") Long[] ids) {
        return null;
    }

    /**
     * 说明书发布(生成二维码)/撤销发布
     *
     * @param specificationManagIfPublishDTO
     * @return
     */
    @PostMapping(value = "/specification/manage/publish/unPublish")
    @ApiOperation(value = "说明书发布(生成二维码)/撤销发布", notes = "说明书发布(生成二维码)/撤销发布")
    public Integer specificationManagePublishOrUnPublish(@RequestBody SpecificationManagIfPublishDTO specificationManagIfPublishDTO) {
        return null;
    }

    /**
     * 说明书累进
     *
     * @return
     */
    @PostMapping(value = "/specification/manage/publish/progression")
    @ApiOperation(value = "说明书累进", notes = "说明书累进")
    public Integer specificationManageProgression(@RequestBody SpecificationManageProgressionDTO specificationManageProgressionDTO, @RequestParam(value = "file", required = false) MultipartFile file) {
        return null;
    }

    /**
     * 说明书二维码下载
     *
     * @param figureNum
     * @return
     */
    @GetMapping(value = "specification/manage/code/download")
    @ApiOperation(value = "说明书二维码下载", notes = "说明书二维码下载")
    public SpecificationManageCodeDownLoadVO specificationManageCodeDownLoad(@RequestParam("figureNum") String figureNum) {
        return null;
    }

    /**
     * 说明书累进展示
     *
     * @param figureNum
     * @return
     */
    @GetMapping(value = "specification/manage/progression/query")
    @ResponseBody
    @ApiOperation(value = "说明书累进展示", notes = "说明书累进展示")
    public List<SpecificationManageProgressQueryVO> specificationManageProgressQuery(@RequestParam("figureNum") String figureNum) {
        return null;
    }

    /**
     * 使用说明书、安装说明书扫码、程序员手册扫码
     *
     * @param specificationManagScanCodeDTO
     * @return
     */
    @PostMapping(value = "specification/manage/scancode")
    @ResponseBody
    @ApiOperation(value = "使用说明书、安装说明书扫码、程序员手册扫码", notes = "使用说明书、安装说明书扫码、程序员手册扫码")
    public SpecificationManagScanCodeVO specificationManageScanCode(@RequestBody SpecificationManagScanCodeDTO specificationManagScanCodeDTO) {
        return null;
    }
}
