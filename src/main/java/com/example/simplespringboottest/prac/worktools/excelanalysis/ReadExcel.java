package com.example.simplespringboottest.prac.worktools.excelanalysis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ ClassName: ReadExcel
 * @Author: legen
 * @Date: 2021/4/19
 */
public class ReadExcel {
    /**
     * POI 读取高版本Excel文件
     *
     * @author yangtingting
     * @date 2019/07/29
     */
    public static void main(String[] args) throws Exception {
        //创建Excel，读取文件内容
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new FileInputStream(new File("C:\\Users\\legen\\Desktop\\网点.xls")));
        } catch (Exception e) {
            workbook = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\legen\\Desktop\\网点.xls")));
        }
        //两种方式读取工作表
        //根据名字读取sheet
        // Sheet sheet=workbook.getSheet("Sheet0");
        //读取第几个sheet
        Sheet sheet = workbook.getSheetAt(0);
        //获取sheet中最后一行行号
        int lastRowNum = sheet.getLastRowNum();
        //创建文件夹
        File f = new File("C:\\Users\\legen\\Desktop\\xuemeng");
        if (!f.exists()) {
            f.mkdir();
        }
        List<BasicData> list = new ArrayList<>();
        Map<Map<Integer, Integer>, String> map = new IdentityHashMap<>();
        for (int i = 0; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (null == row) {
                continue;
            }
            // 获取当前行最后单元格列号
            int lastCellNum = row.getLastCellNum();
            // 为每个元素加索引
            for (int j = 0; j < lastCellNum; j++) {
                // 1.对空cell进行处理
                Cell cell = row.getCell(j);
                if (null == cell) {
                    Cell cell1 = row.createCell(j, CellType.STRING);
                    cell1.setCellValue("");
                    cell = cell1;
                }
              /*  // 2.部分字段类型转换为数字会有问题,此类元素不能加入集合
                try{
                    cell.getNumericCellValue();
                }catch (Exception e){
                    // 如果发生异常，表明当前cell中元素不是数字，
                    continue;
                }*/
                // 3.正式执行流程
                cell.setCellType(CellType.STRING);
                // value是第i行第j个元素
                String value = cell.getStringCellValue();
                // todo
                BasicData basicData = new BasicData(i, j, value);
                list.add(basicData);
                HashMap<Integer, Integer> m = new HashMap<>();
                m.put(j, i);
                map.put(m, value);
            }
        }

        List<String> codeList = new ArrayList<>();
        // 分组为map,获取每列的数据
        XSSFWorkbook xssfWorkbook = null;
        Map<Integer, List<BasicData>> listMap = list.stream().collect(Collectors.groupingBy(BasicData::getColumn));


        for (List<BasicData> element : listMap.values()) {
            codeList.clear();
            System.out.println(element);
            List<BasicData> copyElement = new ArrayList<>();
            copyElement.addAll(element);
            element.remove(0);
            for (int i = 0; i < element.size(); i++) {
                if (StringUtils.isNotBlank(element.get(i).getData())) {
                    codeList.add(element.get(i).getData());
                }
            }
            //发起http请求
            Map<String, String> param = new HashMap<>();
            param.put("psd", "hr-center");
            param.put("cmdType", "r");
            // 拼接sql
            String codeListStr = codeList.toString();
            String r1 = codeListStr.replace("[", "(");
            String conditions = r1.replace("]", ")");
            param.put("cmdLine", "select emp_code,case w_qulality when 1 then '分部' when 2 then '服务部' when 3 then '网点' else '无' end as w_qulality_cn from pc_employee_job_info a left join pc_organization_dot_info b on a.cp_code=b.w_code where emp_code in" + conditions);
            String s = HttpClientUtil.doPost("http://hrcenter.yundasys.com:32558/galaxySync/operation", param);
            //要转成utf-8
            s = new String(s.getBytes(), "UTF-8");
            // 解析响应,获取data数据,
            JSONObject jsonObject = JSON.parseObject(s);
            String objectString = jsonObject.getString("data");
            List<ResultData> data = (List<ResultData>) JSONObject.parse(objectString);
            if (ObjectUtils.isNotEmpty(data)) {
                System.out.println(data.toString());
            }
            // 将数据写入excel
            xssfWorkbook = new XSSFWorkbook();
            Sheet sheetAt = xssfWorkbook.createSheet("sheet1");
            //创建第一行
            Row row = sheet.createRow(0);
            String[] title = {"empCode", "dept"};
            Cell cell = null;
            for (int i = 0; i < title.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(title[i]);
            }

            JSONArray array = JSONObject.parseArray(data.toString());
            List<ResultData> resultDatalist = JSONObject.parseArray(array.toJSONString(), ResultData.class);
            for (int i = 0; i < resultDatalist.size(); i++) {
                // 解析响应,获取data数据,
                row = sheetAt.createRow(i);
                Cell codeCell = row.createCell(0, CellType.STRING);
                codeCell.setCellValue(String.valueOf(resultDatalist.get(i).getEmp_code()));
                Cell deptCell = row.createCell(1, CellType.STRING);
                deptCell.setCellValue(resultDatalist.get(i).getW_qulality_cn());
            }
            // 写入到指定的excel
            System.out.println(copyElement.get(0).getData().trim());
            if (StringUtils.isBlank(copyElement.get(0).getData())) {
                break;
            }
            File file = new File("C:\\Users\\legen\\Desktop\\xuemeng\\" + copyElement.get(0).getData().trim() + ".xls");
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            FileOutputStream stream = new FileOutputStream(file);
            xssfWorkbook.write(stream);
            workbook.close();
        }
        xssfWorkbook.close();
    }


}
