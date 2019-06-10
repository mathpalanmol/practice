package threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

//Current Date - 10/15/2018
//Beginning Date -  01/01/1970
//Current Date - 01/01/1970
//Beginning Date -  01/01/1970
//public class MyDateFormater {
//	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//	 
//	public String getFormattedCurrentDate() {
//		return sdf.format(new Date());
//	}
// 
//	public String getFormattedBeginningDate() {
//		return sdf.format(new Date(0));
//	}
//
//}


class MyDateFormater {

	private static ThreadLocal<SimpleDateFormat> sdfTL = new ThreadLocal<SimpleDateFormat>() {
		@Override
		public SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM/dd/yyyy");
		}
	};

	public String getFormattedCurrentDate() {
		return sdfTL.get().format(new Date());
	}

	public String getFormattedBeginningDate() {
		return sdfTL.get().format(new Date(0));
	}
}