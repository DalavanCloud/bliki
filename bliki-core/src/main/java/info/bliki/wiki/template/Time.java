package info.bliki.wiki.template;

import info.bliki.wiki.model.IWikiModel;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A template parser function for <code>{{ #time: ... }}</code> syntax.
 * 
 * NOT COMPLETE YET!!!
 * 
 * See <a href="http://www.mediawiki.org/wiki/Help:Extension:ParserFunctions">
 * Mediwiki's Help:Extension:ParserFunctions</a>
 * 
 */
public class Time extends AbstractTemplateFunction {
	public final static ITemplateFunction CONST = new Time();

	public Time() {

	}

	public String parseFunction(List<String> list, IWikiModel model, String src, int beginIndex, int endIndex) {
		if (list.size() > 0) {
			String condition = parse(list.get(0), model);
			Date d = new Date();
			if (condition.equals("U")) {
				return secondsSinceJanuary1970(list);
			}
			
			if(condition.equals("F")) {
				return "Month";
			}
			
			if(condition.equals("N")) {
				return String.valueOf(d.getDay());
			}
		}
		return null;
	}

	private String secondsSinceJanuary1970(List<String> list) {
		Date date = new Date();
		long secondsSince1970 = date.getTime() / 1000;
		return Long.toString(secondsSince1970);
	}
}
