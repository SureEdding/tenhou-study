package org.suree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.suree.domain.TaiKyokuTable;
import org.suree.mappers.TaiKyokuTableMapper;
import org.suree.model.Request;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sure on 12/11/2016.
 */



@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    private TaiKyokuTableMapper taiKyokuTableMapper;

    @RequestMapping(value = "/api/{convId}", method = RequestMethod.GET)
    public Map<String, Object> testApi(@RequestParam(name = "name", required = true)String name,
                                       @PathVariable(value = "convId")Integer convId) {
        Map results = new HashMap();

        TaiKyokuTable taiKyokuTable = taiKyokuTableMapper.selectByPrimaryKey(1);

        results.put("results", taiKyokuTable);

        return results;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Map<String, Object> testPost(@RequestBody Request request, HttpServletRequest servletRequestrequest) {
        Map results = new HashMap();
        results.put("name", request);
        return results;
    }

}
