import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;
public class CreateXL {
    /** Excel �ļ�Ҫ��ŵ�λ�ã��ٶ���F����*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {
        try {
            // �����µ�Excel ������
            HSSFWorkbook workbook = new HSSFWorkbook();
            // ��Excel�������н�һ����������Ϊȱʡֵ
            // ��Ҫ�½�һ��Ϊ"Ч��ָ��"�Ĺ����������Ϊ��
            // HSSFSheet sheet = workbook.createSheet("Ч��ָ��");
            HSSFSheet sheet = workbook.createSheet();
            // ������0��λ�ô����У���˵��У�
            HSSFRow row = sheet.createRow((short)0);	//������һ��
            //������0��λ�ô�����Ԫ�����϶ˣ�
            HSSFCell cell0 = row.createCell((short)0);	//�У��ɵ�һ�д����ĵ�һ����Ԫ��
			HSSFCell cell1 = row.createCell((short)1);	//�У��ɵ�һ�д����ĵڶ�����Ԫ��
			  // �ڵ�Ԫ��������һЩ����
            cell0.setCellValue("��Ŀ");
			cell1.setCellValue("�ɼ�");
			
			
			//�����ڶ���
			HSSFRow row1 = sheet.createRow((short)1);		//�����ڶ���
			HSSFCell cell2 = row1.createCell((short)0);		//�У��ɵڶ��д����ĵ�һ����Ԫ��
			HSSFCell cell3 = row1.createCell((short)1);		//�У��ɵڶ��д����ĵڶ�����Ԫ��
			 // �ڵ�Ԫ��������һЩ����
            cell2.setCellValue("�ߵȴ���");
			cell3.setCellValue("90");
			
			
			//����������
			HSSFRow row2 = sheet.createRow((short)2);		//����������
			HSSFCell cell4 = row2.createCell((short)0);		//�У��ɵ����д����ĵ�һ����Ԫ��
			HSSFCell cell5 = row2.createCell((short)1);		//�У��ɵ����д����ĵڶ�����Ԫ��
			 // �ڵ�Ԫ��������һЩ����
            cell4.setCellValue("��ѧ����");
			cell5.setCellValue("90");
			
			
			//����������
			HSSFRow row3 = sheet.createRow((short)3);		//����������
			HSSFCell cell6 = row3.createCell((short)0);		//�У��ɵ����д����ĵ�һ����Ԫ��
			HSSFCell cell7 = row3.createCell((short)1);		//�У��ɵ����д����ĵڶ�����Ԫ��
			 // �ڵ�Ԫ��������һЩ����
            cell6.setCellValue("��������");
			cell7.setCellValue("90");
			
			
			
			
			
			
            

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