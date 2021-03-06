package Include;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.datalook.exceltool.core.OEMContext;
import com.datalook.exceltool.exception.ExcelConstructException;
import com.datalook.exceltool.exception.ExcelNullListException;
import com.datalook.exceltool.exception.ExcelWrongAnnotationException;

public class Main {
	public static void main(String[] args) {
		ArrayList<OutSideObject> al=new ArrayList<OutSideObject>();
		al.add(new OutSideObject(new InSideObject(1,"内层类内容"),"字符串类型2", 1, 2l, (short)3, 4d, 5f, true, new Date(), new StringBuffer("StringBuffer类型2")));
		al.add(new OutSideObject(new InSideObject(2,"内层内的内容2"), "字符串类型2", 1, 2l, (short)3, 4d, 5f, true, new Date(), new StringBuffer("StringBuffer类型2")));
		
		try {
			OEMContext.generateExecl(al, "D:\\", "OutSideObject的映射excel文件名.xls");
		} catch (ExcelNullListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelWrongAnnotationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<OutSideObjectAnother> al2=new ArrayList<OutSideObjectAnother>();
		al2.add(new OutSideObjectAnother(new InSideObject(1,"内层类内容"),new Date(), 1, "b", true, true));
		al2.add(new OutSideObjectAnother(new InSideObject(2,"内层内的内容2"),new Date(), 2, "a", false, false));
		
		try {
			OEMContext.generateExecl(al2, "D:\\", "OutSideObjectAnother的映射excel文件名.xls");
		} catch (ExcelNullListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelWrongAnnotationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			//读取到list中
			List<OutSideObject> lstt=OEMContext.readExecl(OutSideObject.class, "D:\\", "OutSideObject的映射excel文件名.xls");
			System.out.println(lstt);
		} catch (ExcelWrongAnnotationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelConstructException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//读取到list中
			List<OutSideObjectAnother> lstt=OEMContext.readExecl(OutSideObjectAnother.class, "D:\\", "OutSideObjectAnother的映射excel文件名.xls");
			System.out.println(lstt);
		} catch (ExcelWrongAnnotationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcelConstructException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
