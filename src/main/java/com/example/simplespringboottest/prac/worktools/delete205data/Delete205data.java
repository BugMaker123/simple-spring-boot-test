package com.example.simplespringboottest.prac.worktools.delete205data;

import com.example.simplespringboottest.prac.worktools.excelanalysis.BasicData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ ClassName: Delete205data
 * @Author: legen
 * @Date: 2021/6/4
 */
public class Delete205data {
    public static void main(String[] args) throws Exception {
        //创建Excel，读取文件内容
        Workbook workbook=new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\legen\\Desktop\\删除205账号","result2.xlsx")));
        //两种方式读取工作表
        //根据名字读取sheet
        // Sheet sheet=workbook.getSheet("Sheet0");
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\legen\\Desktop\\删除205账号", "error-log.txt"),true);
        //读取第几个sheet
        int count = workbook.getNumberOfSheets();
        for (int m = 0; m < count; m++) {
            Sheet sheet = workbook.getSheetAt(m);
            //获取sheet中最后一行行号
            int lastRowNum = sheet.getLastRowNum();
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

                    if (j == 1) {
                        String value = cell.getStringCellValue();
                        // todo
                        BasicData basicData = new BasicData(i, j, value);
                        list.add(basicData);
                        HashMap<Integer, Integer> hashMap = new HashMap<>();
                        hashMap.put(j, i);
                        map.put(hashMap, value);
                    }
                }
            }
            // 分组为map,获取每列的数据
            Map<Integer, List<BasicData>> listMap = list.stream().collect(Collectors.groupingBy(BasicData::getColumn));
          /*  for (Integer key : listMap.keySet()) {
                System.out.println(key + "===" + listMap.get(key));
            }*/
            // emp_code
            List<BasicData> empCodeList = listMap.get(1);
            empCodeList.remove(0);
            //发起http请求
            Map<String, String> param = new HashMap<>();
            param.put("psd", "hr-center");
            param.put("cmdType", "r");
            // 拼接sql
            List<String> integerArrayList = new ArrayList<>();
            List<String> cpCodeList = new ArrayList<>();
            for (int i = 0; i < empCodeList.size(); i++) {
                integerArrayList.add(empCodeList.get(i).getData());
                if (empCodeList.get(i).getData().length()<=6){
                    System.out.println(empCodeList.get(i).getData());
                }
                cpCodeList.add(empCodeList.get(i).getData().substring(0,6));
            }
            // hr-center
            String codeListStr = integerArrayList.toString();
            String r1 = codeListStr.replace("[", "(");
            String conditions = r1.replace("]", ")");
            System.out.println("=========================================================================================");
            System.out.println("update pc_employee_job_info set working_state=2 where emp_code in " + conditions);
            System.out.println("=========================================================================================");
            // ywy
/*            String cpCodeListStr = cpCodeList.toString();
            String head = cpCodeListStr.replace("[", "(");
            String end = head.replace("]", ")");*/

            String ids = cpCodeList.stream().map(s -> "\'" + s + "\'").collect(Collectors.joining(", "));
            System.out.println("update ywy set ywyzt=0 where bm='205' and gs in (" + ids+")");




            /*String s = HttpClientUtil.doPost("http://hrcenter.yundasys.com:32558/galaxySync/operation", param);
            //要转成utf-8
            s = new String(s.getBytes(), "UTF-8");
            // 解析响应,获取data数据,
            JSONObject jsonObject = JSON.parseObject(s);
            String objectString = jsonObject.getString("data");
            List<Integer> data = (List<Integer>) JSONObject.parse(objectString);
            if (ObjectUtils.isNotEmpty(data)) {
                System.out.println(data.toString());
            }*/
          /*  ArrayList<Integer> idList = new ArrayList<>();
            idList.add(27152);
            idList.add(27153);
            idList.add(27154);
            idList.add(27155);
            idList.add(27156);
            for (int i = 0; i < idList.size(); i++) {
                try {
                    PcEmployeeJobInfoDTO pcEmployeeJobInfoDTO = new PcEmployeeJobInfoDTO();
                    pcEmployeeJobInfoDTO.setId(idList.get(i));
                    pcEmployeeJobInfoDTO.setUpdateTime(System.currentTimeMillis());
                    pcEmployeeJobInfoDTO.setLeavingDate(System.currentTimeMillis());
                    pcEmployeeJobInfoDTO.setUpdateUser("dyh");
                    pcEmployeeJobInfoDTO.setUpdateUserCode("98092854");
                    String jsonString = JSONObject.toJSONString(pcEmployeeJobInfoDTO);
                    // request the interface of hr-center
                    String res = HttpClientUtil.doPostJson("http://hrcenter.yundasys.com:32558/employee/empResign",jsonString);
                    // 解析响应,获取data数据,
                    JSONObject jsonData = JSON.parseObject(res);
                    String resCode = jsonData.getString("code");
                    // record the error log info
                    if (!resCode.equals("200")){
                        String resData = jsonData.getString("data");
                        resData = idList.get(i)+"==============="+resData+"/r/n";
                        fos.write(resData.getBytes(StandardCharsets.UTF_8));
                    }
                }catch (Exception e){
                    // record the exception info
                    String exceptionInfo = e.getMessage();
                    exceptionInfo = idList.get(i)+"==============="+exceptionInfo+"/n";
                    fos.write(exceptionInfo.getBytes(StandardCharsets.UTF_8));
                }
            }
        }*/

        }
        fos.close();
        workbook.close();
    }
}
