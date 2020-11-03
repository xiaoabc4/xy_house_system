package com.xy.controller;

import com.xy.entity.MyEmp;
import com.xy.service.MyempService;
import com.xy.utils.JacksonUtils;
import com.xy.utils.MySession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 修改密码
 */
@WebServlet("/editpsw")
public class Editpsw extends SystemBaseController{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);

    }

}
