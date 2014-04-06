package com.zzti.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073567267921619784L;

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
		if(pageMax==0)
			this.pageMax =  this.pageIndex;
		else
			this.pageMax = pageMax;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PagingTag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doStartTag() throws JspException {
		String str = "";
		if (pageIndex == 1) {
			str += "首页 上一页 ";
		} else {
			str += " <a href='" + url + "?pageIndex=1'>首页</a> " + "<a href='"
					+ url + "?pageIndex=" + (pageIndex - 1) + "'>上一页</a> ";
		}
		if (pageIndex / 6 < 1.0 || pageMax < 10) {
			for (int i = 1; i <= 9; i++) {
				if (i <= pageMax) {
					if (pageIndex != i) {
						str += "<a href='" + url + "?pageIndex=" + i + "'>[" + i
								+ "]</a> ";
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
						str += "<a href='" + url + "?pageIndex=" + i + "'>[" + i
								+ "]</a> ";
					} else {
						str += "  " + i + " ";
					}
				}
			}
		}
		if (pageIndex == pageMax || pageMax < 2) {
			str += "下一页 尾页";
		} else {
			str += "<a href='" + url + "?pageIndex=" + (pageIndex + 1)
					+ "'>下一页</a> " + "<a href='" + url + "?pageIndex=" + pageMax
					+ "'>尾页</a>";
		}
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
