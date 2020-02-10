package com.dyw.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    /**
     * 跨服务器文件上传:需要导入sun公司提供的jersey相关jar包
     * @param upload  此变量名必须与前端表单里面的file项的name值一致
     * @return
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload, String name, Integer age) throws IOException {
        //定义文件上传服务器路径
        String path = "http://localhost:9090/";

        //文件名称
        String fileName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //创建客户端对象
        Client client = Client.create();
        WebResource resource = client.resource(path + fileName);//跟图片服务器连接

        //上传图片
        resource.put(upload.getBytes());

        System.out.println("上传成功" + name + " " + age);
        return "success";
    }

    /**
     * SpringMVC的方式上传：需要在springmvc.xml中新建文件解析器
     * @param upload  此变量名必须与前端表单里面的file项的name值一致
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request,
                              MultipartFile upload, String name, Integer age) {
        //设置文件上传目录
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        try {
            upload.transferTo(Paths.get(realPath, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("上传成功" + name + " " + age);
        return "success";
    }

    /**
     * 文件上传(传统方式使用commons-fileupload包)
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws FileUploadException {
        System.out.println("fileUpload1 执行了...");
        //使用fileupload组件完成文件上传
        //上传文件的目标路径
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        if (!FileUtils.getFile(realPath).exists()) {
            try {
                Files.createDirectory(Paths.get(realPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //解析request对象，获取上传文件项
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        //开始解析
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                //一般的表单字段
                String fieldName = fileItem.getFieldName();
                String value = fileItem.getString();
                System.out.println("字段：" + fieldName + " 值：" + value);
//                fileItem.get
            } else {
                // 文件项
                String fileName = fileItem.getName(); //文件名称
                String uuid = UUID.randomUUID().toString().replace("-", ""); //保证上传文件名称唯一性
                fileName = uuid + "_" + fileName;
                try {
                    fileItem.write(new File(realPath, fileName)); //文件写入目标路径
                    fileItem.delete(); //删除缓存文件
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }


}
