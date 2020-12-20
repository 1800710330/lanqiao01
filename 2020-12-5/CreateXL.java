import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;
public class CreateXL {
    /** Excel 文件要存放的位置，假定在F盘下*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {
			try{
				String scores[][] = {					//定义二维数组
				{"科目","成绩"},{"高等代数","90"},{"数学分析","90"},{"解析几何","90"}
			};
				 
            HSSFWorkbook workbook = new HSSFWorkbook();		 // 创建新的Excel 工作簿
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"学生成绩"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet("学生成绩");
				     // 在索引0的位置创建行（最顶端的行）
			for(int i = 0;i < scores.length;i++){
				HSSFRow row = sheet.createRow((short)i);	//创建行
				for(int j = 0;j < scores[i].length;j++){
					HSSFCell cell = row.createCell((short)j);	//创建列
					cell.setCellValue(scores[i][j]);		//列值
				}
				
			}	
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