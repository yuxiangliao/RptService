/**
 * 
 */
package com.inhe.rpt.common;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.inhe.rpt.exception.DateConvertException;
import com.inhe.rpt.exception.InheExceptionBase;

/**
 * @author songt
 * @MSG 日期帮助类
 * @time 2017年8月1日上午11:02:06
 */
public class DateUtil {
	/**
	 * yyyyMM
	 */
	public static final String DATE_WITHOUT_DAY = "yyyyMM";
	/**
	 * yyyyMMdd
	 */
	public static final String DATE_WITH_NOTHING = "yyyyMMdd";
	/**
	 * yyyy/MM/dd
	 */
	public static final String DATE_WITH_SLASH = "yyyy/MM/dd";
	/**
	 * yyyy-MM-dd
	 */
	public static final String DATE_WITH_LINE = "yyyy-MM-dd";
	/**
	 * yyyyMMdd HH:mm:ss
	 */
	public static final String DATE_TIME_NORMAL = "yyyyMMdd HH:mm:ss";
	/**
	 * yyyy/MM/dd HH:mm:ss
	 */
	public static final String DATE_TIME_WITH_SLASH = "yyyy/MM/dd HH:mm:ss";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_TIME_WITH_LINE = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyyMMddHHmmss
	 */
	public static final String DATE_TIME_WITH_NOTHING = "yyyyMMddHHmmss";
	/**
	 * yyyyMMddHHmmssSSS
	 */
	public static final String DATE_TIME_WITH_NOTHINGSSS = "yyyyMMddHHmmssSSS";
	/**
	 * yyyy年MM月dd日
	 */
	public static final String DATE_WITH_CH = "yyyy年MM月dd日";
	/**
	 * yyyy年MM月dd日HH时mm分ss秒
	 */
	public static final String DATE_TIME_WITH_CH = "yyyy年MM月dd日HH时mm分ss秒";
	/**
	 * HH小时mm分钟ss秒
	 */
	public static final String TIME_WITH_CH = "HH时mm分ss秒";
	/**
	 * HH:mm:ss
	 */
	public static final String TIME_NORMAL = "HH:mm:ss";

