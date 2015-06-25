package com.zzti.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingMaterialTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7938693110364573952L;
	private int pageIndex;
	private int pageMax;
	private String url;
	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageMax() {
		return pageMax;
	}

	public void setPageMax(int pageMax) {
		if (pageMax == 0)
			this.pageMax = this.pageIndex;
		else
			this.pageMax = pageMax;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url.contains("?") ? url + "&" : url + "?";
	}

	public PagingMaterialTag() {
		// TODO Auto-generated constructor stub
	}

	/*
	  <ul class="pagination">
	    <li class="disabled"><a href="#!"><i class="mdi-navigation-chevron-left"></i></a></li>
	    <li class="active"><a href="#!">1</a></li>
	    <li class="waves-effect"><a href="#!">2</a></li>
	    <li class="waves-effect"><a href="#!">3</a></li>
	    <li class="waves-effect"><a href="#!">4</a></li>
	    <li class="waves-effect"><a href="#!">5</a></li>
	    <li class="waves-effect"><a href="#!"><i class="mdi-navigation-chevron-right"></i></a></li>
	  </ul>
	 * */
	@Override
	public int doStartTag() throws JspException {
		String str = "<ul class='pagination'>";
		/*if (pageIndex == 1) {
			str += String.format("%1$s %2$s", type.getFirst(), type.getPrev());
		} else {
			str += String
					.format(" <a href='%1$spageIndex=1'>%2$s</a> <a href='%1$spageIndex=%3$s'>%4$s</a> ",
							url, type.getFirst(), pageIndex - 1, type.getPrev());
		}*/
		str+=String.format("<li class='%s'><a href='%spageIndex=1'><i class='mdi-navigation-chevron-left'></i></a></li>", pageIndex==1?"disabled":"waves-effect",url);
		/*
		if (pageIndex / 6 < 1.0 || pageMax < 10) {
			for (int i = 1; i <= 9; i++) {
				if (i <= pageMax) {
					if (pageIndex != i) {
						// str += "<a href='" + url + "pageIndex=" + i + "'>[" +
						// i
						// + "]</a> ";
						str += String.format(
								"<a href='%1$spageIndex=%2$s'>[%2$s]</a> ",
								url, i);
					} else {
						str += "  " + i + " ";
					}
				}
			}
		} else if (pageIndex / 6 >= 1.0 && pageMax >= 10) {
			int fri = 0;
			int max = 0;
			if (pageMax - pageIndex > 4) {
				fri = pageIndex - 4;
				max = pageIndex + 4;
			} else {
				fri = pageMax - 8;
				max = pageMax;
			}
			for (int i = fri; i <= max; i++) {
				if (i <= pageMax) {
					if (pageIndex != i) {
						// str += "<a href='" + url + "pageIndex=" + i + "'>[" +
						// i
						// + "]</a> ";
						str += String.format(
								"<a href='%1$spageIndex=%2$s'>[%2$s]</a> ",
								url, i);
					} else {
						str += "  " + i + " ";
					}
				}
			}
		}*/
		for(int i=1;i<=pageMax;i++)
		{
			str+=String.format("<li class='%s'><a href='%spageIndex=%d'>%d</a></li>", pageIndex==i?"active":"waves-effect",url,i,i);
		}
		
		/*if (pageIndex == pageMax || pageMax < 2) {
			str += String.format("%1$s %2$s", type.getNext(), type.getLast());
		} else {
			str += String
					.format("<a href='%1$spageIndex=%2$s'>%3$s</a> <a href='%1$spageIndex=%4$s'>%5$s</a>",
							url, pageIndex + 1, type.getNext(), pageMax,
							type.getLast());
		}*/
		
		str+=String.format("<li class='%s'><a href='%spageIndex=%d'><i class='mdi-navigation-chevron-right'></i></a></li>",pageIndex == pageMax || pageMax < 2?"disabled":"waves-effect",url,pageMax);
		str+="</ul>";
		try {
			if (str != "") {
				pageContext.getOut().write(str);
			}
		} catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
}
