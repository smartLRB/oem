package oem.quickstart;


import java.sql.Timestamp;
import java.util.Date;

import com.datalook.excel.annotation.OEMColumn;
import com.datalook.excel.annotation.OEMSheet;

@OEMSheet(sheetName = "sheet")
public class SimpleTypeTest {

	@OEMColumn(location=0, title = "string类型")
	public String myString;
	@OEMColumn(location=1,title = "Integer类型")
	public Integer myInteger;
	@OEMColumn(location=2,title = "Long类型")
	public Long myLong;
	@OEMColumn(location=3,title = "Short类型")
	public Short myShort;
	@OEMColumn(location=4,title = "Double类型")
	public Double myDouble;
	@OEMColumn(location=5,title = "Float类型")
	public Float myFloat;
	@OEMColumn(location=6,title = "Boolean类型")
	public Boolean myBoolean;
	@OEMColumn(location=7,title = "Date类型")
	public Date myDate;
	@OEMColumn(location=8,title = "StringBuffer类型")
	public StringBuffer myStringBuffer;
	@OEMColumn(location=9,title = "Timestamp类型")
	public Timestamp timestampp;
	
	
	public Timestamp getTimestampp() {
		return timestampp;
	}

	public void setTimestampp(Timestamp timestampp) {
		this.timestampp = timestampp;
	}

	public SimpleTypeTest() {
		super();
	}

	public SimpleTypeTest(String myString, Integer myInteger, Long myLong,
			Short myShort, Double myDouble, Float myFloat, Boolean myBoolean,
			Date myDate, StringBuffer myStringBuffer,Timestamp timestampp) {
		super();
		this.myString = myString;
		this.myInteger = myInteger;
		this.myLong = myLong;
		this.myShort = myShort;
		this.myDouble = myDouble;
		this.myFloat = myFloat;
		this.myBoolean = myBoolean;
		this.myDate = myDate;
		this.myStringBuffer = myStringBuffer;
		this.timestampp=timestampp;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	public Integer getMyInteger() {
		return myInteger;
	}

	public void setMyInteger(Integer myInteger) {
		this.myInteger = myInteger;
	}

	public Long getMyLong() {
		return myLong;
	}

	public void setMyLong(Long myLong) {
		this.myLong = myLong;
	}

	public Short getMyShort() {
		return myShort;
	}

	public void setMyShort(Short myShort) {
		this.myShort = myShort;
	}

	public Double getMyDouble() {
		return myDouble;
	}

	public void setMyDouble(Double myDouble) {
		this.myDouble = myDouble;
	}

	public Float getMyFloat() {
		return myFloat;
	}

	public void setMyFloat(Float myFloat) {
		this.myFloat = myFloat;
	}

	public Boolean getMyBoolean() {
		return myBoolean;
	}

	public void setMyBoolean(Boolean myBoolean) {
		this.myBoolean = myBoolean;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public StringBuffer getMyStringBuffer() {
		return myStringBuffer;
	}

	public void setMyStringBuffer(StringBuffer myStringBuffer) {
		this.myStringBuffer = myStringBuffer;
	}

	@Override
	public String toString() {
		return "SimpleTypeTest [myBoolean=" + myBoolean + ", myDate=" + myDate
				+ ", myDouble=" + myDouble + ", myFloat=" + myFloat
				+ ", myInteger=" + myInteger + ", myLong=" + myLong
				+ ", myShort=" + myShort + ", myString=" + myString
				+ ", myStringBuffer=" + myStringBuffer + "]";
	}
	
	
}