	/**
	 * 根据用户输入的格式将字符串转化成日期格式
	 * 
	 * @param date
	 * @param format日期格式
	 * @return
	 * @throws Exception
	 * @throws DateException
	 */
	public static Date stringToDate(String date, String format) throws DateConvertException {
		Date newDate = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			newDate = simpleDateFormat.parse(date);
		} catch (Exception e) {
			throw new DateConvertException("日期格式有误，不能转换:" + e.getMessage());
		}
		return newDate;
	}

	/**
	 * 根据用户输入的格式和日期，得到字符串类型日期
	 * 
	 * @param date
	 * @param format日期格式
	 * @return
	 * @throws DateConvertException
	 */
	public static String dateToString(Date date, String format) throws DateConvertException {
		String newDate = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			newDate = simpleDateFormat.format(date);
		} catch (Exception e) {
			throw new DateConvertException("日期格式有误，不能转换:" + e.getMessage());
		}
		return newDate;
	}

	/**
	 * 毫秒转时间
	 * 
	 * @param millis
	 * @param format
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static String millisToString(long millis, String format) throws DateConvertException {
		try {
			long secondTime = millis / 1000;
			int second = (int) (secondTime % 60);
			int minute = (int) (secondTime / 60 % 60);
			int hour = (int) (secondTime / 60 / 60 % 24);
			int day = (int) (secondTime / 60 / 60 / 24 % 30);
			int month = (int) (secondTime / 60 / 60 / 24 / 30 % 12);
			int year = (int) (secondTime / 60 / 60 / 24 / 30 / 12);
			if (TIME_WITH_CH.equals(format)) {
				StringBuilder t = new StringBuilder();
				t.append(year == 0 ? "" : year + "年");
				t.append(month == 0 ? "" : month + "个月");
				t.append(day == 0 ? "" : day + "天");
				t.append(hour == 0 ? "" : hour + "小时");
				t.append(minute == 0 ? "" : minute + "分钟");
				t.append(second == 0 ? "" : second + "秒");
				return t.toString();
			} else {
				Time time = new Time(hour, minute, second);
				return time.toString();
			}
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常:" + e.getMessage());
		}
	}

	/**
	 * 获得当前时间若干天前或后的日期
	 * 
	 * @param date
	 * @param days正数表示之后，负数表示之前
	 * @return
	 * @throws Exception
	 */
	public static Date rollByDay(Date date, int days) throws DateConvertException {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_YEAR, days);
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常:" + e.getMessage());
		}
		return calendar.getTime();
	}

	/**
	 * 获得当前时间若干月前或后的日期rollByDay
	 * 
	 * @param date
	 * @param days正数表示之后，负数表示之前
	 * @return
	 * @throws Exception
	 */
	public static Date rollByMonth(Date date, int months) throws DateConvertException {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, months);
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常:" + e.getMessage());
		}
		return calendar.getTime();
	}

	/**
	 * 获得当前时间若干年前或后的日期
	 * 
	 * @param date
	 * @param days正数表示之后，负数表示之前
	 * @return
	 * @throws Exception
	 */
	public static Date rollYear(Date date, int years) throws DateConvertException {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, years);
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常:" + e.getMessage());
		}
		return calendar.getTime();
	}

	/**
	 * 获得当前时间若干小时前或后的日期
	 * 
	 * @param date
	 * @param days正数表示之后，负数表示之前
	 * @return
	 * @throws Exception
	 */
	public static Date rollHour(Date date, int hours) throws DateConvertException {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(date);
			calendar.add(Calendar.HOUR, hours);
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常:" + e.getMessage());
		}
		return calendar.getTime();
	}

	/**
	 * 获得当前时间若干分前或后的日期
	 * 
	 * @param date
	 * @param days正数表示之后，负数表示之前
	 * @return
	 * @throws Exception
	 */
	public static Date rollMinute(Date date, int minutes) throws DateConvertException {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, minutes);
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常:" + e.getMessage());
		}
		return calendar.getTime();
	}

	/**
	 * 获得当前时间若干秒前或后的日期
	 * 
	 * @param date
	 * @param days正数表示之后，负数表示之前
	 * @return
	 * @throws Exception
	 */
	public static Date rollSecond(Date date, int seconds) throws DateConvertException {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(date);
			calendar.add(Calendar.SECOND, seconds);
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常:" + e.getMessage());
		}
		return calendar.getTime();
	}

	/**
	 * 根据格式从字符串中查找相应格式的日期字符串
	 * 
	 * @param src
	 * @param format
	 * @return 字符串日期
	 * @throws Exception
	 */
	public static String stringFindDateString(String src, String format) throws DateConvertException {
		try {
			Matcher matcher = null;
			if (DATE_WITH_NOTHING.equalsIgnoreCase(format)) {
				matcher = Pattern.compile("(19|20)\\d{2}[01][0-9][0123][0-9]").matcher(src);
				matcher.find();
			} else if (DATE_WITHOUT_DAY.equalsIgnoreCase(format)) {
				matcher = Pattern.compile("(19|20)\\d{2}[01][0-9]").matcher(src);
				matcher.find();
			} else if (DATE_WITH_SLASH.equalsIgnoreCase(format)) {
				matcher = Pattern.compile("(19|20)\\d{2}[/][01][0-9][/][0123][0-9]").matcher(src);
				matcher.find();
			} else if (DATE_WITH_LINE.equalsIgnoreCase(format)) {
				matcher = Pattern.compile("(19|20)\\d{2}[-][01][0-9][-][0123][0-9]").matcher(src);
				matcher.find();
			} else if (DATE_TIME_NORMAL.equalsIgnoreCase(format)) {
				matcher = Pattern.compile("(19|20)\\d{2}[01][0-9][0123][0-9][ ][012][0-9][:][0-6][0-9][:][0-6][0-9]")
						.matcher(src);
				matcher.find();
			} else if (DATE_TIME_WITH_SLASH.equalsIgnoreCase(format)) {
				matcher = Pattern
						.compile("(19|20)\\d{2}[/][01][0-9][/][0123][0-9][ ][012][0-9][:][0-6][0-9][:][0-6][0-9]")
						.matcher(src);
				matcher.find();
			} else if (DATE_TIME_WITH_LINE.equalsIgnoreCase(format)) {
				matcher = Pattern
						.compile("(19|20)\\d{2}[-][01][0-9][-][0123][0-9][ ][012][0-9][:][0-6][0-9][:][0-6][0-9]")
						.matcher(src);
				matcher.find();
			} else if (DATE_TIME_WITH_NOTHING.equalsIgnoreCase(format)) {
				matcher = Pattern.compile("(19|20)\\d{2}[01][0-9][0123][0-9][012][0-9][0-6][0-9][0-6][0-9]")
						.matcher(src);
				matcher.find();
			} else if (DATE_WITH_CH.equalsIgnoreCase(format)) {
				matcher = Pattern.compile("(19|20)\\d{2}年[01][0-9]月[0123][0-9]日").matcher(src);
				matcher.find();
			} else if (DATE_TIME_WITH_CH.equalsIgnoreCase(format)) {
				matcher = Pattern.compile("(19|20)\\d{2}年[01][0-9]月[0123][0-9]日[ ]?[012][0-9]时[0-6][0-9]分[0-6][0-9]秒")
						.matcher(src);
				matcher.find();
			}
			return matcher.group();
		} catch (IllegalStateException e) {
			throw new DateConvertException("日期转换异常+IllegalStateException" + e.getMessage());
		} catch (NullPointerException e) {
			throw new DateConvertException("日期转换异常+NullPointerException" + e.getMessage());
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常" + e.getMessage());
		}
	}

	/**
	 * 字符串中查找日期格式为yyyyMMdd
	 * 
	 * @param src
	 * @throws Exception
	 * @return返回日期格式
	 */
	public static Date stringFindDate(String src, String format) throws DateConvertException {
		String dateStr = stringFindDateString(src, format);
		Date date = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			date = simpleDateFormat.parse(dateStr);
		} catch (Exception e) {
			throw new DateConvertException("日期转换异常" + e.getMessage());
		}
		return date;
	}

	/**
	 * 计算两个时间相差秒
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws InheExceptionBase 
	 */
	public static long twoDateDiffSecond(Date startDate, Date endDate) throws InheExceptionBase {
		try {
			if (startDate != null && endDate != null) {
				long dissSS = startDate.getTime() - endDate.getTime();
				long hour = dissSS / 1000;
				return hour;
			} else {
				throw new InheExceptionBase("日期不能为空:");
			}
		} catch (Exception e) {
			throw new InheExceptionBase("日期格式有误，不能转换:" + e.getMessage());
		}
	}

	/**
	 * 获取N+-天，日期 返回string
	 * 
	 * @param beginDate
	 * @param dayNum
	 * @return
	 * @throws DateConvertException
	 */
	public static String filstDateToStr(String beginDate, int dayNum) throws DateConvertException {
		Calendar cal = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历。
		cal.setTime(DateUtil.stringToDate(beginDate, DateUtil.DATE_WITH_NOTHING));
		cal.add(Calendar.DAY_OF_MONTH, dayNum);// 取当前日期的前一天.
		// 通过格式化输出日期
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(DateUtil.DATE_WITH_NOTHING);
		return format.format(cal.getTime());
	}

	/**
	 * 获取N+-天，日期 返回date
	 * 
	 * @param beginDate
	 * @param dayNum
	 * @return
	 * @throws DateConvertException
	 */
	public static Date filstDateToDate(String beginDate, int dayNum) throws DateConvertException {
		Calendar cal = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历。
		cal.setTime(DateUtil.stringToDate(beginDate, DateUtil.DATE_WITH_NOTHING));
		cal.add(Calendar.DAY_OF_MONTH, dayNum);// 取当前日期的前一天.
		// 通过格式化输出日期
		return cal.getTime();
	}

	/**
	 * 是否为同一天的交易
	 * @param beginDate 时间开始区间
	 * @param day		实际交易时间
	 * @param time		时间格式，时分秒
	 * @return
	 * @throws InheExceptionBase 
	 */
	public static boolean isWithDay(Date beginDate, Date day, String time) throws InheExceptionBase {
		try {
			String dateNothing = DateUtil.dateToString(beginDate, DateUtil.DATE_WITH_NOTHING);
			Date startDate = DateUtil.stringToDate(dateNothing + time, DateUtil.DATE_TIME_WITH_NOTHING);
			Calendar cal = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历。
			cal.setTime(startDate);
			cal.add(Calendar.DAY_OF_MONTH, 1);// 取当前日期的前一天.
			Date endDate = cal.getTime();
			if (day.getTime() >= startDate.getTime() && day.getTime() <= endDate.getTime()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new InheExceptionBase("date isWithDay error", e);
		}
	}
	
	/**
	 * 获取当前毫秒时间戳
	 * @return
	 * @throws InheExceptionBase 
	 */
	public static Long getMilliSecond(){
		Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
		return milliSecond;
	}
	
	/**
	 * 获取下一个周期时间
	 * type:1：分，2：小时，3：天，4：月，5：年
	 * @return
	 */
	public static Date getNextTime(Date currTime,String cycleType,Integer cycle) throws DateConvertException{
		Date nextTime = currTime;
		Date now = new Date();
		while(nextTime.getTime() < now.getTime()){
			switch (cycleType) {
			case "1":
				nextTime = rollMinute(nextTime, cycle);
				break;
			case "2":
				nextTime = rollHour(nextTime, cycle);
				break;
			case "3":
				nextTime = rollByDay(nextTime, cycle);
				break;
			case "4":
				nextTime = rollByMonth(nextTime, cycle);
				break;
			default:
				nextTime = new Date();
				break;
			}
		}
		return nextTime;
	}
}
