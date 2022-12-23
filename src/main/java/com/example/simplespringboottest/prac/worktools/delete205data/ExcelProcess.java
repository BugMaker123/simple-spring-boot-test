package com.example.simplespringboottest.prac.worktools.delete205data;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelProcess {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        String path = "C:\\Users\\legen\\Desktop\\test20211107";
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        for (int i = 0; i < 10; i++) {
            String fileName = i+".xls";
            File f = new File(path, fileName);
            if (!f.exists()){
                f.createNewFile();
            }
        }
        File f = new File(path, "result.xls");
        if (!f.exists()){
            file.createNewFile();
        }
        FileInputStream targetFile = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook(targetFile);
        Sheet sheet=workbook.getSheet("Sheet0");
        int rowNum = sheet.getLastRowNum();
        File filepath = new File(path);
        File[] files = filepath.listFiles();
        for (int i = 0; i < files.length; i++) {
            FileInputStream fis = new FileInputStream(files[i]);
            XSSFWorkbook workbookSource = new XSSFWorkbook(files[i]);
            XSSFSheet xssfSheet = workbookSource.getSheet("Sheet0");
            int lastRowNum = xssfSheet.getLastRowNum();
            for (int j = 0; j < lastRowNum; j++) {
                Row row = sheet.getRow(j);

            }
        }

       /* //创建Excel，读取文件内容
        Workbook workbook = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\legen\\Desktop", "result2.xlsx")));
        //两种方式读取工作表
        //根据名字读取sheet
        // Sheet sheet=workbook.getSheet("Sheet0");
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\legen\\Desktop\\删除205账号", "error-log.txt"), true);
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
              *//*  // 2.部分字段类型转换为数字会有问题,此类元素不能加入集合
                try{
                    cell.getNumericCellValue();
                }catch (Exception e){
                    // 如果发生异常，表明当前cell中元素不是数字，
                    continue;
                }*//*
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
            // emp_code
            List<BasicData> empCodeList = listMap.get(1);
            empCodeList.remove(0);

            // 拼接sql
            List<String> integerArrayList = new ArrayList<>();
            List<String> cpCodeList = new ArrayList<>();
            for (int i = 0; i < empCodeList.size(); i++) {
                integerArrayList.add(empCodeList.get(i).getData());
                if (empCodeList.get(i).getData().length() <= 6) {
                    System.out.println(empCodeList.get(i).getData());
                }
                cpCodeList.add(empCodeList.get(i).getData().substring(0, 6));
            }
            fos.close();
            workbook.close();
        }*/
    }
}