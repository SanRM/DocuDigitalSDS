package com.docudigitalsds.model.database.services;

import java.util.List;

import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.CategoriaDao;

import jakarta.servlet.http.HttpServletRequest;

public class AdminService extends DefaultService {

    public AdminService(HttpServletRequest request) {
        super(request);
        getCategoryNameList();
    }

    public void getCategoryNameList() {

        CategoriaDao categoriaDao = new CategoriaDao(connection);
        List<String> categoryNameList = categoriaDao.getCategoryNameList();
        List<Integer> categoryIdList = categoriaDao.getCategoryIdList();

        System.out.println("Category Name List: " + categoryNameList); // Debug code
        System.out.println("Category ID: " + categoryIdList); // Debug code
        request.getSession().setAttribute("categoryList", categoryNameList);
        request.getSession().setAttribute("categoryIdList", categoryIdList);
    }
 
}