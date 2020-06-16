package com.project.foodshoot.controller;

import com.project.foodshoot.entity.Recipe;
import com.project.foodshoot.service.RecipeService;
import io.swagger.annotations.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@Api(value="食谱相关业务的接口", tags= {"食谱相关业务的controller"})
@RequestMapping(value = "/recipe")

public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @ApiOperation(value="添加食谱", notes="添加食谱的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="publisherId", value="用户id", required=true,
                    dataType="int", paramType="form"),
            @ApiImplicitParam(name="title", value="标题", required=true,
                    dataType="String", paramType="form"),
            @ApiImplicitParam(name="description", value="文字描述", required=true,
                    dataType="String", paramType="form"),
            @ApiImplicitParam(name="if_recipe", value="是否食谱", required=true,
                    dataType="bollean", paramType="form")
    })
    @PostMapping(value="/insert", headers="content-type=multipart/form-data")
    public String insertRecipe(int publisherId, String title, String description, boolean if_recipe,
                                       @ApiParam(value="图片", required=true)
                                               MultipartFile file) throws Exception {

        // 文件保存的命名空间
        String fileSpace = "/Users/FoodShoot";
        // 保存到数据库中的相对路径
        String uploadPathDB = "/" + publisherId + "/video";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        // 文件上传的最终保存路径
        String finalCoverPath = "";
        try {
            if (file != null) {
                String fileName = file.getOriginalFilename();
                finalCoverPath = fileSpace + uploadPathDB + "/" + fileName;
                // 设置数据库保存的路径
                uploadPathDB += ("/" + fileName);

                File outFile = new File(finalCoverPath);
                if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                    // 创建父文件夹
                    outFile.getParentFile().mkdirs();
                }

                fileOutputStream = new FileOutputStream(outFile);
                inputStream = file.getInputStream();
                IOUtils.copy(inputStream, fileOutputStream);

            } else {
                return "上传出错...";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传出错...";
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        recipeService.insertRecipe(publisherId,title,uploadPathDB,description,0,0,if_recipe);
        return "success";
    }

    //根据recipeId获取食谱
    @GetMapping(value = "/{recipeId}")
    public Recipe getRecipeByRecipeID(@PathVariable int recipeId){
        return recipeService.getRecipeByRecipeId(recipeId);
    }
    //根据userID获取全部食谱
    @GetMapping(value = "/user/{userId}")
    public List<Recipe> getRecipeByUser(@PathVariable int userId){
        return recipeService.getRecipeByUser(userId);
    }
    //随机获取食谱
    @GetMapping(value = "/random")
    public Recipe getRecipeRandomly(){
        return recipeService.getRecipeRandomly();
    }

    @ApiOperation(value="修改食谱", notes="修改食谱的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="publisherId", value="用户id", required=true,
                    dataType="int", paramType="form"),
            @ApiImplicitParam(name="recipeId", value="食谱id", required=true,
                    dataType="int", paramType="form"),
            @ApiImplicitParam(name="title", value="标题", required=true,
                    dataType="String", paramType="form"),
            @ApiImplicitParam(name="description", value="文字描述", required=true,
                    dataType="String", paramType="form")
    })
    @PostMapping(value="/alter", headers="content-type=multipart/form-data")
    public String alterRecipe(int publisherId, int recipeID,String title, String description,
                              @ApiParam(value="图片", required=true)
                                      MultipartFile file) throws Exception {

        // 文件保存的命名空间
        String fileSpace = "/Users/FoodShoot";
        // 保存到数据库中的相对路径
        String uploadPathDB = "/" + publisherId + "/video";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        // 文件上传的最终保存路径
        String finalCoverPath = "";
        try {
            if (file != null) {
                String fileName = file.getOriginalFilename();
                finalCoverPath = fileSpace + uploadPathDB + "/" + fileName;
                // 设置数据库保存的路径
                uploadPathDB += ("/" + fileName);

                File outFile = new File(finalCoverPath);
                if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                    // 创建父文件夹
                    outFile.getParentFile().mkdirs();
                }

                fileOutputStream = new FileOutputStream(outFile);
                inputStream = file.getInputStream();
                IOUtils.copy(inputStream, fileOutputStream);

            } else {
                return "上传出错...";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传出错...";
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        recipeService.alterRecipe(publisherId,recipeID,title,uploadPathDB,description);
        return "success";
    }

    @DeleteMapping(value = "/{recipeId}")
    public void deleteRecipeByRecipeId(@PathVariable int recipeId){
        recipeService.deleteRecipeByRecipeId(recipeId);
    }
}
