package info.bliki.wiki.template;

import info.bliki.wiki.filter.TemplateParser;
import info.bliki.wiki.model.IWikiModel;

import java.io.IOException;
import java.util.List;

/**
 * Interface for a template parser function (i.e. <code>{{ #if: ... }}</code> )
 * 
 */
public interface ITemplateFunction {

	/**
	 * Parse a template function (like for example <code>{{ #if: ... }}</code>)
	 * 
	 * The result is also a text string in Wikipedia syntax notation which will be
	 * parsed again (recursively) in the TemplateParser step.
	 * 
	 * @param parts
	 *          the parser function arguments (extracted from the wiki text by
	 *          splitting the string at the pipe symbol &acute;|&acute;)
	 * @param model
	 *          the wiki model
	 * @param src
	 *          the array of the current Wikipedia source text
	 * @param beginIndex
	 *          the beginning index, inclusive.
	 * @param endIndex
	 *          the ending index, exclusive.
	 * @return the result string of this template function or <code>null</code> if
	 *         the parsing fails or isn't valid
	 * @throws IOException
	 * @see TemplateParser#parseTemplate(StringBuffer)
	 */
	public String parseFunction(List<String> parts, IWikiModel model, String src, int beginIndex, int endIndex) throws IOException;

	/**
	 * Return a short description of the implemented template function
	 * 
	 * @return
	 */
	public String getFunctionDoc();
}
