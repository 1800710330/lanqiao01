import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;
public class CreateXL {
    /** Excel �ļ�Ҫ��ŵ�λ�ã��ٶ���F����*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {
			try{
				String scores[][] = {					//�����ά����
				{"��Ŀ","�ɼ�"},{"�ߵȴ���","90"},{"��ѧ����","90"},{"��������","90"}
			};
				 
            HSSFWorkbook workbook = new HSSFWorkbook();		 // �����µ�Excel ������
            // ��Excel�������н�һ����������Ϊȱʡֵ
            // ��Ҫ�½�һ��Ϊ"ѧ���ɼ�"�Ĺ����������Ϊ��
            HSSFSheet sheet = workbook.createSheet("ѧ���ɼ�");
				     // ������0��λ�ô����У���˵��У�
			for(int i = 0;i < scores.length;i++){
				HSSFRow row = sheet.createRow((short)i);	//������
				for(int j = 0;j < scores[i].length;j++){
					HSSFCell cell = row.createCell((short)j);	//������
					cell.setCellValue(scores[i][j]);		//��ֵ
				}
				
			}	
            // �½�һ����ļ���
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // ����Ӧ��Excel ����������
            workbook.write(fOut);
            fOut.flush();
            // �����������ر��ļ�
            fOut.close();
            System.out.println("�ļ�����...");
        } catch (Exception e) {
            System.out.println("������ xlCreate() : " + e);
        }
	}
}