import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;
public class CreateXL {
    /** Excel 文件要存放的位置，假定在F盘下*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            // HSSFSheet sheet = workbook.createSheet("效益指标");
            HSSFSheet sheet = workbook.createSheet();
            // 在索引0的位置创建行（最顶端的行）
            HSSFRow row = sheet.createRow((short)0);	//创建第一行
            //在索引0的位置创建单元格（左上端）
            HSSFCell cell0 = row.createCell((short)0);	//列，由第一行创建的第一个单元格
			HSSFCell cell1 = row.createCell((short)1);	//列，由第一行创建的第二个单元格
			  // 在单元格中输入一些内容
            cell0.setCellValue("科目");
			cell1.setCellValue("成绩");
			
			
			//创建第二行
			HSSFRow row1 = sheet.createRow((short)1);		//创建第二行
			HSSFCell cell2 = row1.createCell((short)0);		//列，由第二行创建的第一个单元格
			HSSFCell cell3 = row1.createCell((short)1);		//列，由第二行创建的第二个单元格
			 // 在单元格中输入一些内容
            cell2.setCellValue("高等代数");
			cell3.setCellValue("90");
			
			
			//创建第三行
			HSSFRow row2 = sheet.createRow((short)2);		//创建第三行
			HSSFCell cell4 = row2.createCell((short)0);		//列，由第三行创建的第一个单元格
			HSSFCell cell5 = row2.createCell((short)1);		//列，由第三行创建的第二个单元格
			 // 在单元格中输入一些内容
            cell4.setCellValue("数学分析");
			cell5.setCellValue("90");
			
			
			//创建第四行
			HSSFRow row3 = sheet.createRow((short)3);		//创建第四行
			HSSFCell cell6 = row3.createCell((short)0);		//列，由第四行创建的第一个单元格
			HSSFCell cell7 = row3.createCell((short)1);		//列，由第四行创建的第二个单元格
			 // 在单元格中输入一些内容
            cell6.setCellValue("解析几何");
			cell7.setCellValue("90");
			
			
			
			
			
			
            

            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
}