package com.datalook.excel.core.holder;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.datalook.excel.annotation.OEMColumn;
import com.datalook.excel.annotation.OEMColumn.ReadWriteStrategy;
import com.datalook.excel.annotation.OEMColumns;
import com.datalook.util.ReflectUtil;

public class ColumnInfo implements Comparable<ColumnInfo> {

	public Field field;

	public int location;
	public String title;
	public String simpleDateFormatString;
	public SimpleDateFormat sdf;
	public boolean map;
	public String mapString;
	public int sheetId;
	public ReadWriteStrategy strategy;

	public JSONObject mapJsonObject;
	private Set<Entry<String, Object>> mapEntrys;

	public List<ColumnInfo> insideColumns;

	public String mapKey;
	public Class<?> mapClass;

	public ColumnInfo(OEMColumn oemc, Field field, Integer id) {
		mapKey = oemc.mapKey();
		mapClass = oemc.mapClass();

		location = oemc.location();
		title = oemc.title();
		simpleDateFormatString = oemc.simpleDateFormat();
		sdf = new SimpleDateFormat(simpleDateFormatString);
		map = oemc.map();
		if (map) {
			mapString = oemc.mapString();
			mapJsonObject = JSON.parseObject(mapString);
			mapEntrys = mapJsonObject.entrySet();
		}
		sheetId = oemc.sheetId();
		strategy = oemc.strategy();
		this.field = field;
		field.setAccessible(true);
		insideColumns = scanClass(field.getType(), id);
	}

	public List<ColumnInfo> scanClass(Class clazz, int sheetId) {
		List<ColumnInfo> re = new ArrayList<ColumnInfo>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			OEMColumn oemc = ReflectUtil.getAnnotation(field, OEMColumn.class);
			if (oemc != null && oemc.sheetId() == sheetId) {
				if (oemc.location() >= 0) {
					ColumnInfo ci = new ColumnInfo(oemc, field, sheetId);
					re.add(ci);
				} else {
					re.add(new ColumnInfo(oemc, field, sheetId));
				}
			}

			OEMColumns oemcs = ReflectUtil.getAnnotation(field, OEMColumns.class);
			if (oemcs != null && oemcs.value().length > 0) {
				List<OEMColumn> loemc = Arrays.asList(oemcs.value());
				for (int i = 0; i < loemc.size(); i++) {
					if (loemc.get(i).sheetId() == sheetId) {
						ColumnInfo ci = new ColumnInfo(loemc.get(i), field, sheetId);
						re.add(ci);
					}
				}
			}

		}
		return re;
	}

	public String getKey(String value) {
		if (mapEntrys == null) {
			return null;
		}
		for (Entry<String, Object> entry : mapEntrys) {
			if (entry.getValue().toString().equals(value)) {
				return entry.getKey();
			}
		}
		return null;
	}

	@Override
	public int compareTo(ColumnInfo o) {
		return location - o.location;
	}

	public ColumnInfo(int location, int sheetId) {
		super();
		this.location = location;
		this.sheetId = sheetId;
	}

	public void addInsideColumnsTo(Set<ColumnInfo> set) {
		for (ColumnInfo columnInfo : insideColumns) {
			if (set.contains(columnInfo)) {
			} else {
				columnInfo.addInsideColumnsTo(set);
			}
		}
	}

}
