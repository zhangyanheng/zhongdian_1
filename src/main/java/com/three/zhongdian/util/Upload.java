package com.three.zhongdian.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @action 文件上传工具类
 * @user 白雪杰
 * @date 2017年6月26日
 */
public class Upload {
	/*
	 * 上传的方法
	 */
	public static String getUpload(HttpServletRequest request,
			MultipartFile file) throws Exception {
		if (file.getOriginalFilename().length() > 0) {
			String fileName =   Uid.getUuid()
					+ file.getOriginalFilename();
			System.out.println(fileName);
			File files = new File("D://image//" + fileName);
			file.transferTo(files);
			return fileName;
		}
		return null;
	}
}
