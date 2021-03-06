package com.datalook.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.type.NullType;

import org.apache.commons.lang3.ObjectUtils.Null;

/**
 * 用于外层类的属性映射标识。和ColumnCfgs的参数。 location在同一sheetId中不能重复
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Repeatable(OEMColumns.class)
public @interface OEMColumn {
	/**
	 * 必填 功能描述：该对象转化excel后所在的位置 时间：2014年7月25日
	 * 
	 * @author ：lirenbo
	 * @return
	 */
	public int location();

	/**
	 * 必填 功能描述：该对象转化excel后的列标题，location=-1只用于标记自定义类，时表示内层类，其他情况location必须>0。
	 * 时间：2014年7月25日
	 * 
	 * @author ：lirenbo
	 * @return
	 */
	public String title();

	/**
	 * 
	 * 功能描述：Date对象转化excel后的格式，默认为yyyy-MM-dd HH:mm:ss 时间：2014年7月25日
	 * 
	 * @author ：lirenbo
	 * @return
	 */
	public String simpleDateFormat() default "yyyy-MM-dd HH:mm:ss";

	/**
	 * 
	 * 功能描述：是否将类型映射，默认为false 时间：2014年7月25日
	 * 
	 * @author ：lirenbo
	 * @return
	 */
	public boolean map() default false;

	/**
	 * 功能描述：当map为true时，填写需要的映射，格式为
	 * String映射ExcelString时："字符串:字符串,字符串:字符串..."冒号左侧字符串不能重复，冒号右侧字符串不能重复
	 * Integer映射ExcelString时："数字:字符串,数字:字符串..."冒号左侧数字不能重复，冒号右侧字符串不能重复
	 * Boolean映射ExcelString时："#true:字符串,#false:字符串" 时间：2014年7月25日
	 * 
	 * @author ：lirenbo
	 * @return
	 */
	public String mapString() default "{\"true\":\"真\",\"false\":\"假\"}";

	/**
	 * 
	 * 功能描述：用于关联SheetId相同的SheetCfg生成的Excel。-1,-2不能使用 时间：2014年7月25日
	 * 
	 * @author ：lirenbo
	 * @return
	 */
	public int sheetId() default -1;

	public enum ReadWriteStrategy {
		readOnly, writeOnly, readAndWrite
	}

	public ReadWriteStrategy strategy() default ReadWriteStrategy.readAndWrite;

	
	
	
	/**
	 * 用于Map对象中的key值
	 * @return
	 */
	public String mapKey() default "";
	
	/**
	 * 用于Map对象中的key对应的value类型
	 * @return
	 */
	public Class mapClass() default Object.class;
}